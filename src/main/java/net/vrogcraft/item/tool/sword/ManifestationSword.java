package net.vrogcraft.item.tool.sword;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vrogcraft.VrogcraftMod;
import net.vrogcraft.init.ModItems;
import net.vrogcraft.init.ModRarities;
import net.vrogcraft.init.ModTiers;

@Mod.EventBusSubscriber(modid = VrogcraftMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ManifestationSword extends SwordItem {
    int t2s = 0;

    public ManifestationSword() {
        super(ModTiers.MANIFESTATION_SWORD, 8, -2.4f,
                new Item.Properties()
                        .rarity(ModRarities.VMYTHIC)
                        .fireResistant()
        );
    }

    public SwordItem getItem() {
        return this;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (level.isClientSide) return;
        if (!(entity instanceof Player player)) return;

        CompoundTag tag = stack.getOrCreateTag();
        t2s++;

        if (!tag.contains("MassInfectionCD")) tag.putInt("MassInfectionCD", 0);
        if (!tag.contains("UnStableEyeCD")) tag.putInt("UnStableEyeCD", 0);
        if (!tag.contains("EntanglementCD")) tag.putInt("EntanglementCD", 0);
        if (!tag.contains("RujenvenateTheRottenCD")) tag.putInt("RujenvenateTheRottenCD", 0);
        if (!tag.contains("Soul")) tag.putInt("Soul", 0);

        if (t2s >= 20) {
            tag.putInt("MassInfectionCD", Math.max(0, tag.getInt("MassInfectionCD") - 1));
            tag.putInt("UnStableEyeCD", Math.max(0, tag.getInt("UnStableEyeCD") - 1));
            tag.putInt("EntanglementCD", Math.max(0, tag.getInt("EntanglementCD") - 1));
            tag.putInt("RujenvenateTheRottenCD", Math.max(0, tag.getInt("RujenvenateTheRottenCD") - 1));
            t2s = 0;
        }

        // UI display
        if (selected && level.getGameTime() % 20 == 0) {
            player.displayClientMessage(Component.literal(
                    "§aMass Infection: §f" + tag.getInt("MassInfectionCD") +
                            " §a| Entanglement: §f" + tag.getInt("EntanglementCD") +
                            " §a| Unstable Eye: §f" + tag.getInt("UnStableEyeCD") +
                            " §a| Rujenvenate The Rotten (" + tag.getInt("Soul") + "): §f" + tag.getInt("RujenvenateTheRottenCD")
            ), true);
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (player.level().isClientSide) return;

        Item main = player.getMainHandItem().getItem();
        Item off = player.getOffhandItem().getItem();

        boolean mainIsPrimary = main == ModItems.MANIFESTATION_SWORD.get();
        boolean offIsSecondary = off == ModItems.SECOND_MANIFESTATION_SWORD.get();

        // Kalau main-hand memegang MainSword
        if (mainIsPrimary) {

            // 1. Pastikan off-hand berisi SecondSword
            if (!offIsSecondary) {

                // Simpan item lama di inventory
                ItemStack old = player.getOffhandItem();
                if (!old.isEmpty()) {
                    boolean added = player.getInventory().add(old);
                    if (!added) player.drop(old, false);
                }

                // Pasang SecondSword di off-hand
                player.setItemInHand(InteractionHand.OFF_HAND,
                        new ItemStack(ModItems.SECOND_MANIFESTATION_SWORD.get()));
            }

            // 2. HAPUS semua SecondSword dari inventory selain OFFHAND
            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                ItemStack stack = player.getInventory().getItem(i);

                if (stack.getItem() == ModItems.SECOND_MANIFESTATION_SWORD.get()) {
                    // hapus second sword dari slot inventory
                    player.getInventory().setItem(i, ItemStack.EMPTY);
                }
            }
        }

        // Jika main-hand tidak memegang MainSword
        else {
            // Kalau off-hand berisi SecondSword → hapus
            if (offIsSecondary) {
                player.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
            }
        }
    }


}

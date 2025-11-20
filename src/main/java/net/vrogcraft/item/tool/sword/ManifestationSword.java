package net.vrogcraft.item.tool.sword;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

import net.minecraft.world.InteractionHand;
import net.minecraftforge.fml.common.Mod;
import net.vrogcraft.VrogcraftMod;
import net.vrogcraft.dualwield.util.event.DualSwordUtil;
import net.vrogcraft.init.ModItems;
import net.vrogcraft.init.ModRarities;
import net.vrogcraft.init.ModTiers;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

@Mod.EventBusSubscriber(modid = VrogcraftMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ManifestationSword extends SwordItem {

    public ManifestationSword() {
        super(ModTiers.MANIFESTATION_SWORD, 8, -2.4f,
                new Item.Properties()
                        .rarity(ModRarities.VMYTHIC)
                        .fireResistant()
        );
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {

        tooltip.add(Component.translatable("item.vrogcraft.manifestation_sword.desc1"));
        tooltip.add(Component.translatable("item.vrogcraft.manifestation_sword.desc2"));
        tooltip.add(Component.translatable("item.vrogcraft.manifestation_sword.desc3"));
        tooltip.add(Component.translatable("item.vrogcraft.manifestation_sword.desc4"));
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (level.isClientSide) return;
        if (!(entity instanceof Player player)) return;

        CompoundTag tag = stack.getOrCreateTag();

        // --- Init NBT jika belum ada ---
        if (!tag.contains("MassInfectionCD")) tag.putInt("MassInfectionCD", 0);
        if (!tag.contains("UnStableEyeCD")) tag.putInt("UnStableEyeCD", 0);
        if (!tag.contains("EntanglementCD")) tag.putInt("EntanglementCD", 0);
        if (!tag.contains("RujenvenateTheRottenCD")) tag.putInt("RujenvenateTheRottenCD", 0);
        if (!tag.contains("Soul")) tag.putInt("Soul", 0);

        // --- Jalankan dual wield hanya saat item ini yang dipegang (selected = main-hand) ---
            DualSwordUtil.enforceDualWield(
                    player,
                    ModItems.MANIFESTATION_SWORD,
                    ModItems.SECOND_MANIFESTATION_SWORD);

        // --- Tick cooldown setiap 20 tick (1 detik) ---
        if (level.getGameTime() % 20 == 0) {
            tag.putInt("MassInfectionCD", Math.max(0, tag.getInt("MassInfectionCD") - 1));
            tag.putInt("UnStableEyeCD", Math.max(0, tag.getInt("UnStableEyeCD") - 1));
            tag.putInt("EntanglementCD", Math.max(0, tag.getInt("EntanglementCD") - 1));
            tag.putInt("RujenvenateTheRottenCD", Math.max(0, tag.getInt("RujenvenateTheRottenCD") - 1));
        }

        // --- Tampilkan UI cooldown setiap 20 tick ---
        if (selected && level.getGameTime() % 20 == 0) {
            player.displayClientMessage(Component.literal(
                    "§aMass Infection: §f" + tag.getInt("MassInfectionCD") +
                            " §a| Entanglement: §f" + tag.getInt("EntanglementCD") +
                            " §a| Unstable Eye: §f" + tag.getInt("UnStableEyeCD") +
                            " §a| Rujenvenate The Rotten (" + tag.getInt("Soul") + "): §f" + tag.getInt("RujenvenateTheRottenCD")
            ), true);
        }
    }

}

package net.vrogcraft.dualwield.event;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.TickEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;

import net.vrogcraft.dualwield.DualWieldMod;
import net.vrogcraft.dualwield.util.DualSwordPair;
import net.vrogcraft.dualwield.SwordPairs;


@Mod.EventBusSubscriber(modid = DualWieldMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DualSwordEvents {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        Player player = event.player;
        if (player.level().isClientSide) return;

        // ------------------------------
        // 1. CEK APAKAH PLAYER MEMEGANG MAIN SWORD
        // ------------------------------
        boolean hasMain = player.getMainHandItem().is(SwordPairs.MANIFESTATION_PAIR.mainSword().get());

        if (!hasMain) {
            // kalau player tidak memegang main sword → off-sword dihancurkan
            if (player.getOffhandItem().is(SwordPairs.MANIFESTATION_PAIR.offSword().get())) {
                player.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
            }
            return;
        }

        // ------------------------------
        // 2. PASTIKAN OFF-HAND SELALU BERISI OFF SWORD
        // ------------------------------
        boolean offIsCorrect = player.getOffhandItem().is(SwordPairs.MANIFESTATION_PAIR.offSword().get());

        if (!offIsCorrect) {
            // simpan item lama ke inventory
            ItemStack old = player.getOffhandItem();
            if (!old.isEmpty()) {
                boolean ok = player.getInventory().add(old);
                if (!ok) player.drop(old, false);
            }

            // pasang pedang kedua ke off-hand
            player.setItemInHand(
                    InteractionHand.OFF_HAND,
                    new ItemStack(SwordPairs.MANIFESTATION_PAIR.offSword().get())
            );
        }

        // ------------------------------
        // 3. HAPUS SEMUA OFF-SWORD YANG ADA DI INVENTORY
        // (hanya boleh ada 1 di off-hand)
        // ------------------------------
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack st = player.getInventory().getItem(i);

            if (st.is(SwordPairs.MANIFESTATION_PAIR.offSword().get())) {
                player.getInventory().setItem(i, ItemStack.EMPTY);
            }
        }
    }
}

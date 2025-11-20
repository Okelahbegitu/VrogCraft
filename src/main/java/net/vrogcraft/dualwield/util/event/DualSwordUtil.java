package net.vrogcraft.dualwield.util.event;// File: net.vrogcraft.util.DualSwordUtil.java

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.RegistryObject;

public class DualSwordUtil {

    public static void enforceDualWield(Player player, RegistryObject<Item> mainSwordObj, RegistryObject<Item> offSwordObj) {

        Item mainSword = mainSwordObj.get();
        Item offSword = offSwordObj.get();

        // Dapatkan index slot Hotbar yang sedang aktif dipegang (0-8)
        int selectedSlot = player.getInventory().selected;

        // Pemeriksaan dasar: Pastikan pemain memegang pedang utama
        boolean hasMain = player.getMainHandItem().is(mainSword);
        if (!hasMain) {
            // ----------------------------------------------------
            // LOGIKA PELEPASAN OFF-HAND (Saat Main Sword dilepas)
            // ----------------------------------------------------
            if (player.getOffhandItem().is(offSword)) {

                ItemStack off = player.getOffhandItem();

                // 1. Kosongkan slot Off-Hand
                player.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);

                // 🛑 PERBAIKAN KRITIS UNTUK BUG PINDAH KE SLOT 1:
                //    Langsung Drop item ke dunia (TIDAK mencoba add() ke inventory/hotbar)
                player.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY); // false = drop tepat di kaki pemain.
            }
            return;
        }

        // ------------------------------
        // LOGIKA DUAL WIELD HANYA BERJALAN JIKA MAIN SWORD DI TANGAN UTAMA
        // ------------------------------

        boolean hasOff = player.getOffhandItem().is(offSword);

        // 1. PASTIKAN OFF-HAND SELALU BERISI OFF SWORD
        if (!hasOff) {
            // Simpan item lama ke inventory
            ItemStack old = player.getOffhandItem();
            boolean success = player.getInventory().add(old);
            if (!success) {
                player.drop(old, false); // Baru di-drop jika tidak muat
            }
            // Pasang pedang kedua ke off-hand
            player.setItemInHand(
                    InteractionHand.OFF_HAND,
                    new ItemStack(offSword)
            );
        }

        // ------------------------------
        // 2. HAPUS DUPLIKAT OFF-SWORD (CLEANUP LOOP)
        // ------------------------------
        int inventorySize = player.getInventory().getContainerSize(); // 41 slot (Index 0-40)

        for (int i = 0; i < inventorySize; i++) {

            // 🛑 PERBAIKAN KRITIS 1: Lewati slot yang sedang dipegang (mencegah Main Sword hilang)
            if (i == selectedSlot) {
                continue;
            }

            // 🛑 PERBAIKAN KRITIS 2: Lewati off-hand slot (Index 40)
            if (i == 40) {
                continue;
            }

            ItemStack st = player.getInventory().getItem(i);

            // Jika item adalah SECOND SWORD dan bukan di slot aktif/off-hand
            if (st.is(offSword)) {
                // ✅ Hapus item dari slot reguler (Menegakkan aturan "hanya boleh di off-hand")
                player.getInventory().setItem(i, ItemStack.EMPTY);
            }
        }
    }

}
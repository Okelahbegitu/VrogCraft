package net.vrogcraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class CopperVrog extends Item {

    public CopperVrog() {
        super(new Properties()
                        .stacksTo(64).rarity(Rarity.COMMON)
        );
    }

    // Bisa tambah method custom seperti onUse, onCrafted, dsb.
}

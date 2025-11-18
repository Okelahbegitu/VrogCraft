package net.vrogcraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class GoldVrog extends Item {

    public GoldVrog() {
        super(new Properties()
                        .stacksTo(64).rarity(Rarity.UNCOMMON)
        );
    }

    // Bisa tambah method custom seperti onUse, onCrafted, dsb.
}

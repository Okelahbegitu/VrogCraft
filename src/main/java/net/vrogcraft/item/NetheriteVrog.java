package net.vrogcraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class NetheriteVrog extends Item {

    public NetheriteVrog() {
        super(new Properties()
                .stacksTo(64).rarity(Rarity.EPIC)
        );
    }

    // Bisa tambah method custom seperti onUse, onCrafted, dsb.
}

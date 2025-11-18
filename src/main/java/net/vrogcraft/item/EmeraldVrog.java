package net.vrogcraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class EmeraldVrog extends Item {

    public EmeraldVrog() {
        super(new Properties()
                .stacksTo(64).rarity(Rarity.RARE)
        );
    }

    // Bisa tambah method custom seperti onUse, onCrafted, dsb.
}

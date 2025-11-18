package net.vrogcraft.item.tool.sword;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.vrogcraft.init.ModItems;
import net.vrogcraft.init.ModRarities;
import net.vrogcraft.init.ModTiers;

import java.util.Stack;

public class SecondManifestationSword extends SwordItem {
    int t2s = 0;

    public SecondManifestationSword() {
        super(ModTiers.MANIFESTATION_SWORD, 8, -2.4f,
                new Properties()
                        .rarity(ModRarities.VMYTHIC)
                        .fireResistant()
        );
    }

    public SwordItem getItem() {
        return this;
    }
}

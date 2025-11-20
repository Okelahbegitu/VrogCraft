package net.vrogcraft.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

public class GemOfManifestation extends Item {

    public GemOfManifestation() {
        super(new Properties()
                        .stacksTo(64).rarity(Rarity.RARE)
        );
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {

        tooltip.add(Component.translatable("gem_of_manifestation.desc"));
        tooltip.add(Component.translatable("gem_of_manifestation.desc2"));
    }
    // Bisa tambah method custom seperti onUse, onCrafted, dsb.
}

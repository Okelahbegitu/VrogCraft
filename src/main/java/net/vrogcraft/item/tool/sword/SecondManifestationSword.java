package net.vrogcraft.item.tool.sword;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.vrogcraft.dualwield.util.event.DualSwordUtil;
import net.vrogcraft.init.ModItems;
import net.vrogcraft.init.ModRarities;
import net.vrogcraft.init.ModTiers;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
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
        return null;
    }
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (level.isClientSide) return;
        if (!(entity instanceof Player player)) return;
        DualSwordUtil.enforceDualWield(
                player,
                ModItems.MANIFESTATION_SWORD,
                ModItems.SECOND_MANIFESTATION_SWORD);
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {

        tooltip.add(Component.translatable("second_manifestation_sword.desc"));
    }
}

package net.vrogcraft.dualwield.util;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public record DualSwordPair(
        RegistryObject<Item> mainSword,
        RegistryObject<Item> offSword
) {}

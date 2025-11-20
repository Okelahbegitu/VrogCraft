package net.vrogcraft.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vrogcraft.VrogcraftMod;
import net.vrogcraft.item.*;
import net.vrogcraft.item.tool.sword.ManifestationSword;
import net.vrogcraft.item.tool.sword.SecondManifestationSword;

public class ModItems {

    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, VrogcraftMod.MODID);
    //items
    public static final RegistryObject<Item> COPPER_VROG = REGISTRY.register("copper_vrog",
            () -> new CopperVrog());
    public static final RegistryObject<Item> IRON_VROG = REGISTRY.register("iron_vrog",
            () -> new IronVrog());
    public static final RegistryObject<Item> GOLD_VROG = REGISTRY.register("gold_vrog",
            () -> new GoldVrog());
    public static final RegistryObject<Item> DIAMOND_VROG = REGISTRY.register("diamond_vrog",
            () -> new DiamondVrog());
    public static final RegistryObject<Item> EMERALD_VROG = REGISTRY.register("emerald_vrog",
            () -> new EmeraldVrog());
    public static final RegistryObject<Item> NETHERITE_VROG = REGISTRY.register("netherite_vrog",
            () -> new NetheriteVrog());
    public static final RegistryObject<Item> GEM_OF_MANIFESTATION = REGISTRY.register("gem_of_manifestation",
            () -> new GemOfManifestation());
    public static final RegistryObject<Item> MANIFESTATION_SWORD = REGISTRY.register(
            "manifestation_sword",
            ManifestationSword::new
    );

    public static final RegistryObject<Item> SECOND_MANIFESTATION_SWORD = REGISTRY.register(
            "second_manifestation_sword",
            SecondManifestationSword::new
    );

}

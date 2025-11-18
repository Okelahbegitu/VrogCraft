package net.vrogcraft.init;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "vrogcraft", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {

    @SubscribeEvent
    public static void addItemsToTabs(BuildCreativeModeTabContentsEvent event) {
        // Contoh: tambahkan ke tab Ingredients
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.COPPER_VROG.get());
            event.accept(ModItems.IRON_VROG.get());
            event.accept(ModItems.GOLD_VROG.get());
            event.accept(ModItems.DIAMOND_VROG.get());
            event.accept(ModItems.NETHERITE_VROG.get());
            event.accept(ModItems.EMERALD_VROG.get());
        } else if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.MANIFESTATION_SWORD.get());
        }
    }
}

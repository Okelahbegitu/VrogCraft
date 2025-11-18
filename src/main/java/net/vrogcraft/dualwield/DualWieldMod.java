// DualWieldMod.java
package net.vrogcraft.dualwield;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus; // ✅ Tambahkan ini
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.vrogcraft.init.ModItems;

@Mod(DualWieldMod.MODID)
public class DualWieldMod {

    public static final String MODID = "vrogcraft";

    public DualWieldMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus(); // ✅ Ambil bus mod

        // 🚨 BARIS KRITIS YANG HILANG:
        ModItems.REGISTRY.register(modEventBus);
        // Asumsi DeferredRegister Anda di ModItems bernama REGISTRY.

        MinecraftForge.EVENT_BUS.register(this);
    }
}
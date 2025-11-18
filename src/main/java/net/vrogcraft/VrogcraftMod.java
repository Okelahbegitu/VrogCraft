package net.vrogcraft;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
// Hapus yang tidak terpakai: import net.vrogcraft.entity.projectile.MassInfection;
import net.vrogcraft.init.ModEntity;
import net.vrogcraft.init.ModItems;
import net.vrogcraft.init.ModSound;
import net.vrogcraft.network.ModMessages;
// Hapus yang tidak terpakai: import net.minecraft.world.entity.ai.attributes.AttributeInstance;

// ✅ TAMBAHKAN IMPORT INI
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

// ✅ TAMBAHKAN IMPORT INI (Ganti dengan lokasi yang benar jika berbeda)
import net.vrogcraft.entity.goonerminionAI;


@Mod("vrogcraft")
public class VrogcraftMod {

    public static final String MODID = "vrogcraft";

    public VrogcraftMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.REGISTRY.register(bus);
        ModMessages.register();
        System.out.println("=== REGISTERING ENTITIES ===");
        ModEntity.ENTITIES.register(bus);
        System.out.println("=== ENTITIES REGISTERED ===");
        MinecraftForge.EVENT_BUS.register(this);
        ModSound.SOUNDS.register(bus);


        // ✅ DAFTARKAN EVENT ATTRIBUTE CREATION DI SINI
        bus.addListener(this::addEntityAttributes);

        // Hapus (atau biarkan kosong) kode atribut dari setup
        bus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // Biarkan kosong, atau hanya berisi pendaftaran yang tidak terkait atribut
        });
    }

    // ✅ METODE BARU: Mendaftarkan Atribut
    private void addEntityAttributes(EntityAttributeCreationEvent event) {
        // Asumsi kelas entitas Anda bernama goonerminionAI,
        // dan ModEntity.GOONERMINION adalah DeferredRegister<EntityType<...>>

        event.put(
                ModEntity.GOONERMINION.get(),
                goonerminionAI.createAttributes().build()
        );
    }
}

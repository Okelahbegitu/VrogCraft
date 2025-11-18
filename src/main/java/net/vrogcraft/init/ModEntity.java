package net.vrogcraft.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vrogcraft.VrogcraftMod;
import net.vrogcraft.client.model.entity.goonerminionModel;
import net.vrogcraft.client.renderer.entity.goonerminionrRenderer;
import net.vrogcraft.entity.goonerminionAI;
import net.vrogcraft.entity.projectile.*;

public class ModEntity {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, VrogcraftMod.MODID);

    static {
        System.out.println("=== ModEntity CLASS LOADED ===");
    }

    public static final RegistryObject<EntityType<MassInfection>> MASS_INFECTION =
            ENTITIES.register("mass_infection", () ->
                    EntityType.Builder.<MassInfection>of(MassInfection::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .build("mass_infection")
            );

    public static final RegistryObject<EntityType<Entanglement>> ENTANGLEMENT =
            ENTITIES.register("entanglement", () ->
                    EntityType.Builder.<Entanglement>of(Entanglement::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .build("entanglement") // samakan nama dengan registry
            );

    public static final RegistryObject<EntityType<goonerminionAI>> GOONERMINION =
            ENTITIES.register("goonerminion", () ->
                    EntityType.Builder.<goonerminionAI>of(goonerminionAI::new, MobCategory.CREATURE)
                            .sized(0.6f, 1.8f)
                            .build("goonerminion") // samakan nama dengan registry
            );
}

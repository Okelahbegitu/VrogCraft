package net.vrogcraft.client;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vrogcraft.VrogcraftMod;
import net.vrogcraft.client.model.entity.goonerminionModel;
import net.vrogcraft.client.model.entity.projectile.ProEntanglement;
import net.vrogcraft.client.model.entity.projectile.ProMassInfection;
import net.vrogcraft.client.renderer.entity.goonerminionrRenderer;
import net.vrogcraft.client.renderer.entity.projectile.EntanglementRenderer;
import net.vrogcraft.client.renderer.entity.projectile.MassInfectionRenderer;
import net.vrogcraft.init.ModEntity;

@Mod.EventBusSubscriber(modid = VrogcraftMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventBusSubscriber {

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ProMassInfection.LAYER_LOCATION, ProMassInfection::createBodyLayer);
        event.registerLayerDefinition(ProEntanglement.LAYER_LOCATION, ProEntanglement::createBodyLayer);
        event.registerLayerDefinition(goonerminionModel.LAYER_LOCATION, goonerminionModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntity.MASS_INFECTION.get(), MassInfectionRenderer::new);
        event.registerEntityRenderer(ModEntity.ENTANGLEMENT.get(), EntanglementRenderer::new);
        event.registerEntityRenderer(ModEntity.GOONERMINION.get(), goonerminionrRenderer::new);
    }

}


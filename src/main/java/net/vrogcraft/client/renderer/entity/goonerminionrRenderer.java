package net.vrogcraft.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.vrogcraft.client.model.entity.goonerminionModel;
import net.vrogcraft.entity.goonerminionAI;


public class goonerminionrRenderer extends MobRenderer<goonerminionAI, goonerminionModel<goonerminionAI>> {


    public goonerminionrRenderer(EntityRendererProvider.Context p_174304_, goonerminionModel<goonerminionAI> p_174305_, float p_174306_) {
        super(p_174304_, p_174305_, p_174306_);
    }

    @Override
    public void render(goonerminionAI entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        // Scale / offset model jika diperlukan
        poseStack.scale(1f, 1f, 1f);
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        poseStack.popPose();
    }
    public goonerminionrRenderer(EntityRendererProvider.Context context) {
        super(context, new goonerminionModel<>(context.bakeLayer(goonerminionModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(goonerminionAI entity) {
        return new ResourceLocation("vrogcraft", "textures/entity/gooner.png");
    }
}
package net.vrogcraft.client.renderer.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.vrogcraft.client.model.entity.projectile.ProEntanglement;
import net.vrogcraft.entity.projectile.Entanglement;
import org.jetbrains.annotations.NotNull;

public class EntanglementRenderer extends EntityRenderer<Entanglement> {

    private final ProEntanglement<Entanglement> model;

    public EntanglementRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new ProEntanglement<>(context.bakeLayer(ProEntanglement.LAYER_LOCATION));
    }

    @Override
    public void render(Entanglement entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        poseStack.translate(0.0F, 0.0F, 0.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(entity.getYRot() - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(entity.getXRot()));

        model.renderToBuffer(
                poseStack,
                buffer.getBuffer(model.renderType(getTextureLocation(entity))),
                packedLight,
                0,
                1f, 1f, 1f, 1f
        );

        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Entanglement entity) {
        return new ResourceLocation("vrogcraft", "textures/item/manifestation_sword.png");
    }
}

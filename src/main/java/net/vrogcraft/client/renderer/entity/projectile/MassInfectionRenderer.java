package net.vrogcraft.client.renderer.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.vrogcraft.VrogcraftMod;
import net.vrogcraft.entity.projectile.MassInfection;
import net.minecraft.client.model.EntityModel;
import net.vrogcraft.client.model.entity.projectile.ProMassInfection;
import org.jetbrains.annotations.NotNull;

public class MassInfectionRenderer extends EntityRenderer<MassInfection> {
    private final ProMassInfection<MassInfection> model;

    public MassInfectionRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new ProMassInfection<>(context.bakeLayer(ProMassInfection.LAYER_LOCATION));
    }

    @Override
    public void render(MassInfection entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

// Geser ke tengah entitas
        poseStack.translate(0.0F, 0.0F, 0.0F);

// ⚙️ Urutan rotasi seperti di ArrowRenderer
        poseStack.mulPose(Axis.YP.rotationDegrees(entity.getYRot() - 90.0F)); // yaw dulu
        poseStack.mulPose(Axis.ZP.rotationDegrees(entity.getXRot()));         // pitch setelah yaw

// Kalau masih miring 90°, tambah offset model
// poseStack.mulPose(Axis.YP.rotationDegrees(90.0F));

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
    public @NotNull ResourceLocation getTextureLocation(@NotNull MassInfection entity) {
        return new ResourceLocation("vrogcraft", "textures/entity/projectile/mass_infection.png");
    }
}




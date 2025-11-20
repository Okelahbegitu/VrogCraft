package net.vrogcraft.client.renderer.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.vrogcraft.client.model.entity.projectile.ProMassInfection;
import net.vrogcraft.entity.projectile.MassInfection;
import org.jetbrains.annotations.NotNull;

public class MassInfectionRenderer extends EntityRenderer<MassInfection> {

    private final ProMassInfection model;

    public MassInfectionRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new ProMassInfection<>(context.bakeLayer(ProMassInfection.LAYER_LOCATION));
    }

    @Override
    public void render(MassInfection entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        poseStack.pushPose();

        // ===== OFFSET MODEL =====
        // Jika model terlalu tinggi, ubah Y offset
        poseStack.translate(0.0F, -1.5F, 0.0F);

        // ===== ROTASI =====
        // Y = yaw, X = pitch
        poseStack.mulPose(Axis.YP.rotationDegrees(entity.getYRot() - 90.0F));
        poseStack.mulPose(Axis.XP.rotationDegrees(entity.getXRot()));

        // ===== RENDER MODEL =====
        model.renderToBuffer(
                poseStack,
                buffer.getBuffer(model.renderType(getTextureLocation(entity))),
                packedLight,
                0,
                1f, 1f, 1f, 1f
        );

        poseStack.popPose();

        // Memanggil render default (tidak wajib, tapi aman)
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull MassInfection entity) {
        // Sesuaikan texture dengan item/projectile
        return new ResourceLocation("vrogcraft", "textures/item/mass_infection.png");
    }
}

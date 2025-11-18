// Made with Blockbench 5.0.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.vrogcraft.client.model.entity.projectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ProEntanglement<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "entanglement"), "main");
    private final ModelPart bone;
    private final ModelPart bone2;

    public ProEntanglement(ModelPart root) {
        this.bone = root.getChild("bone");
        this.bone2 = root.getChild("bone2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-7.6083F, 6.7869F, -5.398F, 1.25F, 5.0F, 0.8F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.6333F, 7.3869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.6333F, 7.7869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.6333F, 8.1869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.6333F, 8.5869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.6333F, 8.9869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.6333F, 9.3869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.6333F, 9.7869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.6333F, 10.1869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.6333F, 10.5869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.6333F, 10.9869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.5033F, -9.8381F, -5.398F, 0.95F, 16.0F, 0.775F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.7533F, -9.8381F, -5.248F, 1.0F, 16.0F, 0.475F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.3033F, -9.8381F, -5.248F, 1.0F, 16.0F, 0.475F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3583F, 17.827F, -0.1119F, 0.0F, -1.5708F, 1.5708F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(3.8926F, 3.8926F, -4.5F, 0.7F, 0.7F, 0.575F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.7426F, 3.7426F, -4.4F, 1.0F, 1.0F, 0.375F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0333F, -15.8131F, -0.798F, 0.0F, 0.0F, 0.7854F));

        PartDefinition OuterDIamond_r1 = bone.addOrReplaceChild("OuterDIamond_r1", CubeListBuilder.create().texOffs(0, 0).addBox(3.6926F, 3.6176F, -5.525F, 1.25F, 1.25F, 1.05F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.7926F, 3.7176F, -5.625F, 1.05F, 1.05F, 1.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0583F, 5.6119F, 0.002F, 0.0F, 0.0F, 0.7854F));

        PartDefinition InnerHilt2_r1 = bone.addOrReplaceChild("InnerHilt2_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.1961F, 5.0683F, -5.5F, 1.7F, 0.95F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.7333F, 0.9119F, 0.002F, 0.0F, 0.0F, -0.3927F));

        PartDefinition CubeHilt2_r1 = bone.addOrReplaceChild("CubeHilt2_r1", CubeListBuilder.create().texOffs(0, 0).addBox(2.2961F, 5.1683F, -5.375F, 1.0F, 0.75F, 0.75F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(2.3961F, 5.0683F, -5.475F, 1.7F, 0.95F, 0.95F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.9333F, 0.2119F, 0.002F, 0.0F, 0.0F, 0.3927F));

        PartDefinition CubeHilt1_r1 = bone.addOrReplaceChild("CubeHilt1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.3961F, 5.1683F, -5.375F, 1.0F, 0.75F, 0.75F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.1961F, 5.0683F, -5.475F, 1.7F, 0.95F, 0.95F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8083F, 0.9119F, 0.002F, 0.0F, 0.0F, -0.3927F));

        PartDefinition InnerHilt1_r1 = bone.addOrReplaceChild("InnerHilt1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(2.3961F, 5.0683F, -5.5F, 1.7F, 0.95F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0083F, 0.2119F, 0.002F, 0.0F, 0.0F, 0.3927F));

        PartDefinition OuterDiamond_r2 = bone.addOrReplaceChild("OuterDiamond_r2", CubeListBuilder.create().texOffs(0, 0).addBox(3.4926F, 3.4176F, -5.55F, 1.65F, 1.65F, 1.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.6926F, 3.6176F, -5.725F, 0.1F, 1.25F, 1.45F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.8926F, 3.8176F, -5.825F, 0.85F, 0.85F, 1.65F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.5926F, 3.5176F, -5.65F, 1.45F, 1.45F, 1.3F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0583F, 0.6119F, 0.002F, 0.0F, 0.0F, 0.7854F));

        PartDefinition InnerDiamond24_r1 = bone.addOrReplaceChild("InnerDiamond24_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.8583F, 3.6176F, -5.725F, 0.1F, 1.25F, 1.45F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.727F, 3.6176F, -5.725F, 0.1F, 1.25F, 1.45F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0118F, 0.6583F, 0.002F, 0.0F, 0.0F, -0.7854F));

        PartDefinition InnerDiamond22_r1 = bone.addOrReplaceChild("InnerDiamond22_r1", CubeListBuilder.create().texOffs(0, 0).addBox(3.6926F, 3.6176F, -5.725F, 0.1F, 1.25F, 1.45F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.2583F, 1.4119F, 0.002F, 0.0F, 0.0F, 0.7854F));

        PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 0).addBox(6.3917F, 6.7869F, -5.398F, 1.25F, 5.0F, 0.8F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.3667F, 7.3869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.3667F, 7.7869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.3667F, 8.1869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.3667F, 8.5869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.3667F, 8.9869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.3667F, 9.3869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.3667F, 9.7869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.3667F, 10.1869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.3667F, 10.5869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.3667F, 10.9869F, -5.423F, 1.3F, 0.2F, 0.85F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.4967F, -9.8381F, -5.398F, 0.95F, 16.0F, 0.775F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.2467F, -9.8381F, -5.248F, 1.0F, 16.0F, 0.475F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.6967F, -9.8381F, -5.248F, 1.0F, 16.0F, 0.475F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3583F, 17.827F, -0.1119F, 0.0F, -1.5708F, 1.5708F));

        PartDefinition cube_r2 = bone2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(3.8926F, 3.8926F, -4.5F, 0.7F, 0.7F, 0.575F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.7426F, 3.7426F, -4.4F, 1.0F, 1.0F, 0.375F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9667F, -15.8131F, -0.798F, 0.0F, 0.0F, 0.7854F));

        PartDefinition OuterDIamond_r3 = bone2.addOrReplaceChild("OuterDIamond_r3", CubeListBuilder.create().texOffs(0, 0).addBox(3.6926F, 3.6176F, -5.525F, 1.25F, 1.25F, 1.05F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.7926F, 3.7176F, -5.625F, 1.05F, 1.05F, 1.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9417F, 5.6119F, 0.002F, 0.0F, 0.0F, 0.7854F));

        PartDefinition InnerHilt3_r1 = bone2.addOrReplaceChild("InnerHilt3_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.1961F, 5.0683F, -5.5F, 1.7F, 0.95F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2667F, 0.9119F, 0.002F, 0.0F, 0.0F, -0.3927F));

        PartDefinition CubeHilt3_r1 = bone2.addOrReplaceChild("CubeHilt3_r1", CubeListBuilder.create().texOffs(0, 0).addBox(2.2961F, 5.1683F, -5.375F, 1.0F, 0.75F, 0.75F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(2.3961F, 5.0683F, -5.475F, 1.7F, 0.95F, 0.95F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0667F, 0.2119F, 0.002F, 0.0F, 0.0F, 0.3927F));

        PartDefinition CubeHilt2_r2 = bone2.addOrReplaceChild("CubeHilt2_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.3961F, 5.1683F, -5.375F, 1.0F, 0.75F, 0.75F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.1961F, 5.0683F, -5.475F, 1.7F, 0.95F, 0.95F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1917F, 0.9119F, 0.002F, 0.0F, 0.0F, -0.3927F));

        PartDefinition InnerHilt2_r2 = bone2.addOrReplaceChild("InnerHilt2_r2", CubeListBuilder.create().texOffs(0, 0).addBox(2.3961F, 5.0683F, -5.5F, 1.7F, 0.95F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9917F, 0.2119F, 0.002F, 0.0F, 0.0F, 0.3927F));

        PartDefinition OuterDiamond_r4 = bone2.addOrReplaceChild("OuterDiamond_r4", CubeListBuilder.create().texOffs(0, 0).addBox(3.4926F, 3.4176F, -5.55F, 1.65F, 1.65F, 1.1F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.6926F, 3.6176F, -5.725F, 0.1F, 1.25F, 1.45F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.8926F, 3.8176F, -5.825F, 0.85F, 0.85F, 1.65F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.5926F, 3.5176F, -5.65F, 1.45F, 1.45F, 1.3F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9417F, 0.6119F, 0.002F, 0.0F, 0.0F, 0.7854F));

        PartDefinition InnerDiamond25_r1 = bone2.addOrReplaceChild("InnerDiamond25_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.8583F, 3.6176F, -5.725F, 0.1F, 1.25F, 1.45F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.727F, 3.6176F, -5.725F, 0.1F, 1.25F, 1.45F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9882F, 0.6583F, 0.002F, 0.0F, 0.0F, -0.7854F));

        PartDefinition InnerDiamond33_r1 = bone2.addOrReplaceChild("InnerDiamond33_r1", CubeListBuilder.create().texOffs(0, 0).addBox(3.6926F, 3.6176F, -5.725F, 0.1F, 1.25F, 1.45F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.7417F, 1.4119F, 0.002F, 0.0F, 0.0F, 0.7854F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
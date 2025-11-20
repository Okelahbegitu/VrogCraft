package net.vrogcraft.entity.projectile;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;
import net.vrogcraft.client.gui.CCManifestationSwordGUI;
import net.vrogcraft.init.ModEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class Entanglement extends AbstractArrow {

    private int lifetime = 10; // detik
    private int tick2s = 0;
    private boolean temporaryNophysics = false;
    private int noPhysicsTicks = 0;

    public Entanglement(EntityType<? extends Entanglement> type, Level world) {
        super(type, world);
        this.setNoGravity(true); // projectile tidak jatuh
    }

    public Entanglement(Level world, LivingEntity shooter) {
        this(ModEntity.ENTANGLEMENT.get(), world);
        this.setOwner(shooter);
    }


    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public void tick() {
        super.tick();

        // server-side: lifetime
        if (!level().isClientSide) {
            Vec3 oldPos = position();
            super.tick();
            // tembus semua block
            //this.setPos(getX(), getY(), getZ()); // ignore block collision
            tick2s++;
            if (tick2s >= 20) {
                lifetime--;
                tick2s = 0;
                if (lifetime <= 0) remove(RemovalReason.DISCARDED);
            }
        }

        // client-side: particle
        if (level().isClientSide) {
            level().addParticle(ParticleTypes.FLAME, getX(), getY(), getZ(), 0, 0, 0);
        }
    }

    @Override
    protected void doPostHurtEffects(LivingEntity entity) {
        super.doPostHurtEffects(entity);
        this.setNoPhysics(false);
        if (!level().isClientSide) {
            entity.setHealth(entity.getHealth() - 5.0f);
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 255, false, false));
            entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 255, false, false));
        }
    }
    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);

        if (!level().isClientSide()) {
            level().explode(this, getX(), getY(), getZ(), 5.0f, Level.ExplosionInteraction.NONE);
            this.discard(); // hapus proyektil setelah meledak
        }
    }

    //@Override
    //protected void onHitEntity(EntityHitResult result) {
    //    super.onHitEntity(result);
    //    if (!level().isClientSide()) {
    //        if (result.getEntity() instanceof Player) {
    //            Player player = (Player) result.getEntity();
    //            Minecraft.getInstance().setScreen(new CCManifestationSwordGUI());
    //        }
    //    }
    //}


    public static void shoot(Level world, LivingEntity shooter, float velocity, float inaccuracy, int piercing) {
        if (world.isClientSide) return;

        Entanglement projectile = new Entanglement(world, shooter);

        // --- POSISI AWAL (lebih akurat dan sejajar kamera) ---
        double x = shooter.getX() - (double)(Mth.cos(shooter.getYRot() * ((float)Math.PI / 180F)) * 0.16F);
        double y = shooter.getEyeY() - 0.15F; // BUKAN -1.0F
        double z = shooter.getZ() - (double)(Mth.sin(shooter.getYRot() * ((float)Math.PI / 180F)) * 0.16F);
        projectile.setPos(x, y, z);

        // --- ARAH TEMBAK —
        projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0.0F, velocity, inaccuracy);

        projectile.setOwner(shooter);
        projectile.setPierceLevel((byte) piercing);
        projectile.setNoGravity(true); // cocok untuk energy beam / bolt

        world.addFreshEntity(projectile);
    }


}



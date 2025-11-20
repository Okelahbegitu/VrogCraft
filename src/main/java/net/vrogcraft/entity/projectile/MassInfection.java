package net.vrogcraft.entity.projectile;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.vrogcraft.init.ModEntity;

public class MassInfection extends AbstractArrow {

    private int lifetime = 10;
    private int tick2s = 0;

    // Constructor 1: Untuk registrasi (dipanggil oleh Forge)
    public MassInfection(EntityType<? extends MassInfection> type, Level world) {
        super(type, world);
        this.setNoGravity(true);
    }

    // Constructor 2: Untuk spawning manual (dipanggil dari code)
    public MassInfection(Level world, LivingEntity shooter) {
        super(ModEntity.MASS_INFECTION.get(), world);  // Langsung ke super, BUKAN this()
        this.setOwner(shooter);
        this.setNoGravity(true);
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public void tick() {
        super.tick();

        if (!level().isClientSide) {
            tick2s++;
            if (tick2s >= 20) {
                lifetime--;
                tick2s = 0;
                if (lifetime <= 0) remove(RemovalReason.DISCARDED);
            }
        }

        if (level().isClientSide) {
            level().addParticle(ParticleTypes.FLAME, getX(), getY(), getZ(), 0, 0, 0);
        }
    }

    @Override
    protected void doPostHurtEffects(LivingEntity entity) {
        super.doPostHurtEffects(entity);
        this.setNoPhysics(false);
        if (!level().isClientSide) {
            entity.setHealth(entity.getHealth() - 10.0f);
            entity.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 5));
            entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 2));
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!level().isClientSide()) {
            level().explode(this, getX(), getY(), getZ(), 2.5f, Level.ExplosionInteraction.NONE);
            this.discard();
        }
    }

    public static void shoot(Level world, LivingEntity shooter, float velocity, float inaccuracy, int piercing) {
        if (world.isClientSide) return;

        MassInfection projectile = new MassInfection(world, shooter);

        // 🔥 Tentukan posisi awal dulu
        double x = shooter.getX() - (double)(Mth.cos(shooter.getYRot() * ((float)Math.PI / 180F)) * 0.16F);
        double y = shooter.getEyeY() - 0.15F; // 🔥 bukan -1.0F
        double z = shooter.getZ() - (double)(Mth.sin(shooter.getYRot() * ((float)Math.PI / 180F)) * 0.16F);
        projectile.setPos(x, y, z);

        // 🔥 Baru tentukan arah
        projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0.0F, velocity, inaccuracy);

        projectile.setOwner(shooter);
        projectile.setPierceLevel((byte) piercing);
        projectile.setNoGravity(true);

        world.addFreshEntity(projectile);
    }

}
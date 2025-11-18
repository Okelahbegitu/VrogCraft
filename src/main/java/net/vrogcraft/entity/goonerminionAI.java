package net.vrogcraft.entity;
import net.minecraft.ResourceLocationException;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.vrogcraft.init.ModSound;
import org.jetbrains.annotations.Nullable;

public class goonerminionAI extends TamableAnimal {
    public void onAddedToWorld(){
        super.onAddedToWorld();
        if (!level().isClientSide) {
            // Gunakan SoundSource.NEUTRAL atau MOB
            level().playSound(
                    null,
                    this.blockPosition(),
                    ModSound.MINION_SUMMON.get(),
                    SoundSource.NEUTRAL, // Menggunakan NEUTRAL, atau Anda bisa gunakan HOSTILE/MOB
                    1.0F,
                    1.0F
            );
        }

    }
    public goonerminionAI(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        System.out.println("Oit oit ucap minion");
        return ModSound.MINION_IDLE.get();
    }


    public static AttributeSupplier.Builder createAttributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)   // default health
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 4.0D);
    }

    @Override
    protected void registerGoals() {
        // Goal wajib untuk TamableAnimal, diprioritas 0
        this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
        // Mengikuti Owner, diprioritas 0 atau 1
        this.goalSelector.addGoal(0, new FollowOwnerGoal(this, 10.0D, 40.0F, 2.0F, true));

        // Attack Goal (prioritas 1)
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2D, true));

        // Goal non-prioritas
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new FloatGoal(this)); // Untuk memastikan mob tidak tenggelam
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));

        // Proteksi owner (Target Goals)
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }
}

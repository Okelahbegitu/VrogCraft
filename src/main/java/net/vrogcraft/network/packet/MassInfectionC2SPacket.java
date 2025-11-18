package net.vrogcraft.network.packet;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import net.vrogcraft.entity.projectile.MassInfection;
import net.vrogcraft.init.DelayedActionManager;
import net.vrogcraft.init.ModItems;
import net.vrogcraft.init.ModSound;
import net.vrogcraft.item.tool.sword.ManifestationSword;

import java.util.List;
import java.util.function.Supplier;

public class MassInfectionC2SPacket {
    public MassInfectionC2SPacket() {}
    public MassInfectionC2SPacket(FriendlyByteBuf buf) {}
    public void toBytes(FriendlyByteBuf buf) {}

    public void handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ItemStack stack = player.getMainHandItem();
            CompoundTag tag = stack.getOrCreateTag();
            if (player != null) {
                ItemStack mainHand = player.getMainHandItem();
                if (mainHand.getItem() instanceof ManifestationSword && tag.getInt("MassInfectionCD") <= 0) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 100));
                    player.level().playSound(
                            null, // semua pemain di sekitar
                            player.blockPosition(), // posisi sound
                            ModSound.MASS_INFECTION_SFX.get(), // SoundEvent
                            SoundSource.PLAYERS, // kategori suara (PLAYER, NEUTRAL, BLOCKS, dll)
                            1.0f, // volume
                            1.0f  // pitch
                    );
                    player.level().playSound(
                            null, // semua pemain di sekitar
                            player.blockPosition(), // posisi sound
                            ModSound.MASS_INFECTION_VC.get(), // SoundEvent
                            SoundSource.PLAYERS, // kategori suara (PLAYER, NEUTRAL, BLOCKS, dll)
                            1.0f, // volume
                            1.0f  // pitch
                    );
                    DelayedActionManager.startDelay(player, 20, () -> {
                        MassInfection.shoot(player.level(), player, 3f, 0f, 100);
                        tag.putInt("MassInfectionCD", 15);
                    });

                }
            }

        });
        context.setPacketHandled(true);
    }
}

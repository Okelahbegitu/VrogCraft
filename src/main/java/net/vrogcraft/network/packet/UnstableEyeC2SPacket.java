package net.vrogcraft.network.packet;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.vrogcraft.init.DelayedActionManager;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import net.vrogcraft.init.ModItems;
import net.vrogcraft.init.ModSound;
import net.vrogcraft.item.tool.sword.ManifestationSword;


import java.util.List;
import java.util.function.Supplier;

public class UnstableEyeC2SPacket {

    public UnstableEyeC2SPacket() {
    }

    public UnstableEyeC2SPacket(net.minecraft.network.FriendlyByteBuf buf) {
    }

    public void toBytes(net.minecraft.network.FriendlyByteBuf buf) {
    }

    public void handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player == null) return;
            Level level = player.level();
            // Radius 150
            double radius = 150.0D;
            if (player.getMainHandItem().is(ModItems.MANIFESTATION_SWORD.get())) {
                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 1, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
                player.level().playSound(
                        null, // semua pemain di sekitar
                        player.blockPosition(), // posisi sound
                        ModSound.UNSTABLE_EYE_SFX.get(), // SoundEvent
                        SoundSource.PLAYERS, // kategori suara (PLAYER, NEUTRAL, BLOCKS, dll)
                        1.0f, // volume
                        1.0f  // pitch
                );
                DelayedActionManager.startDelay(player, 25, () -> {
                List<Entity> nearby = level.getEntities(player, player.getBoundingBox().inflate(radius));
                ItemStack stack = player.getMainHandItem();
                CompoundTag tag = stack.getOrCreateTag();
                ItemStack mainHand = player.getMainHandItem();
                if (mainHand.getItem() instanceof ManifestationSword && tag.getInt("UnStableEyeCD") <= 0) {
                    player.level().playSound(
                            null, // semua pemain di sekitar
                            player.blockPosition(), // posisi sound
                            ModSound.UNSTABLE_EYE_VC.get(), // SoundEvent
                            SoundSource.PLAYERS, // kategori suara (PLAYER, NEUTRAL, BLOCKS, dll)
                            1.0f, // volume
                            1.0f  // pitch
                    );
                    for (Entity entity : nearby) {
                        if (entity instanceof LivingEntity living && entity != player) {
                            living.addEffect(new MobEffectInstance(MobEffects.GLOWING, 120, 0, false, false)); // 100 ticks = 5s
                        }
                    }
                    tag.putInt("UnStableEyeCD", 30);
                }
                });
            }
        });
        context.setPacketHandled(true);
    }
}

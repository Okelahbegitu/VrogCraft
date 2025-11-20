package net.vrogcraft.network.packet;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import net.vrogcraft.entity.goonerminionAI;
import net.vrogcraft.init.DelayedActionManager;
import net.vrogcraft.init.ModEntity;
import net.vrogcraft.init.ModItems;
import net.vrogcraft.init.ModSound;
import net.vrogcraft.item.tool.sword.ManifestationSword;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class RujenvenateTheRottenC2SPacket {

    public RujenvenateTheRottenC2SPacket() {
    }

    public RujenvenateTheRottenC2SPacket(net.minecraft.network.FriendlyByteBuf buf) {
    }

    public void toBytes(net.minecraft.network.FriendlyByteBuf buf) {
    }

    public void handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player == null) return;
            ServerLevel world = (ServerLevel) player.level();


            ItemStack stack = player.getMainHandItem();
            CompoundTag tag = stack.getOrCreateTag();
            Level level = player.level();
            if (tag.getInt("Soul") >=1 && player.getMainHandItem().getItem() instanceof ManifestationSword && tag.getInt("RujenvenateTheRottenCD") <= 0) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 100));
                player.level().playSound(
                        null, // semua pemain di sekitar
                        player.blockPosition(), // posisi sound
                        ModSound.NECROMANCY_VC.get(), // SoundEvent
                        SoundSource.PLAYERS, // kategori suara (PLAYER, NEUTRAL, BLOCKS, dll)
                        1.0f, // volume
                        1.0f  // pitch
                );
                DelayedActionManager.startDelay(player, 45, () -> {
                for (int i = tag.getInt("Soul"); i > 0; i--) {
                    goonerminionAI minion = new goonerminionAI(ModEntity.GOONERMINION.get(),  level);
                    Random rand = new Random();
                    minion.moveTo(player.getX() + rand.nextInt(-15, 15) , player.getY(), player.getZ() + rand.nextInt(-15, 15));
                    minion.setTame(true);
                    minion.setOwnerUUID(player.getUUID());
                    world.addFreshEntity(minion);
                    tag.putInt("Soul", tag.getInt("Soul") - 1);
                }
                });
                tag.putInt("RujenvenateTheRottenCD", 120);
            }
        });
        context.setPacketHandled(true);
    }
}

package net.vrogcraft.network.packet;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import net.vrogcraft.entity.projectile.Entanglement;
import net.vrogcraft.entity.projectile.MassInfection;
import net.vrogcraft.init.DelayedActionManager;
import net.vrogcraft.init.ModSound;
import net.vrogcraft.item.tool.sword.ManifestationSword;

import java.util.function.Supplier;

public class EntanglementC2SPacket {
    public EntanglementC2SPacket() {}
    public EntanglementC2SPacket(FriendlyByteBuf buf) {}
    public void toBytes(FriendlyByteBuf buf) {}

    public void handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ItemStack stack = player.getMainHandItem();
            CompoundTag tag = stack.getOrCreateTag();
            if (player != null) {
                ItemStack mainHand = player.getMainHandItem();
                if (mainHand.getItem() instanceof ManifestationSword && tag.getInt("EntanglementCD") <= 0) {
                    player.level().playSound(
                            null, // semua pemain di sekitar
                            player.blockPosition(), // posisi sound
                            ModSound.ENTANGLEMENT_SFX.get(), // SoundEvent
                            SoundSource.PLAYERS, // kategori suara (PLAYER, NEUTRAL, BLOCKS, dll)
                            1.0f, // volume
                            1.0f  // pitch
                    );
                    player.level().playSound(
                            null, // semua pemain di sekitar
                            player.blockPosition(), // posisi sound
                            ModSound.ENTANGLEMENT_VC.get(), // SoundEvent
                            SoundSource.PLAYERS, // kategori suara (PLAYER, NEUTRAL, BLOCKS, dll)
                            1.0f, // volume
                            1.0f  // pitch
                    );
                    DelayedActionManager.startDelay(player, 25, () -> {
                        Entanglement.shoot(player.level(), player, 3f, 3f, 3);
                        tag.putInt("EntanglementCD", 15);
                    });

                }
            }

        });
        context.setPacketHandled(true);
    }
}

package net.vrogcraft.client.event;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vrogcraft.VrogcraftMod;
import net.vrogcraft.client.key.ModKeyBindings;
import net.vrogcraft.network.ModMessages;
import net.vrogcraft.network.packet.EntanglementC2SPacket;
import net.vrogcraft.network.packet.MassInfectionC2SPacket;
import net.vrogcraft.network.packet.RujenvenateTheRottenC2SPacket;
import net.vrogcraft.network.packet.UnstableEyeC2SPacket;

@Mod.EventBusSubscriber(modid = VrogcraftMod.MODID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        // pastikan hanya jalan di phase END, biar aman
        if (event.phase == TickEvent.Phase.END) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player == null) return;

            // deteksi tombol ditekan
            if (ModKeyBindings.UNSTABLE_EYE_KEY.consumeClick()) {
                System.out.println("[DEBUG] Tombol Unstable Eye ditekan!");
                ModMessages.sendToServer(new UnstableEyeC2SPacket());
            }
            if (ModKeyBindings.MASS_INFECTION_KEY.consumeClick()) {
                System.out.println("[DEBUG] Tombol Mass Infection ditekan!");
                ModMessages.sendToServer(new MassInfectionC2SPacket());
            }
            if (ModKeyBindings.ENTANGLEMENT_KEY.consumeClick()) {
                System.out.println("[DEBUG] Tombol Entanglement ditekan!");
                ModMessages.sendToServer(new EntanglementC2SPacket());
            }
            if (ModKeyBindings.REJUVENATE_THE_ROTTEN_KEY.consumeClick()) {
                System.out.println("[DEBUG] Tombol Rujenvante ditekan!");
                ModMessages.sendToServer(new RujenvenateTheRottenC2SPacket());
            }
        }
    }
}

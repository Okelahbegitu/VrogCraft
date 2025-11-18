package net.vrogcraft.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.vrogcraft.VrogcraftMod;
import net.vrogcraft.network.packet.*;

public class ModMessages {
    private static SimpleChannel INSTANCE;
    private static int packetId = 0;
    private static int id() { return packetId++; }

    public static void register() {
        INSTANCE = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(VrogcraftMod.MODID, "messages"),
                () -> "1.0",
                s -> true,
                s -> true
        );

        INSTANCE.messageBuilder(UnstableEyeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(UnstableEyeC2SPacket::new)
                .encoder(UnstableEyeC2SPacket::toBytes)
                .consumerMainThread(UnstableEyeC2SPacket::handle)
                .add();

        INSTANCE.messageBuilder(MassInfectionC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(MassInfectionC2SPacket::new)
                .encoder(MassInfectionC2SPacket::toBytes)
                .consumerMainThread(MassInfectionC2SPacket::handle)
                .add();
        INSTANCE.messageBuilder(EntanglementC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(EntanglementC2SPacket::new)
                .encoder(EntanglementC2SPacket::toBytes)
                .consumerMainThread(EntanglementC2SPacket::handle)
                .add();
        INSTANCE.messageBuilder(RujenvenateTheRottenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(RujenvenateTheRottenC2SPacket::new)
                .encoder(RujenvenateTheRottenC2SPacket::toBytes)
                .consumerMainThread(RujenvenateTheRottenC2SPacket::handle)
                .add();

    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }
}

package net.vrogcraft.client.key;

import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.fml.common.Mod;
import net.vrogcraft.network.ModMessages;
import  net.vrogcraft.network.ModMessages;
import net.vrogcraft.network.packet.*;

public class KeyInputHandler {
    public static void KeyInputHandler(InputEvent event)
    {
        if (ModKeyBindings.UNSTABLE_EYE_KEY.consumeClick())
        {
            ModMessages.sendToServer(new UnstableEyeC2SPacket());
        } else if (ModKeyBindings.MASS_INFECTION_KEY.consumeClick()) {
            ModMessages.sendToServer(new MassInfectionC2SPacket());
        } else  if (ModKeyBindings.ENTANGLEMENT_KEY.consumeClick()) {
            ModMessages.sendToServer(new EntanglementC2SPacket());
        } else if (ModKeyBindings.REJUVENATE_THE_ROTTEN_KEY.consumeClick()) {
            ModMessages.sendToServer(new RujenvenateTheRottenC2SPacket());
        }
    }
}

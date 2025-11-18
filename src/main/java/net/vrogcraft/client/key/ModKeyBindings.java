package net.vrogcraft.client.key;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModKeyBindings {
    public static final KeyMapping UNSTABLE_EYE_KEY = new KeyMapping(
            "key.vrogcraft.unstable_eye",
            GLFW.GLFW_KEY_UNKNOWN, // default: NONE
            "key.categories.manifestation_sword_skill"
    );
    public static final KeyMapping MASS_INFECTION_KEY = new KeyMapping(
            "key.vrogcraft.mass_infection",
            GLFW.GLFW_KEY_UNKNOWN, // default: NONE
            "key.categories.manifestation_sword_skill"
    );
    public static final KeyMapping ENTANGLEMENT_KEY = new KeyMapping(
            "key.vrogcraft.entanglement",
            GLFW.GLFW_KEY_UNKNOWN, // default: NONE
            "key.categories.manifestation_sword_skill"
    );
    public static final KeyMapping REJUVENATE_THE_ROTTEN_KEY = new KeyMapping(
            "key.vrogcraft.rejunvenate_the_rotten",
            GLFW.GLFW_KEY_UNKNOWN, // default: NONE
            "key.categories.manifestation_sword_skill"
    );

    @SubscribeEvent
    public static void register(RegisterKeyMappingsEvent event) {

        event.register(UNSTABLE_EYE_KEY);
        event.register(MASS_INFECTION_KEY);
        event.register(ENTANGLEMENT_KEY);
        event.register(REJUVENATE_THE_ROTTEN_KEY);
    }
}
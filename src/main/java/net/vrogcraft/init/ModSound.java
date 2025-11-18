package net.vrogcraft.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vrogcraft.VrogcraftMod;

public class ModSound {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, VrogcraftMod.MODID);

    public static final RegistryObject<SoundEvent> MINION_SUMMON =
            SOUNDS.register("minion_summon", () ->SoundEvent.createVariableRangeEvent(new ResourceLocation(VrogcraftMod.MODID, "minion_summon")));

    public static final RegistryObject<SoundEvent> MINION_IDLE =
            SOUNDS.register("minion_idle", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(VrogcraftMod.MODID, "minion_idle")));

    public static final RegistryObject<SoundEvent> MASS_INFECTION_VC =
            SOUNDS.register("manifestation_sword_mass_infection_vc", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(VrogcraftMod.MODID, "manifestation_sword_mass_infection_vc")));

    public static final RegistryObject<SoundEvent> MASS_INFECTION_SFX =
            SOUNDS.register("manifestation_sword_mass_infection_sfx", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(VrogcraftMod.MODID, "manifestation_sword_mass_infection_sfx")));

    public static final RegistryObject<SoundEvent> ENTANGLEMENT_VC =
            SOUNDS.register("manifestation_sword_entanglement_vc", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(VrogcraftMod.MODID, "manifestation_sword_entanglement_vc")));

    public static final RegistryObject<SoundEvent> ENTANGLEMENT_SFX =
            SOUNDS.register("manifestation_sword_entanglement_sfx", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(VrogcraftMod.MODID, "manifestation_sword_entanglement_sfx")));

    public static final RegistryObject<SoundEvent> UNSTABLE_EYE_VC =
            SOUNDS.register("manifestation_sword_unstable_eye_vc", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(VrogcraftMod.MODID, "manifestation_sword_unstable_eye_vc")));

    public static final RegistryObject<SoundEvent> UNSTABLE_EYE_SFX =
            SOUNDS.register("manifestation_sword_unstable_eye_sfx", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(VrogcraftMod.MODID, "manifestation_sword_unstable_eye_sfx")));

    public static final RegistryObject<SoundEvent> NECROMANCY_VC =
            SOUNDS.register("manifestation_sword_necromancy_vc", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(VrogcraftMod.MODID, "manifestation_sword_necromancy_vc")));
}

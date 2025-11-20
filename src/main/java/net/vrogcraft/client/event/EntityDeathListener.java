package net.vrogcraft.client.event;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.vrogcraft.item.tool.sword.ManifestationSword;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EntityDeathListener {
    @SubscribeEvent
    public static void onLivingDeathEvent(LivingDeathEvent event) {
        Entity killer = event.getSource().getEntity();
        Entity victim = event.getEntity();
        if (killer instanceof Player player) {
            ItemStack stack = player.getMainHandItem();
            if (stack.getItem() instanceof ManifestationSword) {
                CompoundTag tag = stack.getOrCreateTag();
                int soul = tag.getInt("Soul");
                if (soul < 25) {
                    tag.putInt("Soul", soul + 1);
                    player.displayClientMessage(Component.literal("Soul 1+"), false);
                }
            }
        }
    }
}

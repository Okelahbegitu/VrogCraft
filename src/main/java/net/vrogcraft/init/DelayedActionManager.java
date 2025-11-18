package net.vrogcraft.init;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Mod.EventBusSubscriber
public class DelayedActionManager {
    // Ubah Map: Sekarang menyimpan Runnable (aksi) dan Integer (ticks)
    private static final Map<ServerPlayer, Map.Entry<Runnable, Integer>> delayedActions = new HashMap<>();

    public static void startDelay(ServerPlayer player, int ticks, Runnable action) {
        // SimpleImmutableEntry digunakan untuk menyimpan pasangan nilai (aksi dan waktu)
        delayedActions.put(player, Map.entry(action, ticks));
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && !delayedActions.isEmpty()) {
            Iterator<Map.Entry<ServerPlayer, Map.Entry<Runnable, Integer>>> it = delayedActions.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ServerPlayer, Map.Entry<Runnable, Integer>> mapEntry = it.next();

                Runnable action = mapEntry.getValue().getKey();
                int newTime = mapEntry.getValue().getValue() - 1;

                if (newTime <= 0) {
                    // 1. Waktu Habis: LAKUKAN AKSI
                    action.run();

                    // 2. Hapus dari map
                    it.remove();
                } else {
                    // 3. Update Waktu
                    delayedActions.put(mapEntry.getKey(), Map.entry(action, newTime));
                }
            }
        }
    }
}
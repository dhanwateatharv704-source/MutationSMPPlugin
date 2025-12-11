package com.mutationsmp;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class AbilityHandler {

    private final HashMap<UUID, Long> cooldowns = new HashMap<>();

    public void usePower(Player player, int power) {
        UUID uuid = player.getUniqueId();
        long now = System.currentTimeMillis();
        long last = cooldowns.getOrDefault(uuid, 0L);

        if (now - last < 1000 * 60) { // 1-minute cooldown for ultimate
            player.sendMessage("§cUltimate power is on cooldown!");
            return;
        }

        switch (power) {
            case 1 -> player.sendMessage("§aUsed Power 1!");
            case 2 -> player.sendMessage("§aUsed Power 2!");
            case 3 -> player.sendMessage("§aUsed Power 3!");
            case 4 -> player.sendMessage("§aUsed Power 4!");
            case 5 -> player.sendMessage("§6Used Ultimate Power 5!");
        }

        cooldowns.put(uuid, now);

        // Optional: Add small particle effect
        new BukkitRunnable() {
            @Override
            public void run() {
                // Particle code here
            }
        }.runTaskLater(MutationSMP.getInstance(), 2L);
    }
}

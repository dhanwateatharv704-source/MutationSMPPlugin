package com.mutationsmp;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GracePeriodManager {

    private boolean graceActive = false;

    public void startGrace(int seconds) {
        graceActive = true;
        Bukkit.broadcastMessage("§bGrace period started! PvP disabled for " + seconds + " seconds.");

        new BukkitRunnable() {
            @Override
            public void run() {
                graceActive = false;
                Bukkit.broadcastMessage("§cPvP is now enabled!");
                // Optional: Play sound for all players
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.playSound(player.getLocation(), "UI_TOAST_CHALLENGE_COMPLETE", 1f, 1f);
                }
            }
        }.runTaskLater(MutationSMP.getInstance(), 20L * seconds);
    }

    public boolean isGraceActive() {
        return graceActive;
    }
}

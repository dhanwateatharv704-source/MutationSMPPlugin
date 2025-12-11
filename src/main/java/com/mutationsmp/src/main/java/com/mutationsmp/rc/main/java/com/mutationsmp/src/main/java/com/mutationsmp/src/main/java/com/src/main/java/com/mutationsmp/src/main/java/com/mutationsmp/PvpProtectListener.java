package com.mutationsmp;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Player;

public class PvpProtectListener implements Listener {

    @EventHandler
    public void onPvp(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        if (!(e.getDamager() instanceof Player)) return;

        if (MutationSMP.getInstance().getGraceManager().isGraceActive()) {
            e.setCancelled(true);
            ((Player) e.getDamager()).sendMessage("§cPvP is disabled during grace period!");
        }
    }
}

package com.mutationsmp;

import org.bukkit.entity.Player;

public class SoundHelper {

    public static void playSound(Player player, String soundKey) {
        player.playSound(player.getLocation(), soundKey, 1f, 1f);
    }
}

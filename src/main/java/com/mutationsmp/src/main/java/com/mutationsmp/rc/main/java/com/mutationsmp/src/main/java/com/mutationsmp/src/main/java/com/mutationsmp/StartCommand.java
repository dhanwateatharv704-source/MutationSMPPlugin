package com.mutationsmp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) return true;

        String owner = MutationSMP.getInstance().getConfig().getString("owner-name");
        if (!player.getName().equalsIgnoreCase(owner)) {
            player.sendMessage("§cYou are not the owner!");
            return true;
        }

        // Start grace period
        int grace = MutationSMP.getInstance().getConfig().getInt("grace.duration-seconds");
        MutationSMP.getInstance().getGraceManager().startGrace(grace);

        // Assign mutants to all online players
        for (Player p : player.getServer().getOnlinePlayers()) {
            MutationSMP.getInstance().getMutationManager().assignMutation(p);
        }

        player.getServer().broadcastMessage("§bMutation SMP has started!");
        return true;
    }
}

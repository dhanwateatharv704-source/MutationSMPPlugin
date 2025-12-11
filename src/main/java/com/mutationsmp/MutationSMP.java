package com.mutationsmp;

import org.bukkit.plugin.java.JavaPlugin;

public class MutationSMP extends JavaPlugin {

    private static MutationSMP instance;
    private MutationManager mutationManager;
    private GracePeriodManager graceManager;
    private AbilityHandler abilityHandler;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        mutationManager = new MutationManager();
        graceManager = new GracePeriodManager();
        abilityHandler = new AbilityHandler();

        getCommand("start").setExecutor(new StartCommand());
        getServer().getPluginManager().registerEvents(new PvpProtectListener(), this);

        getLogger().info("MutationSMP enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MutationSMP disabled!");
    }

    public static MutationSMP getInstance() {
        return instance;
    }

    public MutationManager getMutationManager() {
        return mutationManager;
    }

    public GracePeriodManager getGraceManager() {
        return graceManager;
    }

    public AbilityHandler getAbilityHandler() {
        return abilityHandler;
    }
}

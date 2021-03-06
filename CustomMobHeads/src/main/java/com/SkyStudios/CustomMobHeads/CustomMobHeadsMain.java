package com.SkyStudios.CustomMobHeads;

import com.SkyStudios.CustomMobHeads.DataBase.DatabaseManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomMobHeadsMain extends JavaPlugin implements Listener{

    private static DatabaseManager databaseManager;

    private static Plugin plugin;

    public void onEnable(){
        plugin = this;

        this.getServer().getLogger().info("CustomMobHeads V1.0.0 Enabled Successfully");
        registerEvents(this, new ItemStacks(), new MobGainCounter(), new MobDrops(), new Collections());
        getCommand("pighead").setExecutor(new Commands());
        getCommand("cowhead").setExecutor(new Commands());
        getCommand("sheephead").setExecutor(new Commands());
        getCommand("chickenhead").setExecutor(new Commands());
        getCommand("pigcounter").setExecutor(new Commands());
        getCommand("cowcounter").setExecutor(new Commands());
        getCommand("sheepcounter").setExecutor(new Commands());
        getCommand("chickencounter").setExecutor(new Commands());
        getCommand("collections").setExecutor(new Commands());
        getCommand("heal").setExecutor(new Commands());
        databaseManager = new DatabaseManager(true);
    }


    public static DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    @Override
    public void onDisable() {
        this.getServer().getLogger().info("CustomMobHeads V1.0.0 Disabled Successfully");
        plugin = null;
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }


    public static Plugin getPlugin() {
        return plugin;
    }
}
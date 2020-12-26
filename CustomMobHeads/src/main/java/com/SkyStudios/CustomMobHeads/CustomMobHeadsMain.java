package com.SkyStudios.CustomMobHeads;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class CustomMobHeadsMain extends JavaPlugin implements Listener{

    private static DatabaseManager databaseManager;

    private static Plugin plugin;

    public void onEnable(){
        plugin = this;

        this.getServer().getLogger().info("CustomMobHeads V1.0.0 Enabled Successfully");
        registerEvents(this, new ItemStacks(), new MobGainCounter(), new MobDrops());
        getCommand("pighead").setExecutor(new Commands());
        getCommand("counter").setExecutor(new Commands());
        getCommand("heal").setExecutor(new Commands());
        databaseManager = new DatabaseManager();
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
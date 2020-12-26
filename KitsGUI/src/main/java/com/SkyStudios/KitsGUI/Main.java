package com.SkyStudios.KitsGUI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Main extends JavaPlugin implements Listener{

    private static Plugin plugin;

    public void onEnable(){
        this.getServer().getLogger().info("KitsGUI V1.0.0 Enabled Successfully");

        plugin = this;
        registerEvents(this, new ItemStacks());
        registerEvents(this, this);

        getCommand("kits").setExecutor(new Commands());
    }

    public void onDisable(){
        this.getServer().getLogger().info("KitsGUI V1.0.0 Disabled Successfully!");
        plugin=null;
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }


    public static Plugin getPlugin() {
        return plugin;
    }

    @EventHandler

    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = (Player) e.getPlayer();

        File f = new File(this.getDataFolder(), "KitsGUI"+p.getName()+".yml");
        if(!(f.exists())) {
            try {
                this.getDataFolder().mkdir();
                f.createNewFile();
                this.getLogger().info("Created File for "+p.getName());
            }
            catch(IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
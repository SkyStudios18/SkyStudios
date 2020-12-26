package com.SkyStudios.KitsGUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class KitsGUI implements Listener {

    static String Prefix = ChatColor.GRAY + "[" + ChatColor.AQUA + "Sky" + ChatColor.RED + "Studios" + ChatColor.GRAY + "] ";
    static String KitsGUIInvDisplay = Prefix + ChatColor.GOLD + "Kits" + ChatColor.BLUE + "GUI";

    static Inventory KitsGUIInv = Bukkit.createInventory(null, 9, KitsGUIInvDisplay);
}

package com.SkyStudios.CustomMobHeads;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.SkyStudios.CustomMobHeads.Collections.collectionsInv;
import static com.SkyStudios.CustomMobHeads.ItemStacks.*;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {

        Player p = (Player) sender;

        int dropHead = p.getInventory().firstEmpty();

        if(cmd.getName().equalsIgnoreCase("pighead")) {
            if(dropHead >= 0){
                p.getInventory().setItem(dropHead, pigheadIS);
            }
            else{
                p.getWorld().dropItemNaturally(p.getLocation(), pigheadIS);
                p.sendMessage("Your Inventory is full, Dropping item...");
            }
        }

        if(cmd.getName().equalsIgnoreCase("cowhead")) {
            if(dropHead >= 0){
                p.getInventory().setItem(dropHead, cowheadIS);
            }
            else{
                p.getWorld().dropItemNaturally(p.getLocation(), cowheadIS);
                p.sendMessage("Your Inventory is full, Dropping item...");
            }
        }

        if(cmd.getName().equalsIgnoreCase("chickenhead")) {
            if(dropHead >= 0){
                p.getInventory().setItem(dropHead, chickenheadIS);
            }
            else{
                p.getWorld().dropItemNaturally(p.getLocation(), chickenheadIS);
                p.sendMessage("Your Inventory is full, Dropping item...");
            }
        }

        if(cmd.getName().equalsIgnoreCase("sheephead")) {
            if(dropHead >= 0){
                p.getInventory().setItem(dropHead, sheepheadIS);
            }
            else{
                p.getWorld().dropItemNaturally(p.getLocation(), sheepheadIS);
                p.sendMessage("Your Inventory is full, Dropping item...");
            }
        }
        if(cmd.getName().equalsIgnoreCase("pigcounter")) {
            p.sendMessage(ChatColor.AQUA + "Your Pig Head Count is: " + ChatColor.GOLD + CustomMobHeadsMain.getDatabaseManager().pigManager.getCounter(p));
        }
        if(cmd.getName().equalsIgnoreCase("cowcounter")) {
            p.sendMessage(ChatColor.AQUA + "Your Cow Head Count is: " + ChatColor.GOLD + CustomMobHeadsMain.getDatabaseManager().cowManager.getCounter(p));
        }
        if(cmd.getName().equalsIgnoreCase("sheepcounter")) {
            p.sendMessage(ChatColor.AQUA + "Your Sheep Head Count is: " + ChatColor.GOLD + CustomMobHeadsMain.getDatabaseManager().sheepManager.getCounter(p));
        }
        if(cmd.getName().equalsIgnoreCase("chickencounter")) {
            p.sendMessage(ChatColor.AQUA + "Your Chicken Head Count is: " + ChatColor.GOLD + CustomMobHeadsMain.getDatabaseManager().chickenManager.getCounter(p));
        }
        if(cmd.getName().equalsIgnoreCase("collections")){
            p.openInventory(collectionsInv);
            p.sendMessage(ChatColor.AQUA + "Opening Collections...");
        }

        if(cmd.getName().equalsIgnoreCase("heal")) {
            p.setHealth(p.getHealthScale());
            p.setFoodLevel(20);
            p.setSaturation(20);
        }

        return true;
    }
}

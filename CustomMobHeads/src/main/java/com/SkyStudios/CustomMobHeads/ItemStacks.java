package com.SkyStudios.CustomMobHeads;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemStacks implements Listener {

    static ItemStack pigheadIS = new ItemStack(Material.PLAYER_HEAD, 1);
    static ItemStack cowheadIS = new ItemStack(Material.PLAYER_HEAD, 1);
    static ItemStack chickenheadIS = new ItemStack(Material.PLAYER_HEAD, 1);
    static ItemStack sheepheadIS = new ItemStack(Material.PLAYER_HEAD, 1);


    @EventHandler

    public void onPlayerInteract(PlayerInteractEvent e) {

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            final ItemStack currentItem = e.getPlayer().getItemInHand();
            if (currentItem.getType() != Material.AIR) {
                if (currentItem.getItemMeta() != null) {
                    if (currentItem.getItemMeta().getDisplayName().equals(ChatColor.RED + "Pig Head " + ChatColor.GREEN + "Right Click " + ChatColor.AQUA + "to add it to your collection.")) {
                        e.getPlayer().sendMessage("Pig Head added to collection. View collection with /collections");
                        e.getPlayer().getInventory().removeItem(currentItem);
                        CustomMobHeadsMain.getDatabaseManager().addPlayer(e.getPlayer());
                        e.setCancelled(true);
                    }
                }
            }
        }
    }

        static {

            SkullMeta cowheadSkullmeta = (SkullMeta) cowheadIS.getItemMeta();
            if(cowheadSkullmeta != null) {
                cowheadSkullmeta.setOwner("MHF_Cow");
                cowheadSkullmeta.setDisplayName(ChatColor.RED + "Cow Head " + ChatColor.GREEN + "Right Click " + ChatColor.AQUA + "to add it to your collection.");
                cowheadIS.setItemMeta(cowheadSkullmeta);
            }

            SkullMeta pigheadSkullmeta = (SkullMeta) pigheadIS.getItemMeta();
            if(pigheadSkullmeta != null) {
                pigheadSkullmeta.setOwner("MHF_Pig");
                pigheadSkullmeta.setDisplayName(ChatColor.RED + "Pig Head " + ChatColor.GREEN + "Right Click " + ChatColor.AQUA + "to add it to your collection.");
                pigheadIS.setItemMeta(pigheadSkullmeta);
            }

            SkullMeta chickenheadSkullmeta = (SkullMeta) chickenheadIS.getItemMeta();
            if(chickenheadSkullmeta != null) {
                chickenheadSkullmeta.setOwner("MHF_Chicken");
                chickenheadSkullmeta.setDisplayName(ChatColor.RED + "Pig Head " + ChatColor.GREEN + "Right Click " + ChatColor.AQUA + "to add it to your collection.");
                chickenheadIS.setItemMeta(pigheadSkullmeta);
            }

            SkullMeta sheepheadSkullmeta = (SkullMeta) sheepheadIS.getItemMeta();
            if(sheepheadSkullmeta != null) {
                sheepheadSkullmeta.setOwner("MHF_Pig");
                sheepheadSkullmeta.setDisplayName(ChatColor.RED + "Pig Head " + ChatColor.GREEN + "Right Click " + ChatColor.AQUA + "to add it to your collection.");
                sheepheadIS.setItemMeta(pigheadSkullmeta);
            }
        }
}
package com.SkyStudios.CustomMobHeads;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Collections;

public class ItemStacks implements Listener {

    static ItemStack pigheadIS = new ItemStack(Material.PLAYER_HEAD, 1);
    static ItemStack cowheadIS = new ItemStack(Material.PLAYER_HEAD, 1);
    static ItemStack chickenheadIS = new ItemStack(Material.PLAYER_HEAD, 1);
    static ItemStack sheepheadIS = new ItemStack(Material.PLAYER_HEAD, 1);
    static ItemStack pigheadcounterIS = new ItemStack(Material.PLAYER_HEAD, 1);
    static ItemStack sheepheadcounterIS = new ItemStack(Material.PLAYER_HEAD, 1);
    static ItemStack chickenheadcounterIS = new ItemStack(Material.PLAYER_HEAD, 1);
    static ItemStack cowheadcounterIS = new ItemStack(Material.PLAYER_HEAD, 1);


    @EventHandler

    public void onPlayerInteract(PlayerInteractEvent e) {

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            final ItemStack currentItem = e.getPlayer().getItemInHand();
            if (currentItem.getType() != Material.AIR) {
                if (currentItem.getItemMeta() != null) {
                    if (currentItem.getItemMeta().getDisplayName().equals(ChatColor.RED + "Pig Head " + ChatColor.GREEN + "Right Click " + ChatColor.AQUA + "to add it to your collection.")) {
                        e.getPlayer().sendMessage(ChatColor.AQUA + "Added " + ChatColor.GREEN + "x" + ChatColor.GOLD + currentItem.getAmount() + ChatColor.AQUA + " to " + ChatColor.RED + "Pig Collection!");
                        CustomMobHeadsMain.getDatabaseManager().pigManager.addPlayer(e.getPlayer(), currentItem.getAmount());
                        e.getPlayer().getInventory().removeItem(currentItem);
                        e.setCancelled(true);
                    }
                    else if (currentItem.getItemMeta().getDisplayName().equals(ChatColor.RED + "Cow Head " + ChatColor.GREEN + "Right Click " + ChatColor.AQUA + "to add it to your collection.")) {
                        e.getPlayer().sendMessage(ChatColor.AQUA + "Added " + ChatColor.GREEN + "x" + ChatColor.GOLD + currentItem.getAmount() + ChatColor.AQUA + " to " + ChatColor.RED + "Cow Collection!");
                        CustomMobHeadsMain.getDatabaseManager().cowManager.addPlayer(e.getPlayer(), currentItem.getAmount());
                        e.getPlayer().getInventory().removeItem(currentItem);
                        e.setCancelled(true);
                    }
                    else if (currentItem.getItemMeta().getDisplayName().equals(ChatColor.RED + "Sheep Head " + ChatColor.GREEN + "Right Click " + ChatColor.AQUA + "to add it to your collection.")) {
                        e.getPlayer().sendMessage(ChatColor.AQUA + "Added " + ChatColor.GREEN + "x" + ChatColor.GOLD + currentItem.getAmount() + ChatColor.AQUA + " to " + ChatColor.RED + "Sheep Collection!");
                        CustomMobHeadsMain.getDatabaseManager().sheepManager.addPlayer(e.getPlayer(), currentItem.getAmount());
                        e.getPlayer().getInventory().removeItem(currentItem);
                        e.setCancelled(true);
                    }
                    else if (currentItem.getItemMeta().getDisplayName().equals(ChatColor.RED + "Chicken Head " + ChatColor.GREEN + "Right Click " + ChatColor.AQUA + "to add it to your collection.")) {
                        e.getPlayer().sendMessage(ChatColor.AQUA + "Added " + ChatColor.GREEN + "x" + ChatColor.GOLD + currentItem.getAmount() + ChatColor.AQUA + " to " + ChatColor.RED + "Chicken Collection!");
                        CustomMobHeadsMain.getDatabaseManager().chickenManager.addPlayer(e.getPlayer(), currentItem.getAmount());
                        e.getPlayer().getInventory().removeItem(currentItem);
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
                chickenheadSkullmeta.setDisplayName(ChatColor.RED + "Chicken Head " + ChatColor.GREEN + "Right Click " + ChatColor.AQUA + "to add it to your collection.");
                chickenheadIS.setItemMeta(chickenheadSkullmeta);
            }

            SkullMeta sheepheadSkullmeta = (SkullMeta) sheepheadIS.getItemMeta();
            if(sheepheadSkullmeta != null) {
                sheepheadSkullmeta.setOwner("MHF_Sheep");
                sheepheadSkullmeta.setDisplayName(ChatColor.RED + "Sheep Head " + ChatColor.GREEN + "Right Click " + ChatColor.AQUA + "to add it to your collection.");
                sheepheadIS.setItemMeta(sheepheadSkullmeta);
            }
        }

        public static ItemStack getPigStack(Player player) {
            ItemStack pigstack = pigheadcounterIS.clone();
            ItemMeta pigheadcounterMeta = pigstack.getItemMeta();
            if(pigheadcounterMeta != null) {
                pigheadcounterMeta.setDisplayName(ChatColor.RED + "Pig Collection" + ChatColor.AQUA + ":");
                pigheadcounterMeta.setLore(Collections.singletonList(ChatColor.GOLD + Integer.toString(CustomMobHeadsMain.getDatabaseManager().pigManager.getCounter(player))));
                pigstack.setItemMeta(pigheadcounterMeta);
            }
            return pigstack;
        }
}
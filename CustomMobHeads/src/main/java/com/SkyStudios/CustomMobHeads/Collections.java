package com.SkyStudios.CustomMobHeads;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static com.SkyStudios.CustomMobHeads.ItemStacks.pigheadcounterIS;
import static org.bukkit.Bukkit.getServer;

public class Collections implements Listener {

    static String collectionsInvDisplay = ChatColor.LIGHT_PURPLE + "Collections";

    static Inventory collectionsInv = getServer().createInventory(null, 9, collectionsInvDisplay);

    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        if(e.getView().getTitle().equals(collectionsInvDisplay)) {
            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
            }
        }

        Player p = (Player) e.getWhoClicked();


        collectionsInv.setItem(0, ItemStacks.getPigStack(p));

        ClickType click = e.getClick();
        Inventory open = e.getClickedInventory();
        ItemStack item = e.getCurrentItem();

        if(open == null) {
            return;
        }
        if(e.getView().getTitle().equals(collectionsInvDisplay)) {

            e.setCancelled(true);

            if(item == (null) || !item.hasItemMeta()) {
                return;
            }
            if(item.getItemMeta() != null && item.getItemMeta().getDisplayName().equals(ChatColor.RED + "Pig Collection" + ChatColor.AQUA + ":")) {
                p.closeInventory();
            }
        }


    }

}

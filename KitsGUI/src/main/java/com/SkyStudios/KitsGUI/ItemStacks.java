package com.SkyStudios.KitsGUI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStacks implements Listener {

    static {


        final String StarterSwordDisplay = ChatColor.AQUA + "Starter " + ChatColor.GOLD + "Sword";


        ItemStack StarterSwordIS = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta StarterSwordMeta = StarterSwordIS.getItemMeta();
        if(StarterSwordMeta != null) {
            StarterSwordMeta.setDisplayName(StarterSwordDisplay);
            StarterSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
            StarterSwordMeta.addEnchant(Enchantment.DURABILITY, 50, true);
            StarterSwordIS.setItemMeta(StarterSwordMeta);
        }
    }

}

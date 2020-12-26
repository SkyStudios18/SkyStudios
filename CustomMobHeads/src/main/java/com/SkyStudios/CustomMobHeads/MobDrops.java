package com.SkyStudios.CustomMobHeads;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MobDrops implements Listener {

    @EventHandler

    public void onEntityDeath(EntityDeathEvent event){
        LivingEntity e = event.getEntity();
        if(e instanceof Pig){
            e.getLocation().getWorld().dropItem(e.getLocation(), ItemStacks.pigheadIS);
        }
        else if(e instanceof Cow){
            e.getLocation().getWorld().dropItem(e.getLocation(), ItemStacks.cowheadIS);
        }
        else if(e instanceof Chicken){
            e.getLocation().getWorld().dropItem(e.getLocation(), ItemStacks.cowheadIS);
        }
        else if(e instanceof Sheep){
            e.getLocation().getWorld().dropItem(e.getLocation(), ItemStacks.cowheadIS);
        }
    }

}

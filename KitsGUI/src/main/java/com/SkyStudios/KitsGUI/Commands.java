package com.SkyStudios.KitsGUI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.SkyStudios.KitsGUI.KitsGUI.KitsGUIInv;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("kits")) {
            p.openInventory(KitsGUIInv);
        }

        return false;
    }
}

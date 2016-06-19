/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.modtools.commands;

import com.lwer0.modtools.inventories.MainInventory;
import static com.lwer0.modtools.inventories.MainInventory.maininv;
import com.lwer0.modtools.inventories.permortemp.PermOrTempBan;
import com.lwer0.modtools.inventories.permortemp.PermOrTempMute;
import com.lwer0.modtools.inventories.temps.TempBansInv;
import com.lwer0.modtools.inventories.temps.TempMuteInv;
import static com.lwer0.modtools.utils.ColorUtil.color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Joel
 */
public class mtopen implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player psender = (Player) sender;
        try {
            MainInventory mainInventory = new MainInventory();
            mainInventory.setName(args[0]);
            PermOrTempBan permortempban = new PermOrTempBan();
            permortempban.setName(args[0]);
            TempBansInv tempbansinv = new TempBansInv();
            tempbansinv.setName(args[0]);
            PermOrTempMute permortempmute = new PermOrTempMute();
            permortempmute.setName(args[0]);
            TempMuteInv tempmuteinv = new TempMuteInv();
            tempmuteinv.setName(args[0]);
        } catch (Exception e) {
            psender.sendMessage(color("&cError al establecer un usuario como nominado a la sancion"));
        }
        if (cmd.getName().equalsIgnoreCase("mt")) {
            if (sender.hasPermission("modtools.moderate")) {
                if (args.length == 0) {
                    sender.sendMessage(color("&cArgumento invalido"));
                    sender.sendMessage(color("&aCorrecto --> /mt <nick>"));
                } else {
                    psender.openInventory(maininv);
                }
            } else {
                sender.sendMessage(color("&cNo Permissions"));
            }
        }
        return false;
    }
    
}


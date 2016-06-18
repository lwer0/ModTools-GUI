/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.modtools.listeners;

import com.lwer0.modtools.ModTools;
import com.lwer0.modtools.inventories.BanInventory;
import com.lwer0.modtools.inventories.MainInventory;
import com.lwer0.modtools.inventories.permortemp.PermOrTempBan;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 *
 * @author Joel
 */
public class InventoryMove implements Listener {
    
    @EventHandler
    public void onInventoryClick (InventoryClickEvent event) {
        Player p = (Player)event.getWhoClicked();
        if (event.getInventory().equals(MainInventory.maininv) || event.getInventory().equals(BanInventory.baninv) || event.getInventory().equals(PermOrTempBan.banpermortempinv)) {
            event.setCancelled(true);
            p.updateInventory();
        }
    }

    public InventoryMove(ModTools aThis) {
    }
    
    
    
}

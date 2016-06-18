/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.modtools.inventories;

import com.lwer0.modtools.ModTools;
import com.lwer0.modtools.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainInventory implements Listener {
    
    private static String name;

    public MainInventory() {
    }
    
    public void naming(String pname) {
        MainInventory.name = pname;
    }
    
    public static Inventory maininv = Bukkit.createInventory(null, 27, ColorUtil.color("&bModTools"));    
    static {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1);
        ItemMeta meta = skull.getItemMeta();
        meta.setDisplayName(name);
        skull.setItemMeta(meta);
        maininv.setItem(4, skull);
    }
    
    public MainInventory(ModTools aThis) {
    } 
}

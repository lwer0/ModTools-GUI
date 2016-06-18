/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.modtools.inventories;

import static com.lwer0.modtools.inventories.MainInventory.maininv;
import com.lwer0.modtools.utils.ColorUtil;
import static com.lwer0.modtools.utils.ColorUtil.color;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Joel
 */
public class BanInventory implements Listener {
    
    public static Inventory baninv = Bukkit.createInventory(null, 27, ColorUtil.color("&2ModTools - Ban"));    
    static {
                //Item 1
        List<String> list = new ArrayList<String>();
        list.add(color("&7Desde aquí puedes"));
        list.add(color("&7manejar los baneos"));
        ItemStack ns1 = new ItemStack (Material.NETHER_STAR, 1);
        ItemMeta im1 = ns1.getItemMeta();
        im1.setDisplayName(color("&4Ban"));
        im1.setLore(list);
        ns1.setItemMeta(im1);
        //Item 2
        ItemStack ns2 = new ItemStack (Material.NETHER_STAR, 1);
        ItemMeta im2 = ns1.getItemMeta();
        //Item 3
        ItemStack ns3 = new ItemStack (Material.NETHER_STAR, 1);
        ItemMeta im3 = ns1.getItemMeta();
        //Item 4
        ItemStack ns4 = new ItemStack (Material.NETHER_STAR, 1);
        ItemMeta im4 = ns1.getItemMeta();
        //Item 5
        ItemStack ns5 = new ItemStack (Material.NETHER_STAR, 1);
        ItemMeta im5 = ns1.getItemMeta();
        baninv.setItem(4, null);
        baninv.setItem(11, ns1);
        baninv.setItem(12, ns2);
        baninv.setItem(13, ns3);
        baninv.setItem(14, ns4);
        baninv.setItem(15, ns5); 
    }
    
}

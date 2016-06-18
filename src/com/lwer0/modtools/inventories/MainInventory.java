/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.modtools.inventories;

import com.lwer0.modtools.ModTools;
import static com.lwer0.modtools.inventories.BanInventory.baninv;
import com.lwer0.modtools.utils.ColorUtil;
import static com.lwer0.modtools.utils.ColorUtil.color;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class MainInventory implements Listener {
    
    private static String name;

    public MainInventory() {
    }
    
    public void setName(String pname) {
        MainInventory.name = pname;
    }
    
    public static Inventory maininv = Bukkit.createInventory(null, 27, ColorUtil.color("&2ModTools"));    
    static {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
        SkullMeta sm = (SkullMeta)head.getItemMeta();
        sm.setOwner(MainInventory.name);
        head.setItemMeta(sm);
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
        maininv.setItem(4, head);
        maininv.setItem(11, ns1);
        maininv.setItem(12, ns2);
        maininv.setItem(13, ns3);
        maininv.setItem(14, ns4);
        maininv.setItem(15, ns5); 
    }
    
    @EventHandler
    public void InvClick (InventoryClickEvent event) {
        Player p = (Player)event.getWhoClicked();
        if (event.getClickedInventory().equals(maininv)) {
            if (event.getSlot() == 11) {
                p.openInventory(baninv);
            }
        }
    }
    
    public MainInventory(ModTools aThis) {
    } 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.modtools.inventories.temps;

import com.lwer0.modtools.ModTools;
import static com.lwer0.modtools.inventories.BanInventory.baninv;
import com.lwer0.modtools.inventories.permortemp.PermOrTempBan;
import static com.lwer0.modtools.inventories.permortemp.PermOrTempBan.banpermortempinv;
import com.lwer0.modtools.utils.ColorUtil;
import static com.lwer0.modtools.utils.ColorUtil.color;
import java.util.ArrayList;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

/**
 *
 * @author Joel
 */
public class TempMuteInv implements Listener {
    
    private ModTools plugin;
    
    public TempMuteInv(ModTools instance) {
        this.plugin = instance;
    }

    private static String name;

    public TempMuteInv() {
    }
    
    public void setName(String pname) {
        TempMuteInv.name = pname;
    }
    
    public static Inventory tempmuteinv = Bukkit.createInventory(null, 27, ColorUtil.color("&2ModTools"));
    
    static {
        for(Player players : Bukkit.getOnlinePlayers()) {
            if(!players.getName().equals(name)) {
                
                    List<String> lorename = new ArrayList<String>();
                    lorename.add(color("&cJugador el cual"));
                    lorename.add(color("&cva a ser sancionado"));
 
                    String pl = players.getName();
                    ItemStack skull = new ItemStack(Material.SKULL_ITEM);
                    skull.setDurability((short)3);
                    SkullMeta sm = (SkullMeta) skull.getItemMeta();
                    sm.setOwner(pl);
                    sm.setDisplayName(ChatColor.AQUA + "" + pl);
                    sm.setLore(lorename);
                    skull.setItemMeta(sm);
 
                    tempmuteinv.setItem(4, skull);
            }
         }
        
        //Item 1
        List<String> list = new ArrayList<String>();
        ItemStack ns1 = new ItemStack (Material.FIREWORK_CHARGE, 10);
        ItemMeta im1 = ns1.getItemMeta();
        im1.setDisplayName(color("&410 Minutos"));
        im1.setLore(list);
        ns1.setItemMeta(im1);
        //Item 2
        ItemStack ns2 = new ItemStack (Material.FIREWORK_CHARGE, 30);
        ItemMeta im2 = ns1.getItemMeta();
        im2.setDisplayName(color("&430 Minutos"));
        im2.setLore(list);
        ns2.setItemMeta(im2);
        //Item 3
        ItemStack ns3 = new ItemStack (Material.FIREWORK_CHARGE, 60);
        ItemMeta im3 = ns1.getItemMeta();
        im3.setDisplayName(color("&41 hora"));
        im3.setLore(list);
        ns3.setItemMeta(im3);
        //Item 4
        ItemStack ns4 = new ItemStack (Material.FIREWORK_CHARGE, 24);
        ItemMeta im4 = ns1.getItemMeta();
        im4.setDisplayName(color("&41 dia"));
        im4.setLore(list);
        ns4.setItemMeta(im4);
        //Item 5
        ItemStack ns5 = new ItemStack (Material.FIREWORK_CHARGE, 7);
        ItemMeta im5 = ns1.getItemMeta();
        im5.setDisplayName(color("&41 semana"));
        im5.setLore(list);
        ns5.setItemMeta(im5);
        
        
        tempmuteinv.setItem(11, ns1);
        tempmuteinv.setItem(12, ns2);
        tempmuteinv.setItem(13, ns3);
        tempmuteinv.setItem(14, ns4);
        tempmuteinv.setItem(15, ns5); 
    }

    
    @EventHandler
    public void onInventoryClick (InventoryClickEvent event) {
        Player p2 = Bukkit.getServer().getPlayer(name);
        if (event.getInventory().equals(TempMuteInv.tempmuteinv)) {
            if (plugin.getConfig().getString("ModTools.ModManager").equalsIgnoreCase("essentials")) {
                if (event.getSlot() == 11) {
                    plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "mute " + p2.getName() + " 10m");
                } else if (event.getSlot() == 12) {
                    plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "mute " + p2.getName() + " 30m");
                }  else if (event.getSlot() == 13) {
                    plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "mute " + p2.getName() + " 1h");
                }  else if (event.getSlot() == 14) {
                    plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "mute " + p2.getName() + " 1d");
                }  else if (event.getSlot() == 15) {
                    plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "mute " + p2.getName() + " 1w");
                }
            }
        }
    }
    
}

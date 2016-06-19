/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.modtools.inventories;

import com.lwer0.modtools.ModTools;
import static com.lwer0.modtools.inventories.BanInventory.baninv;
import com.lwer0.modtools.inventories.permortemp.PermOrTempBan;
import static com.lwer0.modtools.inventories.permortemp.PermOrTempMute.mutetemporperminv;
import static com.lwer0.modtools.inventories.temps.TempMuteInv.tempmuteinv;
import com.lwer0.modtools.utils.ColorUtil;
import static com.lwer0.modtools.utils.ColorUtil.color;
import static com.lwer0.modtools.utils.FreezeUtil.freeze;
import static com.lwer0.modtools.utils.FreezeUtil.unfreeze;
import java.util.ArrayList;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.Vector;

public class MainInventory implements Listener {
    
    private static String name;

    public MainInventory() {
    }
    
    public void setName(String pname) {
        MainInventory.name = pname;
    }
    
    public static Inventory maininv = Bukkit.createInventory(null, 27, ColorUtil.color("&2ModTools"));    
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
 
                    maininv.setItem(4, skull);
            }
         }
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
        List<String> list2 = new ArrayList<String>();
        list2.add(color("&7Expulsa al jugador"));
        list2.add(color("&7del servidor"));
        ItemStack ns2 = new ItemStack (Material.NETHER_STAR, 1);
        ItemMeta im2 = ns1.getItemMeta();
        im2.setLore(list2);
        im2.setDisplayName(color("&cKick"));
        ns2.setItemMeta(im2);
        //Item 3
        ItemStack ns3 = new ItemStack (Material.NETHER_STAR, 1);
        ItemMeta im3 = ns1.getItemMeta();
        im3.setDisplayName(color("&aMute"));
        ns3.setItemMeta(im3);
        //Item 4
        List<String> list4 = new ArrayList<String>();
        list4.add(color("&7Congela al jugador"));
        ItemStack ns4 = new ItemStack (Material.NETHER_STAR, 1);
        ItemMeta im4 = ns1.getItemMeta();
        im4.setLore(list4);
        im4.setDisplayName(color("&bCongelar"));
        ns4.setItemMeta(im4);
        //Item 5
        List<String> list5 = new ArrayList<String>();
        list5.add(color("&7Descongela al jugador"));
        ItemStack ns5 = new ItemStack (Material.NETHER_STAR, 1);
        ItemMeta im5 = ns1.getItemMeta();
        im5.setDisplayName(color("&bDescongelar"));
        im5.setLore(list5);
        ns5.setItemMeta(im5);
        
        maininv.setItem(11, ns1);
        maininv.setItem(12, ns2);
        maininv.setItem(13, ns3);
        maininv.setItem(14, ns4);
        maininv.setItem(15, ns5); 
    }
    
    @EventHandler
    public void InvClick (InventoryClickEvent event) {
        Player p = (Player)event.getWhoClicked();
        Player p2 = Bukkit.getServer().getPlayer(name);
        if (event.getClickedInventory().equals(maininv)) {
            if (event.getSlot() == 11) {
                p.openInventory(PermOrTempBan.banpermortempinv);
            } else if (event.getSlot() == 12) {
                p2.kickPlayer(color("&cHas sido expulsado por no respetar las normas de HideOutMC"));
            } else if (event.getSlot() == 13) {
                p.openInventory(mutetemporperminv);
            } else if (event.getSlot() == 14) {
                freeze(p2);
                p2.sendMessage(color("&bHas sido congelado por " + p.getName()));
            } else if (event.getSlot() == 15) {
                unfreeze(p2);
                p2.sendMessage(color("&bHas sido descongelado por " + p.getName()));
            }
        }
    }
    
    public MainInventory(ModTools aThis) {
    } 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.modtools.utils;

import com.lwer0.modtools.ModTools;
import static com.lwer0.modtools.utils.ColorUtil.color;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

/**
 *
 * @author Joel
 */
public class FreezeUtil implements Listener {
    
    public static List<String> freezed = new ArrayList<String>();
    
    public static void freeze(Player p) {
        if (!freezed.contains(p.getName())) {
            freezed.add(p.getName());
        }        
    }
    public static void unfreeze(Player p) {
        if (freezed.contains(p.getName())) {
            freezed.remove(p.getName());
        }
    }

    public FreezeUtil(ModTools aThis) {
    }
    
    @EventHandler
    public void onPlayerMove (PlayerMoveEvent event) {
        if (freezed.contains(event.getPlayer().getName())) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }
}

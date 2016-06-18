/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.modtools.listeners;

import com.lwer0.modtools.ModTools;
import static com.lwer0.modtools.utils.ColorUtil.color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 *
 * @author Joel
 */
public class AntiSteal implements Listener {

    public AntiSteal(ModTools aThis) {
    }
    
    @EventHandler
    public void onPlayerMove (PlayerMoveEvent event) {
        Player p = (Player)event.getPlayer();
        p.sendMessage(color("&cAntiSteal - Spam Message Anti ROBO"));
    }
    
}

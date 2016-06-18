/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.modtools.utils;

import com.lwer0.modtools.ModTools;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;

/**
 *
 * @author Joel
 */
public class ColorUtil implements Listener {
    
    public static String color (String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public ColorUtil(ModTools aThis) {
    }
    
}

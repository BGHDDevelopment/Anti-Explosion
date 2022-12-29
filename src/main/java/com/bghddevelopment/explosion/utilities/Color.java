package com.bghddevelopment.explosion.utilities;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class Color {

    public static String translate(String value) {
        return ChatColor.translateAlternateColorCodes('&', value);
    }
}

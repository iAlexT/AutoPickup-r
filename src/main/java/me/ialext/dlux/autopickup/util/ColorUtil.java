package me.ialext.dlux.autopickup.util;

import org.bukkit.ChatColor;

import java.util.List;

public interface ColorUtil {

    static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    static List<String> colorizeList(List<String> stringList) {
        stringList.replaceAll(line -> ChatColor.translateAlternateColorCodes('&', line));

        return stringList;
    }
}

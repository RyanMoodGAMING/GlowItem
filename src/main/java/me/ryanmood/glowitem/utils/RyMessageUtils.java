package me.ryanmood.glowitem.utils;

import lombok.Getter;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import java.util.List;
import java.util.stream.Collectors;

/*
 * This software and its content is copyright of RyanMoodGAMING - © RyanMoodGAMING 2023. All rights reserved.
 * Any redistribution or reproduction of part or all of the contents in any form is prohibited other than the following:
 * you may print or download to a local hard disk extracts for your personal and non-commercial use only
 * you may copy the content to individual third parties for their personal use, but only if you acknowledge the website as the source of the material
 * You may not, except with our express written permission, distribute or commercially exploit the content. Nor may you transmit it or store it in any other website or other form of electronic retrieval system.
 */

public class RyMessageUtils {

    @Getter
    private static String prefix = "&dGlowItem &7» &f";
    @Getter
    private static String errorPrefix = "&cError &7» &c";
    @Getter
    private static String breaker = "&7&m------------------------------------";

    private static String translate(Player player, String message) {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            String PAPI = PlaceholderAPI.setPlaceholders(player, message)
                    .replace("%prefix%", getPrefix())
                    .replace("%player%", player.getName());

            return HEXUtils.colorify(PAPI);
        }

        return HEXUtils.colorify(message)
                .replace("%prefix%", getPrefix())
                .replace("%player%", player.getName());

    }

    public static String translate(String message) {
        return HEXUtils.colorify(message)
                .replace("%prefix%", getPrefix());
    }

    private static List<String> translate(List<String> source) {
        return source.stream().map(RyMessageUtils::translate).collect(Collectors.toList());
    }

    public static void sendPlayer(Player player, String message) {
        player.sendMessage(translate(player, message));
    }

    public static void sendPlayer(Player player, String... messages) {
        for (String message : messages) {
            player.sendMessage(translate(player, message));
        }
    }

    public static void sendPlayer(Player player, List<String> messages) {
        for (String message : messages) {
            player.sendMessage(translate(player, message));
        }
    }

    public static void sendSender(CommandSender sender, String message) {
        sender.sendMessage(translate(message));
    }

    public static void sendSender(CommandSender sender, String... messages) {
        for (String message : messages) {
            sender.sendMessage(translate(message));
        }
    }

    public static void sendSender(CommandSender sender, List<String> messages) {
        for (String message : messages) {
            sender.sendMessage(translate(message));
        }
    }

    public static void sendConsole(boolean prefix, String message) {
        if (prefix) {
            Bukkit.getConsoleSender().sendMessage(translate(getPrefix() + message));
        } else {
            Bukkit.getConsoleSender().sendMessage(translate(message));
        }
    }

    public static void sendConsole(boolean prefix, String... messages) {
        if (prefix) {
            for (String message : messages) {
                Bukkit.getConsoleSender().sendMessage(translate(getPrefix() + message));
            }
        } else {
            for (String message : messages) {
                Bukkit.getConsoleSender().sendMessage(translate(message));
            }
        }
    }

    public static void sendConsole(boolean prefix, List<String> messages) {
        if (prefix) {
            for (String message : messages) {
                Bukkit.getConsoleSender().sendMessage(translate(getPrefix() + message));
            }
        } else {
            for (String message : messages) {
                Bukkit.getConsoleSender().sendMessage(translate(message));
            }
        }
    }

    public static void broadcast(Player player, String permission, String message) {
        for (Player online : Bukkit.getOnlinePlayers()) {
            if (online.hasPermission(permission)) {
                online.sendMessage(translate(player,  message));
            }
        }
    }

    public static void broadcast(Player player, Permission permission, String message) {
        for (Player online : Bukkit.getOnlinePlayers()) {
            if (online.hasPermission(permission)) {
                online.sendMessage(translate(player, message));
            }
        }
    }

    public static void broadcast(Player player, String message) {
        Bukkit.broadcastMessage(translate(player, message));
    }

    public static void broadcast(String message) {
        Bukkit.broadcastMessage(translate(message));
    }
}

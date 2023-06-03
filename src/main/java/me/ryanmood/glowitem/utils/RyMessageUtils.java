package me.ryanmood.glowitem.utils;

import lombok.Getter;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;

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
    private final static String prefix = "&dGlowItem &7» &f";
    @Getter
    private final static String errorPrefix = "&cError &7» &c";
    @Getter
    private final static String breaker = "&7&m------------------------------------";

    public static @NotNull String translate(Player player, String message) {
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

    public static @NotNull String translate(String message) {
        return HEXUtils.colorify(message)
                .replace("%prefix%", getPrefix());
    }

    public static void sendPlayer(@NotNull Player player, String message) {
        player.sendMessage(translate(player, message));
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

}

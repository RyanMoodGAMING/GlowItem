package me.ryanmood.glowitem.commands;

import com.cryptomorin.xseries.XMaterial;
import me.ryanmood.glowitem.GlowItem;
import me.ryanmood.glowitem.enchantments.Glow;
import me.ryanmood.glowitem.utils.RyMessageUtils;
import me.ryanmood.glowitem.utils.commands.Command;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/*
 * This software and its content is copyright of RyanMoodGAMING - © RyanMoodGAMING 2023. All rights reserved.
 * Any redistribution or reproduction of part or all of the contents in any form is prohibited other than the following:
 * you may print or download to a local hard disk extracts for your personal and non-commercial use only
 * you may copy the content to individual third parties for their personal use, but only if you acknowledge the website as the source of the material
 * You may not, except with our express written permission, distribute or commercially exploit the content. Nor may you transmit it or store it in any other website or other form of electronic retrieval system.
 */

public class GlowCommand extends Command {

    public GlowCommand() {
        super("glowitem", "glow");
    }


    @Override
    public int compareTo(@NotNull Command o) {
        return 0;
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String command, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            RyMessageUtils.sendConsole(true, "Console can't use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("glowitem.glow")) {
            RyMessageUtils.sendPlayer(player, "&cYou don't have permission to do this.");
            return true;
        }

        if (XMaterial.matchXMaterial(player.getInventory().getItemInMainHand().getType()) == XMaterial.AIR) {
            RyMessageUtils.sendPlayer(player, "&cYou can not add a glow to AIR.");
            return true;
        }

        ItemStack hand = player.getInventory().getItemInMainHand();
        ItemMeta meta = hand.getItemMeta();

        NamespacedKey key = new NamespacedKey(GlowItem.getInstance(), GlowItem.getInstance().getDescription().getName());
        Glow glow = new Glow(key);

        meta.addEnchant(glow, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        hand.setItemMeta(meta);

        RyMessageUtils.sendPlayer(player, "&aAdded glow to the item in your hand.");

        return true;
    }


}

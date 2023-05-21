package me.ryanmood.glowitem.enchantments;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;

/*
 * This software and its content is copyright of RyanMoodGAMING - © RyanMoodGAMING 2023. All rights reserved.
 * Any redistribution or reproduction of part or all of the contents in any form is prohibited other than the following:
 * you may print or download to a local hard disk extracts for your personal and non-commercial use only
 * you may copy the content to individual third parties for their personal use, but only if you acknowledge the website as the source of the material
 * You may not, except with our express written permission, distribute or commercially exploit the content. Nor may you transmit it or store it in any other website or other form of electronic retrieval system.
 */

public class Glow extends Enchantment {

    public Glow(NamespacedKey i) {
        super(i);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean canEnchantItem(ItemStack arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getMaxLevel() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getStartLevel() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isCursed() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isTreasure() {
        // TODO Auto-generated method stub
        return false;
    }

}
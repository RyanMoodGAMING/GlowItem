package me.ryanmood.glowitem;

import lombok.Getter;
import me.ryanmood.glowitem.enchantments.Glow;
import me.ryanmood.glowitem.utils.RyMessageUtils;
import me.ryanmood.glowitem.utils.commands.CommandManager;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public final class GlowItem extends JavaPlugin {

    @Getter
    private static GlowItem instance;

    @Override
    public void onEnable() {
        instance = this;
        registerGlow();
        CommandManager.registerAll();
        RyMessageUtils.sendConsole(true, RyMessageUtils.getBreaker(),
                "&fEnabling GlowItem by RyanMood",
                "&fLoaded Glow enchant.",
                "&fLoaded commands.",
                "&fEnabled GlowItem",
                RyMessageUtils.getBreaker());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerGlow() {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        }  catch (Exception e) {
            e.printStackTrace();
        } try {
            NamespacedKey key = new NamespacedKey(this, getDescription().getName());

            Glow glow = new Glow(key);
            Enchantment.registerEnchantment(glow);
        } catch (IllegalArgumentException ignored) {

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}

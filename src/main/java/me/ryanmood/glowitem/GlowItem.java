package me.ryanmood.glowitem;

import lombok.Getter;
import me.ryanmood.glowitem.utils.RyMessageUtils;
import me.ryanmood.glowitem.utils.commands.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class GlowItem extends JavaPlugin {

    @Getter
    private static GlowItem instance;

    @Override
    public void onEnable() {
        instance = this;
        CommandManager.registerAll();
        RyMessageUtils.sendConsole(true, RyMessageUtils.getBreaker(),
                "&fEnabling GlowItem by RyanMood",
                "&fLoaded commands.",
                "&fEnabled GlowItem",
                RyMessageUtils.getBreaker());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}

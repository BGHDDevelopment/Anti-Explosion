package me.noodles.antiexplosion;

import org.bukkit.plugin.java.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import org.bukkit.*;

public class AntiExplosion extends JavaPlugin implements Listener
{
    public static AntiExplosion plugin;
    private UpdateChecker checker;

    public void onEnable() {
        AntiExplosion.plugin = this;
        final PluginDescriptionFile VarUtilType = this.getDescription();
        this.getLogger().info("AntiExplosion V" + VarUtilType.getVersion() + " starting...");
        this.saveDefaultConfig();
        this.reloadConfig();
        registerEvents((Plugin)this, new UpdateJoinEvent());
        registerEvents((Plugin)this, new Events());
        registerEvents(this, this);
        this.getLogger().info("AntiExplosion V" + VarUtilType.getVersion() + " started!");
        this.setEnabled(true);
        this.getLogger().info("AntiExplosion V" + VarUtilType.getVersion() + " checking for updates...");
        this.checker = new UpdateChecker(this);
        if (this.checker.isConnected()) {
            if (this.checker.hasUpdate()) {
                getServer().getConsoleSender().sendMessage("------------------------");
                getServer().getConsoleSender().sendMessage("AntiExplosion is outdated!");
                getServer().getConsoleSender().sendMessage("Newest version: " + this.checker.getLatestVersion());
                getServer().getConsoleSender().sendMessage("Your version: " + AntiExplosion.plugin.getDescription().getVersion());
                getServer().getConsoleSender().sendMessage("Please Update Here: https://www.spigotmc.org/resources/45655");
                getServer().getConsoleSender().sendMessage("------------------------");
            }
            else {
                getServer().getConsoleSender().sendMessage("------------------------");
                getServer().getConsoleSender().sendMessage("AntiExplosion is up to date!");
                getServer().getConsoleSender().sendMessage("------------------------");            }
        }
    }
    
    public static void registerEvents(final Plugin plugin, final Listener... listeners) {
        for (final Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes"})
	public static AntiExplosion getPlugin() {
        return (AntiExplosion)getPlugin((Class) AntiExplosion.class);
    }
    
}

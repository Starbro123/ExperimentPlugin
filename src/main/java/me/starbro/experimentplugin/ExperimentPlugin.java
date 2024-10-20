package me.starbro.experimentplugin;

import me.starbro.experimentplugin.commands.MenuCommand;
import me.starbro.experimentplugin.commands.TestCommand;
import me.starbro.experimentplugin.events.MenuListener;
import me.starbro.experimentplugin.events.cancelCommands;
import me.starbro.experimentplugin.events.onPlayerJoin;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExperimentPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Test] If you see this then the plugin is starting up!");

        // Register commands and tab complete!
        getCommand("menu").setExecutor(new MenuCommand());
        getCommand("test").setExecutor(new TestCommand());
        getCommand("test").setTabCompleter(new TestCommand());
        // save the config!
        saveDefaultConfig();

        // Register Events!
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new onPlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new cancelCommands(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "[Test] If you see this then the plugin is shutting down!");
    }
    public static ExperimentPlugin getInstance() {
        return ExperimentPlugin.getPlugin(ExperimentPlugin.class);
    }
}

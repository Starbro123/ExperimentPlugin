package me.starbro.experimentplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class cancelCommands implements Listener {
    @EventHandler(priority = EventPriority.LOW)
    public void cancelCommands(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (e.getMessage().startsWith("/tell")) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.RED + "You cannot use the /tell command because I thought that it would be fun to get rid of it :)");
        }
        if (e.getMessage().startsWith("/me")) {
            e.setCancelled(true);
            p.setHealth(1.0);
            p.sendMessage(ChatColor.RED + "Wow, Imagine trying to use the /me command, what a noob! You just got punished! :)");
        }

    }
}

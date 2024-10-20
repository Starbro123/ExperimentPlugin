package me.starbro.experimentplugin.events;


import me.starbro.experimentplugin.ExperimentPlugin;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class MenuListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (player.hasMetadata("OpenedMenu")) {
            event.setCancelled(true);
            if (event.getSlot() == 13) {
               player.getInventory().addItem(new ItemStack(Material.DIRT, 1));
            } else if (event.getSlot() == 22) {
                player.setFoodLevel(20);
            }else if (event.getSlot() == 31) {
                player.setDisplayName("test");
                player.setCustomName("mynameissteve");
                player.setCustomNameVisible(true);
            }
        }
    }
    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (player.hasMetadata("OpenedMenu")) {
            player.removeMetadata("OpenedMenu", ExperimentPlugin.getInstance());
        }
    }
}

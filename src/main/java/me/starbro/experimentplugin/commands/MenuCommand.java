package me.starbro.experimentplugin.commands;


import me.starbro.experimentplugin.ExperimentPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.List;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }
        Player player = (Player) sender;
        if (args.length > 0) {
            player.sendMessage("You cannot specify any arguments for this command!");
        }




        // send message and create itemstack
        player.sendMessage("Did you see this message?");
        Inventory inventory = Bukkit.createInventory(player, 36, ChatColor.DARK_AQUA + "Test menu!");
        ItemStack one = new ItemStack(Material.CHEST);
        ItemStack feed = new ItemStack(Material.COOKED_CHICKEN);
        ItemStack name = new ItemStack(Material.NAME_TAG);


        // set the ItemMeta
        ItemMeta onemeta = one.getItemMeta();
        onemeta.setDisplayName(ChatColor.BLUE + "This is item one");
        onemeta.setLore(List.of(ChatColor.RED + "This is an example item that gives you a dirt block!"));
        one.setItemMeta(onemeta);

        ItemMeta feedmeta = feed.getItemMeta();
        onemeta.setDisplayName(ChatColor.AQUA + "This is item two!");
        onemeta.setLore(List.of(ChatColor.GOLD + "This is an example item that gives you fills your hunger bar to full!"));
        one.setItemMeta(onemeta);

        ItemMeta namemeta = name.getItemMeta();
        namemeta.setDisplayName(ChatColor.DARK_AQUA + "This is item three!");
        namemeta.setLore(List.of(ChatColor.DARK_GREEN + "This is an example item that changes your display name!"));
        one.setItemMeta(namemeta);




        // open the gui
        inventory.setItem( 13, one);
        inventory.setItem( 22, one);
        inventory.setItem( 31, one);
        player.openInventory(inventory);
        player.setMetadata("OpenedMenu",new FixedMetadataValue(ExperimentPlugin.getInstance(),"Test menu!"));
        return true;
    }
}

package me.starbro.experimentplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class TestCommand implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "You need to provide arguments! Usage: /test <args>");
            return true;
        }
        if (args.length > 1) {
            player.sendMessage("You can only have one argument! Usage: /test <args>");
        }


        // Test if args is a certain thing, if it is, do something random :) NOT SURE IF IT WILL EVEN WORK?
        if (Objects.equals(args[0], "Test")) {
            player.setGameMode(GameMode.CREATIVE);
        }
        if (Objects.equals(args[0], "Random")) {
            player.setGameMode(GameMode.SURVIVAL);
        }
        if (Objects.equals(args[0], "Things")) {
            player.setGameMode(GameMode.SPECTATOR);
        }




        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {

        if (args.length == 1) {
            List<String> arguments = new ArrayList<>();
            arguments.add("Test");
            arguments.add("Random");
            arguments.add("Things");
            return arguments;
        }

        return null;
    }
}

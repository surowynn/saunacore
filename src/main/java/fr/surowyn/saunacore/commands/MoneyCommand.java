package fr.surowyn.saunacore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoneyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;

            p.sendMessage("Argent: " + "0");

        }
        return true;
    }
}

package fr.plutonia.quests.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.murder.quests.Core;

public class Developer implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(! sender.hasPermission("quests.developer")) {
			sender.sendMessage(ChatColor.RED + "You don't have the permission to execute this command");
			return true;
		}
		
		if(args.length != 1) {
			sender.sendMessage(ChatColor.RED + "Usage: /developer <command>");
			return true;
		}
		
		if(args[0].equalsIgnoreCase("nextday")) {
			Core.getQPlayer((Player) sender).setDate(null);
			sender.sendMessage(ChatColor.GREEN + "You are now on a new day");
		}
		
		if(args[0].equalsIgnoreCase("succeedquest")) {
			Core.getQPlayer((Player) sender).setDate(null);
			sender.sendMessage(ChatColor.GREEN + "You have now finished your daily quest");
		}
		
		return false;
	}

}

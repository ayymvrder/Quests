package fr.murder.quests.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Quest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(! sender.hasPermission("quests.quest")) {
			sender.sendMessage(ChatColor.RED + "You don't have the permission to execute this command");
			return true;
		}
		
		if(args.length != 1) {
			sender.sendMessage(ChatColor.RED + "Usage: /quest");
			return true;
		}
		return false;
	}
	
	

}

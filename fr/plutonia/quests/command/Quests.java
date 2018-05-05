package fr.plutonia.quests.command;

import java.util.ArrayList;
import java.util.Calendar;

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

public class Quests implements CommandExecutor {

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
		
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Quêtes journalières");
		for(int i=2; i<8; i++) {
			ItemStack is = new ItemStack(Material.ANVIL);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName("Jour " + i);
			ArrayList<String> lore = new ArrayList<String>();
			lore.add("Cette quête sera disponible dans " + ChatColor.GREEN + ((24 - Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) + 24 * (i - 2)) + ChatColor.WHITE + " heure(s)");
			im.setLore(lore);
			is.setItemMeta(im);
			
			inv.setItem(i, is);
		}
		((Player) sender).openInventory(inv);
		
		return false;
	}
	
	

}

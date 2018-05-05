package fr.plutonia.quests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.plutonia.quests.command.Developer;
import fr.plutonia.quests.command.Quests;

public class Core extends JavaPlugin {
	
	public static String prefix = "§e[Quete] §f";
	public static HashMap<UUID, QPlayer> qplayer_oc;
	public static ArrayList<Quest> quests = new ArrayList<>();
	
	@Override
	public void onEnable() {
		qplayer_oc = new HashMap<UUID, QPlayer>();
		
		getCommand("developer").setExecutor(new Developer());
		getCommand("quests").setExecutor(new Quests());
		
		@SuppressWarnings("deprecation")
		Player[] players = Bukkit.getOnlinePlayers();
		for(int i=0; i < players.length; i++) {
			QPlayer qp = new QPlayer(players[i]);
		}
	
		ConfigurationSection questsSection = getConfig().getConfigurationSection("quests");
		for(String s : questsSection.getKeys(true)) {
			int id = Integer.parseInt(s);
			List<Integer> X = questsSection.getIntegerList(s);
			for(int n : X) {
				quests.add(new Quest(id, n));
			}
		}

	}
	
	public static int getRanking(String player) {
		return 1;
	}
	
	public static QPlayer getQPlayer(Player player) {
		return qplayer_oc.containsKey(player.getUniqueId()) ? qplayer_oc.get(player.getUniqueId()) : new QPlayer(player);
	}

}

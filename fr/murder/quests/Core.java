package fr.murder.quests;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.murder.quests.command.Developer;

public class Core extends JavaPlugin {
	
	public static HashMap<UUID, QPlayer> qplayer_oc;
	
	@Override
	public void onEnable() {
		qplayer_oc = new HashMap<UUID, QPlayer>();
		
		getCommand("developer").setExecutor(new Developer());
		
		@SuppressWarnings("deprecation")
		Player[] players = Bukkit.getOnlinePlayers();
		for(int i=0; i < players.length; i++) {
			QPlayer qp = new QPlayer(players[i]);
		}
	}
	
	public static QPlayer getQPlayer(Player player) {
		return qplayer_oc.containsKey(player.getUniqueId()) ? qplayer_oc.get(player.getUniqueId()) : null;
	}

}

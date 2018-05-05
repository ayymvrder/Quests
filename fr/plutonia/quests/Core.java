package fr.murder.quests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.murder.quests.command.Developer;

public class Core extends JavaPlugin {
	
	public static String prefix;
	public static HashMap<UUID, QPlayer> qplayer_oc;
	public static ArrayList<Quest> quests = new ArrayList<>();
	public static SQL sql;
	public static SQLBase sqlBase;
	public static String tab;
	
	@Override
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		
		prefix = getConfig().getString("plugin.prefix");
		
		qplayer_oc = new HashMap<UUID, QPlayer>();
		
		getCommand("developer").setExecutor(new Developer());
		
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
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	public void initSQL(String urlBase, String host, String database, String username, String password, String table) {
		sqlBase = new AskiaSqlBase(urlBase, host, database, username, password);
		sqlBase.connection();
		try {
			sqlBase.init(table);
		} catch (SQLException e) {
			Bukkit.getPluginManager().disablePlugin(this);
			e.printStackTrace();
		}
		sql = sqlBase.make();
		
	}
	
	public static int getRanking(String player) {
		String s = sql.getString(player, tab, "Player", "Quest");
		
		return s.split(";").length;
	}
	
	public static QPlayer getQPlayer(Player player) {
		return qplayer_oc.containsKey(player.getUniqueId()) ? qplayer_oc.get(player.getUniqueId()) : new QPlayer(player);
	}

}

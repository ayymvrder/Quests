package fr.murder.quests.event;

import java.text.SimpleDateFormat;
import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.murder.quests.Core;
import fr.murder.quests.QPlayer;
import fr.murder.quests.Quest;

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		QPlayer qplayer = Core.getQPlayer(player);
		
		if(qplayer.getDate() != new SimpleDateFormat("dd/MM/yyyy").toString()) {
			if(!qplayer.hasSucceeded()) {
				player.sendMessage(Core.prefix + "§cVous n'avez pas réussi la quête précédente");
				Quest random = Core.quests.get(new Random().nextInt(Core.quests.size()));
				qplayer.setCurrentQuest(random);
			} {
				Quest random = Core.quests.get(new Random().nextInt(Core.quests.size()));
				random.setGoal((int) (random.getGoal() * (Core.getRanking(player.getName()) * 0.78)));
				qplayer.setCurrentQuest(random);
			}
		}
		qplayer.setTimeMillis(System.currentTimeMillis());
		
	}

	public static void main(String[] args) {
	}
	
}


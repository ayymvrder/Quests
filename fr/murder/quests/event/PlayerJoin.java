package fr.murder.quests.event;

import java.text.SimpleDateFormat;

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
		Quest current = qplayer.getCurrentQuest();
		
		if(qplayer.getDate() != new SimpleDateFormat("dd/MM/yyyy").toString() && ! qplayer.hasSucceeded()) {
			//supprimer quete
		}
		
		if(current.getId() == 1) {
			//enregistrer heure de connexion
		}
	}

}

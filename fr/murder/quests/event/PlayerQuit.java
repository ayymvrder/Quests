package fr.murder.quests.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.murder.quests.Core;
import fr.murder.quests.QPlayer;
import fr.murder.quests.Quest;

public class PlayerQuit implements Listener {
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		QPlayer qplayer = Core.getQPlayer(event.getPlayer());
		Quest current = qplayer.getCurrentQuest();
		
		if(current.getId() == 1) {
			
		}
	}

}

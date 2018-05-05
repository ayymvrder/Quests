package fr.murder.quests.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.murder.quests.Core;
import fr.murder.quests.QPlayer;
import fr.murder.quests.Quest;
import fr.murder.quests.Type;

public class PlayerQuit implements Listener {
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		QPlayer qplayer = Core.getQPlayer(event.getPlayer());
		Quest current = qplayer.getCurrentQuest();
		
		if(current.getId() == Type.CONNECTED.getId()) {
			current.setProgression((int) (current.getProgression() + ((System.currentTimeMillis() - qplayer.getTimeMillis() / 1000 / 60))));
			qplayer.setTimeMillis(System.currentTimeMillis());
		}
	}

}

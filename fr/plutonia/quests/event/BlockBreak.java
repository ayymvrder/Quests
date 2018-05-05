package fr.plutonia.quests.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import fr.plutonia.quests.Core;
import fr.plutonia.quests.QPlayer;
import fr.plutonia.quests.Quest;
import fr.plutonia.quests.Type;

public class BlockBreak implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		QPlayer qplayer = Core.getQPlayer(player);
		Quest current = qplayer.getCurrentQuest();
		
		if(current.getId() == Type.BREAK_BLOCK.getId()) {
			
		}
	}

}

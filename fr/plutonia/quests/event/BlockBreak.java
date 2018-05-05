package fr.plutonia.quests.event;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import fr.plutonia.quests.Core;
import fr.plutonia.quests.QPlayer;
import fr.plutonia.quests.Quest;
import fr.plutonia.quests.Type;

public class BlockBreak implements Listener {
	
	private List<Material> allowed = new ArrayList<Material>() {
		private static final long serialVersionUID = 1L;
	{
		add(Material.STONE);
		add(Material.GRASS);
		add(Material.OBSIDIAN);
	}};
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		QPlayer qplayer = Core.getQPlayer(player);
		Quest current = qplayer.getCurrentQuest();
		
		if(current.getId() == Type.BREAK_BLOCK.getId() && allowed.contains(event.getBlock().getType())) {
			current.setProgression(current.getProgression() + 1);
		}
	}

}

package fr.murder.quests.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import fr.murder.quests.Core;
import fr.murder.quests.QPlayer;
import fr.murder.quests.Quest;

public class EntityDeath implements Listener {
	
	public void onEntityDeath(EntityDeathEvent event) {
		EntityDamageEvent dmg_cause = event.getEntity().getLastDamageCause();
		
		if(dmg_cause instanceof EntityDamageByEntityEvent && (EntityDamageByEntityEvent) dmg_cause instanceof Player) {
			Player player = (Player) dmg_cause;
			QPlayer qplayer = Core.getQPlayer(player);
			Quest current = qplayer.getCurrentQuest();
			
			if(current.getId() == 0) {
				current.setProgression(current.getProgression() + 1);
			}
		}
	}

}

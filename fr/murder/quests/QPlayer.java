package fr.murder.quests;

import java.text.SimpleDateFormat;
import java.util.UUID;

import org.bukkit.entity.Player;

public class QPlayer {
	
	private UUID uid;
	private Quest current_quest;
	private int ranking;
	private String date;
	private long timeMillis;
	
	public QPlayer(Player player) {
		this.timeMillis = System.currentTimeMillis();
		this.uid = player.getUniqueId();
		this.current_quest = null;
		this.ranking = 0;
		this.date = new SimpleDateFormat("dd/MM/yyyy").toString();
	}
	
	
	
	public long getTimeMillis() {
		return timeMillis;
	}
	
	public void setTimeMillis(long timeMillis) {
		this.timeMillis = timeMillis;
	}
	
	public UUID getUID() {
		return this.uid;
	}
	
	public Quest getCurrentQuest() {
		return this.current_quest;
	}
	
	public void setCurrentQuest(Quest current_quest) {
		this.current_quest = current_quest;
	}
	
	public int getRanking() {
		return this.ranking;
	}
	
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public boolean hasSucceeded() {
		if(current_quest == null) {
			return false;
		}
		else return current_quest.getGoal() <= current_quest.getProgression();
	}
	
	
}

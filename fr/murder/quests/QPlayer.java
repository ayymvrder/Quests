package fr.murder.quests;

import java.text.SimpleDateFormat;
import java.util.UUID;

import org.bukkit.entity.Player;

public class QPlayer {
	
	private UUID uid;
	private Quest current_quest;
	private int ranking;
	private String date;
	
	public QPlayer(Player player) {
		this.uid = player.getUniqueId();
		this.current_quest = new Quest(0);
		this.ranking = 0;
		this.date = new SimpleDateFormat("dd/MM/yyyy").toString();
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
}

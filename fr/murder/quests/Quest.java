package fr.murder.quests;

public class Quest {
	
	private String name;
	private String description;
	private int ranking;
	private int id;
	private int progression;
	private int goal;
	
	public Quest(int id, int goal) {
		this.name = null;
		this.ranking = 0;
		this.id = 0;
		this.progression = 0;
		this.goal = 0;
	}
	
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	public void setGoal(int goal) {
		this.goal = goal;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public int getRanking() {
		return this.ranking;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getProgression() {
		return this.progression;
	}
	
	public void setProgression(int progression) {
		this.progression = progression;
	}

	public int getGoal() {
		return this.goal;
	}
}

package entities;

public class Level {

	private Integer level;
	
	public Level() {
	}

	public Level(Integer level) {
		this.level = level;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public String toString() {
		return "Level: " + getLevel();
	}
	
}

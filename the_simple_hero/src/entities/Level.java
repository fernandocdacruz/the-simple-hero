package entities;

public class Level {

	private Integer level;
	private Integer xpAtual;
	private Integer xpProximoLevel;
	
	public Level() {
	}

	public Level(Integer level) {
		this.level = level;
		this.xpAtual = 0;
		this.xpProximoLevel = 50;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getXpAtual() {
		return xpAtual;
	}

	public void setXpAtual(Integer xpAtual) {
		this.xpAtual = xpAtual;
	}

	public Integer getXpProximoLevel() {
		return xpProximoLevel;
	}

	public void setXpProximoLevel(Integer xpProximoLevel) {
		this.xpProximoLevel = xpProximoLevel;
	}

	public String toString() {
		return "Level: " + getLevel();
	}
	
	public void ganharXp(int xp) {
		setXpAtual(xpAtual + xp);
	}
	
	public boolean aumentarLevel() {
		boolean aumentouDeLevel = false;
		if (xpAtual >= xpProximoLevel) {
			setLevel(level + 1);
			setXpAtual(0);
			System.out.println("\nParabéns !! Você alcançou o level " + getLevel());
			aumentouDeLevel = true;
		}
		return aumentouDeLevel;
	}
	
	public String totalXp() {
		return "\nXp: " + xpProximoLevel+ " / " + xpAtual;
	}
	
}

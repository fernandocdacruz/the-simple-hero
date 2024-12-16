package entities;

public class Floresta {
	
	private Batalha batalha;

	public Floresta(Batalha batalha) {
		this.batalha = batalha;
	}

	public Batalha getBatalha() {
		return batalha;
	}

	public void setBatalha(Batalha batalha) {
		this.batalha = batalha;
	}
	
}

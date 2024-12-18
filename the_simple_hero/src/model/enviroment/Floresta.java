package model.enviroment;

import service.BatalhaComum;

public class Floresta {
	
	private BatalhaComum batalha;

	public Floresta(BatalhaComum batalha) {
		this.batalha = batalha;
	}

	public BatalhaComum getBatalha() {
		return batalha;
	}

	public void setBatalha(BatalhaComum batalha) {
		this.batalha = batalha;
	}
	
}

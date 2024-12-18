package model.characters;

import java.util.Random;

public class Ataque {

	private Integer ataque;
	
	public Ataque() {
	}

	public Ataque(Integer ataque) {
		this.ataque = ataque;
	}

	public Integer getAtaque() {
		return ataque;
	}

	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}
	
	public String toString() {
		return "\nAtaque: " + getAtaque();
	}
	
	public void aumentarAtaqueAtual(int valor) {
		setAtaque(getAtaque() + valor);
	}
	
	public int atacar() {
		Random random = new Random();
		return random.nextInt(getAtaque() + 1);
	}
	
}

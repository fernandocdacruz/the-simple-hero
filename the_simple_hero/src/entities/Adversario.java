package entities;

import java.util.Random;

public class Adversario {

	private String nome;
	private Energia energia;
	private Ataque ataque;
	private Defesa defesa;
	private Integer ouro;
	private Integer xp;
	
	public Adversario() {
	}

	public Adversario(String nome, Energia energia, Ataque ataque, Defesa defesa, Integer ouro, Integer xp) {
		this.nome = nome;
		this.energia = energia;
		this.ataque = ataque;
		this.defesa = defesa;
		this.ouro = ouro;
		this.xp = xp;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Energia getEnergia() {
		return energia;
	}

	public void setEnergia(Energia energia) {
		this.energia = energia;
	}

	public Ataque getAtaque() {
		return ataque;
	}

	public void setAtaque(Ataque ataque) {
		this.ataque = ataque;
	}

	public Defesa getDefesa() {
		return defesa;
	}

	public void setDefesa(Defesa defesa) {
		this.defesa = defesa;
	}

	public Integer getOuro() {
		return ouro;
	}

	public void setOuro(Integer ouro) {
		this.ouro = ouro;
	}

	public Integer getXp() {
		return xp;
	}

	public void setXp(Integer xp) {
		this.xp = xp;
	}
	
}

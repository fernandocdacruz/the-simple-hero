package entities;

public class Adversario {

	private String nome;
	private Energia energia;
	private Ataque ataque;
	private Defesa defesa;
	
	public Adversario() {
	}

	public Adversario(String nome, Energia energia, Ataque ataque, Defesa defesa) {
		this.nome = nome;
		this.energia = energia;
		this.ataque = ataque;
		this.defesa = defesa;
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
	
	
	
}

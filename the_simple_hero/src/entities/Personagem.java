package entities;

public class Personagem {
	
	private String nome;
	private Integer energia;
	private Integer ataque;
	private Integer defesa;
	
	public Personagem() {
		
	}

	public Personagem(String nome, Integer energia, Integer ataque, Integer defesa) {
		super();
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

	public Integer getEnergia() {
		return energia;
	}

	public void setEnergia(Integer energia) {
		this.energia = energia;
	}

	public Integer getAtaque() {
		return ataque;
	}

	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}

	public Integer getDefesa() {
		return defesa;
	}

	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}

	@Override
	public String toString() {
		return "Nome: " + getNome() + "\nEnergia: " + getEnergia() + "\nAtaque: " + getAtaque() + "\nDefesa: " + getDefesa();
	}
	
	
	
 }

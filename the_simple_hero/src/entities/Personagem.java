package entities;

import java.util.Scanner;

public class Personagem {

	private Level level;
	private String nome;
	private Energia energia;
	private Ataque ataque;
	private Defesa defesa;
	private Ouro ouro;
	private Pocao pocao;

	public Personagem() {

	}

	public Personagem(Level level, String nome, Energia energia, Ataque ataque, Defesa defesa, Ouro ouro, Pocao pocao) {
		this.level = level;
		this.nome = nome;
		this.energia = energia;
		this.ataque = ataque;
		this.defesa = defesa;
		this.ouro = ouro;
		this.pocao = pocao;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
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

	public Ouro getOuro() {
		return ouro;
	}

	public void setOuro(Ouro ouro) {
		this.ouro = ouro;
	}

	public Pocao getPocao() {
		return pocao;
	}

	public void setPocao(Pocao pocao) {
		this.pocao = pocao;
	}

	public String toString() {
		return getLevel().toString() + "\nNome: " + getNome() + getEnergia().toString() + getAtaque().toString() + getDefesa().toString()
				+ getOuro().toString() + getPocao().toString();
	}

	public boolean confirmarPersonagem(Scanner scanner) {
		boolean valido = true;
		boolean opValida = false;
		while (!opValida) {
			try {
				System.out.print("\nDeseja alterar o personagem? Digite 's' para sim e 'n' para não: ");
				char op = scanner.next().toLowerCase().charAt(0);
				if (op != 's' && op != 'n') {
					throw new IllegalArgumentException("\nOpção inválida. Tente novamente");
				}
				scanner.nextLine();
				if (op == 'n') {
					valido = false;
				}
				opValida = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return valido;
	}

}

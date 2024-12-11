package entities;

import java.util.Scanner;

public class Personagem {

	private String nome;
	private Energia energia;
	private Integer ataque;
	private Integer defesa;
	private Ouro ouro;

	public Personagem() {

	}

	public Personagem(String nome, Energia energia, Integer ataque, Integer defesa, Ouro ouro) {
		this.nome = nome;
		this.energia = energia;
		this.ataque = ataque;
		this.defesa = defesa;
		this.ouro = ouro;
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

	public Ouro getOuro() {
		return ouro;
	}

	public void setOuro(Ouro ouro) {
		this.ouro = ouro;
	}

	public String toString() {
		return "Nome: " + getNome() + getEnergia().toString() + "\nAtaque: " + getAtaque() + "\nDefesa: " + getDefesa()
				+ getOuro().toString();
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

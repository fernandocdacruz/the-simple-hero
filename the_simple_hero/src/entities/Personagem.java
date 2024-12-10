package entities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Personagem {
	
	private String nome;
	private Integer energiaTotal;
	private Integer energiaAtual;
	private Integer ataque;
	private Integer defesa;
	private Integer ouro;
	
	public Personagem() {
		
	}

	public Personagem(String nome, Integer energiaTotal, Integer energiaAtual, Integer ataque, Integer defesa,
			Integer ouro) {
		this.nome = nome;
		this.energiaTotal = energiaTotal;
		this.energiaAtual = energiaAtual;
		this.ataque = ataque;
		this.defesa = defesa;
		this.ouro = ouro;
	}

	public String getNome() {
		return nome;
	}
	
	public Integer getEnergiaTotal() {
		return energiaTotal;
	}

	public void setEnergiaTotal(Integer energiaTotal) {
		this.energiaTotal = energiaTotal;
	}

	public Integer getEnergiaAtual() {
		return energiaAtual;
	}

	public void setEnergiaAtual(Integer energiaAtual) {
		this.energiaAtual = energiaAtual;
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

	public Integer getOuro() {
		return ouro;
	}

	public void setOuro(Integer ouro) {
		this.ouro = ouro;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return "Nome: " + getNome() + "\nEnergia: " + getEnergiaTotal() + "\nAtaque: " + getAtaque() + "\nDefesa: " + getDefesa();
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

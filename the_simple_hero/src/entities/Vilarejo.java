package entities;

import java.util.InputMismatchException;
import java.util.Scanner;

import utilities.ObterInputs;

public class Vilarejo {

	private Hospedaria hospedaria;
	private Cigana cigana;
	private LojaDeArmas lojaDeArmas;
	private Floresta floresta;
	private Batalha batalha;


	public Vilarejo(Hospedaria hospedaria, Cigana cigana, LojaDeArmas lojaDeArmas, Floresta floresta) {
		this.hospedaria = hospedaria;
		this.cigana = cigana;
		this.lojaDeArmas = lojaDeArmas;
		this.floresta = floresta;
	}

	public Hospedaria getHospedaria() {
		return hospedaria;
	}

	public void setHospedaria(Hospedaria hospedaria) {
		this.hospedaria = hospedaria;
	}

	public Cigana getCigana() {
		return cigana;
	}

	public void setCigana(Cigana cigana) {
		this.cigana = cigana;
	}

	public LojaDeArmas getLojaDeArmas() {
		return lojaDeArmas;
	}

	public void setLojaDeArmas(LojaDeArmas lojaDeArmas) {
		this.lojaDeArmas = lojaDeArmas;
	}

	public Floresta getFloresta() {
		return floresta;
	}

	public void setFloresta(Floresta floresta) {
		this.floresta = floresta;
	}

	public String iniciarAventura() {
		return "\nBem vindo ao Vilarejo Satolep!! Boa sorte na sua jornada.";
	}
	
	public void mostrarMenu() {
		System.out.println("\nOnde você deseja ir:");
		System.out.println("\n[0] - Sair do jogo");
		System.out.println("[1] - Status do meu personagem");
		System.out.println("[2] - Usar poção");
		System.out.println("[3] - Hospedaria Satolep");
		System.out.println("[4] - Consultar a velha Cigana Afrodite");
		System.out.println("[5] - Loja de Armas do Samarone");
		System.out.println("[6] - Ir para floresta");
	}

	public int obterOpMenu(Scanner scanner) {
		int op = 0;
		boolean inputValido = false;
		while (!inputValido) {
			try {
				System.out.print("\nDigite a opção desejada: ");
				op = scanner.nextInt();
				if (op < 0 || op > 6) {
					throw new IllegalArgumentException("Opção inválida, tente novamente.");
				}
				inputValido = true;
			} catch (InputMismatchException e) {
				System.out.println("\nInput inválido. Tente novamente.");
				scanner.next();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return op;
	}
}

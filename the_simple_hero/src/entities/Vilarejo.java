package entities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vilarejo {

	private Hospedaria hospedaria;
	private Cigana cigana;

	public Vilarejo(Hospedaria hospedaria, Cigana cigana) {
		this.hospedaria = hospedaria;
		this.cigana = cigana;
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

	public String iniciarAventura() {
		return "\nBem vindo ao Vilarejo Satolep!! Boa sorte na sua jornada.";
	}

	public void mostrarMenu() {
		System.out.println("\nOnde você deseja ir:");
		System.out.println("\n[0] - Sair do jogo");
		System.out.println("[1] - Hospedaria Satolep");
		System.out.println("[2] - Consultar a velha Cigana Afrodite");
	}

	public int obterOpMenu(Scanner scanner) {
		int op = 0;
		boolean inputValido = false;
		while (!inputValido) {
			try {
				System.out.print("\nDigite a opção desejada: ");
				op = scanner.nextInt();
				if (op < 0 || op > 2) {
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

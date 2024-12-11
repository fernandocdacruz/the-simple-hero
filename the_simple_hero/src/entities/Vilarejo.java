package entities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vilarejo {

	private Hospedaria hospedaria;

	public Vilarejo(Hospedaria hospedaria) {
		this.hospedaria = hospedaria;
	}

	public Hospedaria getHospedaria() {
		return hospedaria;
	}

	public void setHospedaria(Hospedaria hospedaria) {
		this.hospedaria = hospedaria;
	}

	public String iniciarAventura() {
		return "\nBem vindo ao Vilarejo Satolep!! Boa sorte na sua jornada.";
	}

	public void mostrarMenu() {
		System.out.println("\nOnde você deseja ir:");
		System.out.println("\n[0] - Sair do jogo");
		System.out.println("[1] - Hospedaria Satolep");
	}

	public int obterOpMenu(Scanner scanner) {
		int op = 0;
		boolean inputValido = false;
		while (!inputValido) {
			try {
				System.out.print("\nDigite a opção desejada: ");
				op = scanner.nextInt();
				if (op < 0 || op > 1) {
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

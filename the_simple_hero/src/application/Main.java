package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Personagem;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("\nTHE SIMPLE HERO\n");
			System.out.println("\nVamos criar o seu herói!");
			do {
				Personagem personagem = obterPersonagem(scanner);
				System.out.println("\nHerói criado!\n");
				System.out.println(personagem);
			} while (confirmarPersonagem(scanner));
		}

	}
	
	public static Personagem obterPersonagem(Scanner scanner) {
		Personagem personagem = null;
		boolean personagemValido = false;
		while (!personagemValido) {
			try {
				System.out.print("\nDigite o nome do seu herói: ");
				String nome = scanner.nextLine();
				if (nome.isEmpty()) {
					throw new IllegalArgumentException("\nEsse input não pode ficar vazio, tente novamente.");
				}
				System.out.println("\nVocê possui 100 pontos para distribuir entre os atributos do seu herói.");
				System.out.print("\nEnergia: ");
				int energia = scanner.nextInt();
				if (energia < 1) {
					scanner.nextLine();
					throw new IllegalArgumentException("\nValor inválido. Tente novamente.");
				}
				System.out.print("Ataque: ");
				int ataque = scanner.nextInt();
				if (ataque < 1) {
					scanner.nextLine();
					throw new IllegalArgumentException("\nValor inválido. Tente novamente.");
				}
				int defesa = 100 - ( energia + ataque);
				System.out.print("Defesa: " + defesa);
				if (defesa < 1) {
					scanner.nextLine();
					throw new IllegalArgumentException("\n\nDistribuição de pontos inválida. Tente novamente");
				}
				personagem = new Personagem(nome, energia, ataque, defesa);
				personagemValido = true;
			} catch (InputMismatchException e) {
				System.out.println("\nInput inválido. Tente novamente.");
				scanner.next();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} 
		}
		
		return personagem;
	}
	
	public static boolean confirmarPersonagem(Scanner scanner) {
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

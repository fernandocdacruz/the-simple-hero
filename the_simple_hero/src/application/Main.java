package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Ataque;
import entities.Cigana;
import entities.Defesa;
import entities.Energia;
import entities.Hospedaria;
import entities.Level;
import entities.LojaDeArmas;
import entities.Ouro;
import entities.Personagem;
import entities.Pocao;
import entities.Vilarejo;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("\nTHE SIMPLE HERO\n");
			System.out.println("\nVamos criar o seu herói!");
			Personagem personagem = obterPersonagem(scanner);
			System.out.println("\n\nHerói criado!\n");
			System.out.println(personagem);
			while (personagem.confirmarPersonagem(scanner)) {
				obterPersonagem(scanner);
			}
			iniciarJogo(scanner, personagem);
			System.out.println("\nGAME OVER");
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
				int defesa = 100 - (energia + ataque);
				System.out.print("Defesa: " + defesa);
				if (defesa < 1) {
					scanner.nextLine();
					throw new IllegalArgumentException("\n\nDistribuição de pontos inválida. Tente novamente");
				}
				personagem = new Personagem(new Level(1),nome, new Energia(energia, energia), new Ataque(ataque), new Defesa(defesa), new Ouro(20), new Pocao(3));
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

	public static void iniciarJogo(Scanner scanner, Personagem personagem) {
		Vilarejo vilarejo = new Vilarejo(new Hospedaria(), new Cigana(), new LojaDeArmas());
		System.out.println(vilarejo.iniciarAventura());
		int opVilarejo = 0;
		do {
			vilarejo.mostrarMenu();
			opVilarejo = vilarejo.obterOpMenu(scanner);
			executarOpJogo(opVilarejo, vilarejo, personagem, scanner);
		} while (opVilarejo != 0);
	}

	public static void executarOpJogo(int opMenu, Vilarejo vilarejo, Personagem personagem, Scanner scanner) {
		switch (opMenu) {
		case 1:
			System.out.println("\n" + personagem.toString());
			break;
		case 2:
			vilarejo.getHospedaria().recuperarEnergia(scanner, personagem);
			break;
		case 3:
			vilarejo.getCigana().consultaCigana(personagem, scanner);
			break;
		case 4:
			vilarejo.getLojaDeArmas().aaaa(scanner, personagem);
			break;
		}
	}

}

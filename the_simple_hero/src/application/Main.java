package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.characters.Ataque;
import model.characters.Defesa;
import model.characters.Energia;
import model.characters.Level;
import model.characters.Ouro;
import model.characters.Personagem;
import model.characters.Pocao;
import model.enviroment.Floresta;
import model.enviroment.Montanhas;
import model.enviroment.Vilarejo;
import model.npc.Cigana;
import model.npc.Hospedaria;
import model.npc.LojaDeArmas;
import service.BatalhaBoss;
import service.BatalhaComum;
import utilities.ObterInputs;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		try (Scanner scanner = new Scanner(System.in)) {
			ObterInputs obterInputs = new ObterInputs();
			System.out.println("\nTHE SIMPLE HERO\n");
			System.out.println("\nVamos criar o seu herói!");
			Personagem personagem = obterPersonagem(scanner, obterInputs);
			System.out.println("\n\nHerói criado!\n");
			System.out.println(personagem);
			while (personagem.confirmarPersonagem(scanner)) {
				obterPersonagem(scanner, obterInputs);
			}
			iniciarJogo(scanner, personagem, obterInputs);
			System.out.println("\nGAME OVER");
		}
	}

	public static Personagem obterPersonagem(Scanner scanner, ObterInputs obterInputs) {
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
				personagem = new Personagem(new Level(1),nome, new Energia(energia, energia), new Ataque(ataque), new Defesa(defesa), new Ouro(20), new Pocao(3), obterInputs);
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

	public static void iniciarJogo(Scanner scanner, Personagem personagem, ObterInputs obterInputs) {
		Vilarejo vilarejo = new Vilarejo(new Hospedaria(), new Cigana(), new LojaDeArmas(), new Floresta(new BatalhaComum()), new Montanhas(new BatalhaBoss()));
		System.out.println(vilarejo.iniciarAventura());
		int opVilarejo = 0;
		do {
			vilarejo.mostrarMenu();
			opVilarejo = vilarejo.obterOpMenu(scanner);
			executarOpJogo(opVilarejo, vilarejo, personagem, scanner, obterInputs);
		} while (opVilarejo != 0);
	}

	public static void executarOpJogo(int opMenu, Vilarejo vilarejo, Personagem personagem, Scanner scanner, ObterInputs obterInputs) {
		switch (opMenu) {
		case 1:
			System.out.println("\n" + personagem.toString());
			break;
		case 2: 
			personagem.usarPocao();
			break;
		case 3:
			vilarejo.getHospedaria().recuperarEnergia(scanner, personagem, obterInputs);
			break;
		case 4:
			vilarejo.getCigana().consultaCigana(personagem, scanner, obterInputs);
			break;
		case 5:
			vilarejo.getLojaDeArmas().comprarArmas(scanner, personagem, obterInputs);
			break;
		case 6:
			vilarejo.getFloresta().getBatalha().iniciarBatalha(personagem, scanner);
			break;
		case 7:
			vilarejo.getMontanhas().getBatalha().iniciarBatalha(personagem, scanner);
			break;
		}
	}

}

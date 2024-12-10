package entities;

import java.util.Scanner;

public class Hospedaria {

	public Hospedaria() {
	}
	
	public void recuperarEnergia(Scanner scanner, Personagem personagem) {
		try {
			System.out.println("\nBem vindo a hospedaria Satolep!!");
			System.out.println("Gostaria de passar uma noite aqui e descansar com qualidade?");
			System.out.println("Energia: " + personagem.getEnergiaTotal() + " / " + personagem.getEnergiaAtual());
			System.out.println("O valor é de 10 moedas de ouro!");
			System.out.print("\nDigite 's' para sim e 'n' para não: ");
			char op = scanner.next().toString().charAt(0);
			if (op != 's' && op != 'n') {
				throw new IllegalArgumentException("\nOpção inválida. Tente novamente");
			}
			if (op == 's') {
				if (personagem.getOuro() < 10) {
					System.out.println("\nVocê não tem ouro suficiente ! Volte outra hora");
				} else {
					if (personagem.getEnergiaAtual() == personagem.getEnergiaTotal()) {
						System.out.println("\nParece que você esta bem descansado. Deixe essa dormida para outra hora!");
					} else {
						System.out.println("\nTenha um bom descanso.");
						personagem.setOuro(personagem.getOuro() - 10);
						personagem.setEnergiaAtual(personagem.getEnergiaTotal());
						System.out.println("Energias renovadas: " + personagem.getEnergiaTotal() + " / " + personagem.getEnergiaAtual());
						System.out.println("Ouro total: " + personagem.getOuro());
						System.out.println("Volte sempre!");
					}
				}
			} else {
				String[] frasesAtendente = {"AH, va encomodar outro!", "Ok, volte sempre.", "Tranquilo, você é sempre bem vindo aqui."};
				  int indice = (int) (Math.random() * frasesAtendente.length);
				System.out.println("\n" + frasesAtendente[indice]);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}

package model.npc;

import java.util.Scanner;

import model.characters.Personagem;
import utilities.ObterInputs;

public class Hospedaria {

	public Hospedaria() {
	}

	public void recuperarEnergia(Scanner scanner, Personagem personagem, ObterInputs obterInputs) {
		boolean inputValido = false;
		char op = ' ';
		while (!inputValido) {
			try {
				System.out.println("\nBem vindo a hospedaria Satolep!!");
				System.out.println("Gostaria de passar uma noite aqui e descansar com qualidade?");
				System.out.println("Energia: " + personagem.getEnergia().mostrarDiferencaEnergia());
				System.out.println("O valor é de 10 moedas de ouro!");
				op = obterInputs.obterChar();
				inputValido = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			if (op == 's') {
				if (personagem.getOuro().testarQuantidadeDeOuro(10)) {
					if (personagem.getEnergia().compararEnergiaTotalEAtual()) {
						System.out
								.println("\nParece que você esta bem descansado. Deixe essa dormida para outra hora!");
					} else {
						System.out.println("\nTenha um bom descanso.");
						personagem.getOuro().debitarQuantidadeDeOuro(10);
						personagem.getEnergia().completarEnergia();
						System.out.println("Energias renovadas: " + personagem.getEnergia().mostrarDiferencaEnergia());
						System.out.println("Ouro total: " + personagem.getOuro().getQuantidade());
						System.out.println("Volte sempre!");
					}
				} else {
					System.out.println("\nVocê não tem ouro suficiente ! Volte outra hora");

				}
			} else {
				String[] frasesAtendente = { "AH, va encomodar outro!", "Ok, volte sempre.",
						"Tranquilo, você é sempre bem vindo aqui." };
				int indice = (int) (Math.random() * frasesAtendente.length);
				System.out.println("\n" + frasesAtendente[indice]);
			}
		}
	}
}

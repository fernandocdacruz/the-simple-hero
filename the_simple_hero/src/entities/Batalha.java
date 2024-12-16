package entities;

import java.util.Random;
import java.util.Scanner;

import utilities.AcoesBatalhas;

public class Batalha {

	public void iniciarBatalha(Personagem personagem, Scanner scanner) {
		
		Random random = new Random();
		Adversario adversario = null;
		int opAdversario = random.nextInt(3) + 1;
		switch (opAdversario) {
		case 1: adversario = new Adversario("Margina", new Energia(20, 20), new Ataque(10), new Defesa(10));
			break;
		case 2: adversario = new Adversario("Maloca", new Energia(30, 30), new Ataque(15), new Defesa(15));
			break;
		case 3: adversario = new Adversario("Lebéia", new Energia(40, 40), new Ataque(20), new Defesa(20));
			break;
		}
		AcoesBatalhas acoes = new AcoesBatalhas(personagem, adversario, scanner);
		System.out.println("\nAchamos um adversário na floresta, é hora de enfrenta-lo!");
		System.out.println("\nÉ o " + adversario.getNome() + "!! Tome cuidado.");
		System.out.println("\nVocê tem a iniciativa das ações!");
		boolean personagemVivo = true;
		boolean adversarioVivo = true;
		while (personagemVivo == true && adversarioVivo == true) {
			acoes.roundPersonagem();
			if (acoes.checarEnergiaAdversario()) {
				adversarioVivo = false;
				System.out.println("\nFim de luta. Você venceu.");
			} else {
				acoes.causarDanoPersonagem();
				if (acoes.checarEnergiaAdversario()) {
					personagemVivo = false;
					System.out.println("\nFim de luta. Você perdeu.");
				}
			}
		}
		
		
	}
}

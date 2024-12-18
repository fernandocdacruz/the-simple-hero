package service;

import java.util.Random;
import java.util.Scanner;

import model.characters.Ataque;
import model.characters.Defesa;
import model.characters.Energia;
import model.characters.Personagem;
import model.npc.Adversario;
import utilities.AcoesBatalhas;
import utilities.ObterInputs;

public class BatalhaComum implements Batalha {

	public void iniciarBatalha(Personagem personagem, Scanner scanner) {

		ObterInputs obter = new ObterInputs();
		Adversario adversario = obterAdversario();
		AcoesBatalhas acoes = new AcoesBatalhas(personagem, adversario, scanner);
		System.out.println("\nAchamos um adversário na floresta, é hora de enfrenta-lo!");
		System.out.println("\nÉ o " + adversario.getNome() + "!! Tome cuidado.");
		System.out.println("Deseja fugir?");
		char op = obter.obterChar();
		if (op == 's') {
			System.out.println("\nVocê conseguiu escapar. As vezes um passo para trás são dois para frente.");
		} else {
			System.out.println("\nVocê tem a iniciativa das ações!");
			boolean personagemVivo = true;
			boolean adversarioVivo = true;
			while (personagemVivo == true && adversarioVivo == true) {
				acoes.roundPersonagem();
				if (acoes.checarEnergiaAdversario()) {
					adversarioVivo = false;
					System.out.println("\nFim de luta. Você venceu.");
					System.out.println("E ganhou " + adversario.getOuro() + " de ouro.");
					System.out.println("E " + adversario.getXp() + " de XP.");
					personagem.testarLevel(adversario.getXp());
					personagem.getOuro().adicionarQuantidadeDeOuro(adversario.getOuro());
				} else {
					acoes.causarDanoPersonagem();
					if (acoes.checarEnergiaPersonagem()) {
						personagemVivo = false;
						personagem.getEnergia().completarEnergia();
						System.out.println("\nFim de luta. Você perdeu.");
					}
				}

			}
		}

	}

	public Adversario obterAdversario() {
		Adversario adversario = null;
		Random random = new Random();
		int opAdversario = random.nextInt(3) + 1;
		switch (opAdversario) {
		case 1:
			adversario = new Adversario("Margina", new Energia(20, 20), new Ataque(10), new Defesa(10), 5, 5);
			break;
		case 2:
			adversario = new Adversario("Maloca", new Energia(30, 30), new Ataque(15), new Defesa(15), 10, 10);
			break;
		case 3:
			adversario = new Adversario("Lebéia", new Energia(40, 40), new Ataque(20), new Defesa(20), 15, 15);
			break;
		}
		return adversario;
	}

}

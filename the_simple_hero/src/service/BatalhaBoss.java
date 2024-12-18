package service;

import java.util.Scanner;

import model.characters.Ataque;
import model.characters.Defesa;
import model.characters.Energia;
import model.characters.Personagem;
import model.npc.Adversario;
import utilities.AcoesBatalhas;
import utilities.ObterInputs;

public class BatalhaBoss implements Batalha {

	@Override
	public void iniciarBatalha(Personagem personagem, Scanner scanner) {

		ObterInputs obter = new ObterInputs();
		Adversario adversario = obterAdversario();
		AcoesBatalhas acoes = new AcoesBatalhas(personagem, adversario, scanner);
		System.out.println("\nFinalmente chegamos no local desejado nas montanhas, e achamos o líder dessa balburdia. \nÉ hora de enfrenta-lo!");
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
					System.out.println("\nFim de luta. Você venceu e acabou com todo o caos que dominava o vilarejo.");
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

	@Override
	public Adversario obterAdversario() {
		Adversario adversario = new Adversario("Marcola do PCC", new Energia(300, 300), new Ataque(100), new Defesa(100), 0, 0);
		return adversario;
	}

}

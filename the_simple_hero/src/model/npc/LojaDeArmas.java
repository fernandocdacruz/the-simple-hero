package model.npc;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.characters.Personagem;
import utilities.ObterInputs;

public class LojaDeArmas {

	public LojaDeArmas() {
	}

	public void comprarArmas(Scanner scanner, Personagem personagem, ObterInputs obterInputs) {
		boolean inputValido = false;
		char op = ' ';
		while (!inputValido) {
			try {
				System.out.println("\nBem vindo a Loja de Armas da XV!! Me chamo Samarone, em que posso ajudar?");
				System.out.println("\nDeseja comprar alguma coisa?");
				op = obterInputs.obterChar();
				inputValido = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			if (op == 's') {
				int menuOp = 0;
				do {
					try {
						inputValido = false;
						while (!inputValido) {
							System.out.println("\nCerto, o que você deseja comprar?");
							System.out.println(personagem.getOuro().toString());
							System.out.println("\n[0] - Sair");
							System.out.println("[1] - +1 de ataque, 25 de ouro");
							System.out.println("[2] - +1 de defesa, 25 de ouro");
							System.out.println("[3] - +10 de energia, 60 de ouro");
							System.out.println("[4] - 1 Poção de enegia, 80 de ouro");
							System.out.print("\nEscolha uma opção: ");
							menuOp = scanner.nextInt();
							if (menuOp < 0 || menuOp > 4) {
								throw new IllegalArgumentException("Opção inválida. Tente novamente.");
							}
							if (menuOp == 0) {
								System.out.println("\nOk! Volte sempre");
								inputValido = true;
							} else {
								int[] valores = { 0, 25, 25, 60, 80 };
								if (personagem.getOuro().testarQuantidadeDeOuro(valores[menuOp])) {
									switch (menuOp) {
									case 1:
										personagem.getAtaque().aumentarAtaqueAtual(1);
										break;
									case 2:
										personagem.getDefesa().aumentarDefesaAtual(1);
										break;
									case 3:
										personagem.getEnergia().aumentarEnergiaAtual(10);
										break;
									case 4:
										personagem.getPocao().comprarPocao(1);
										break;
									}
									personagem.getOuro().debitarQuantidadeDeOuro(valores[menuOp]);
									System.out.println("\nMuito bom fazer negócios com você.");
								} else {
									System.out.println(
											"\nMe desculpe, mas você não possui o valor necessário. Tente de novo uma próxima vez.");
								}
							}
						}
					} catch (InputMismatchException e) {
						System.out.println("\nInput inválido. Tente novamente.");
						scanner.next();
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
				} while (menuOp != 0);

			} else {
				System.out.println("\nOk, estamos aqui para ajudar a te proteger. Volte sempre!");
			}
		}
	}
}

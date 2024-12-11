package entities;

import java.util.Scanner;

public class Cigana {

	public Cigana() {
	}

	private String[] frasesCigana = { "Se você acha que o vento está a seu favor, cuidado: ele também espalha poeira.",
			"Cuidado ao pisar na grama, às vezes ela é só uma pedra disfarçada.",
			"A lua cheia brilha para todos, mas nem todo mundo gosta de lobisomens.",
			"Coma cenouras. Não vai mudar nada, mas ao menos sua visão vai melhorar, talvez.",
			"O caminho mais curto geralmente é aquele que te deixa perdido mais rápido.",
			"Plante uma árvore hoje. Se ela crescer, pode te dar sombra ou cair na sua cabeça.",
			"Quem canta seus males espanta, mas quem desafina irrita até os deuses.",
			"A sorte sorri para quem se arrisca, mas às vezes ela só dá risada mesmo.",
			"Não confie em galinhas sorridentes. É um mau presságio.",
			"Se alguém te oferecer um mapa do tesouro, verifique se o 'tesouro' não é imposto atrasado.",
			"Olhe para o céu e veja as estrelas. Agora abaixe a cabeça antes de bater no poste.",
			"Se o destino está te empurrando, certifique-se de que não seja para um penhasco.",
			"A água é vida, mas não esqueça de aprender a nadar.",
			"Algumas portas se abrem para o sucesso, outras só dão em banheiros mal limpos.",
			"Não mexa com o que está quieto, exceto se for um baú brilhando no canto da sala." };

	public void consultaCigana(Personagem personagem, Scanner scanner) {
		boolean inputValido = false;
		char op = ' ';
		while (!inputValido) {
			try {
				System.out.println("\nEstava a sua espera " + personagem.getNome() + ", você esta 15 minutos atrasado.");
				System.out.println("Enfim, gostaria de um conselho?");
				System.out.println("Não vou lhe cobrar nada... Por agora... HA HA HA!");
				System.out.print("\nDigite 's' para sim e 'n' para não: ");
				op = scanner.next().toString().charAt(0);
				if (op != 's' && op != 'n') {
					throw new IllegalArgumentException("\nOpção inválida. Tente novamente");
				}
				inputValido = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			if (op == 's') {
				System.out.println("\nEscolha sábia... Preste atenção no que vou te falar:");
				int indice = (int) (Math.random() * frasesCigana.length);
				System.out.println("\n" + frasesCigana[indice]);
			} else {
				System.out.println("\nHmmm, ok... Tome cuidado, as coisas acontecem quando menos esperamos.");
			}
		}
	}
}

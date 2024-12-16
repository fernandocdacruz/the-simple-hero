package utilities;

import java.util.Scanner;

import entities.Adversario;
import entities.Personagem;

public class AcoesBatalhas {
	
	private Personagem personagem;
	private Adversario adversario;
	private Scanner scanner;
	
	public AcoesBatalhas() {
	}

	public AcoesBatalhas(Personagem personagem, Adversario adversario, Scanner scanner) {
		this.personagem = personagem;
		this.adversario = adversario;
		this.scanner = scanner;
	}

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

	public Adversario getAdversario() {
		return adversario;
	}

	public void setAdversario(Adversario adversario) {
		this.adversario = adversario;
	}
	
	public boolean checarEnergiaPersonagem() {
		return personagem.getEnergia().checarEnergia() ? true : false;
	}
	
	public boolean checarEnergiaAdversario() {
		return adversario.getEnergia().checarEnergia() ? true : false;
	}
	
	public void roundPersonagem() {
		System.out.println("\n" + personagem.getEnergia().mostrarDiferencaEnergia());
		System.out.println("\n[1] - Atacar");
		System.out.print("\nDigite a opção desejada: ");
		int op = scanner.nextInt();
		switch (op) {
		case 1: causarDanoAdversario();
			break;
		}
	}
	
	public void causarDanoAdversario() {
		int ataque = personagem.getAtaque().atacar();
		int defesa = adversario.getDefesa().defender();
		int totalDeDano = ataque - defesa;
		if (totalDeDano > 0) {
			System.out.println("teste");
			System.out.println("\nAtaque realizado com sucesso. Total de dano: " + totalDeDano);
			adversario.getEnergia().receberDano(totalDeDano);
		}
	}
	
	public void causarDanoPersonagem() {
		System.out.println("\nAgora é a vez do seu adversário atacar !! Defendasse !!");
		int ataque = adversario.getAtaque().atacar();
		int defesa = personagem.getDefesa().defender();
		int totalDeDano = ataque - defesa;
		if (totalDeDano > 0) {
			System.out.println("\nAtaque realizado com sucesso. Total de dano: " + totalDeDano);
			personagem.getEnergia().receberDano(totalDeDano);
		}
	}
	
}

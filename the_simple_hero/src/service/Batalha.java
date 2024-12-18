package service;

import java.util.Scanner;

import model.characters.Personagem;
import model.npc.Adversario;

public interface Batalha {

	public void iniciarBatalha(Personagem personagem, Scanner scanner);
	public Adversario obterAdversario();
	
}

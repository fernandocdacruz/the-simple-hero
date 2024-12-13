package utilities;

import java.util.Scanner;

public class ObterInputs {
	
	static Scanner scanner = new Scanner(System.in);
	
	public ObterInputs() {
	}
	
	public char obterChar() {
		System.out.print("\nDigite 's' para sim e 'n' para não: ");
		char op = scanner.next().toString().charAt(0);
		if (op != 's' && op != 'n') {
			throw new IllegalArgumentException("\nOpção inválida. Tente novamente");
		}
		return op;
	}
}

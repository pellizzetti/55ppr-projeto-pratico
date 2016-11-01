package br.udesc.ceavi.designpatterns.projetopratico;

import java.util.Scanner;

public class Client {

	private static Scanner in;

	public static void main(String[] args) {

		int option = 0;
		in = new Scanner(System.in);
		
		System.out.println("1. Op 1\n"
                + "2. Op 2\n"
                + "3. Op 3\n"
                + "4. Op 4\n"
                + "5. Op 5\n"
                + "6. Sair");
		System.out.print("Escolha uma opção: ");
		
		while ((option < 1) || (option > 7)) {
			option = in.nextInt();
			
			switch (option) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:		
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}
		}
		
		System.exit(0);

	}

}

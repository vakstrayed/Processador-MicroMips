package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String args[]) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite 1 para executar modo processador: ");
		System.out.println("Digite 2 para executar modo tradutor: ");

		int k = teclado.nextInt();

		// Execu��o como processador (uso das memorias de instru��o e dados)
		if (k == 1)
			ControladorMemoria.getIntance().executar();

		// Execu��o como fila de instru��o (ignora as mem�rias)
		else if (k == 2) {
			ArrayList<String> instru��es = Arquivo.getInstance().lerArquivo();
			for (String s : instru��es) {
				Interpretador.translateAssembly(s);
			}
		}
	}
}

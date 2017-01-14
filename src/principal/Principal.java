package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	private static Scanner teclado;

	public static void main(String args[]) {

		
		teclado = new Scanner(System.in);
		
		System.out.println("==================================================================");
		System.out.println("= Digite 1 para executar modo processador:                       =");
		System.out.println("= Digite 2 para executar modo tradutor:                          =");
		System.out.println("=                                                                =");
		System.out.println("=                                                                =");
		System.out.println("= O valor inicial da memoria de dados é 8192 e pode ser alterado =");
		System.out.println("= através da variável posicINICIO dentro da classe MemoriaDados  =");
		System.out.println("==================================================================");


		int k = teclado.nextInt();

		// Execução como processador (uso das memorias de instrução e dados)
		if (k == 1)
			ControladorMemoria.getIntance().executar();

		// Execução como fila de instrução (ignora a memória de instrução)
		else if (k == 2) {
			ArrayList<String> instruções = Arquivo.getInstance().lerArquivo();
			for (String s : instruções) {
				Interpretador.translateAssembly(s);
			}
		}
	
	}
}

package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String args[]) {

		
		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite 1 para executar modo processador: ");
		System.out.println("Digite 2 para executar modo tradutor: ");

		int k = teclado.nextInt();

		// Execução como processador (uso das memorias de instrução e dados)
		if (k == 1)
			ControladorMemoria.getIntance().executar();

		// Execução como fila de instrução (ignora as memórias)
		else if (k == 2) {
			ArrayList<String> instruções = Arquivo.getInstance().lerArquivo();
			for (String s : instruções) {
				Interpretador.translateAssembly(s);
			}
		}
	
		/*
		String rd = "000010";
		String rt = "000000";
		String sh = "11110";
		String rs = "000010";
		Util u = new Util();
		
		ControladorRegistradores c = new ControladorRegistradores();
		c.inicializarRegistradores();
		c.getRegistradores()[u.TODecimal(rt)].setConteudo("0100000000000000000010000010010");
		c.getRegistradores()[u.TODecimal(rs)].setConteudo("0000100");
		
		c.sra(rd, rt, rs);
		//c.srlv(rd, rt, rs);
		*/
	}
}

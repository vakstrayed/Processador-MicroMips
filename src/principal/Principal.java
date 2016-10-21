package principal;

import java.util.ArrayList;

public class Principal {

	public static void main(String args[]) {

		ArrayList<String> instruções = Arquivo.lerArquivo();
		for (String s : instruções) {
			System.out.println(Interpretador.translateAssembly(s));

		}

	}

}

package principal;

import java.util.ArrayList;

public class Principal {

	public static void main(String args[]) {

		ArrayList<String> instruções = Arquivo.getInstance().lerArquivo();
		for (String s : instruções) {
			Interpretador.translateAssembly(s);
		}

	}

}

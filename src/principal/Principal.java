package principal;

import java.util.ArrayList;

public class Principal {

	public static void main(String args[]) {
		
		//Execução como processador (uso das memorias de instrução e dados)
		//ControladorMemoria.getIntance().executar();
		
		
		//Execução como fila de instrução (ignora as memórias)
		/*ArrayList<String> instruções = Arquivo.getInstance().lerArquivo();
		for (String s : instruções) {
			Interpretador.translateAssembly(s);
		}*/
	}

}

package principal;

import java.util.ArrayList;
import java.util.HashMap;

public class ControladorMemoria {

	private static ControladorMemoria instance;
	private HashMap<Integer, String> memoriaInstrucoes;

	private int enderecoAtual;
	private int enderecoFinal;

	private ControladorMemoria() {
		memoriaInstrucoes = new HashMap<Integer, String>();

		enderecoAtual = 0;
	}

	public static ControladorMemoria getIntance() {
		if (instance == null) {
			instance = new ControladorMemoria();
		}
		return instance;
	}

	public void povoaMemoria() {
		int end = -4;

		ArrayList<String> instrucoes = Arquivo.getInstance().lerArquivo();
		for (String s : instrucoes) {
			end = end + 4;

			if (s.length() == 10)
				memoriaInstrucoes.put(end, (s.substring(2, s.length())));
			else if (s.length() == 8)
				memoriaInstrucoes.put(end, s);

		}
		enderecoFinal = end;

	}

	public int getEnderecoAtual() {
		return enderecoAtual;
	}

	public void setEnderecoAtual(int enderecoAtual) {
		this.enderecoAtual = enderecoAtual;
	}

	public void executar() {
		povoaMemoria();
		while (enderecoAtual < enderecoFinal) {
			Interpretador.translateAssembly(memoriaInstrucoes.get(enderecoAtual));
			System.out.println(memoriaInstrucoes.get(enderecoAtual));
			enderecoAtual = enderecoAtual + 4;
		}
	}

}

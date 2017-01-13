package principal;

import java.util.ArrayList;
import java.util.List;

public class MemoriaDados {

	private static MemoriaDados instance;
	private List<Registrador> memoria;
	private static int posicINICIO = 8192;
	private Util util;

	private MemoriaDados() {
		this.memoria = new ArrayList<Registrador>();
	}

	public static MemoriaDados getInstance() {
		if (instance == null) {
			instance = new MemoriaDados();
		}
		return instance;
	}

	public int verificaENDERECO(String end) {
		int key = 0;
		int chave = 0;
		for (int i = 0; i < this.memoria.size(); i++) {
			if ((this.memoria.get(i).getNome().equals(end)) && (key == 0)) {
				key = 1;
				chave = i;
			}
		}
		if (key == 0) {
			Registrador r = new Registrador(end, "0");
			this.memoria.add(r);
			chave = this.memoria.indexOf(r);
		}
		return chave;

	}

	public void InserirSW(String endereco, int valor) {

		int end = Integer.parseInt(endereco);
		end = end - posicINICIO;
		int posicao = end / 4;
		// TOposicao diz em que endereço ele deve ser inserido
		int TOposicao = posicINICIO + posicao;
		int casa = posicao * 4;
		// casa vai dizer quem que byte deve ser inserido
		casa = end - casa;

		String dado = Integer.toBinaryString(valor);

		int chave = verificaENDERECO(Integer.toString(TOposicao));

		switch (casa) {
		case 0:
			dado = util.completacomZero(dado);
			this.memoria.get(chave).setConteudo(dado);
			break;
		case 1:

			break;
		case 2:
			break;
		case 3:
			break;
		}

	}

}

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

		int chave = verificaENDERECO(Integer.toString(TOposicao));

		String dado = Integer.toBinaryString(valor);

		String getdado = this.memoria.get(chave).getConteudo();
		String dataBIN = Integer.toBinaryString(Integer.parseInt(getdado));
		dataBIN = util.completacomZero(dataBIN);

		String db, dg, dataINSERT;

		switch (casa) {
		case 0:
			this.memoria.get(chave).setConteudo(Integer.toString(valor));
			break;
		case 1:
			db = dataBIN.substring(24);
			dg = dado.substring(8);
			dataINSERT = dg.concat(db);
			this.memoria.get(chave).setConteudo(util.twoComplment(dataINSERT));
			break;
		case 2:
			db = dataBIN.substring(16);
			dg = dado.substring(16);
			dataINSERT = dg.concat(db);
			this.memoria.get(chave).setConteudo(util.twoComplment(dataINSERT));
			break;
		case 3:
			db = dataBIN.substring(8);
			dg = dado.substring(24);
			dataINSERT = dg.concat(db);
			this.memoria.get(chave).setConteudo(util.twoComplment(dataINSERT));
			break;
		}

	}

	public void InserirSB(String endereco, int valor) {

		int end = Integer.parseInt(endereco);
		end = end - posicINICIO;
		int posicao = end / 4;
		// TOposicao diz em que endereço ele deve ser inserido
		int TOposicao = posicINICIO + posicao;
		int casa = posicao * 4;
		// casa vai dizer quem que byte deve ser inserido
		casa = end - casa;

		int chave = verificaENDERECO(Integer.toString(TOposicao));

		String dado = Integer.toBinaryString(valor);

		String getdado = this.memoria.get(chave).getConteudo();
		String dataBIN = Integer.toBinaryString(Integer.parseInt(getdado));
		dataBIN = util.completacomZero(dataBIN);
		
		switch (casa) {
		case 0:
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

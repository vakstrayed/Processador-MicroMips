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
	
	public int getPosicINICIO(){
		return MemoriaDados.posicINICIO;
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
		dado = util.completacomZero(dado);

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
		dado = util.completacomZero(dado);

		String getdado = this.memoria.get(chave).getConteudo();
		String dataBIN = Integer.toBinaryString(Integer.parseInt(getdado));
		dataBIN = util.completacomZero(dataBIN);

		String corteDADO = dado.substring(24);

		String corteDBINa = dataBIN.substring(0, 8);
		String corteDBINb = dataBIN.substring(8, 16);
		String corteDBINc = dataBIN.substring(16, 24);
		String corteDBINd = dataBIN.substring(24);

		String dataINSERT;

		switch (casa) {
		case 0:
			dataINSERT = corteDBINa.concat(corteDBINb).concat(corteDBINc).concat(corteDADO);
			this.memoria.get(chave).setConteudo(util.twoComplment(dataINSERT));
			break;
		case 1:
			dataINSERT = corteDBINa.concat(corteDBINb).concat(corteDADO).concat(corteDBINd);
			this.memoria.get(chave).setConteudo(util.twoComplment(dataINSERT));
			break;
		case 2:
			dataINSERT = corteDBINa.concat(corteDADO).concat(corteDBINc).concat(corteDBINd);
			this.memoria.get(chave).setConteudo(util.twoComplment(dataINSERT));
			break;
		case 3:
			dataINSERT = corteDADO.concat(corteDBINb).concat(corteDBINc).concat(corteDBINd);
			this.memoria.get(chave).setConteudo(util.twoComplment(dataINSERT));
			break;
		}

	}

	public String LerMemoria(String endereco) {
		
		int end = Integer.parseInt(endereco);
		end = end - posicINICIO;
		int posicao = end / 4;
		// TOposicao diz em que endereço ele deve ser inserido
		int TOposicao = posicINICIO + posicao;
		int casa = posicao * 4;
		// casa vai dizer quem que byte deve ser inserido
		casa = end - casa;

		int chave = verificaENDERECO(Integer.toString(TOposicao));
		String t = this.memoria.get(chave).getConteudo();
		t = Integer.toBinaryString(Integer.parseInt(t));
		t = util.completacomZero(t);
		return t;

	}
	
	public String toStringMemoDado() {

		String conteudo;
		List<Registrador> DataMemo = new ArrayList<Registrador>();

		for (int i = 0; i < memoria.size(); i++) {

			conteudo = util.twoComplment(memoria.get(i).getConteudo());

			DataMemo.add(new Registrador(memoria.get(i).getNome(), conteudo));

		}

		return DataMemo.toString();
	}

}

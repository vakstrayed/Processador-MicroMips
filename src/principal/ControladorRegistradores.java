package principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControladorRegistradores {

	private Registrador[] registradores = new Registrador[32];
	private Registrador[] Aux = new Registrador[32];
	private Registrador hi = new Registrador("hi", "00000000000000000000000000000000");
	private Registrador lo = new Registrador("lo", "00000000000000000000000000000000");
	private List<Registrador> MemoriaDado = new ArrayList<Registrador>();

	private Util util = new Util();
	private ControladorMemoria memoria;

	public ControladorRegistradores() {
		inicializarRegistradores();
		memoria = ControladorMemoria.getIntance();
	}

	public void inicializarRegistradores() {
		for (int i = 0; i < registradores.length; i++) {
			registradores[i] = new Registrador("$" + i, "00000000000000000000000000000000");
		}

	}

	public void add(String rd, String rs, String rt) {

		String conteudoRegs = registradores[util.TODecimal(rs)].getConteudo();
		conteudoRegs = util.twoComplment(conteudoRegs);
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);

		String conteudoRegT = registradores[util.TODecimal(rt)].getConteudo();
		conteudoRegT = util.twoComplment(conteudoRegT);
		int conteudoComplementoT = Integer.parseInt(conteudoRegT);

		registradores[util.TODecimal(rd)]
				.setConteudo(util.completacomZero(Integer.toBinaryString(conteudoComplementoS + conteudoComplementoT)));

		System.out.println(toString());

	}

	public void addi(String rt, String rs, String imm) {

		String conteudoRegs = registradores[util.TODecimal(rs)].getConteudo();
		conteudoRegs = util.twoComplment(conteudoRegs);
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);

		String imediato = util.twoComplment(imm);
		int imediatoComplemento = Integer.parseInt(imediato);

		registradores[util.TODecimal(rt)]
				.setConteudo(util.completacomZero(Integer.toBinaryString(conteudoComplementoS + imediatoComplemento)));

		System.out.println(toString());

	}

	public void addu(String rd, String rs, String rt) {

		String conteudoRegs = registradores[util.TODecimal(rs)].getConteudo();
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);

		String conteudoRegT = registradores[util.TODecimal(rt)].getConteudo();
		int conteudoComplementoT = Integer.parseInt(conteudoRegT);

		registradores[util.TODecimal(rd)]
				.setConteudo(util.completacomZero(Integer.toBinaryString(conteudoComplementoS + conteudoComplementoT)));

		System.out.println(toString());

	}

	public void addiu(String rt, String rs, String imm) {

		String conteudoRegs = registradores[util.TODecimal(rs)].getConteudo();
		conteudoRegs = util.twoComplment(conteudoRegs);
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);

		String imediato = util.twoComplment(imm);
		int imediatoComplemento = Integer.parseInt(imediato);

		registradores[util.TODecimal(rt)]
				.setConteudo(util.completacomZero(Integer.toBinaryString(conteudoComplementoS + imediatoComplemento)));

		System.out.println(toString());

	}

	public void sub(String rd, String rs, String rt) {

		String conteudoRegs = registradores[util.TODecimal(rs)].getConteudo();
		conteudoRegs = util.twoComplment(conteudoRegs);
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);

		String conteudoRegT = registradores[util.TODecimal(rt)].getConteudo();
		conteudoRegT = util.twoComplment(conteudoRegT);
		int conteudoComplementoT = Integer.parseInt(conteudoRegT);

		registradores[util.TODecimal(rd)]
				.setConteudo(util.completacomZero(Integer.toBinaryString(conteudoComplementoS - conteudoComplementoT)));

		System.out.println(toString());

	}

	public void subu(String rd, String rs, String rt) {

		String conteudoRegs = registradores[util.TODecimal(rs)].getConteudo();
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);

		String conteudoRegT = registradores[util.TODecimal(rt)].getConteudo();
		int conteudoComplementoT = Integer.parseInt(conteudoRegT);

		registradores[util.TODecimal(rd)]
				.setConteudo(util.completacomZero(Integer.toBinaryString(conteudoComplementoS - conteudoComplementoT)));

		System.out.println(toString());

	}

	public void slt(String rd, String rs, String rt) {

		String conteudoRegs = registradores[util.TODecimal(rs)].getConteudo();
		conteudoRegs = util.twoComplment(conteudoRegs);
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);

		String conteudoRegT = registradores[util.TODecimal(rt)].getConteudo();
		conteudoRegT = util.twoComplment(conteudoRegT);
		int conteudoComplementoT = Integer.parseInt(conteudoRegT);

		if (conteudoComplementoS > conteudoComplementoT)
			registradores[util.TODecimal(rd)].setConteudo(util.completacomZero("1"));
		else
			registradores[util.TODecimal(rd)].setConteudo(util.completacomZero("0"));

		System.out.println(toString());

	}

	public void slti(String rt, String rs, String imm) {

		String conteudoRegs = registradores[util.TODecimal(rs)].getConteudo();
		conteudoRegs = util.twoComplment(conteudoRegs);
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);

		String imediato = util.twoComplment(imm);
		int imediatoComplemento = Integer.parseInt(imediato);

		if (conteudoComplementoS > imediatoComplemento)
			registradores[util.TODecimal(rt)].setConteudo(util.completacomZero("1"));
		else
			registradores[util.TODecimal(rt)].setConteudo(util.completacomZero("0"));

		System.out.println(toString());

	}

	public void mfhi(String rd) {

		String conteudoHi = hi.getConteudo();
		registradores[util.TODecimal(rd)].setConteudo(conteudoHi);
		hi.setConteudo("00000000000000000000000000000000");

		System.out.println(toString());

	}

	public void mflo(String rd) {

		String conteudoLo = lo.getConteudo();
		registradores[util.TODecimal(rd)].setConteudo(conteudoLo);
		lo.setConteudo("00000000000000000000000000000000");

		System.out.println(toString());

	}

	public void and(String rd, String rs, String rt) {
		int rtB = util.TODecimal(registradores[util.TODecimal(rt)].getConteudo());
		int rsB = util.TODecimal(registradores[util.TODecimal(rs)].getConteudo());

		String r = Integer.toBinaryString(rtB & rsB);

		registradores[util.TODecimal(rd)].setConteudo(util.completacomZero(r));
		System.out.println(toString());

	}

	public void andi(String rt, String rs, String imm) {
		int rsB = util.TODecimal(registradores[util.TODecimal(rs)].getConteudo());
		int immB = util.TODecimal(imm);

		String r = Integer.toBinaryString(rsB & immB);

		registradores[util.TODecimal(rt)].setConteudo(util.completacomZero(r));
		System.out.println(toString());

	}

	public void or(String rd, String rs, String rt) {
		int rtB = util.TODecimal(registradores[util.TODecimal(rt)].getConteudo());
		int rsB = util.TODecimal(registradores[util.TODecimal(rs)].getConteudo());

		String r = Integer.toBinaryString(rtB | rsB);

		registradores[util.TODecimal(rd)].setConteudo(util.completacomZero(r));
		System.out.println(toString());

	}

	public void ori(String rt, String rs, String imm) {
		int rsB = util.TODecimal(registradores[util.TODecimal(rs)].getConteudo());
		int immB = util.TODecimal(imm);

		String r = Integer.toBinaryString(rsB | immB);

		registradores[util.TODecimal(rt)].setConteudo(util.completacomZero(r));
		System.out.println(toString());

	}

	public void nor(String rd, String rs, String rt) {
		int rtB = util.TODecimal(registradores[util.TODecimal(rt)].getConteudo());
		int rsB = util.TODecimal(registradores[util.TODecimal(rs)].getConteudo());

		String r = Integer.toBinaryString(~(rtB | rsB));

		registradores[util.TODecimal(rd)].setConteudo(util.completacomZero(r));
		System.out.println(toString());

	}

	public void mult(String rs, String rt) {

		String rsB = util.twoComplment(registradores[util.TODecimal(rs)].getConteudo());
		String rtB = util.twoComplment(registradores[util.TODecimal(rt)].getConteudo());

		long a = Long.parseLong(rsB);
		long b = Long.parseLong(rtB);

		long r = a * b;

		String rS = util.completacomZero64(Long.toBinaryString(r));

		this.hi.setConteudo(rS.substring(0, 32));
		this.lo.setConteudo(rS.substring(32, 63));

		System.out.println("hi: " + hi.getConteudo() + "\nlo: " + lo.getConteudo());

	}

	public void multu(String rs, String rt) {

		long rsB = util.TODecimal(registradores[util.TODecimal(rs)].getConteudo());
		long rtB = util.TODecimal(registradores[util.TODecimal(rt)].getConteudo());

		long r = rsB * rtB;

		String rS = util.completacomZero64(Long.toBinaryString(r));

		this.hi.setConteudo(rS.substring(0, 32));
		this.lo.setConteudo(rS.substring(32, 63));

		System.out.println("hi: " + hi.getConteudo() + "\nlo: " + lo.getConteudo());

	}

	public void div(String rs, String rt) {

		String rsB = util.twoComplment(registradores[util.TODecimal(rs)].getConteudo());
		String rtB = util.twoComplment(registradores[util.TODecimal(rt)].getConteudo());

		int a = Integer.parseInt(rsB);
		int b = Integer.parseInt(rtB);

		if (b > 0) {
			int r = a / b;
			int resto = a % b;

			String rS = util.completacomZero(Integer.toBinaryString(r));
			String restoS = util.completacomZero(Integer.toBinaryString(resto));

			this.hi.setConteudo(restoS);
			this.lo.setConteudo(rS);
		} else {
			this.hi.setConteudo(util.completacomZero("0"));
			this.lo.setConteudo(util.completacomZero("0"));
		}

		System.out.println("hi: " + hi.getConteudo() + "\nlo: " + lo.getConteudo());

	}

	public void divu(String rs, String rt) {
		int rsB = util.TODecimal(registradores[util.TODecimal(rs)].getConteudo());
		int rtB = util.TODecimal(registradores[util.TODecimal(rt)].getConteudo());

		if (rtB > 0) {
			int r = rsB / rtB;
			int resto = rsB % rtB;

			String rS = util.completacomZero(Integer.toBinaryString(r));
			String restoS = util.completacomZero(Integer.toBinaryString(resto));

			this.hi.setConteudo(restoS);
			this.lo.setConteudo(rS);
		} else {
			this.hi.setConteudo(util.completacomZero("0"));
			this.lo.setConteudo(util.completacomZero("0"));
		}

		System.out.println("hi: " + hi.getConteudo() + "\nlo: " + lo.getConteudo());
	}

	public void xor(String rd, String rs, String rt) {
		int rtB = util.TODecimal(registradores[util.TODecimal(rt)].getConteudo());
		int rsB = util.TODecimal(registradores[util.TODecimal(rs)].getConteudo());

		String r = Integer.toBinaryString(rtB ^ rsB);

		registradores[util.TODecimal(rd)].setConteudo(util.completacomZero(r));
		System.out.println(toString());

	}

	public void xori(String rt, String rs, String imm) {
		int rsB = util.TODecimal(registradores[util.TODecimal(rs)].getConteudo());
		int immB = util.TODecimal(imm);

		String r = Integer.toBinaryString(rsB ^ immB);

		registradores[util.TODecimal(rt)].setConteudo(util.completacomZero(r));
		System.out.println(toString());

	}

	public void jr(String rs) {
		String conteudo = registradores[util.TODecimal(rs)].getConteudo();
		int conteudoD = util.TODecimal(conteudo);
		memoria.setEnderecoAtual(conteudoD);
	}

	public void bltz(String rs, String imm) {
		String conteudo = registradores[util.TODecimal(rs)].getConteudo();
		String conteudoDD = util.twoComplment(conteudo);
		int conteudoD = Integer.parseInt(conteudoDD);
		if (conteudoD < 0) {
			int endereco = util.TODecimal(imm);
			System.out.println(endereco);
			memoria.setEnderecoAtual(endereco);
		}
	}

	public void beq(String rs, String rt, String imm) {
		String conteudo = registradores[util.TODecimal(rs)].getConteudo();
		String conteudoDD = util.twoComplment(conteudo);
		int conteudoRS = Integer.parseInt(conteudoDD);
		
		String conteudoA = registradores[util.TODecimal(rs)].getConteudo();
		String conteudoAA = util.twoComplment(conteudoA);
		int conteudoRT = Integer.parseInt(conteudoAA);
		
		if (conteudoRS == conteudoRT) {
			int endereco = util.TODecimal(imm);
			memoria.setEnderecoAtual(endereco);
		}
	}

	public void bne(String rs, String rt, String imm) {
		String conteudo = registradores[util.TODecimal(rs)].getConteudo();
		String conteudoDD = util.twoComplment(conteudo);
		int conteudoRS = Integer.parseInt(conteudoDD);
		
		String conteudoA = registradores[util.TODecimal(rs)].getConteudo();
		String conteudoAA = util.twoComplment(conteudoA);
		int conteudoRT = Integer.parseInt(conteudoAA);

		if (conteudoRS != conteudoRT) {
			int endereco = util.TODecimal(imm);
			memoria.setEnderecoAtual(endereco);
		}
	}

	public void j(String imm) {

		int conteudoD = util.TODecimal(imm);
		memoria.setEnderecoAtual(conteudoD);
	}

	public void jal(String imm) {

		int conteudoD = util.TODecimal(imm);
		int endereco = ControladorMemoria.getIntance().getEnderecoAtual();

		memoria.setEnderecoAtual(conteudoD);

		String r = util.completacomZero(Integer.toBinaryString(endereco));

		registradores[31].setConteudo(r);

	}

	public void lb(String rt, String imm, String rs) {

		String contIMM = util.twoComplment(imm);
		String conteudoRs = registradores[util.TODecimal(rs)].getConteudo();
		int conteudoRS = util.TODecimal(conteudoRs);
		int conteudoIMM = Integer.parseInt(contIMM);

		int soma = conteudoIMM + conteudoRS;
		String r = Integer.toString(soma);

		verificaMD(r);
		String data = getMemoriaDADO(r);
		data = data.substring(7);
		data = util.twoComplment(data);
		int dado = Integer.parseInt(data);
		data = Integer.toBinaryString(dado);

		registradores[util.TODecimal(rt)].setConteudo(util.completacomZero(data));

	}

	public void lbu(String rt, String imm, String rs) {

		String contIMM = util.twoComplment(imm);
		String conteudoRs = registradores[util.TODecimal(rs)].getConteudo();
		int conteudoRS = util.TODecimal(conteudoRs);
		int conteudoIMM = Integer.parseInt(contIMM);

		int soma = conteudoIMM + conteudoRS;
		String r = Integer.toString(soma);

		verificaMD(r);
		String data = getMemoriaDADO(r);
		data = data.substring(7);

		registradores[util.TODecimal(rt)].setConteudo(util.completacomZero(data));

	}

	public void lui(String rt, String imm) {
		
		
		String zeros = "0000000000000000";

		String r = imm.concat(zeros);

		registradores[util.TODecimal(rt)].setConteudo(r);

	}

	public void lw(String rt, String imm, String rs) {

		String contIMM = util.twoComplment(imm);
		String conteudoRs = registradores[util.TODecimal(rs)].getConteudo();
		int conteudoRS = util.TODecimal(conteudoRs);
		int conteudoIMM = Integer.parseInt(contIMM);

		int soma = conteudoIMM + conteudoRS;
		String r = Integer.toString(soma);

		verificaMD(r);
		String data = getMemoriaDADO(r);

		registradores[util.TODecimal(rt)].setConteudo(util.completacomZero(data));

	}

	public void sb(String rt, String imm, String rs) {

		String contIMM = util.twoComplment(imm);
		String conteudoRs = registradores[util.TODecimal(rs)].getConteudo();
		int conteudoRS = util.TODecimal(conteudoRs);
		int conteudoIMM = Integer.parseInt(contIMM);

		int soma = conteudoIMM + conteudoRS;
		String r = Integer.toString(soma);

		verificaMD(r);
		String data = getMemoriaDADO(r);
		data = data.substring(7);
		data = util.twoComplment(data);
		int dado = Integer.parseInt(data);
		data = Integer.toBinaryString(dado);

		setMemoriaDADO(r, util.completacomZero(data));

	}

	public void sw(String rt, String imm, String rs) {

		String contIMM = util.twoComplment(imm);
		String conteudoRs = registradores[util.TODecimal(rs)].getConteudo();
		int conteudoRS = util.TODecimal(conteudoRs);
		int conteudoIMM = Integer.parseInt(contIMM);

		int soma = conteudoIMM + conteudoRS;
		String r = Integer.toString(soma);

		verificaMD(r);
		String data = getMemoriaDADO(r);

		setMemoriaDADO(r, util.completacomZero(data));

	}

	public void sll() {

	}

	public void sllv() {

	}

	public void sra() {

	}

	public void srav() {

	}

	public void srl() {

	}

	public void srlv() {

	}

	public void syscall() {

	}

	public void verificaMD(String id) {

		int key = 0;

		for (int i = 0; i < MemoriaDado.size(); i++) {
			if (MemoriaDado.get(i).getNome().equals(id)) {
				key = 1;
			}
		}
		if (key == 0) {
			Registrador v = new Registrador(id, "00000000000000000000000000000000");
			MemoriaDado.add(v);
		}

	}

	public String getMemoriaDADO(String id) {

		String dado = null;

		for (int i = 0; i < MemoriaDado.size(); i++) {
			if (MemoriaDado.get(i).getNome().equals(id)) {
				dado = MemoriaDado.get(i).getConteudo();
			}
		}
		return dado;
	}

	public void setMemoriaDADO(String id, String dado) {

		verificaMD(id);
		for (int i = 0; i < MemoriaDado.size(); i++) {
			if (MemoriaDado.get(i).getNome().equals(id)) {
				MemoriaDado.get(i).setConteudo(dado);
			}
		}

	}

	public String toString() {
		String conteudo;

		for (int i = 0; i < registradores.length; i++) {

			conteudo = util.twoComplment(registradores[i].getConteudo());

			Aux[i] = new Registrador("$" + i, conteudo);

		}

		return Arrays.toString(Aux);
	}

	public String toStringHILO() {

		String conteudoHI, conteudoLO;

		conteudoHI = util.twoComplment(hi.getConteudo());
		conteudoLO = util.twoComplment(lo.getConteudo());

		Registrador Hi1 = new Registrador("hi", conteudoHI);
		Registrador Lo1 = new Registrador("lo", conteudoLO);

		return (Hi1.toString() + ";" + "\r\n" + Lo1.toString() + ";");
	}

	public String toStringMemoDado() {

		String conteudo;
		List<Registrador> DataMemo = new ArrayList<Registrador>();

		for (int i = 0; i < MemoriaDado.size(); i++) {

			conteudo = util.twoComplment(MemoriaDado.get(i).getConteudo());

			DataMemo.add(new Registrador(MemoriaDado.get(i).getNome(), conteudo));

		}

		return DataMemo.toString();
	}

}

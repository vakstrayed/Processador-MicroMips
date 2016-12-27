package principal;

import java.util.Arrays;

public class ControladorRegistradores {

	private Registrador[] registradores = new Registrador[32];
	private Registrador[] Aux = new Registrador[32];
	private Registrador hi = new Registrador("hi", "00000000000000000000000000000000");
	private Registrador lo = new Registrador("lo", "00000000000000000000000000000000");
	private MemoriaDados MemData = new MemoriaDados();

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
		long rsB = util.TODecimal(registradores[util.TODecimal(rs)].getConteudo());
		long rtB = util.TODecimal(registradores[util.TODecimal(rt)].getConteudo());

		long r = rsB * rtB;

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
		int conteudoD = util.TODecimal(conteudo);
		if (conteudoD < 0) {
			int endereco = util.TODecimal(imm);
			memoria.setEnderecoAtual(endereco);
		}
	}

	public void beq(String rs, String rt, String imm) {
		String conteudoRs = registradores[util.TODecimal(rs)].getConteudo();
		int conteudoRS = util.TODecimal(conteudoRs);

		String conteudoRt = registradores[util.TODecimal(rt)].getConteudo();
		int conteudoRT = util.TODecimal(conteudoRt);

		if (conteudoRS == conteudoRT) {
			int endereco = util.TODecimal(imm);
			memoria.setEnderecoAtual(endereco);
		}
	}

	public void bne(String rs, String rt, String imm) {
		String conteudoRs = registradores[util.TODecimal(rs)].getConteudo();
		int conteudoRS = util.TODecimal(conteudoRs);

		String conteudoRt = registradores[util.TODecimal(rt)].getConteudo();
		int conteudoRT = util.TODecimal(conteudoRt);

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
		memoria.setEnderecoAtual(conteudoD);
		//falta coisa aqui
		
	}
	
	public void sll(){
		
	}
	
	public void sllv(){
		
	}
	
	public void sra(){
		
	}
	
	public void srav(){
		
	}
	
	public void srl(){
		
	}
	
	public void srlv(){
		
	}
	
	public void syscall(){
		
	}
	
	public void lui(){
		
	}
	
	public void lb(){
		
	}
	
	public void lw(){
		
	}
	
	public void lbu(){
		
	}
	
	public void sb(){
		
	}
	
	public void sw(){
		
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
	

}

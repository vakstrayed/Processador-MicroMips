package principal;

public class Interpretador {

	public static ControladorRegistradores Controler = new ControladorRegistradores();
	private static Util util = new Util();

	public Interpretador() {

	}

	public static void translateAssembly(String instrucao) {
		
		System.out.println(ControladorMemoria.getIntance().getEnderecoAtual());
		
		
		if (instrucao.length() == 10)
			instrucao = util.toBin(instrucao.substring(2, instrucao.length()));
		else if (instrucao.length() == 8)
			instrucao = util.toBin(instrucao);

		// ---------- separação do opCode ---------//

		String opCode = instrucao.substring(0, 6);

		// ----------------------------------------//

		// -------- estruturação do tipo r -------//

		String rs, rt, rd, sh, fn, imm;

		// ---------------------------------------//

		switch (opCode) {

		case "000000":

			// ADD ADDU AND ADD ADDU AND DIV DIVU JR MFHI MFLO MULT
			// MULTU NOR OR SLL SLLV SLT SRA SRAV SRL SRLV SUB SUBU
			// SYSCALL XOR

			fn = instrucao.substring(26);
			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			rd = instrucao.substring(16, 21);
			sh = instrucao.substring(21, 26);

			switch (fn) {

			case "100000":
				// ADD

				System.out.println("\nInstrução ADD:");
				System.out.println("Add " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rs) + ", $"
						+ util.toDecimalString(rt));

				Controler.add(rd, rs, rt);
				Arquivo.getInstance().arquivoSaida("Add " + "$" + util.toDecimalString(rd) + ", $"
						+ util.toDecimalString(rs) + ", $" + util.toDecimalString(rt), Controler.toString());
				break;

			case "100001":
				// ADDU
				System.out.println("\nInstrução ADDU:");
				System.out.println("Addu " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rs) + ", $"
						+ util.toDecimalString(rt));
				Controler.addu(rd, rs, rt);
				Arquivo.getInstance().arquivoSaida("Addu " + "$" + util.toDecimalString(rd) + ", $"
						+ util.toDecimalString(rs) + ", $" + util.toDecimalString(rt), Controler.toString());
				break;

			case "100100":
				// AND
				System.out.println("\nInstrução AND:");
				System.out.println("And " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rs) + ", $"
						+ util.toDecimalString(rt));
				Controler.and(rd, rs, rt);
				Arquivo.getInstance().arquivoSaida("And " + "$" + util.toDecimalString(rd) + ", $"
						+ util.toDecimalString(rs) + ", $" + util.toDecimalString(rt), Controler.toString());
				break;

			case "001000":
				// JR
				System.out.println("\nInstrução JR:");
				System.out.println("Jr " + "$" + util.toDecimalString(rs));
				Controler.jr(rs);
				Arquivo.getInstance().arquivoSaida("Jr " + "$" + util.toDecimalString(rs), Controler.toString());
				break;

			case "010000":
				// MFHI
				System.out.println("\nInstrução MFHI:");
				System.out.println("Mfhi " + "$" + util.toDecimalString(rd));
				Controler.mfhi(rd);
				Arquivo.getInstance().arquivoSaidaExclusivo("Mfhi " + "$" + util.toDecimalString(rd),
						Controler.toStringHILO(), Controler.toString());
				System.out.println(Controler.toStringHILO());
				break;

			case "010010":
				// MFLO
				System.out.println("\nInstrução MFLO:");
				System.out.println("Mflo " + "$" + util.toDecimalString(rd));
				Controler.mflo(rd);
				Arquivo.getInstance().arquivoSaidaExclusivo("Mflo " + "$" + util.toDecimalString(rd),
						Controler.toStringHILO(), Controler.toString());
				System.out.println(Controler.toStringHILO());
				break;

			case "011000":
				// MULT
				System.out.println("\nInstrução MULT:");
				System.out.println("Mult " + "$" + util.toDecimalString(rs) + ", $" + util.toDecimalString(rt));
				Controler.mult(rs, rt);
				Arquivo.getInstance().arquivoSaidaExclusivo(
						"Mult " + "$" + util.toDecimalString(rs) + ", $" + util.toDecimalString(rt),
						Controler.toStringHILO(), Controler.toString());
				break;

			case "011001":
				// MULTU
				System.out.println("\nInstrução MULTU:");
				System.out.println("Multu " + "$" + util.toDecimalString(rs) + ", $" + util.toDecimalString(rt));
				Controler.multu(rs, rt);
				Arquivo.getInstance().arquivoSaidaExclusivo(
						"Multu " + "$" + util.toDecimalString(rs) + ", $" + util.toDecimalString(rt),
						Controler.toStringHILO(), Controler.toString());
				break;

			case "100111":
				// NOR
				System.out.println("\nInstrução NOR:");
				System.out.println("Nor " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rs) + ", $"
						+ util.toDecimalString(rt));
				Controler.nor(rd, rs, rt);
				Arquivo.getInstance().arquivoSaida("Nor " + "$" + util.toDecimalString(rd) + ", $"
						+ util.toDecimalString(rs) + ", $" + util.toDecimalString(rt), Controler.toString());
				break;

			case "100101":
				// OR
				System.out.println("\nInstrução OR:");
				System.out.println("Or " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rs) + ", $"
						+ util.toDecimalString(rt));
				Controler.or(rd, rs, rt);
				Arquivo.getInstance().arquivoSaida("Or " + "$" + util.toDecimalString(rd) + ", $"
						+ util.toDecimalString(rs) + ", $" + util.toDecimalString(rt), Controler.toString());

				break;

			case "000000":
				// SLL
				System.out.println("\nInstrução SLL:");
				System.out.println("Sll " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rt) + ", $"
						+ util.toDecimalString(sh));
				Controler.sll(rd,rt,sh);

				break;

			case "000100":
				// SLLV
				System.out.println("\nInstrução SLLV:");
				System.out.println("Sllv " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rt) + ", $"
						+ util.toDecimalString(rs));

				break;

			case "101010":
				// SLT
				System.out.println("\nInstrução SLT:");
				System.out.println("Slt " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rs) + ", $"
						+ util.toDecimalString(rt));
				Controler.slt(rd, rs, rt);
				Arquivo.getInstance().arquivoSaida("Slt " + "$" + util.toDecimalString(rd) + ", $"
						+ util.toDecimalString(rs) + ", $" + util.toDecimalString(rt), Controler.toString());

				break;

			case "000011":
				// SRA
				System.out.println("\nInstrução SRA:");
				System.out.println("Sra " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rt) + ", $"
						+ util.toDecimalString(sh));
				Controler.sra(rd, rt, sh);
				Arquivo.getInstance().arquivoSaida(("Sra " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rt) + ", $"
						+ util.toDecimalString(sh)), Controler.toString());

				break;

			case "000111":
				// SRAV
				System.out.println("\nInstrução SRAV:");
				System.out.println("Srav " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rt) + ", $"
						+ util.toDecimalString(rs));
				Controler.srav(rd, rt, rs);
				Arquivo.getInstance().arquivoSaida(("Srav " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rt) + ", $"
						+ util.toDecimalString(rs)), Controler.toString());
				
				break;

			case "000010":
				// SRL
				System.out.println("\nInstrução SRL:");
				System.out.println("Srl " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rt) + ", $"
						+ util.toDecimalString(sh));
				Controler.srl(rd, rt, sh);
				Arquivo.getInstance().arquivoSaida(("Srl " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rt) + ", $"
						+ util.toDecimalString(sh)), Controler.toString());

				break;

			case "000110":
				// SRLV
				System.out.println("\nInstrução SRLV:");
				System.out.println("Srlv " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rt) + ", $"
						+ util.toDecimalString(rs));
				Controler.srlv(rd, rt, rs);
				Arquivo.getInstance().arquivoSaida(("Srlv " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rt) + ", $"
						+ util.toDecimalString(rs)), Controler.toString());
				
				break;

			case "100010":
				// SUB
				System.out.println("\nInstrução SUB:");
				System.out.println("Sub " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rs) + ", $"
						+ util.toDecimalString(rt));
				Controler.sub(rd, rs, rt);
				Arquivo.getInstance().arquivoSaida("Sub " + "$" + util.toDecimalString(rd) + ", $"
						+ util.toDecimalString(rs) + ", $" + util.toDecimalString(rt), Controler.toString());

				break;

			case "100011":
				// SUBU
				System.out.println("\nInstrução SUBU:");
				System.out.println("Subu " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rs) + ", $"
						+ util.toDecimalString(rt));
				Controler.subu(rd, rs, rt);
				Arquivo.getInstance().arquivoSaida("Subu " + "$" + util.toDecimalString(rd) + ", $"
						+ util.toDecimalString(rs) + ", $" + util.toDecimalString(rt), Controler.toString());

				break;

			case "001100":
				// SYSCALL
				System.out.println("\nInstrução SYSCALL:");
				System.out.println("Syscall");
				break;

			case "100110":
				// XOR
				System.out.println("\nInstrução XOR:");
				System.out.println("Xor " + "$" + util.toDecimalString(rd) + ", $" + util.toDecimalString(rs) + ", $"
						+ util.toDecimalString(rt));
				Controler.xor(rd, rs, rt);
				Arquivo.getInstance().arquivoSaida("Xor " + "$" + util.toDecimalString(rd) + ", $"
						+ util.toDecimalString(rs) + ", $" + util.toDecimalString(rt), Controler.toString());

				break;

			case "011011":
				// DIVU
				System.out.println("\nInstrução DIVU:");
				System.out.println("Divu " + "$" + util.toDecimalString(rs) + ", $" + util.toDecimalString(rt));
				Controler.divu(rs, rt);
				Arquivo.getInstance().arquivoSaidaExclusivo(
						"Divu " + "$" + util.toDecimalString(rs) + ", $" + util.toDecimalString(rt),
						Controler.toStringHILO(), Controler.toString());

				break;

			case "011010":
				// DIV
				System.out.println("\nInstrução DIV:");
				System.out.println("Div " + "$" + util.toDecimalString(rs) + ", $" + util.toDecimalString(rt));
				Controler.div(rs, rt);
				Arquivo.getInstance().arquivoSaidaExclusivo(
						"Div " + "$" + util.toDecimalString(rs) + ", $" + util.toDecimalString(rt),
						Controler.toStringHILO(), Controler.toString());

				break;

			}

			break;

		case "000001":
			// BLTZ

			rs = instrucao.substring(6, 11);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução BLTZ:");
			System.out.println("Bltz " + "$" + util.toDecimalString(rs) + "," + util.twoComplment(imm));
			Controler.bltz(rs, imm);
			Arquivo.getInstance().arquivoSaida("Bltz " + "$" + util.toDecimalString(rs) + "," + util.twoComplment(imm),
					Controler.toString());

			break;

		case "000010":
			// J

			imm = instrucao.substring(6, 32);

			System.out.println("\nInstrução J:");
			System.out.println("J " + "$" + util.toDecimalString(imm));
			Controler.j(imm);
			Arquivo.getInstance().arquivoSaida("J " + "$" + util.toDecimalString(imm), Controler.toString());

			break;

		case "000011":

			// JAL

			imm = instrucao.substring(6, 32);

			System.out.println("\nInstrução JAL:");
			System.out.println("Jal " + "$" + util.toDecimalString(imm));
			Controler.jal(imm);
			Arquivo.getInstance().arquivoSaida("Jal " + "$" + util.toDecimalString(imm), Controler.toString());

			break;

		case "000100":

			// BEQ

			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução BEQ:");
			System.out.println("Beq " + "$" + util.toDecimalString(rs) + ", $" + util.toDecimalString(rt) + ","
					+ util.twoComplment(imm));
			Controler.beq(rs, rt, imm);
			Arquivo.getInstance().arquivoSaida("Beq " + "$" + util.toDecimalString(rs) + ", $"
					+ util.toDecimalString(rt) + "," + util.twoComplment(imm), Controler.toString());

			break;

		case "000101":

			// BNE

			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução BNE:");
			System.out.println("Bne " + "$" + util.toDecimalString(rs) + ", $" + util.toDecimalString(rt) + ","
					+ util.twoComplment(imm));
			Controler.bne(rs, rt, imm);
			Arquivo.getInstance().arquivoSaida("Bne " + "$" + util.toDecimalString(rs) + ", $"
					+ util.toDecimalString(rt) + "," + util.twoComplment(imm), Controler.toString());

			break;

		case "001000":

			// ADDI
			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução ADDI:");
			System.out.println("Addi " + "$" + util.toDecimalString(rt) + ", $" + util.toDecimalString(rs) + ","
					+ util.twoComplment(imm));
			Controler.addi(rt, rs, imm);
			Arquivo.getInstance().arquivoSaida("Addi " + "$" + util.toDecimalString(rt) + ", $"
					+ util.toDecimalString(rs) + "," + util.twoComplment(imm), Controler.toString());

			break;

		case "001001":

			// ADDIU
			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução ADDIU:");
			System.out.println("Addiu " + "$" + util.toDecimalString(rt) + ", $" + util.toDecimalString(rs) + ","
					+ util.toDecimalString(imm));
			Controler.addiu(rt, rs, imm);
			Arquivo.getInstance().arquivoSaida("Addiu " + "$" + util.toDecimalString(rt) + ", $"
					+ util.toDecimalString(rs) + "," + util.toDecimalString(imm), Controler.toString());

			break;

		case "001010":

			// SLTI

			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução SLTI:");
			System.out.println("Slti " + "$" + util.toDecimalString(rt) + ", $" + util.toDecimalString(rs) + ","
					+ util.toDecimalString(imm));
			Controler.slti(rt, rs, imm);
			Arquivo.getInstance().arquivoSaida("Slti " + "$" + util.toDecimalString(rt) + ", $"
					+ util.toDecimalString(rs) + "," + util.toDecimalString(imm), Controler.toString());

			break;

		case "001100":

			// ANDI
			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução ANDI:");
			System.out.println("Andi " + "$" + util.toDecimalString(rt) + ", $" + util.toDecimalString(rs) + ","
					+ util.toDecimalString(imm));
			Controler.andi(rt, rs, imm);
			Arquivo.getInstance().arquivoSaida("Andi " + "$" + util.toDecimalString(rt) + ", $"
					+ util.toDecimalString(rs) + "," + util.toDecimalString(imm), Controler.toString());

			break;

		case "001101":

			// ORI
			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução ORI:");
			System.out.println("Ori " + "$" + util.toDecimalString(rt) + ", $" + util.toDecimalString(rs) + ","
					+ util.toDecimalString(imm));
			Controler.ori(rt, rs, imm);
			Arquivo.getInstance().arquivoSaida("Ori " + "$" + util.toDecimalString(rt) + ", $"
					+ util.toDecimalString(rs) + "," + util.toDecimalString(imm), Controler.toString());

			break;

		case "001110":

			// XORI
			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução XORI:");
			System.out.println("Xori " + "$" + util.toDecimalString(rt) + ", $" + util.toDecimalString(rs) + ","
					+ util.toDecimalString(imm));
			Controler.xori(rt, rs, imm);
			Arquivo.getInstance().arquivoSaida("Xori " + "$" + util.toDecimalString(rt) + ", $"
					+ util.toDecimalString(rs) + "," + util.toDecimalString(imm), Controler.toString());

			break;

		case "001111":

			// LUI

			rt = instrucao.substring(11, 16);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução LUI:");
			System.out.println("Lui " + "$" + util.toDecimalString(rt) + "," + util.toDecimalString(imm));
			Controler.lui(rt, imm);
			Arquivo.getInstance().arquivoSaida(
					("Lui " + "$" + util.toDecimalString(rt) + "," + util.toDecimalString(imm)), Controler.toString());

			break;

		case "100000":

			// LB
			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução LB:");
			System.out.println("Lb " + "$" + util.toDecimalString(rt) + "," + util.toDecimalString(imm) + "($"
					+ util.toDecimalString(rs) + ")");
			Controler.lb(rt, imm, rs);
			Arquivo.getInstance().arquivoSaida(("Lb " + "$" + util.toDecimalString(rt) + "," + util.toDecimalString(imm)
					+ "($" + util.toDecimalString(rs) + ")"), Controler.toString());

			break;

		case "100011":

			// LW
			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução LW:");
			System.out.println("Lw  $" + util.toDecimalString(rt) + "," + util.toDecimalString(imm) + "($"
					+ util.toDecimalString(rs) + ")");
			Controler.lw(rt, imm, rs);
			Arquivo.getInstance().arquivoSaida(("Lw  $" + util.toDecimalString(rt) + "," + util.toDecimalString(imm)
					+ "($" + util.toDecimalString(rs) + ")"), Controler.toString());

			break;

		case "100100":

			// LBU
			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução LBU:");
			System.out.println("lbu  $" + util.toDecimalString(rt) + "," + util.toDecimalString(imm) + "($"
					+ util.toDecimalString(rs) + ")");
			Controler.lbu(rt, imm, rs);
			Arquivo.getInstance().arquivoSaida(("lbu  $" + util.toDecimalString(rt) + "," + util.toDecimalString(imm)
					+ "($" + util.toDecimalString(rs) + ")"), Controler.toString());

			break;

		case "101000":

			// SB
			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução SB:");
			System.out.println("Sb  $" + util.toDecimalString(rt) + "," + util.toDecimalString(imm) + "($"
					+ util.toDecimalString(rs) + ")");
			Controler.sb(rt, imm, rs);
			Arquivo.getInstance()
					.arquivoToDaTaMemo(
							("Sb  $" + util.toDecimalString(rt) + "," + util.toDecimalString(imm) + "($"
									+ util.toDecimalString(rs) + ")"),
							Controler.toStringMemoDado(), Controler.toString());

			break;

		case "101011":

			// SW
			rs = instrucao.substring(6, 11);
			rt = instrucao.substring(11, 16);
			imm = instrucao.substring(16, 32);

			System.out.println("\nInstrução SW:");
			System.out.println("Sw  $" + util.toDecimalString(rt) + "," + util.toDecimalString(imm) + "($"
					+ util.toDecimalString(rs) + ")");
			Controler.sw(rt, imm, rs);
			Arquivo.getInstance()
					.arquivoToDaTaMemo(
							("Sw  $" + util.toDecimalString(rt) + "," + util.toDecimalString(imm) + "($"
									+ util.toDecimalString(rs) + ")"),
							Controler.toStringMemoDado(), Controler.toString());

			break;
			
	
		default:
			System.out.println("Instrução não reconhecida");
		}

	}

}

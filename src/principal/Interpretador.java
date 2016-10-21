package principal;

import java.math.BigInteger;

public class Interpretador {

	public static ControladorRegistradores Controler = new ControladorRegistradores();
	private static Util util = new Util();
	
	public Interpretador() {

	}	

	public static String translateAssembly(String result) {
		
		result = util.toBin(result.substring(2,result.length()));

		// ---------- separação do opCode ---------//

		String opCode = result.substring(0, 6);

		// ----------------------------------------//

		// -------- estruturação do tipo r -------//

		String rs, rt, rd, sh, fn,imm;

		// ---------------------------------------//

	
		switch (opCode) {

		case "000000":

			// ADD ADDU AND ADD ADDU AND DIV DIVU JR MFHI MFLO MULT
			// MULTU NOR OR SLL SLLV SLT SRA SRAV SRL SRLV SUB SUBU
			// SYSCALL XOR

			fn = result.substring(26, 32);
			rs = result.substring(6, 11);
			rt = result.substring(11, 16);
			rd = result.substring(16, 21);
			sh = result.substring(21, 26);

			switch (fn) {

			case "100000":
				// ADD
				System.out.println("\nInstrução ADD:");
				Controler.add(rd, rs, rt);
				return ("Add " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rs)+", $"+ util.toDecimalString(rt) );

			case "100001":
				// ADDU
				System.out.println("\nInstrução ADDU:");
				Controler.addu(rd, rs, rt);
				return("Addu " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rs)+", $"+ util.toDecimalString(rt) );


			case "100100":
				// AND
				System.out.println("\nInstrução AND:");
				Controler.and(rd, rs, rt);
				return ("And " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rs)+", $"+ util.toDecimalString(rt) );
		

			case "001000":
				// JR
				System.out.println("\nInstrução JR:");

				return ("Jr " +"$"+util.toDecimalString(rs));
				

			case "010000":
				// MFHI
				System.out.println("\nInstrução MFHI:");
				Controler.mfhi(rd);
				return ("Mfhi " +"$"+util.toDecimalString(rd));
			

			case "010010":
				// MFLO
				System.out.println("\nInstrução MFLO:");
				Controler.mflo(rd);
				return ("Mflo " +"$"+ util.toDecimalString(rd) );
			

			case "011000":
				// MULT
				System.out.println("\nInstrução MULT:");
				Controler.mult(rs, rt);
				return ("Mult " +"$"+util.toDecimalString(rs)+ ", $" +util.toDecimalString(rt));
				

			case "011001":
				// MULTU
				System.out.println("\nInstrução MULTU:");

				return ("Multu " +"$"+util.toDecimalString(rs)+ ", $"+ util.toDecimalString(rt) );
				

			case "100111":
				// NOR
				System.out.println("\nInstrução NOR:");
				Controler.nor(rd, rs, rt);
				return ("Nor " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rs)+", $"+ util.toDecimalString(rt) );
				

			case "100101":
				// OR
				System.out.println("\nInstrução OR:");

				return ("Or " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rs)+", $"+ util.toDecimalString(rt) );
				

			case "000000":
				// SLL
				System.out.println("\nInstrução SLL:");

				return ("Sll " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rt)+", $"+ util.toDecimalString(sh) );
			

			case "000100":
				// SLLV
				System.out.println("\nInstrução SLLV:");

				return ("Sllv " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rt)+", $"+ util.toDecimalString(rs) );
				

			case "101010":
				// SLT
				System.out.println("\nInstrução SLT:");
				Controler.slt(rd, rs, rt);
				return ("Slt " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rs)+", $"+ util.toDecimalString(rt) );
				

			case "000011":
				// SRA
				System.out.println("\nInstrução SRA:");

				return ("Sra " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rt)+", $"+ util.toDecimalString(sh) );
		

			case "000111":
				// SRAV
				System.out.println("\nInstrução SRAV:");

				return ("Srav " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rt)+", $"+ util.toDecimalString(rs) );
				

			case "000010":
				// SRL
				System.out.println("\nInstrução SRL:");

				return ("Srl " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rt)+", $"+ util.toDecimalString(sh) );
				
			case "000110":
				// SRLV
				System.out.println("\nInstrução SRLV:");

				return ("Srlv " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rt)+", $"+ util.toDecimalString(rs) );
				

			case "100010":
				// SUB
				System.out.println("\nInstrução SUB:");
				Controler.sub(rd, rs, rt);
				return ("Sub " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rs)+", $"+ util.toDecimalString(rt) );
				

			case "100011":
				// SUBU
				System.out.println("\nInstrução SUBU:");
				Controler.subu(rd, rs, rt);
				return ("Subu " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rs)+", $"+ util.toDecimalString(rt) );
				

			case "001100":
				// SYSCALL
				System.out.println("\nInstrução SYSCALL:");

				return ("Syscall");
				

			case "100110":
				// XOR
				System.out.println("\nInstrução XOR:");

				return ("Xor " +"$"+util.toDecimalString(rd)+ ", $" +util.toDecimalString(rs)+", $"+ util.toDecimalString(rt) );
				

			case "011011":
				// DIVU
				System.out.println("\nInstrução DIVU:");

				return ("Divu "+ "$"+util.toDecimalString(rs)+", $"+ util.toDecimalString(rt) );
				

			case "011010":
				// DIV
				System.out.println("\nInstrução DIV:");
				Controler.div(rs, rt);
				return("Div " +"$"+util.toDecimalString(rs)+ ", $" +util.toDecimalString(rt) );

			}

			break;

		case "000001":
			// BLTZ
			
			rs = result.substring(6, 11);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução BLTZ:");

			return("Bltz " + "$" + util.toDecimalString(rs) + "," + util.twoComplment(imm));
			
			

		case "000010":
			// J
			
			imm= result.substring(6,32);
			
			System.out.println("\nInstrução J:");

			return("J " + "$" + util.toDecimalString(imm));



		case "000011":

			// JAL
			
			imm= result.substring(6,32);
			
			System.out.println("\nInstrução JAL:");

			return ("Jal " + "$" + util.toDecimalString(imm));

			

		case "000100":

			// BEQ
			
			rs = result.substring(6, 11);
			rt = result.substring(11, 16);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução BEQ:");

			return("Beq " + "$" + util.toDecimalString(rs) + ", $" + util.toDecimalString(rt) + "," + util.twoComplment(imm));


		case "000101":

			// BNE
			
			rs = result.substring(6, 11);
			rt = result.substring(11, 16);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução BNE:");

			return ("Bne " + "$" + util.toDecimalString(rs) + ", $" + util.toDecimalString(rt) + "," + util.twoComplment(imm));



		case "001000":

			// ADDI
			rs = result.substring(6, 11);
			rt = result.substring(11, 16);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução ADDI:");
			Controler.addi(rt, rs, imm);
			return("Addi " + "$" + util.toDecimalString(rt) + ", $" + util.toDecimalString(rs) + "," + util.toDecimalString(imm));

		

		case "001001":

			// ADDIU
			rs = result.substring(6, 11);
			rt = result.substring(11, 16);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução ADDIU:");
			Controler.addiu(rt, rs, imm);
			return ("Addiu " + "$" + util.toDecimalString(rt) + ", $" + util.toDecimalString(rs) + "," + util.toDecimalString(imm));


		case "001010":

			// SLTI
			
			rs = result.substring(6, 11);
			rt = result.substring(11, 16);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução SLTI:");
			Controler.slti(rt, rs, imm);
			return ("Slti " + "$" + util.toDecimalString(rt) + ", $" + util.toDecimalString(rs) + "," + util.toDecimalString(imm));

		

		case "001100":

			// ANDI
			rs = result.substring(6, 11);
			rt = result.substring(11, 16);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução ANDI:");

			return ("Andi " + "$" + util.toDecimalString(rt) + ", $" + util.toDecimalString(rs) + "," + util.toDecimalString(imm));

			

		case "001101":

			// ORI
			rs = result.substring(6, 11);
			rt = result.substring(11, 16);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução ORI:");

			return ("Ori " + "$" + util.toDecimalString(rt) + ", $" + util.toDecimalString(rs) + "," + util.toDecimalString(imm));

			

		case "001110":

			// XORI
			rs = result.substring(6, 11);
			rt = result.substring(11, 16);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução XORI:");

			return ("Xori " + "$" + util.toDecimalString(rt) + ", $" + util.toDecimalString(rs) + "," + util.toDecimalString(imm));

			

		case "001111":

			// LUI
			
			rt = result.substring(11, 16);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução LUI:");

			return ("Lui " + "$" + util.toDecimalString(rt) + "," + util.toDecimalString(imm));

		

		case "100000":

			// LB
			rs = result.substring(6, 11);
			rt = result.substring(11, 16);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução LB:");

			return ("Lb " + "$" + util.toDecimalString(rt) + "," + util.toDecimalString(imm) + "($"+ util.toDecimalString(rs)+ ")");


		case "100011":

			// LW
			rs = result.substring(6, 11);
			rt = result.substring(11, 16);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução LW:");

			return ("Lw  $" + util.toDecimalString(rt) + "," + util.toDecimalString(imm) + "($" +util.toDecimalString(rs) +")");


		case "100100":

			// LBU
			rs = result.substring(6, 11);
			rt = result.substring(11, 16);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução LBU:");

			return("lbu  $" + util.toDecimalString(rt) + "," + util.toDecimalString(imm) + "($" +util.toDecimalString(rs) +")");


		case "101000":

			// SB
			rs = result.substring(6, 11);
			rt = result.substring(11, 16);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução SB:");

			return ("Sb  $" + util.toDecimalString(rt) + "," + util.toDecimalString(imm) + "($" +util.toDecimalString(rs) +")");
			

		case "101011":

			// SW
			rs = result.substring(6, 11);
			rt = result.substring(11, 16);
			imm= result.substring(16,32);
			
			System.out.println("\nInstrução SW:");

			return ("Sw  $" + util.toDecimalString(rt) + "," + util.toDecimalString(imm) + "($" +util.toDecimalString(rs) +")");

		}
		return "Instrução não reconhecida";


	}

}

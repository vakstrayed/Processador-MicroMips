package principal;

import java.util.ArrayList;

public class Principal {
	
	
	public static void main(String args[]){
		

		ArrayList<String> instruções = Arquivo.lerArquivo();
		for(String s: instruções){
			System.out.println(Interpretador.translateAssembly(s));
			
		}
	/*
		ControladorRegistradores  c = new ControladorRegistradores();
		c.addi("00000", "00001", "11101");
		c.add("00000","00000","00011");
		c.add("00000", "00000", "00001");
		System.out.println(c.getRegistradores()[0].getConteudo());
		*/
	}
	
	
	


}

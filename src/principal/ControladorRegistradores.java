package principal;

import java.util.Arrays;

public class ControladorRegistradores {
    private Registrador[] registradores = new Registrador[32];
    private Registrador hi = new Registrador("hi","00000000000000000000000000000000");
    private Registrador lo = new Registrador("lo","00000000000000000000000000000000");
    
  
	
	public ControladorRegistradores()
	{
		inicializarRegistradores();
	}
	
	public void inicializarRegistradores(){
		for(int i = 0; i < registradores.length; i++){
			registradores[i] = new Registrador("$"+ i,"00000000000000000000000000000000");
		}
		setReg();
	}
	
	public String completacomZero(String parametro){
		while(parametro.length() < 32 ){
			parametro = "0" + parametro; 
		}
		return parametro;
	}
	public String completacomZero64(String parametro){
		while(parametro.length() < 64 ){
			parametro = "0" + parametro; 
		}
		return parametro;
	}
	public static int toDecimal(String nom){
		
		String data = Integer.toString(Integer.parseInt(nom, 2), 10);		
		return Integer.parseInt(data);
	}
	
	
	public void add(String rd, String rs, String rt){
		
		String conteudoRegs = registradores[toDecimal(rs)].getConteudo();
		conteudoRegs = Interpretador.twoComplment(conteudoRegs);
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);
		
		String conteudoRegT = registradores[toDecimal(rt)].getConteudo();
		conteudoRegT = Interpretador.twoComplment(conteudoRegT);
		int conteudoComplementoT = Integer.parseInt(conteudoRegT);
		
		registradores[toDecimal(rd)].setConteudo( completacomZero(Integer.toBinaryString(conteudoComplementoS + conteudoComplementoT))); 
		
		System.out.println(toString());

		
	}
	public void addi( String rt, String rs,String imm){
		
		String conteudoRegs = registradores[toDecimal(rs)].getConteudo();
		conteudoRegs = Interpretador.twoComplment(conteudoRegs);
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);
		
		String imediato = Interpretador.twoComplment(imm);
		int imediatoComplemento = Integer.parseInt(imediato);
		
		registradores[toDecimal(rt)].setConteudo( completacomZero(Integer.toBinaryString(conteudoComplementoS + imediatoComplemento))); 
		
		System.out.println(toString());
				
	}
	public void addu(String rd, String rs, String rt){
		
		String conteudoRegs = registradores[toDecimal(rs)].getConteudo();
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);
		
		String conteudoRegT = registradores[toDecimal(rt)].getConteudo();
		int conteudoComplementoT = Integer.parseInt(conteudoRegT);
		
		registradores[toDecimal(rd)].setConteudo( completacomZero(Integer.toBinaryString(conteudoComplementoS + conteudoComplementoT))); 
		
		System.out.println(toString());

		
	}
	public void addiu( String rt, String rs,String imm){
		
		String conteudoRegs = registradores[toDecimal(rs)].getConteudo();
		conteudoRegs = Interpretador.twoComplment(conteudoRegs);
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);
		
		String imediato = Interpretador.twoComplment(imm);
		int imediatoComplemento = Integer.parseInt(imediato);
		
		registradores[toDecimal(rt)].setConteudo( completacomZero(Integer.toBinaryString(conteudoComplementoS + imediatoComplemento))); 
		
		System.out.println(toString());

				
	}
	public void sub(String rd, String rs, String rt){
		
		String conteudoRegs = registradores[toDecimal(rs)].getConteudo();
		conteudoRegs = Interpretador.twoComplment(conteudoRegs);
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);
		
		String conteudoRegT = registradores[toDecimal(rt)].getConteudo();
		conteudoRegT = Interpretador.twoComplment(conteudoRegT);
		int conteudoComplementoT = Integer.parseInt(conteudoRegT);
		
		registradores[toDecimal(rd)].setConteudo( completacomZero(Integer.toBinaryString(conteudoComplementoS - conteudoComplementoT))); 
		
		System.out.println(toString());

		
	}
    public void subu(String rd, String rs, String rt){
		
		String conteudoRegs = registradores[toDecimal(rs)].getConteudo();
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);
		
		String conteudoRegT = registradores[toDecimal(rt)].getConteudo();
		int conteudoComplementoT = Integer.parseInt(conteudoRegT);
		
		registradores[toDecimal(rd)].setConteudo( completacomZero(Integer.toBinaryString(conteudoComplementoS - conteudoComplementoT))); 
		
		System.out.println(toString());

		
	}
    public void slt(String rd, String rs, String rt){
		
		String conteudoRegs = registradores[toDecimal(rs)].getConteudo();
		conteudoRegs = Interpretador.twoComplment(conteudoRegs);
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);
		
		String conteudoRegT = registradores[toDecimal(rt)].getConteudo();
		conteudoRegT = Interpretador.twoComplment(conteudoRegT);
		int conteudoComplementoT = Integer.parseInt(conteudoRegT);
		
		if(conteudoComplementoS > conteudoComplementoT)
			registradores[toDecimal(rd)].setConteudo( completacomZero("1"));
		else
			registradores[toDecimal(rd)].setConteudo( completacomZero("0"));
		
		System.out.println(toString());

							
	}
    
    public void slti( String rt, String rs,String imm){
		
		String conteudoRegs = registradores[toDecimal(rs)].getConteudo();
		conteudoRegs = Interpretador.twoComplment(conteudoRegs);
		int conteudoComplementoS = Integer.parseInt(conteudoRegs);
		
		String imediato = Interpretador.twoComplment(imm);
		int imediatoComplemento = Integer.parseInt(imediato);
		
		if(conteudoComplementoS > imediatoComplemento)
			registradores[toDecimal(rt)].setConteudo( completacomZero("1"));
		else
			registradores[toDecimal(rt)].setConteudo( completacomZero("0"));
		 
		System.out.println(toString());
	
				
	}
    
    public void mfhi(String rd){
    	
    	String conteudoHi = hi.getConteudo();
		registradores[toDecimal(rd)].setConteudo( conteudoHi ); 
		hi.setConteudo("00000000000000000000000000000000");

		System.out.println(toString());
    	
    }
    
    public void mflo(String rd){
    	
    	String conteudoLo = lo.getConteudo();
		registradores[toDecimal(rd)].setConteudo( conteudoLo ); 
		lo.setConteudo("00000000000000000000000000000000");

		System.out.println(toString());
    	
    }
    public void and(String rd,String rs ,String rt){
    	int rtB = toDecimal(registradores[toDecimal(rt)].getConteudo());
    	int rsB  = toDecimal(registradores[toDecimal(rs)].getConteudo());
    	    	
    	String r = Integer.toBinaryString(rtB & rsB);
    	
    	registradores[toDecimal(rd)].setConteudo( completacomZero(r) );
    	System.out.println(toString());
    	
    }
    public void andi(String rt,String rs ,String imm){
    	int rsB = toDecimal(registradores[toDecimal(rs)].getConteudo());
    	int immB  = toDecimal(imm);
    	    	
    	String r = Integer.toBinaryString(rsB & immB);
    	
    	registradores[toDecimal(rt)].setConteudo( completacomZero(r) );
    	System.out.println(toString());
    	
    }
    public void or(String rd,String rs ,String rt){
    	int rtB = toDecimal(registradores[toDecimal(rt)].getConteudo());
    	int rsB  = toDecimal(registradores[toDecimal(rs)].getConteudo());
    	    	
    	String r = Integer.toBinaryString(rtB | rsB);
    	
    	registradores[toDecimal(rd)].setConteudo( completacomZero(r) );
    	System.out.println(toString());
    	
    }
    public void ori(String rt,String rs ,String imm){
    	int rsB = toDecimal(registradores[toDecimal(rs)].getConteudo());
    	int immB  = toDecimal(imm);
    	    	
    	String r = Integer.toBinaryString(rsB | immB);
    	
    	registradores[toDecimal(rt)].setConteudo( completacomZero(r) );
    	System.out.println(toString());
    	
    }
    public void nor(String rd,String rs ,String rt){
    	int rtB = toDecimal(registradores[toDecimal(rt)].getConteudo());
    	int rsB  = toDecimal(registradores[toDecimal(rs)].getConteudo());
    	
    	String r = Integer.toBinaryString(~(rtB | rsB));

    	registradores[toDecimal(rd)].setConteudo( completacomZero(r) );
    	System.out.println(toString());
    	
    }
    public void mult(String rs,String rt){
    	long rsB = toDecimal(registradores[toDecimal(rs)].getConteudo());
    	long rtB = toDecimal(registradores[toDecimal(rt)].getConteudo());
    	
    	long r = rsB * rtB;
    	
    	String rS = completacomZero64(Long.toBinaryString(r));
    	
    	this.hi.setConteudo( rS.substring(0, 32));
    	this.lo.setConteudo( rS.substring(32, 63));
    	
    	System.out.println("hi: "+hi.getConteudo() + "\nlo: "+ lo.getConteudo());
    	
    }
    public void multu(String rs,String rt){
    	long rsB = toDecimal(registradores[toDecimal(rs)].getConteudo());
    	long rtB = toDecimal(registradores[toDecimal(rt)].getConteudo());
    	
    	long r = rsB * rtB;
    	
    	String rS = completacomZero64(Long.toBinaryString(r));
    	
    	this.hi.setConteudo( rS.substring(0, 32));
    	this.lo.setConteudo( rS.substring(32, 63));
    	
    	System.out.println("hi: "+hi.getConteudo() + "\nlo: "+ lo.getConteudo());
    	
    }
    public void div(String rs,String rt){
    	long rsB = toDecimal(registradores[toDecimal(rs)].getConteudo());
    	long rtB = toDecimal(registradores[toDecimal(rt)].getConteudo());
    	
    	long r = rsB / rtB;
    	
    	String rS = completacomZero64(Long.toBinaryString(r));
    	
    	this.hi.setConteudo( rS.substring(0, 32));
    	this.lo.setConteudo( rS.substring(32,63));
    	
    	System.out.println("hi: "+hi.getConteudo() + "\nlo: "+ lo.getConteudo());
    	
    }
    public void divu(String rs,String rt){
    	long rsB = toDecimal(registradores[toDecimal(rs)].getConteudo());
    	long rtB = toDecimal(registradores[toDecimal(rt)].getConteudo());
    	
    	long r = rsB / rtB;
    	
    	String rS = completacomZero64(Long.toBinaryString(r));
    	
    	this.hi.setConteudo( rS.substring(0, 32));
    	this.lo.setConteudo( rS.substring(32,63));
    	
    	System.out.println("hi: "+hi.getConteudo() + "\nlo: "+ lo.getConteudo());
    	
    }
    public void xor(String rd,String rs ,String rt){
    	int rtB = toDecimal(registradores[toDecimal(rt)].getConteudo());
    	int rsB  = toDecimal(registradores[toDecimal(rs)].getConteudo());
    	    	
    	String r = Integer.toBinaryString(rtB ^ rsB);
    	
    	registradores[toDecimal(rd)].setConteudo( completacomZero(r) );
    	System.out.println(toString());
    	
    }
    public void xori(String rt,String rs ,String imm){
    	int rsB = toDecimal(registradores[toDecimal(rs)].getConteudo());
    	int immB  = toDecimal(imm);
    	    	
    	String r = Integer.toBinaryString(rsB ^ immB);
    	
    	registradores[toDecimal(rt)].setConteudo( completacomZero(r) );
    	System.out.println(toString());
    	
    }
	
	
	//para teste------------------------
	
	public void setReg(){
		registradores[1].setConteudo("00000");
		registradores[2].setConteudo(completacomZero("111"));
		registradores[3].setConteudo(completacomZero("101"));
	}
	public Registrador[] getRegistradores(){
		return registradores;
	}
	
	//-----------------------------------
	@Override
	public String toString() {
		return "Registradores :\n" + Arrays.toString(registradores) + "]";
	}

}

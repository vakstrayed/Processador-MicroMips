package principal;

public class Util {

	public Util() {

	}

	public String completacomZero(String parametro) {
		while (parametro.length() < 32) {
			parametro = "0" + parametro;
		}
		return parametro;
	}

	public String completacomZero64(String parametro) {
		while (parametro.length() < 64) {
			parametro = "0" + parametro;
		}
		return parametro;
	}

	public int TODecimal(String nom) {

		String data = Integer.toString(Integer.parseInt(nom, 2), 10);
		return Integer.parseInt(data);
	}

	public String toDecimalString(String nom) {

		String data = Integer.toString(Integer.parseInt(nom, 2), 10);
		return data;
	}

	public String twoComplment(String parametro) {

		if (parametro.charAt(0) == '0') {
			return toDecimalString(parametro.substring(1, parametro.length()));
		} else {
			int position = parametro.substring(1, parametro.length()).lastIndexOf("1");
			if (position == -1) {

				return toDecimalString(parametro.substring(1, parametro.length()));
			} else {
				char[] vetor = parametro.substring(1, parametro.length()).toCharArray();

				for (int i = 0; i < position; i++) {

					if (vetor[i] == '1') {
						vetor[i] = '0';
					} else
						vetor[i] = '1';
				}
				return "-" + toDecimalString(String.valueOf(vetor));

			}

		}

	}
	
	public String toBin(String parametro){
		
		parametro = parametro.toLowerCase();
		
		String resultado = "";
		for(int i = 0; i< parametro.length();i++){
			switch(parametro.substring(i,i+1)){
				case "0": resultado += "0000";break;
				case "1": resultado += "0001";break;
				case "2": resultado += "0010";break;
				case "3": resultado += "0011";break;
				case "4": resultado += "0100";break;
				case "5": resultado += "0101";break;
				case "6": resultado += "0110";break;
				case "7": resultado += "0111";break;
				case "8": resultado += "1000";break;
				case "9": resultado += "1001";break;
				case "a": resultado += "1010";break;
				case "b": resultado += "1011";break;
				case "c": resultado += "1100";break;
				case "d": resultado += "1101";break;
				case "e": resultado += "1110";break;
				case "f": resultado += "1111";break;
			}
		}
		return resultado;
	}

}

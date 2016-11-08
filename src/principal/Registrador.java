package principal;

public class Registrador {
	private String nome;
	private String conteudo;
	

	public Registrador(String nome,String conteudo){
		this.setNome(nome);
		this.setConteudo(conteudo);
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	@Override
	public String toString(){
		return nome+": " + conteudo+"\r\n";
	}

}

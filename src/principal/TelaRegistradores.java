package principal;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTable;

public class TelaRegistradores extends JFrame{
	
	private JTable tabela;
	
	public TelaRegistradores(){
		
		iniciarComponentes();
	}
	public void iniciarComponentes(){
		this.setSize(400,650);
		this.setLayout(new FlowLayout());
		
		
		String[] colunas = {"nome","número","valor"}; 
		Object[][] dados = {
				{"$zero","0","000000000"},
				{"$at","1","000000000"},
				{"$v0","2","000000000"}
		};
		
		tabela = new JTable(dados,colunas);
		//tabela.setSize(399,600);
		//tabela.setLayout(new FlowLayout());
		this.add(tabela);
		
		tabela.setVisible(true);
		this.setVisible(true);
		
		
		
		
	}
	/*
	public static void main(String args[]){
		new TelaRegistradores();
	}
	*/

}

/**
 * 
 */
package br.com.helpdesk.model;

import java.util.ArrayList;

/**
 * @author Marking
 *
 */
public class Tecnico extends Usuario{
	
	private String especiaridade;
	private String atuação;
	private ArrayList<Chamado> chamadosAtendidos;
	
	public Tecnico() {
		super();
		this.chamadosAtendidos = new ArrayList<>();
	}
	
	public Tecnico(int id, String nome, String cpf, String telefone, boolean atende, String email, String senha) {
		super(id, nome, cpf, telefone, atende, email, senha);
		// TODO Auto-generated constructor stub
	}

        public Tecnico(String nome, String cpf, String telefone, boolean atende, String email, String senha, String areaatuacao) {
            super(nome, cpf, telefone, atende, email, senha, areaatuacao);
        }

     	public Tecnico(String especiaridade, String atuação, ArrayList<Chamado> chamadosAtendidos) {
		super();
		this.especiaridade = especiaridade;
		this.atuação = atuação;
		this.chamadosAtendidos = new ArrayList<>();
	}

	public String getEspeciaridade() {
		return especiaridade;
	}
        
	public void setEspeciaridade(String especiaridade) {
		this.especiaridade = especiaridade;
	}

	public String getAtuação() {
		return atuação;
	}
        
        public void setAtuação(String atuação) {
		this.atuação = atuação;
	}

	public void atenderChamado(Chamado c, String resposta ){
		c.setResp(resposta);
		chamadosAtendidos.add(c);
		c.setAtendido(true);
	}
	
	public void listaChamadosAtendidos(){
		for (int i = 0; i < chamadosAtendidos.size(); i++) {
			System.out.println("Titulo: "+chamadosAtendidos.get(i).gettitulo());
			System.out.println("Descrição: "+chamadosAtendidos.get(i).getDescricao());
                        System.out.println(""+chamadosAtendidos.get(i).getResp());
			//System.out.println("Autor: "+chamadosAtendidos.get(i).getAutor().getNome());
			
		}
	}
        
       
}

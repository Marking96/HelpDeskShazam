package br.com.helpdesk.model;

import java.util.ArrayList;

public class Solicitante extends Usuario{

        public Solicitante(String nome, String cpf, String telefone, boolean atende, String email, String senha, String areaatuacao) {
             super(nome, cpf, telefone, atende, email, senha, areaatuacao);
        }
	
        
    
	private ArrayList<Chamado> chamadosAtendidos;

    Solicitante() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	public void criarChamado(){
		Chamado cha = new Chamado();
		
	}
        public void responderChamado(Chamado c, String resposta){
            c.setResp(resposta);
        }
}

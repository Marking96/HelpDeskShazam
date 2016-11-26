package br.com.helpdesk.model;

import java.util.ArrayList;

public class Solicitante extends Usuario{
	
	private String areaAtualcao;
	private ArrayList<Chamado> chamadosAtendidos;
	
	public void criarChamado(){
		Chamado cha = new Chamado();
		
	}
        public void responderChamado(Chamado c, String resposta){
            c.setResp(resposta);
        }
}

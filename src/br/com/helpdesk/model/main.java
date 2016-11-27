package br.com.helpdesk.model;

//import br.com.helpdesk.view.LoginScreen;

import br.com.helpdesk.view.LoginFrame;


public class main {

	public static void main(String[] args) {
		Tecnico t = new Tecnico(); 
		Usuario user = t;
		
                user.setNome("Marcos");
                user.setSenha("1234");
		Usuario u = new Usuario();
                u.setNome("marcelo");
		u.setSenha("123");
		
		Tecnico a = new Tecnico();
		a.setNome("Tiquinho");
		Solicitante s = new  Solicitante();
		Chamado c = new Chamado();
		c.settitulo("Cabo de rede");
		c.setDescricao("falta cabo de rede no laboratorio");
		
		a.atenderChamado(c, "Atendido");
		s.responderChamado(c, "Ok! obrigado");
                s.responderChamado(c, "depois pesso mais coisas!!");
		a.listaChamadosAtendidos();
		//LoginScreen l = new LoginScreen();
		
                new LoginFrame(new Usuario());
                //System.out.println(""+user.);
	}
	

}

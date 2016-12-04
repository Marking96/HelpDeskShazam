package br.com.helpdesk.model;


import br.com.helpdesk.DAO.DAO;
import br.com.helpdesk.view.*;


public class main {

	public static void main(String[] args) throws ClassNotFoundException {
		Tecnico t = new Tecnico(); 
		Usuario user = t;
		
                user.setNome("Antonio");
                user.setSenha("1234");
		Usuario u = new Usuario();
                u.setNome("marcelo");
		u.setSenha("123");
		
		Tecnico a = new Tecnico();
		a.setNome("Tiquinho");
		//Solicitante s = new  Solicitante();
		Chamado c = new Chamado();
		c.settitulo("Cabo de rede");
		c.setDescricao("falta cabo de rede no laboratorio");
		
		a.atenderChamado(c, "Atendido");
		//s.responderChamado(c, "Ok! obrigado");
                //s.responderChamado(c, "depois pesso mais coisas!!");
		a.listaChamadosAtendidos();
		//LoginScreen l = new LoginScreen();
		DAO dao = new DAO();
                dao.conectar();
                //new LoginFrame(new Usuario());
                //System.out.println(""+user.);
	}
	

}

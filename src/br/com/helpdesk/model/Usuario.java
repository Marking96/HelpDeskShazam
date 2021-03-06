/**
 * 
 */
package br.com.helpdesk.model;

import java.util.ArrayList;
import br.com.helpdesk.Control.HeldeskDao;
import br.com.helpdesk.DAO.Chamadobd;
import java.util.List;

/**
 * @author Marking
 *
 */
public  class Usuario {
	private int id;
	private String nome;
	private String cpf;
	private String telefone;
	private boolean logado = false;
        private boolean atende;
	private String email;
	private String senha;
	private String areaatuacao;
        private ArrayList<HeldeskDao> obs = new ArrayList<HeldeskDao>(); 
        private Chamadobd dao;
        
	public Usuario() {
                dao = Chamadobd.getinstacia();
		
	}
	public Usuario(int id, String nome, String cpf, String telefone, boolean atende, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		//this.atende = atende;
		this.email = email;
		this.senha = senha;
	}

        public Usuario(String nome, String cpf, String telefone, boolean atende, String email, String senha, String areaatuacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.atende = atende;
        this.email = email;
        this.senha = senha;
        this.areaatuacao = areaatuacao;
    }
        
        
        
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public boolean isAtende() {
		return atende;
	}
	public void setAtende(boolean atende) {
		this.atende = atende;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

        public String getAreaatuacao() {
        return areaatuacao;
    }

       public void setAreaatuacao(String areaatuacao) {
        this.areaatuacao = areaatuacao;
    }
	
        public  boolean  isLogado(){
            return logado;
        };
	
        public void setusuario(Usuario user){
            dao.setusuario(user);
        }
        
       public String Login(String senha,String email){
               return dao.login(senha, email);
       }
       
       public Usuario getuser(String email){
           return dao.getUsuario(email);
       }
       
       public List<Usuario> getusers(String email){
           return dao.getTodosUser(email);
       }
}

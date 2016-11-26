/**
 * 
 */
package br.com.helpdesk.model;

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
	private String email;
	private String senha;
	private String areaatuacao;
        
	public Usuario() {
		// TODO Auto-generated constructor stub
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
	//public boolean isAtende() {
	//	return atende;
	//}
	//public void setAtende(boolean atende) {
	//	this.atende = atende;
	//}
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
	
	public boolean doLogin (String nome,String senha){
		if (nome.equals(this.getNome()) && senha.equals(this.getSenha()) ) {
			return true;
		}
		return false;
	}
	
    public  boolean  isLogado(){
    	return logado;
    };
	
}

package br.com.helpdesk.model;

public class Respostas {
	private Usuario autor;
	private String resposta;
	
	public Respostas(Usuario autor, String resposta) {
		super();
		this.autor = autor;
		this.resposta = resposta;
	}
	
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	
}

/**
 * 
 */
package br.com.helpdesk.model;

import java.util.ArrayList;

/**
 * @author Marking
 *
 */
public class Chamado {
	private int id;
	private boolean atendido;
	private Usuario autor;
	private String titulo;
	private String descricao;
	private String grauPrioridade;
	private String status;
	private ArrayList<String> respostas;
	
	
	public Chamado(int id, Usuario autor, String titulo, String descricao, String grauPrioridade, String status) {
		super();
		this.id = id;
		this.atendido = false;
		this.autor = autor;
		this.titulo = titulo;
		this.descricao = descricao;
		this.grauPrioridade = grauPrioridade;
		this.status = status;
		this.respostas = new ArrayList<>();
	}

	public Chamado() {
		super();
		this.respostas = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isAtendido() {
		return atendido;
	}

	public void setAtendido(boolean atendido) {
		this.atendido = atendido;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public String gettitulo() {
		return titulo;
	}

	public void settitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGrauPrioridade() {
		return grauPrioridade;
	}

	public void setGrauPrioridade(String grauPrioridade) {
		this.grauPrioridade = grauPrioridade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus() {
		this.status = "Aberto";
	}
	
	public void setResp(String resposta){
		this.respostas.add(resposta);
	}
	public String getResp(){
            
                return respostas.toString();
            
        }
}

/**
 *
 */
package br.com.helpdesk.model;

import br.com.helpdesk.DAO.Chamadobd;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marking
 *
 */
public class Chamado {

    private int id = 0;
    private boolean atendido;
    private Usuario autor;
    private String titulo;
    private String descricao;
    private String grauPrioridade;
    private String status = "Aguardando";
    private String respostas;
    private Chamadobd dao;

    public Chamado(int id, Usuario autor, String titulo, String descricao, String grauPrioridade, String status) {
        super();
        this.id = id;
        this.atendido = false;
        this.autor = autor;
        this.titulo = titulo;
        this.descricao = descricao;
        this.grauPrioridade = grauPrioridade;
        this.status = status;
        
    }

    public Chamado(String titulo, String descricao, String grauPrioridade, String status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.grauPrioridade = grauPrioridade;
        this.status = status;
    }

    public Chamado() {
        super();
        dao = Chamadobd.getinstacia();
        
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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRespostas() {
        return respostas;
    }

    public void setRespostas(String respostas) {
        this.respostas = respostas;
    }

    

    public void salvar(Chamado cha) {
        dao.setChamado(cha);
    }

    public List<Chamado> listar() {
        return dao.getTodosChamados();
    }

    public Chamado getChamado(String titulo) {
        return dao.getChamado(titulo);
    }
    
    public void delete(Chamado c){
        dao.deletaChamado(c);
    }
    
    public void updade(Chamado c){
        dao.atualizarChamado(c);
    }
    public List<String> listarespostas(int id){
        return dao.getResposta(id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helpdesk.DAO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marking
 */
@Entity
@Table(name = "Chamado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chamado.findAll", query = "SELECT c FROM Chamado c")
    , @NamedQuery(name = "Chamado.findById", query = "SELECT c FROM Chamado c WHERE c.id = :id")
    , @NamedQuery(name = "Chamado.findByTitulo", query = "SELECT c FROM Chamado c WHERE c.titulo = :titulo")
    , @NamedQuery(name = "Chamado.findByIdAutor", query = "SELECT c FROM Chamado c WHERE c.idAutor = :idAutor")
    , @NamedQuery(name = "Chamado.findByDescricao", query = "SELECT c FROM Chamado c WHERE c.descricao = :descricao")
    , @NamedQuery(name = "Chamado.findByStatus", query = "SELECT c FROM Chamado c WHERE c.status = :status")
    , @NamedQuery(name = "Chamado.findByPrioridade", query = "SELECT c FROM Chamado c WHERE c.prioridade = :prioridade")
    , @NamedQuery(name = "Chamado.findByAtendido", query = "SELECT c FROM Chamado c WHERE c.atendido = :atendido")})
public class Chamado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "id_autor")
    private int idAutor;
    @Basic(optional = false)
    @Column(name = "descricao")
    private int descricao;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "prioridade")
    private String prioridade;
    @Basic(optional = false)
    @Column(name = "atendido")
    private boolean atendido;

    public Chamado() {
    }

    public Chamado(Integer id) {
        this.id = id;
    }

    public Chamado(Integer id, String titulo, int idAutor, int descricao, String status, String prioridade, boolean atendido) {
        this.id = id;
        this.titulo = titulo;
        this.idAutor = idAutor;
        this.descricao = descricao;
        this.status = status;
        this.prioridade = prioridade;
        this.atendido = atendido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getDescricao() {
        return descricao;
    }

    public void setDescricao(int descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public boolean getAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chamado)) {
            return false;
        }
        Chamado other = (Chamado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.helpdesk.DAO.Chamado[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helpdesk.model;

import java.util.List;

/**
 *
 * @author Marking
 */
public class FacadeChamado {
    private Chamado chamado;

    public FacadeChamado() {
        this.chamado = new Chamado();
    }
    
    public void setChamado(Chamado c){
        chamado.salvar(c);
    }
    public Chamado getChamado(String titulo){
       return chamado.getChamado(titulo);
    }
    public List<Chamado> getAllChamado(){
        return chamado.listar();
    }
    public void removeChamado(){
        chamado.delete(chamado);
    }
    
    public void atualizarChamado(Chamado c){
        chamado.updade(c);
    }
    
    public List<String> listarespostas(int id){
        return chamado.listarespostas(id);
    }
    public void Comentar(Chamado c){
         chamado.Comentar(c);
    }
    
    public void alteraStatus(Chamado c){
        chamado.alteraStatus(c);
    }
    
    public List<Chamado> listarAtendido() {
        return chamado.listarAtendido();
    }
    
    public void reabrir(Chamado c){
        chamado.reabrir(c);
    }
    
    public Chamado getChamado(){
        return chamado;
    }
}

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
public class FacadeUsuario {
    private Usuario usuario = null;
    

    public FacadeUsuario() {
        this.usuario = new Usuario();
    }
    
    public void salva(Usuario us){
        usuario.setusuario(us);
    }
    
    public String login(String senha,String email){
        return usuario.Login(senha, email);
    }
    public List<Usuario> getusers(String email){
           return usuario.getusers(email);
       }
    
    public Usuario getuser(String email){
        return usuario.getuser(email);
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    
}

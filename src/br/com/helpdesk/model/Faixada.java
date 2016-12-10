
package br.com.helpdesk.model;

/**
 *
 * @author Marking
 */
public class Faixada {

    public Faixada() {
    }
    
    public void cadastro(String nome, String email,String telefone,String cpf,String senha,String areaatuacao,boolean atende ){
        if(atende){
           // Tecnico tecnico = new Tecnico(nome, cpf, telefone, atende, email, senha, areaatuacao); 
         }else{
             Solicitante solicitante = new Solicitante(nome, cpf, telefone, atende, email, senha, areaatuacao);
         }
    }
    
    public void CadastroChamado(String titulo, String descricao, String grauPrioridade, String status){
        Chamado chamado = new Chamado(titulo, descricao, grauPrioridade, status);
    }
    
}

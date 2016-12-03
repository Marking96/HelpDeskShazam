
package br.com.helpdesk.Control;

import br.com.helpdesk.model.Usuario;
import br.com.helpdesk.view.LoginFrame;
import java.awt.event.ActionEvent;

/**
 *
 * @author Marking
 */
public class CadastraControl implements Observe{
    
    private LoginFrame view;
    private Usuario model;

    @Override
    public void update() {
        //implementar verificar se todos as variaveis não estão null em um metodo na fachada.
    }

    public CadastraControl(LoginFrame view, Usuario model) {
        this.view = view;
        this.model = model;
        model.registerObserver(this);
    }
    
    public void getEvent(ActionEvent event){
        if(event.getActionCommand().equals("Criar Conta")){
            model.setNome(view.getTxtNome());
            model.setEmail(view.getTxtEmail());
            model.setTelefone(view.getTxtTelefone());
            model.setCpf(view.getTxtCPF());
            model.setSenha(view.getTxtSenha());
            model.setAreaatuacao(view.getTxtAtuação());
            if(view.getjCAtende().equals("sim")){
                model.setAtende(true);
            }else{
                model.setAtende(false);
            }
        }else{
            if(event.getActionCommand().equals("Cancelar")){
                //implementa
            }
        }
    }
    
    
}

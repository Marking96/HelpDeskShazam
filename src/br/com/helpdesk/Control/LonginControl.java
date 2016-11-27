
package br.com.helpdesk.Control;
import java.util.Observable;
import java.util.Observer;
import br.com.helpdesk.model.Usuario;
import br.com.helpdesk.view.LoginFrame;
import java.awt.event.ActionEvent;

/**
 *
 * @author Marking
 */
public class LonginControl implements Observe{
    
    private LoginFrame view;
    private Usuario model;

    public void update() {
        if(model.isLogado()){
            view.exibirMensag("Logado");
        }else{
            view.exibirMensag("Usuario ou senha incorretos!");
        }
    }

    public LonginControl(LoginFrame view, Usuario model) {
        this.view = view;
        this.model = model;
        model.registerObserver(this);
    }
    
    public void getEvent(ActionEvent event){
        if(event.getActionCommand().equals("Entra")){
            model.doLogin(view.getTxtLogin(), view.getTxtSenha());
        }else{
            if(event.getActionCommand().equals("Cancelar")){
                //implementa
            }
        }
    }
    
    
}

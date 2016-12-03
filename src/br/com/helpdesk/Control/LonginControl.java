
package br.com.helpdesk.Control;
import java.util.Observable;
import java.util.Observer;
import br.com.helpdesk.model.Usuario;
import br.com.helpdesk.view.LoginFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Marking
 */
public class LonginControl implements ActionListener {
    
    private LoginFrame view;
    private Usuario model;


    public LonginControl(LoginFrame view) {
        this.view = view;
        model = new Usuario();
        adicionarListener();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Entra")){
            
            if (model.doLogin(view.getTxtLogin(), view.getTxtSenha())) {
            //Camar janela principal;
            }else{
                JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos!!");
            }
            
            
        }else if (ae.getActionCommand().equals("Cancela")) {
            view.setTxtLogin("");
            view.setTxtSenha("");
        }
    }

    private void adicionarListener() {
        view.getBtEntra().addActionListener(this);
        view.getBtCancela().addActionListener(this);
    }
    
    
    
    
    
}

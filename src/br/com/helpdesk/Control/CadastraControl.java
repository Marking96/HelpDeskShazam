
package br.com.helpdesk.Control;

import br.com.helpdesk.model.Usuario;
import br.com.helpdesk.view.LoginFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

/**
 *
 * @author Marking
 */
public class CadastraControl implements ActionListener {
    
    private LoginFrame view;
    private Usuario model;

    public CadastraControl(LoginFrame view) {
        this.view = view;
        model = new Usuario();
        adicionarListener();
    }

   @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Sim")) {
           enabletxtAtentende(true);
        }else{
            enabletxtAtentende(false);
        }
       
        if(ae.getActionCommand().equals("Criar Conta") ){
            
            if (view.getTxtNome() == "" || view.getTxtCPF() == "" || view.getTxtEmail()  == "" || view.getTxtTelefone()  == "" || view.getTxtSenha()  == "" || view.getTxtAtuação() == "") {
                JOptionPane.showMessageDialog(null, "Você deixou campos vazio!!");
            }else{
                if (view.getTxtSenhaCada().equals(view.getTxtConfSenha())) {
                model.setNome(view.getTxtNome());
                model.setCpf(view.getTxtCPF());
                model.setEmail(view.getTxtEmail());
                model.setTelefone(view.getTxtTelefone());
                model.setSenha(view.getTxtSenha());
                model.setAreaatuacao(view.getTxtAtuação());
                JOptionPane.showMessageDialog(null, "Usuarios Cadastrado! Efetue o Login");
                }else{
                    JOptionPane.showMessageDialog(null, "Senhas estão diferentes");

                }
            }
        }
    }  
    
     public void adicionarListener(){
        view.getjBCadastra().addActionListener(this);
        view.getjBCancelar().addActionListener(this);
        view.pegaJCAtende().addActionListener(this);
    }
    
    public void enabletxtAtentende(boolean enable){
        view.getTxtTecnico().setEnabled(enable);
    }

}

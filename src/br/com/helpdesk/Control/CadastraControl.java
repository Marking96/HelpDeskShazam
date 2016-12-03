
package br.com.helpdesk.Control;

import br.com.helpdesk.model.Usuario;
import br.com.helpdesk.view.LoginFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Marking
 */
public class CadastraControl implements ActionListener{
    
    private LoginFrame view;
    private Usuario model;

    public CadastraControl(LoginFrame view) {
        this.view = view;
        model = new Usuario();
        adicionarListener();
    }

    public void adicionarListener(){
        view.getjBCadastra().addActionListener(this);
        view.getjBCancelar().addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Criar Conta") ){
            if (view.getTxtNome() == null || view.getTxtCPF() == null || view.getTxtEmail()  == null || view.getTxtTelefone()  == null || view.getTxtSenha()  == null || view.getTxtAtuação() == null) {
                JOptionPane.showMessageDialog(null, "Você deixou campos vazio!!");
            }else{
                if (view.getTxtSenhaCada().equals(view.getTxtConfSenha())) {
                model.setNome(view.getTxtNome());
                model.setCpf(view.getTxtCPF());
                model.setEmail(view.getTxtEmail());
                model.setTelefone(view.getTxtTelefone());
                model.setSenha(view.getTxtSenha());
                model.setAreaatuacao(view.getTxtAtuação());
                }else{
                    JOptionPane.showMessageDialog(null, "Senhas estão diferentes");

                }
            }
        }
    }   
    
}

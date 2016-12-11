package br.com.helpdesk.Control;

import br.com.helpdesk.DAO.HelpDeskDaoFactory;
import br.com.helpdesk.model.FacadeUsuario;
import br.com.helpdesk.model.ListenerAdapter;
import br.com.helpdesk.model.Usuario;
import br.com.helpdesk.view.LoginFrame;
import br.com.helpdesk.view.Tela_Primcipal;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Marking
 */
public class LonginControl extends ListenerAdapter {

    private LoginFrame view;
    private FacadeUsuario model;
    private HelpDeskDaoFactory dao = HelpDeskDaoFactory.getintancia();

    public LonginControl(LoginFrame view) {
        this.view = view;
        model = new FacadeUsuario();
        adicionarListener();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Entra")) {
            if (model.login(view.getTxtSenha(), view.getTxtLogin()) == "tecnico") {

                Usuario user = model.getuser(view.getTxtEmail());
                Tela_Primcipal telap = new Tela_Primcipal(user);
                telap.setVisible(true);
                view.dispose();

            } else if (model.login(view.getTxtSenha(), view.getTxtLogin()) == "comum") {

                Usuario user = model.getuser(view.getTxtEmail());
                Tela_Primcipal telap = new Tela_Primcipal(user);
                telap.getjMLista().setVisible(false);
                telap.setVisible(true);
                view.dispose();

            } else if ("".equals(view.getTxtSenha()) || "".equals(view.getTxtLogin())) {
                JOptionPane.showMessageDialog(null, "Campus em branco");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos!!");
            }
        } else if (ae.getActionCommand().equals("Cancela")) {
            view.setTxtLogin("");
            view.setTxtSenha("");
        } else if (ae.getActionCommand().equals("Criar Conta")) {
            if(view.pegaJCAtende().getSelectedItem() == "Não"){
            model.getUsuario().setNome(view.getTxtNome());
            model.getUsuario().setEmail(view.getTxtEmail());
            model.getUsuario().setCpf(view.getTxtCPF());
            model.getUsuario().setSenha(view.getTxtSenhaCada());
            model.getUsuario().setAreaatuacao(view.getTxtAtuação());
            model.getUsuario().setTelefone(view.getTxtTelefone());

            model.getUsuario().setusuario(model.getUsuario());
            }else{
            
            }
        }else if(ae.getActionCommand().equals(view.pegaJCAtende().getSelectedItem())){
             if (view.pegaJCAtende().getSelectedItem() == "não") {
                view.getTxtTecnico().enable(false);
            }
        }
    }

    private void adicionarListener() {
        view.getBtEntra().addActionListener(this);
        view.getBtCancela().addActionListener(this);
        view.getjBCadastra().addActionListener(this);
        view.pegaJCAtende().addMouseListener(this);
        
    }
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == view.pegaJCAtende()){
           //else if
        }
    }
}

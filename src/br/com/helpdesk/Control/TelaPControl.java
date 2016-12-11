

package br.com.helpdesk.Control;

import br.com.helpdesk.model.ListenerAdapter;
import br.com.helpdesk.model.Usuario;
import br.com.helpdesk.view.ListaChamado;
import br.com.helpdesk.view.ListaChamadoTecnico;
import br.com.helpdesk.view.LoginFrame;
import br.com.helpdesk.view.Sobre;
import br.com.helpdesk.view.Tela_Primcipal;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;



/**
 *
 * @author Marking
 */
public class TelaPControl extends ListenerAdapter{
    private Tela_Primcipal view;
    private Usuario user;

    public TelaPControl(Tela_Primcipal view,Usuario user) {
        this.view = view;
        this.user = user;
        adicionarListener();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
    }
    
    public void adicionarListener(){
        view.getjMExibir().addMouseListener(this);
        view.getjMSair().addMouseListener(this);
        view.getjMLista().addMouseListener(this);
        view.getjMSobre().addMouseListener(this);
        
    }


    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == view.getjMExibir()){
            ListaChamado listaC = new ListaChamado(user);
            view.getjDPrincipal().add(listaC).setVisible(true);
          
        }else if(me.getSource() == view.getjMSair()){
            new LoginFrame().setVisible(true);
            view.dispose();
            
        }else if(me.getSource() == view.getjMLista()){
            ListaChamadoTecnico listaCT = new ListaChamadoTecnico(user);
            view.getjDPrincipal().add(listaCT).setVisible(true);
            
        }else if(me.getSource() == view.getjMSobre()){
            Sobre sobre = new Sobre();
            view.getjDPrincipal().add(sobre).setVisible(true);
        }    
    }

            
}



package br.com.helpdesk.Control;

import br.com.helpdesk.view.CriarChamado;
import br.com.helpdesk.view.ListaChamado;
import br.com.helpdesk.view.LoginFrame;
import br.com.helpdesk.view.SolicitantePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 *
 * @author Marking
 */
public class SolicitanteControl implements ActionListener,MouseListener{
    private SolicitantePrincipal view;

    public SolicitanteControl(SolicitantePrincipal view) {
        this.view = view;
        adicionarListener();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
    }
    
    public void adicionarListener(){
        view.getjMNovo().addMouseListener(this);
        view.getjMExibir().addMouseListener(this);
        view.getjMSair().addMouseListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()== view.getjMNovo()){
            CriarChamado criar = new CriarChamado();
            view.getjDPrincipal().add(criar);
            criar.setVisible(true);
        }
        else if(me.getSource() == view.getjMExibir()){
            ListaChamado listaC = new ListaChamado();
            view.getjDPrincipal().add(listaC);
            listaC.setVisible(true);
        }else if(me.getSource() == view.getjMSair()){
            new LoginFrame().setVisible(true);
            view.dispose();
            
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

            
}

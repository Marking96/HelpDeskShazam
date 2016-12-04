
package br.com.helpdesk.Control;

import br.com.helpdesk.model.Chamado;
import br.com.helpdesk.view.AtendeChamado;
import br.com.helpdesk.view.ListaChamado;
import br.com.helpdesk.view.SolicitantePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marking
 */
public class ListaChamadoControl implements ActionListener,MouseListener{
    private ListaChamado view;
    private SolicitantePrincipal viewS;
    private Chamado model;

    public ListaChamadoControl(ListaChamado view) {
        this.view = view;
        viewS = new SolicitantePrincipal();
        model = new Chamado();
        adicinaListener();
        lista();
    }
    
    public void lista(){
        DefaultTableModel tChamados = (DefaultTableModel) view.getjTChamados().getModel();
        
        for(Chamado c: model.listar()){
            tChamados.addRow(new Object[]{
               c.gettitulo(),
                c.getGrauPrioridade(),
                c.getStatus()
            });
        }
       
    }
    
    public void adicinaListener(){
        view.getjTChamados().addMouseListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getClickCount() == 2 ){
            String c = (String) (view.getjTChamados().getValueAt(view.getjTChamados().getSelectedRow(), 0));
            System.out.println(c.toString());
            AtendeChamado atChamado = new AtendeChamado();
            viewS.getjDPrincipal().add(atChamado);
            atChamado.setVisible(true);
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
    
    


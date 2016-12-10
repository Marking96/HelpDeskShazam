package br.com.helpdesk.Control;

import br.com.helpdesk.model.Chamado;
import br.com.helpdesk.model.ListenerAdapter;
import br.com.helpdesk.view.ListaChamado;
import br.com.helpdesk.view.SolicitantePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marking
 */
public class ListaChamadoControl extends ListenerAdapter{

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

    public void lista() {
        DefaultTableModel tChamados = (DefaultTableModel) view.getjTChamados().getModel();

        for (Chamado c : model.listar()) {
            tChamados.addRow(new Object[]{
                c.gettitulo(),
                c.getGrauPrioridade(),
                c.getStatus()
            });
        }

    }

    public void adicinaListener() {
        view.getjTChamados().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand() == "Enviar"){
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getClickCount() == 2) {
            if(view.getjTChamados().getSelectedRow() != -1){
                view.getTxtTitulo().setText(view.getjTChamados().getValueAt(view.getjTChamados().getSelectedRow(), 0).toString());
                view.getTxtPriori().setText(view.getjTChamados().getValueAt(view.getjTChamados().getSelectedRow(), 1).toString());
                view.getTxtStatus().setText(view.getjTChamados().getValueAt(view.getjTChamados().getSelectedRow(), 2).toString());
                //view.getTxtDescrição().setText(view.getjTChamados().getValueAt(view.getjTChamados().getSelectedRow(), 3).toString());
            }
        }
    }

}

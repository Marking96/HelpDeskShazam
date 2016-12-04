
package br.com.helpdesk.Control;

import br.com.helpdesk.model.Chamado;
import br.com.helpdesk.view.ListaChamado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class ListaChamadoControl implements ActionListener,ListSelectionListener{
    private ListaChamado view;
    private Chamado model;

    public ListaChamadoControl(ListaChamado view) {
        this.view = view;
        model = new Chamado();
        lista();
    }
    
    public void lista(){
        
        JLabel titulo = new JLabel();
        titulo.setText("Teste");
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        view.getjPanel1().add(titulo);
        titulo.setVisible(true);
       
    }
    
    public void adicinaListener(){
        view.getjTChamados().getSelectionModel().addListSelectionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       DefaultTableModel tChamados = (DefaultTableModel) view.getjTChamados().getModel();
       Object[] Chamados = {model.gettitulo(),model.getAutor(),model.getGrauPrioridade(),model.getStatus()};
       tChamados.addRow(Chamados);
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        if (lse.getValueIsAdjusting())
         return;
      int selected = view.getjTChamados().getSelectedRow(); //Use getSelectedRows se vc permite seleção múltipla
      //faça algo com selected
   }

}
    
    



package br.com.helpdesk.Control;


import br.com.helpdesk.model.Chamado;
import br.com.helpdesk.view.CriarChamado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Marking
 */
public class CriarChamadoControl implements ActionListener{
    private CriarChamado view;
    private Chamado model;
    

    public CriarChamadoControl(CriarChamado view, Chamado model) {
        this.view = view;
        this.model = new Chamado();
        adicionarListener();
                
    }
    
   

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Enviar")) {
            model.setDescricao(view.getTxtDescricao());
            model.settitulo(view.getTxtTitulo());
            model.setGrauPrioridade(view.getJcPrioridade());
            model.salvar(model);
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
        }
    }

    private void adicionarListener() {
        view.getBtnEnviar().addActionListener(this);
    }
    
    
}

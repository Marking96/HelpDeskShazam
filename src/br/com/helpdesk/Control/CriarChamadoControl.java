
package br.com.helpdesk.Control;


import br.com.helpdesk.model.Chamado;
import br.com.helpdesk.model.ListenerAdapter;
import br.com.helpdesk.view.CriarChamado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Marking
 */
public class CriarChamadoControl extends ListenerAdapter{
    private CriarChamado view;
    private Chamado model;
    

    public CriarChamadoControl(CriarChamado view) {
        this.view = view;
        model = new Chamado();
        adicionarListener();
                
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Enviar")) {
            model.setDescricao(view.getTxtDescricao().getText());
            model.settitulo(view.getTxtTitulo().getText());
            model.setGrauPrioridade(view.getJcPrioridade());
            model.salvar(model);
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
            
            view.getTxtDescricao().setText("");
            view.getTxtTitulo().setText("");
        }
    }

    private void adicionarListener() {
        view.getBtnEnviar().addActionListener(this);
    }
    
    
}

package br.com.helpdesk.Control;

import br.com.helpdesk.model.Chamado;
import br.com.helpdesk.model.ListenerAdapter;
import br.com.helpdesk.model.Usuario;
import br.com.helpdesk.view.ListaChamado;
import br.com.helpdesk.view.Tela_Primcipal;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marking
 */
public class ListaChamadoControl extends ListenerAdapter {
    
    private ListaChamado view;
    private Chamado model;
    private Usuario user;
    
    public ListaChamadoControl(ListaChamado view,Usuario user) {
        this.view = view;
        this.user = user;
        model = new Chamado();
        adicinaListener();
        lista();
    }
    
    public void lista() {
        DefaultTableModel tChamados = (DefaultTableModel) view.getjTChamados().getModel();
        tChamados.setNumRows(0);
        for (Chamado c : model.listar()) {
            tChamados.addRow(new Object[]{
                c.getId(),
                c.gettitulo(),
                c.getGrauPrioridade(),
                c.getStatus()
            });
        }
        
    }
    public void limpalista(){
        DefaultListModel tRespostas = new DefaultListModel();
        view.getjLRespotas().setModel(tRespostas);
    }
    public void listarespostas(int id){
        DefaultListModel tRespostas = new DefaultListModel();
        for (String resposta : model.listarespostas(id)) {
            tRespostas.addElement(resposta);
            
        }
        view.getjLRespotas().setModel(tRespostas);
    }
    
    public void adicinaListener() {
        view.getjTChamados().addMouseListener(this);
        view.getBtnEnviar().addActionListener(this);
        view.getBtnExcluir().addActionListener(this);
        view.getBtnAltera().addActionListener(this);
        view.getBtnLimpa().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Enviar")) {
            model.setDescricao(view.getTxtDescrição().getText());
            model.settitulo(view.getTxtTitulo().getText());
            model.setGrauPrioridade((String) view.getJcPrioridade().getSelectedItem());
            model.setAutor(user);
            model.salvar(model);
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
            
            view.getTxtDescrição().setText("");
            view.getTxtTitulo().setText("");
            view.getLbstatus().setText("");
            
            lista();
        } else if (ae.getActionCommand().equals("Excluir")) {
            if (view.getjTChamados().getSelectedRow() != -1) {
                
                model.setId((int) view.getjTChamados().getValueAt(view.getjTChamados().getSelectedRow(), 0));
                model.delete(model);
                
                view.getTxtDescrição().setText("");
                view.getTxtTitulo().setText("");
                view.getLbstatus().setText("");
                JOptionPane.showMessageDialog(null, "Chamado excluido com sucesso!!");
                
                lista();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um chamado para excluir");
                
            }
        } else if (ae.getActionCommand().equals("Altera")) {
            if (view.getjTChamados().getSelectedRow() != -1) {
                
                model.setDescricao(view.getTxtDescrição().getText());
                model.settitulo(view.getTxtTitulo().getText());
                model.setGrauPrioridade((String) view.getJcPrioridade().getSelectedItem());
                model.setId((int) view.getjTChamados().getValueAt(view.getjTChamados().getSelectedRow(), 0));
                model.updade(model);
                
                view.getTxtDescrição().setText("");
                view.getTxtTitulo().setText("");
                view.getLbstatus().setText("");
                
                JOptionPane.showMessageDialog(null, "Chamado Atualizado com sucesso!!");
                
                lista();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um chamado para atuarizar");
                
            }
        }else if(ae.getActionCommand().equals("Limpa")){
            view.getTxtDescrição().setText("");
            view.getTxtTitulo().setText("");
            view.getLbstatus().setText("");
            limpalista();
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getClickCount() == 2) {
            if (view.getjTChamados().getSelectedRow() != -1) {
                
                view.getTxtTitulo().setText(view.getjTChamados().getValueAt(view.getjTChamados().getSelectedRow(), 1).toString());
                view.getJcPrioridade().setSelectedItem(view.getjTChamados().getValueAt(view.getjTChamados().getSelectedRow(), 2).toString());
                view.getLbstatus().setText(view.getjTChamados().getValueAt(view.getjTChamados().getSelectedRow(), 3).toString());
                listarespostas((int) view.getjTChamados().getValueAt(view.getjTChamados().getSelectedRow(), 0));
            }
        }
    }
    
}

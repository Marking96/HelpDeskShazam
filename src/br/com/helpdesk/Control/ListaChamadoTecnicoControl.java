/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helpdesk.Control;

import br.com.helpdesk.model.Chamado;
import br.com.helpdesk.model.ListenerAdapter;
import br.com.helpdesk.model.Usuario;
import br.com.helpdesk.view.ListaChamadoTecnico;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marking
 */
public class ListaChamadoTecnicoControl extends ListenerAdapter{
    private ListaChamadoTecnico view;
    private Chamado model;
    private Usuario user;
    
    public ListaChamadoTecnicoControl(ListaChamadoTecnico view,Usuario user) {
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
        view.getBtnAtendido().addActionListener(this);
        view.getBtnLimpa().addActionListener(this);
        view.getBtnComentar().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Atendido")) {
            if (view.getjTChamados().getSelectedRow() != -1) {
                
                
                model.setId((int) view.getjTChamados().getValueAt(view.getjTChamados().getSelectedRow(), 0));
                model.alteraStatus(model);
                
                view.getTxtDescrição().setText("");
                view.getTxtTitulo().setText("");
                view.getLbstatus().setText("");
                
                JOptionPane.showMessageDialog(null, "Chamado Atendido com sucesso!!");
                limpalista();
                lista();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um chamado para atuarizar");
                
            }
        }else if(ae.getActionCommand().equals("Limpa")){
            view.getTxtDescrição().setText("");
            view.getTxtTitulo().setText("");
            view.getLbstatus().setText("");
            limpalista();
        }else if(ae.getActionCommand().equals("Comentar")){
            model.setId((int) view.getjTChamados().getValueAt(view.getjTChamados().getSelectedRow(), 0));
            model.setRespostas(view.getTxtResposta().getText());
            model.Comentar(model);
            listarespostas((int) view.getjTChamados().getValueAt(view.getjTChamados().getSelectedRow(), 0));
            view.getTxtResposta().setText("");
            JOptionPane.showMessageDialog(null, "comentario realizado com sucesso!!");
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

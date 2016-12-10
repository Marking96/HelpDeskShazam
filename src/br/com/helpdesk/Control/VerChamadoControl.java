package br.com.helpdesk.Control;

import br.com.helpdesk.model.Chamado;
import br.com.helpdesk.view.VerChamado;

/**
 *
 * @author Marking
 */
public class VerChamadoControl {

    private VerChamado view;
    private Chamado model;

    public VerChamadoControl(VerChamado view) {
        this.view = new VerChamado();
        model = new Chamado();
        adicionarListenaer();
    }

    public VerChamadoControl() {
        this.model = new Chamado();
        this.view = new VerChamado();
    }

    private void adicionarListenaer() {
    }

    public void setChamado(Chamado chamado) {

        view.getTxtTitulo().setText(chamado.gettitulo());
    }

}

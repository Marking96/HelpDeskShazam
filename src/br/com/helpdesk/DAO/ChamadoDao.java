
package br.com.helpdesk.DAO;

import br.com.helpdesk.model.Chamado;
import java.util.List;

/**
 *
 * @author Marking
 */
public interface ChamadoDao {
    public List<Chamado> getTodosChamados();
    public Chamado getChamado(String titulo);
    public void setChamado(Chamado chamado);
    public void atualizarChamado(Chamado chamado);
    public void deletaChamado(Chamado chamado);
}

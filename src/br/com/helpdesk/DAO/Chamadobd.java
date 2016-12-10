/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helpdesk.DAO;

import br.com.helpdesk.model.Chamado;
import br.com.helpdesk.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marking
 */
public class Chamadobd implements ChamadoDao {

    private HelpDeskDaoFactory dao = HelpDeskDaoFactory.getintancia();
    private static Chamadobd intacie;

    protected Chamadobd() {
    }

    public static Chamadobd getinstacia() {
        if (intacie == null) {
            intacie = new Chamadobd();
        }
        return intacie;
    }

    @Override
    public List<Chamado> getTodosChamados() {
        List<Chamado> chamados = new ArrayList<Chamado>();
        Connection con = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("select * from Chamado");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Chamado chamado = new Chamado();
                chamado.setId(rs.getInt("id"));
                chamado.settitulo(rs.getString("titulo"));
                chamado.setDescricao(rs.getString("descricao"));
                chamado.setStatus(rs.getString("status"));
                chamado.setGrauPrioridade(rs.getString("prioridade"));
                chamado.setAtendido(rs.getBoolean("atendido"));

                chamados.add(chamado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Chamadobd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dao.closeConnection(con, stmt, rs);
        }
        return chamados;
    }

    @Override
    public Chamado getChamado(String titulo) {
            Connection con = dao.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
        try {
            Chamado chamado = new Chamado();
            stmt = con.prepareStatement("select * from Chamado where titulo = '" + titulo + "'");
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                chamado.setId(rs.getInt("id"));
                chamado.settitulo(rs.getString("titulo"));
                chamado.setDescricao(rs.getString("descricao"));
                chamado.setStatus(rs.getString("status"));
                chamado.setGrauPrioridade(rs.getString("prioridade"));
                chamado.setAtendido(rs.getBoolean("atendido"));


            }
            return chamado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dao.closeConnection(con, stmt, rs);
        }
    }

    @Override
    public void setChamado(Chamado chamado) {
        Connection con = dao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into Chamado (titulo,descricao,status,prioridade,atendido) values(?,?,?,?,?)");
            stmt.setString(1, chamado.gettitulo());
            stmt.setString(2, chamado.getDescricao());
            stmt.setString(3, chamado.getStatus());
            stmt.setString(4, chamado.getGrauPrioridade());
            stmt.setBoolean(5, chamado.isAtendido());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Chamadobd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dao.closeConnection(con, stmt);
        }
    }

    @Override
    public void atualizarChamado(Chamado chamado) {
        String query = "update Chamado set titulo = ?,descricao = ?,stattus = ?,prioridade = ? where id = ?";
        Connection con = dao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(query);

            stmt.setString(1, chamado.gettitulo());
            stmt.setString(2, chamado.getDescricao());
            stmt.setString(3, chamado.getStatus());
            stmt.setString(4, chamado.getGrauPrioridade());
            stmt.setInt(5, chamado.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dao.closeConnection(con, stmt);
        }
    }

    @Override
    public void deletaChamado(Chamado chamado) {
        Connection con = dao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from Chamado where id=?");
            stmt.setInt(1, chamado.getId());
            stmt.executeUpdate();
            

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dao.closeConnection(con, stmt);
        }

    }

    public void setusuario(Usuario user) {
        String query = "insert into usuario (nome,email,cpf,telefone,areaatuacao,senha) values(?,?,?,?,?,?)";
        Connection con = dao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(query);

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getCpf());
            stmt.setString(4, user.getTelefone());
            stmt.setString(5, user.getAreaatuacao());
            stmt.setString(6, user.getSenha());

            stmt.executeUpdate();
            

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dao.closeConnection(con, stmt);
        }
    }

    public String login(String senha, String email) {
        String query = "select * from usuario where email like '" + email + "' and senha like '" + senha+"'";
        Connection con = dao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            if (rs.isFirst() && rs.getBoolean("atende")) {
               
                return "tecnico";
            } else if (rs.first() && !rs.getBoolean("atende")) {
                
                return "comum";
            }
            

            return null;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
           dao.closeConnection(con, stmt, rs);
        }
    }
}

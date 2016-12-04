/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helpdesk.DAO;

import br.com.helpdesk.model.Chamado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marking
 */
public class Chamadobd implements ChamadoDao{
    
    private Connection conectar;

    public Chamadobd() {
        this.conectar = new DAO().conectar();
    }
    
    
    
    @Override
    public List<Chamado> getTodosChamados() {
        try {
            List<Chamado> chamados = new ArrayList<Chamado>();
            PreparedStatement stmt = conectar.prepareStatement("select * from Chamado");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Chamado chamado = new Chamado();
                chamado.setId(rs.getInt("id"));
                chamado.settitulo(rs.getString("titulo"));
                chamado.setDescricao(rs.getString("descricao"));
                chamado.setStatus (rs.getString("status"));
                chamado.setGrauPrioridade(rs.getString("prioridade"));
                chamado.setAtendido(rs.getBoolean("atendido"));
                
                chamados.add(chamado);
            }
            rs.close();
            stmt.close();
            return chamados;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Chamado getChamado(String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setChamado(Chamado chamado) {
        String query = "insert into Chamado (titulo,descricao,status,prioridade,atendido) values(?,?,?,?,?)";
    
        try{
            PreparedStatement stmt = conectar.prepareStatement(query);
            
            stmt.setString(1, chamado.gettitulo());
            stmt.setString(2, chamado.getDescricao());
            stmt.setString(3, chamado.getStatus());
            stmt.setString(4, chamado.getGrauPrioridade());
            stmt.setBoolean(5, chamado.isAtendido());
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizarChamado(Chamado chamado) {
        String query = "update Chamado set titulo = ?,descricao = ?,stattus = ?,prioridade = ? where id = ?";
        
        try{
            PreparedStatement stmt = conectar.prepareStatement(query);
            
            stmt.setString(1, chamado.gettitulo());
            stmt.setString(2, chamado.getDescricao());
            stmt.setString(3, chamado.getStatus());
            stmt.setString(4, chamado.getGrauPrioridade());
            stmt.setInt(5, chamado.getId());
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletaChamado(Chamado chamado) {
        try {
            PreparedStatement stmt = conectar.prepareStatement("delete from Chamado where id=?");
            stmt.setInt(1, chamado.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
}

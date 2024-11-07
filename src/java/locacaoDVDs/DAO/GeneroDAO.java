/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.DAO;

import java.sql.SQLException;
import java.util.List;
import locacaoDVDs.Entidades.Genero ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.util.ArrayList;

/**
 *
 * @author nicho
 */
public class GeneroDAO extends dao<Genero>{

    public GeneroDAO() throws SQLException {
        super() ;
    }
    
    @Override
    public void salvar(Genero obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
            INSERT INTO genero(descricao)
            VALUES (?) ;""") ;
        
        sql.setString(1, obj.getDescricao());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public void atualizar(Genero obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
            UPDATE genero
            SET
                descricao = ?
            WHERE
                id = ? ;""") ;
        
        sql.setString(1, obj.getDescricao());
        sql.setInt(2, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public void excluir(Genero obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              DELETE FROM genero
                                                                WHERE id = ? ;""") ;
        
        sql.setInt(1, obj.getId());
        
        sql.executeUpdate();
        sql.close();
    }

    @Override
    public List<Genero> selecionarTodos() throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
            SELECT id, descricao from genero ;
            """) ;
        List<Genero> generos = new ArrayList<>() ;
        
        ResultSet rs = sql.executeQuery() ;
        
        while(rs.next()) {
            Genero novo = new Genero() ;
            novo.setId(rs.getInt("id"));
            novo.setDescricao(rs.getString("descricao"));
            
            generos.add(novo) ;
        }
        
        rs.close();
        sql.close();
        
        return generos ;
    }

    @Override
    public Genero selecionarPorID(int id) throws SQLException {
        
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT descricao FROM genero
                                                              WHERE id = ?;""") ;
        
        sql.setInt(1, id);
        
        ResultSet rs = sql.executeQuery() ;
        Genero gen = null ;
        if (rs.next()) {
            gen = new Genero() ;
            gen.setDescricao(rs.getString("descricao"));
            gen.setId(id);
        }
        
        return gen ;
    }
    
}

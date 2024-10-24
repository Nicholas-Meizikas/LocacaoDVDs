/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.DAO;

import java.sql.SQLException;
import java.util.List;
import locacaoDVDs.Entidades.Ator ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.util.ArrayList;
/**
 *
 * @author nicho
 */
public class AtorDAO extends dao<Ator>{

    public AtorDAO() throws SQLException {
        super() ;
    }
    @Override
    public void salvar(Ator obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              INSERT INTO ator (nome, sobrenome, data_estreia)
                                                              VALUES ( ?, ?, ?) ;""") ;
        sql.setString(1, obj.getNome());
        sql.setString(2, obj.getSobrenome());
        sql.setDate(3, obj.getDataEstreia());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public void atualizar(Ator obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              INSERT ator 
                                                                SET
                                                                    nome = ?,
                                                                    sobrenome = ?, 
                                                                    data_estreia = ?
                                                              WHERE 
                                                                id = ?;""") ;
        sql.setString(1, obj.getNome());
        sql.setString(2, obj.getSobrenome());
        sql.setDate(3, obj.getDataEstreia());
        sql.setInt(4, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public void excluir(Ator obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              DELETE FROM ator 
                                                              WHERE 
                                                                id = ?;""") ;
        
        sql.setInt(1, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public List<Ator> selecionarTodos() throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT id,nome,sobrenome,data_estreia 
                                                              FROM ator ;""") ;
        
        List<Ator> lista = new ArrayList<>() ;
        
        ResultSet rs = sql.executeQuery() ;
        
        while (rs.next()) {
            Ator a = new Ator() ;
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setSobrenome(rs.getString("sobrenome"));
            a.setDataEstreia(rs.getDate("data_estreia"));
            
            lista.add(a) ;
        }
        
        rs.close();
        sql.close();
        
        return lista ;
    }

    @Override
    public Ator selecionarPorID(int id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT nome,sobrenome,data_estreia 
                                                              FROM ator 
                                                              WHERE id = ?;""") ;
        sql.setInt(1, id);
        
        ResultSet rs = sql.executeQuery() ;
        
        Ator a = null ;
        if (rs.next()) {
            a = new Ator() ;
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setSobrenome(rs.getString("sobrenome"));
            a.setDataEstreia(rs.getDate("data_estreia"));
            
        }
        
        rs.close();
        sql.close();
        
        return a ;
    }
    
}

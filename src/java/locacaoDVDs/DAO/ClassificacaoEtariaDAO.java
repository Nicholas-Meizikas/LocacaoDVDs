/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.DAO;

import java.sql.SQLException;
import java.util.List;
import locacaoDVDs.Entidades.ClassificacaoEtaria ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.util.ArrayList;
/**
 *
 * @author nicho
 */
public class ClassificacaoEtariaDAO extends dao<ClassificacaoEtaria>{

    public ClassificacaoEtariaDAO() throws SQLException {
        super() ;
    }
    
    @Override
    public void salvar(ClassificacaoEtaria obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              INSERT INTO classicficacao_etaria (descricao)
                                                                VALUES (?) ; """) ;
        
        sql.setString(1, obj.getDescricao());
        
        sql.executeUpdate() ;
        sql.close();
        
    }

    @Override
    public void atualizar(ClassificacaoEtaria obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              UPDATE classicficacao_etaria 
                                                              set descricao = ?
                                                                WHERE id = ? ; """) ;
        
        sql.setString(1, obj.getDescricao());
        sql.setInt(2, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public void excluir(ClassificacaoEtaria obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              DELETE FROM classicficacao_etaria 
                                                                WHERE id = ? ; """) ;
      
        sql.setInt(1, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public List<ClassificacaoEtaria> selecionarTodos() throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT id, descricao FROM classificacao_etaria;""") ;
      
        
        ResultSet rs = sql.executeQuery() ;
        List<ClassificacaoEtaria> lista = new ArrayList<>() ;
        while(rs.next()) {
            ClassificacaoEtaria nova = new ClassificacaoEtaria() ;
            nova.setDescricao(rs.getString("descricao"));
            nova.setId(rs.getInt("id"));
            
            lista.add(nova) ;
        }
        
        rs.close();
        sql.close();
        
        return lista ;
    }

    @Override
    public ClassificacaoEtaria selecionarPorID(int id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT descricao FROM classificacao_etaria
                                                              WHERE id = ?;""") ;
      
        sql.setInt(1, id);
        
        ResultSet rs = sql.executeQuery() ;
        ClassificacaoEtaria nova = null ;
        
        if(rs.next()) {
            nova = new ClassificacaoEtaria() ;
            nova.setDescricao(rs.getString("descricao"));
            nova.setId(id);
            
        }
        
        rs.close();
        sql.close();
        
        return nova ;
    }
    
}

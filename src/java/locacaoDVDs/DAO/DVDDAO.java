/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.DAO;

import java.sql.SQLException;
import java.util.List;
import locacaoDVDs.Entidades.*;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
        
/**
 *
 * @author nicho
 */
public class DVDDAO extends dao<DVD>{

    public DVDDAO() throws SQLException {
        super() ;
    }
    
    @Override
    public void salvar(DVD obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              INSERT INTO dvd 
                                                              (titulo, ano_lancamento, data_lancamento,
                                                               duracao_minutos, ator_principal_id, ator_coadjuvante_id,
                                                              genero_id, classificacao_etaria_id)
                                                              VALUES ( ?, ?, ?, ?, ?, ?, ?, ?) ;""") ;
        
        sql.setString(1, obj.getTitulo());
        sql.setInt(2, obj.getAnoLancamento());
        sql.setDate(3, obj.getDataLancamento());
        sql.setInt(4, obj.getDuracaoMinutos());
        sql.setInt(5, obj.getAtorPrincipal().getId());
        sql.setInt(6, obj.getAtorCoadjuvante().getId());
        sql.setInt(7, obj.getGenero().getId());
        sql.setInt(8, obj.getClasEt().getId());
        
        sql.executeUpdate() ;
        sql.close();
        
    }

    @Override
    public void atualizar(DVD obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              UPDATE dvd 
                                                              SET titulo = ?,
                                                                ano_lancamento = ?, 
                                                                data_lancamento = ?,
                                                                duracao_minutos = ?,
                                                                ator_principal_id = ?,
                                                                ator_coadjuvante_id = ?,
                                                                genero_id = ?, 
                                                                classificacao_etaria_id = ?
                                                              WHERE id = ? ;""") ;
        
        sql.setString(1, obj.getTitulo());
        sql.setInt(2, obj.getAnoLancamento());
        sql.setDate(3, obj.getDataLancamento());
        sql.setInt(4, obj.getDuracaoMinutos());
        sql.setInt(5, obj.getAtorPrincipal().getId());
        sql.setInt(6, obj.getAtorCoadjuvante().getId());
        sql.setInt(7, obj.getGenero().getId());
        sql.setInt(8, obj.getClasEt().getId());
        sql.setInt(9, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
        
    }

    @Override
    public void excluir(DVD obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              DELETE FROM dvd
                                                              WHERE id = ? ;""") ;
        
        
        sql.setInt(1, obj.getClasEt().getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public List<DVD> selecionarTodos() throws SQLException {
        
        
        List<DVD> lista = new ArrayList<>() ;
        
        return lista ;
    }

    @Override
    public DVD selecionarPorID(int id) throws SQLException {
        DVD d = null ;
        
        return d ;
                
    }
    
}

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
        sql.setInt(8, obj.getEtaria().getId());
        
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
        sql.setInt(8, obj.getEtaria().getId());
        sql.setInt(9, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
        
    }

    @Override
    public void excluir(DVD obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              DELETE FROM dvd
                                                              WHERE id = ? ;""") ;
        
        
        sql.setInt(1, obj.getEtaria().getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public List<DVD> selecionarTodos() throws SQLException {
        
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT dvd.id, dvd.titulo, dvd.ano_lancamento anoL, dvd.data_lancamento dataL,
                                                              dvd.duracao_minutos duracao, dvd.ator_principal_id atorPrincipal, dvd.ator_coadjuvante_id atorCoadjuvante,
                                                              g.id idGen, ce.id idEtaria
                                                              FROM dvd, genero g, classificacao_etaria ce 
                                                              WHERE 
                                                                dvd.genero_id = g.id AND
                                                                dvd.classificacao_etaria_id = ce.id;""") ;
        
        ResultSet rs = sql.executeQuery() ;
        List<DVD> lista = new ArrayList<>() ;
        
        while (rs.next()) {
            Genero g = new Genero() ;
            g.setId(rs.getInt("idGen"));
            
            ClassificacaoEtaria ce = new ClassificacaoEtaria() ;
            ce.setId(rs.getInt("idEtaria"));
            AtorDAO dao = new AtorDAO() ;
            Ator principal = dao.selecionarPorID(rs.getInt("atorPrincipal")) ;
            Ator Coadjuvante = dao.selecionarPorID(rs.getInt("atorCoadjuvante")) ;
            
            DVD d = new DVD() ;
            d.setAtorPrincipal(principal);
            d.setGenero(g);
            d.setEtaria(ce);
            d.setAtorCoadjuvante(Coadjuvante);
            d.setAnoLancamento(rs.getInt("anoL"));
            d.setDataLancamento(rs.getDate("dataL"));
            d.setDuracaoMinutos(rs.getInt("duracao"));
            d.setTitulo(rs.getString("titulo"));
            d.setId(rs.getInt("id"));
            
            lista.add(d) ;
        }
        
        rs.close();
        sql.close();
        return lista ;
    }

    @Override
    public DVD selecionarPorID(int id) throws SQLException {
        
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT dvd.id id, dvd.titulo titulo, dvd.ano_lancamento anoL, dvd.data_lancamento dataL,
                                                              dvd.duracao_minutos duracao, dvd.ator_principal_id atorPrincipal, 
                                                              dvd.ator_coadjuvante_id coadjuvante, g.id idGen, ce.id idEtaria
                                                              FROM dvd, genero g, classificacao_etaria ce 
                                                              WHERE 
                                                                dvd.id = ? AND
                                                                dvd.genero_id = g.id AND
                                                                dvd.classificacao_etaria_id = ce.id;""") ;
        
        sql.setInt(1, id);
        
        ResultSet rs = sql.executeQuery() ;
        DVD d = null ;
        
        if (rs.next()) {
            Genero g = new Genero() ;
            g.setId(rs.getInt("idGen"));
            
            ClassificacaoEtaria ce = new ClassificacaoEtaria() ;
            ce.setId(rs.getInt("idEtaria"));
            
            
            AtorDAO dao= new AtorDAO() ;
            Ator principal = dao.selecionarPorID(rs.getInt("atorPrincipal")) ;
            Ator Coadjuvante = dao.selecionarPorID(rs.getInt("coadjuvante")) ;
            
            
            d = new DVD() ;
            d.setAtorPrincipal(principal);
            d.setGenero(g);
            d.setEtaria(ce);
            d.setAtorCoadjuvante(Coadjuvante);
            d.setAnoLancamento(rs.getInt("anoL"));
            d.setDataLancamento(rs.getDate("dataL"));
            d.setDuracaoMinutos(rs.getInt("duracao"));
            d.setTitulo(rs.getString("titulo"));
            d.setId(rs.getInt("id"));
            
        }
        
        rs.close();
        sql.close();
        
        return d ;
                
    }
    
}

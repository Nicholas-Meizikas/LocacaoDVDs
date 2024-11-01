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
                                                              SET 
                                                                titulo = ?,
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
        
        
        sql.setInt(1, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public List<DVD> selecionarTodos() throws SQLException {
        
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT dvd.id, dvd.titulo, dvd.ano_lancamento anoL, dvd.data_lancamento dataL,
                                                              dvd.duracao_minutos duracao, dvd.ator_principal_id atorPrincipal, dvd.ator_coadjuvante_id atorCoadjuvante,
                                                              g.id idGen,g.descricao descricaoG, ce.id idEtaria, ce.descricao descricaoCE
                                                              FROM dvd, genero g, classificacao_etaria ce 
                                                              WHERE 
                                                                dvd.genero_id = g.id AND
                                                                dvd.classificacao_etaria_id = ce.id;""") ;
        
        ResultSet rs = sql.executeQuery() ;
        List<DVD> lista = new ArrayList<>() ;
        
        while (rs.next()) {
            Genero g = new Genero() ;
            g.setId(rs.getInt("idGen"));
            g.setDescricao(rs.getString("descricaoG"));
            
            ClassificacaoEtaria ce = new ClassificacaoEtaria() ;
            ce.setId(rs.getInt("idEtaria"));
            ce.setDescricao(rs.getString("descricaoCE"));
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
                                                              SELECT dvd.id DVDid, dvd.titulo DVDtitulo,
                                                                dvd.ano_lancamento DVDano, dvd.data_lancamento DVDdata, dvd.duracao_minutos DVDduracao,
                                                                dvd.ator_principal_id principal, dvd.ator_coadjuvante_id coadjuvante, 
                                                                g.id idG, g.descricao descricaoGenero, 
                                                                ce.id idCE, ce.descricao descricaoCE
                                                              FROM dvd, genero g, classificacao_etaria ce
                                                              WHERE g.id = dvd.genero_id AND
                                                                ce.id = dvd.classificacao_etaria_id AND
                                                                dvd.id = ?;""") ;
        
        sql.setInt(1, id);
        
        ResultSet rs = sql.executeQuery() ;
        DVD d = null ;
        
        if (rs.next()) {
            Genero g = new Genero() ;
            g.setId(rs.getInt("idG")) ;
            g.setDescricao(rs.getString("descricaoGenero"));
            
            ClassificacaoEtaria ce = new ClassificacaoEtaria() ;
            ce.setId(rs.getInt("idCE"));
            ce.setDescricao(rs.getString("descricaoCE"));
            
            AtorDAO dao= new AtorDAO() ;
            Ator principal = dao.selecionarPorID(rs.getInt("principal")) ;
            Ator Coadjuvante = dao.selecionarPorID(rs.getInt("coadjuvante")) ;
            
            
            d = new DVD() ;
            d.setAtorPrincipal(principal);
            d.setGenero(g);
            d.setEtaria(ce);
            d.setAtorCoadjuvante(Coadjuvante);
            d.setAnoLancamento(rs.getInt("DVDano"));
            d.setDataLancamento(rs.getDate("DVDdata"));
            d.setDuracaoMinutos(rs.getInt("DVDduracao"));
            d.setTitulo(rs.getString("DVDtitulo"));
            d.setId(rs.getInt("DVDid"));
            
        }
        
        rs.close();
        sql.close();
        
        return d ;
                
    }
    
}

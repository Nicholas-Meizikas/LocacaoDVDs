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
                                                              VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)""") ;
        
        sql.setString(1, obj.getTitulo());
        sql.setInt(2, obj.getAnoLancamento());
        sql.setDate(3, obj.getDataLancamento());
        
        sql.executeUpdate() ;
        sql.close();
        
    }

    @Override
    public void atualizar(DVD obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(DVD obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DVD> selecionarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DVD selecionarPorID(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

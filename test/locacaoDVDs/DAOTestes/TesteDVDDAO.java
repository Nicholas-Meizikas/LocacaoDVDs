/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.DAOTestes;

import java.sql.Date;
import java.sql.SQLException;
import locacaoDVDs.Entidades.* ;
import locacaoDVDs.DAO.DVDDAO ;

/**
 *
 * @author nicho
 */
public class TesteDVDDAO {
    public static void testeDVDDAO() {
        DVDDAO dao = null ;
        DVD d1 = new DVD() ;
        DVD d2 = new DVD() ;
        ClassificacaoEtaria ce = new ClassificacaoEtaria();
        Ator principal = new Ator() ;
        Ator coadjuvante = new Ator() ;
        Genero g = new Genero() ;
        
        try{
            dao = new DVDDAO() ;
        
            g.setId(1);
            principal.setId(1);
            coadjuvante.setId(2);
            ce.setId(1);
            d1.setAnoLancamento(2010);
            d1.setAtorCoadjuvante(coadjuvante);
            d1.setAtorPrincipal(principal);
            d1.setDataLancamento(new Date(System.currentTimeMillis()));
            d1.setDuracaoMinutos(200);
            d1.setEtaria(ce);
            d1.setGenero(g);
            d1.setTitulo("Shrek");
            
            dao.salvar(d1);
            
            for (DVD d3 : dao.selecionarTodos()) {
                System.out.println(d3.toString());
                d2 = d3 ;
            }
            
            d2.setTitulo("John Wick");
            
            dao.atualizar(d2);
            
            System.out.println(dao.selecionarPorID(d2.getId()));
            
            dao.excluir(d2);
            
            for (DVD d3 : dao.selecionarTodos()) {
                System.out.println(d3.toString());
                d2 = d3 ;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            
            if (dao!=null) {
                try{
                    dao.fecharConexao();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            
        }
    }
}

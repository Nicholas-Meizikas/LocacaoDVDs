/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.DAOTestes;

import locacaoDVDs.Entidades.ClassificacaoEtaria;
import locacaoDVDs.DAO.ClassificacaoEtariaDAO;
import java.sql.SQLException ;
/**
 *
 * @author nicho
 */
public class testeClassificacaoEtariaDAO {
    public static void testeClassificacaoEtariaDAO() {
        ClassificacaoEtaria g = new ClassificacaoEtaria() ;
        ClassificacaoEtaria g2 = new ClassificacaoEtaria() ;
        ClassificacaoEtariaDAO dao = null ;
        
        try{
            dao = new ClassificacaoEtariaDAO();
            
            g.setId(2);
            g.setDescricao("para Adultos");
            
            dao.salvar(g);
            
            for (ClassificacaoEtaria g3 : dao.selecionarTodos()){
                System.out.println(g3.toString());
                g2.setId(g3.getId());
                g2.setDescricao(g3.getDescricao());
            }
            
            dao.excluir(g2);
            System.out.println();
            
            for (ClassificacaoEtaria g3 : dao.selecionarTodos()){
                System.out.println(g3.toString());
                g2.setId(g3.getId());
                g2.setDescricao(g3.getDescricao());
            }
            System.out.println("\n" + dao.selecionarPorID(g2.getId()).toString());
            dao.atualizar(g);
            
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (dao!= null) {
                try{
                    dao.fecharConexao();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

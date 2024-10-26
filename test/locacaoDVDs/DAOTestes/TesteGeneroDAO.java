/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.DAOTestes;

import java.sql.SQLException;
import locacaoDVDs.DAO.GeneroDAO ;
import locacaoDVDs.Entidades.Genero ;

/**
 *
 * @author nicho
 */
public class TesteGeneroDAO {
    public static void TesteGeneroDAO() {
        Genero g = new Genero() ;
        Genero g2 = new Genero() ;
        GeneroDAO dao = null ;
        
        try{
            dao = new GeneroDAO();
            
            g.setId(1);
            g.setDescricao("sci-fi");
            
            dao.salvar(g);
            
            for (Genero g3 : dao.selecionarTodos()){
                System.out.println(g3.toString());
                g2.setId(g3.getId());
                g2.setDescricao(g3.getDescricao());
            }
            
            dao.excluir(g2);
            System.out.println();
            
            for (Genero g3 : dao.selecionarTodos()){
                System.out.println(g3.toString());
                g2.setId(g3.getId());
                g2.setDescricao(g3.getDescricao());
            }
            
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

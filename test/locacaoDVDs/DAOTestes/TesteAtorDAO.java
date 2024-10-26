/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.DAOTestes;

import java.sql.Date;
import locacaoDVDs.DAO.AtorDAO;
import locacaoDVDs.Entidades.Ator ;
import java.sql.SQLException ;
import java.sql.Date ;
/**
 *  
 * @author nicho
 */
public class TesteAtorDAO {
    public static void testeAtorDAO() {
        AtorDAO dao = null ;
        Ator a1 = new Ator();
        Ator a2 = new Ator() ;
        
        try{
            dao = new AtorDAO();
            a1.setNome("Lomberd");
            a1.setSobrenome("Bernardo");
            a1.setDataEstreia( new Date(System.currentTimeMillis()));
            dao.salvar(a1);
            a1 = dao.selecionarPorID(1) ;
            
            System.out.println(a1.toString());
            
            for(Ator a3 : dao.selecionarTodos()) {
                System.out.println(a3.toString());
                a2 = a3 ;
            }
            a2.setNome("Conde");
            a2.setSobrenome("Joke");
            dao.atualizar(a2);
            
            System.out.println(dao.selecionarPorID(a2.getId()));
            
            dao.excluir(a2);
            
            for(Ator a3 : dao.selecionarTodos()) {
                System.out.println(a3.toString());
                a2 = a3 ;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (dao != null) {
                try {
                    dao.fecharConexao();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
            
        
    }
}

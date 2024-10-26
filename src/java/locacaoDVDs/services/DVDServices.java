/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaoDVDs.DAO.DVDDAO ;
import locacaoDVDs.Entidades.DVD ;
/**
 *
 * @author nicho
 */
public class DVDServices {
    public List<DVD> getTodos() {
        List<DVD> lista = new ArrayList<>() ;
        DVDDAO dao = null ;
        
        try{
            dao = new DVDDAO() ;
            lista = dao.selecionarTodos() ;
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
        return lista ;
    }
    
}

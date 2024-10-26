/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import locacaoDVDs.Entidades.Genero ;
import locacaoDVDs.DAO.GeneroDAO ;

/**
 *
 * @author nicho
 */
public class GeneroServices {
    
    public List<Genero> getTodos(){
        List<Genero> lista = new ArrayList<>() ;
        GeneroDAO dao = null ;
        
        try{
            dao = new GeneroDAO() ;
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

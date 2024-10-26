/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaoDVDs.DAO.AtorDAO;
import locacaoDVDs.Entidades.Ator;

/**
 *
 * @author nicho
 */
public class AtorServices {
    public List<Ator> getTodos() {
        AtorDAO dao = null ;
        List<Ator> lista = new ArrayList<>() ;
        
        try {
            dao = new AtorDAO();
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaoDVDs.DAO.ClassificacaoEtariaDAO ;
import locacaoDVDs.Entidades.ClassificacaoEtaria ;

/**
 *
 * @author nicho
 */
public class ClassificacaoEtariaServices {
    
    public List<ClassificacaoEtaria> getTodos() {
        ClassificacaoEtariaDAO dao = null ;
        List<ClassificacaoEtaria> lista = new ArrayList<>() ;
        
        try {
            dao = new ClassificacaoEtariaDAO() ;
            lista = dao.selecionarTodos() ;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            
            if (dao != null) {
                try{
                    dao.fecharConexao();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return lista ;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.DAO;

import java.sql.Connection ;
import locacaoDVDs.jdbc.ConnecitonFactory ;
import java.sql.SQLException ;
import java.util.List ;
/**
 *
 * @author nicho
 */
public abstract class dao<Tipo> {
    
    private Connection conexao ;
    
    public dao() throws SQLException {
        conexao = ConnecitonFactory.getConnection() ;
    }
    public Connection getConexao() {
        return conexao;
    }

    public void fecharConexao () throws SQLException {
        conexao.close();
    }
    
    public abstract void salvar(Tipo obj) throws SQLException;
    public abstract void atualizar(Tipo obj) throws SQLException;
    public abstract void excluir(Tipo obj) throws SQLException;
    public abstract List<Tipo> selecionarTodos() throws SQLException;
    public abstract Tipo selecionarPorID(int id) throws SQLException;
    
    
}

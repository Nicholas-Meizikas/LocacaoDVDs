/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.jdbc;

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
/**
 *
 * @author nicho
 */
public class ConnecitonFactory {
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mariadb://localhost/locacao_dvds",
                    "root",
                    "") ;
    }
}

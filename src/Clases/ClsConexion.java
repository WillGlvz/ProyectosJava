/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;
import java.sql.*;

/**
 *
 * @author Will Vasquez
 */
public class ClsConexion {public Connection conectar()
    {
        Connection cn = null; 
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=RealRentCar;integratedSecurity=true;");
             }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return cn;
    }
}

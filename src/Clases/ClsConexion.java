/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Will Vásquez
 */
public class ClsConexion {
    public Connection conectar(String base)
    {
        Connection cn = null; 
        try
        {
            Class.forName("org.mariadb.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/" + base,"root","admin123");
             }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return cn;
    }
}

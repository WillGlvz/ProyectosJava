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
 * @author Will Vasquez
 */
public class ClsConexion {
    public Connection conectar()
    {
        Connection cn = null; 
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(ClsSQLQuery.AutenticacionWindows2);
             }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return cn;
    }
    
    public Connection conectar2()
    {
        Connection cn = null; 
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(ClsBaseDatos.AutenticacionWindows);
             }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return cn;
    }
}

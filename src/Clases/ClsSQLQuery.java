/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Will Vasquez
 */
public class ClsSQLQuery {
    public static int ProCodigoUsuario;
    public static int ProTipoUsuario;
    public static String ProNombreUsuario;
    public static String ProNombresUsuario;
    public static String ProApellidosUsuario;
    public static String Url = "jdbc:sqlserver://192.168.0.1:1433;databaseName=EasyParkingDB;user=sa;password=1234;selectMethod=Direct;";
    public static String AutenticacionWindows2 = "jdbc:sqlserver://localhost:1433;databaseName=EasyParkingDB;integratedSecurity=true";
    public static Connection cn = null;
    ClsConexion con = new ClsConexion();
    int idioma;

    public int getIdioma() {
        return idioma;
    }

    public void setIdioma(int idioma) {
        this.idioma = idioma;
    }
    
    public static ResultSet MtoObtenerValor(PreparedStatement query) {
        ResultSet resultado = null;
        try {
            resultado = query.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return resultado;
    }
    
    public static JTable MtoCargarTabla(PreparedStatement query, JTable origen) {
        try {
            ResultSet rs = MtoObtenerValor(query);
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                   return false;
                }
            };
            ResultSetMetaData metaDatos = rs.getMetaData();
            int numeroColumnas = metaDatos.getColumnCount();
            Object[] etiquetas = new Object[numeroColumnas];
            for (int i = 0; i < numeroColumnas; i++) { 
                etiquetas[i] = metaDatos.getColumnLabel(i + 1);
            }
            modelo.setColumnIdentifiers(etiquetas);
            while (rs.next())
            { 
                Object [] fila = new Object[numeroColumnas];
                for (int i=0;i<numeroColumnas;i++) {
                    fila[i] = rs.getObject(i+1);
                }
                modelo.addRow(fila); 
            }
            origen.setModel(modelo);
            return origen;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return origen;
        }
    }
    
    public boolean ConsultarIdioma(){
        boolean resp = false;
        try {
            cn = con.conectar();
            String sql = "SELECT idioma FROM Lenguaje";
            try (PreparedStatement cmd = cn.prepareStatement(sql)) {
                ResultSet rs = cmd.executeQuery();
                if(rs.next()){
                    resp = true;
                    idioma = rs.getInt(1);
                }
            }
            cn.close();
        }catch(SQLException ex){System.out.println("Error: " + ex);}
        return resp;
    }
    
    public boolean CambiarIdioma(){
        boolean resp = false;
        try {
            cn = con.conectar();
            String sql = "UPDATE Lenguaje SET idioma = ?";
            try (PreparedStatement cmd = cn.prepareStatement(sql)) {
                cmd.setInt(1, idioma);
                if(!cmd.execute()){
                    resp = true;
                }
            }
            cn.close();
        }catch(SQLException ex){System.out.println("Error: " + ex.getMessage());}
        return resp;
    }
    
}

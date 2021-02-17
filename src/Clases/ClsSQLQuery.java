/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Will Vasquez
 */
public class ClsSQLQuery {
    public static int ProCodigoUsuario;
    public static String ProNombreUsuario;
    Connection cn;
    int codigo_usuario;
    String usuario;
    String correo;
    String contraseña;
    String foto;
    int codigo_tipo_usuario;

    public ClsSQLQuery() {
        cn = new ClsConexion().conectar();
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getCodigo_tipo_usuario() {
        return codigo_tipo_usuario;
    }

    public void setCodigo_tipo_usuario(int codigo_tipo_usuario) {
        this.codigo_tipo_usuario = codigo_tipo_usuario;
    }
    
    public boolean AgregarUsuario() {
        boolean resultado = false;
        try {
            String consulta = "INSERT INTO usuarios(usuariox, correo, contraseña, foto, codigo_tipo_usuario) VALUES(?, ?, ?, ?, ?)";
            try (PreparedStatement cmd = cn.prepareStatement(consulta)) {
                cmd.setString(1, usuario);
                cmd.setString(2, correo);
                cmd.setString(3, contraseña);
                cmd.setString(4, foto);
                cmd.setInt(5, codigo_tipo_usuario);
                resultado = !cmd.execute();
            }
            String sql = "SELECT MAX(codigo_usuario) FROM usuarios";
            try (PreparedStatement cmd = cn.prepareStatement(sql)) {
                try (ResultSet rs = cmd.executeQuery()) {
                    if(rs.next()) {
                        resultado = true;
                        codigo_usuario = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return resultado;
    }
    
    public boolean ConsultarUsuario() {
        boolean resultado = false;
        try {
            String sql = "SELECT * FROM usuarios where codigo_usuario = ?";
            try (PreparedStatement cmd = cn.prepareStatement(sql)) {
                cmd.setInt(1, codigo_usuario);
                try (ResultSet rs = cmd.executeQuery()) {
                    if(rs.next()) {
                        resultado = true;
                        codigo_usuario = rs.getInt(1);
                        usuario = rs.getString(2);
                        correo = rs.getString(3);
                        contraseña = rs.getString(4);
                        foto = rs.getString(5);
                        codigo_tipo_usuario = rs.getInt(6);
                    }
                }
            }
            cn.close();
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }
    
    public boolean ImagenUsuario() {
        boolean resultado = false;
        try {
            String consulta = "UPDATE usuarios SET foto = ? WHERE codigo_usuario = ?";
            try (PreparedStatement cmd = cn.prepareStatement(consulta)) {
                cmd.setString(1, foto);
                cmd.setInt(2, codigo_usuario);
                if(!cmd.execute()) {
                    resultado = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return resultado;
    }
    
    public int CantidadUsuario() {
        int resultado = 0;
        try {
            String sql = "SELECT COUNT(*) FROM usuarios";
            try (PreparedStatement cmd = cn.prepareStatement(sql)) {
                try (ResultSet rs = cmd.executeQuery()) {
                    if(rs.next()) {
                        resultado = rs.getInt(1);
                    }
                }
            }
            cn.close();
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
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
    
    public JComboBox comboboxUsuario(JComboBox lista) {
        lista.removeAllItems();
        try {
            String sql = "SELECT usuariox, codigo_usuario FROM usuarios";
            try (PreparedStatement cmd = cn.prepareStatement(sql)) {
                try (ResultSet rs = cmd.executeQuery()) {
                    while(rs.next()) {
                        lista.addItem(new ClsID(rs.getString(1), rs.getInt(2)));
                    }
                }
                cn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        lista.setSelectedIndex(-1);
        return lista;
    }
}

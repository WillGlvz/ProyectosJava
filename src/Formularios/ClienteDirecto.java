/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Clases.ClsConexion;
import Clases.ClsValidaciones;
import com.sun.awt.AWTUtilities;
import java.awt.HeadlessException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Will Vasquez
 */
public class ClienteDirecto extends javax.swing.JDialog {
int x,y;
DefaultTableModel modelo;
    /**
     * Creates new form ClienteDirecto
     * @param parent
     * @param modal
     */
    public ClienteDirecto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Registro de clientes directos");
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Diseño/Clientes.jpg")); 
        JLabel fondo= new JLabel(); fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuEmergente = new javax.swing.JPopupMenu();
        MenuLimpiar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcodigo = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtapellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdui = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        BtnAgregar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnConsultar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();

        MenuLimpiar.setText("Limpiar");
        MenuLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLimpiarActionPerformed(evt);
            }
        });
        MenuEmergente.add(MenuLimpiar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10), java.awt.Color.white)); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo:");

        txtcodigo.setEditable(false);
        txtcodigo.setEnabled(false);
        txtcodigo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombres:");

        txtnombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos:");

        txtapellidos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtapellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidosKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DUI:");

        txtdui.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtdui.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtduiKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefono:");

        txttelefono.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Direccion:");

        txtdireccion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtdui, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txttelefono)
                                .addGap(1, 1, 1)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tabla);

        BtnAgregar.setBackground(new java.awt.Color(0, 0, 0));
        BtnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregar.setText("Agregar");
        BtnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BtnAgregar.setContentAreaFilled(false);
        BtnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAgregar.setFocusable(false);
        BtnAgregar.setOpaque(true);
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnModificar.setBackground(new java.awt.Color(0, 0, 0));
        BtnModificar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnModificar.setForeground(new java.awt.Color(255, 255, 255));
        BtnModificar.setText("Modificar");
        BtnModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BtnModificar.setContentAreaFilled(false);
        BtnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnModificar.setFocusable(false);
        BtnModificar.setOpaque(true);
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnConsultar.setBackground(new java.awt.Color(0, 0, 0));
        BtnConsultar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        BtnConsultar.setText("Consultar");
        BtnConsultar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BtnConsultar.setContentAreaFilled(false);
        BtnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnConsultar.setFocusable(false);
        BtnConsultar.setOpaque(true);
        BtnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConsultarActionPerformed(evt);
            }
        });

        BtnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        BtnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        BtnEliminar.setText("Eliminar");
        BtnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BtnEliminar.setContentAreaFilled(false);
        BtnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEliminar.setFocusable(false);
        BtnEliminar.setOpaque(true);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(panelCurves1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelCurves1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        if(txtnombre.getText().isEmpty() || txtapellidos.getText().isEmpty() || txttelefono.getText().isEmpty() || txtdui.getText().isEmpty() || txtdireccion.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "No puedes dejar campos en blanco", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if (!ClsValidaciones.ComprobarNumeroTelefono(txttelefono.getText())) {
            JOptionPane.showMessageDialog(this, "Numero de telefono incorrecto", "AVISO", JOptionPane.CANCEL_OPTION);
            txttelefono.setText(null);
        }
        else{
            try {
                PreparedStatement st = cn.prepareStatement("SELECT nombres FROM cliente_directo WHERE nombres = ?");
                st.setString(1, txtnombre.getText());
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Ya existe este cliente", "AVISO", JOptionPane.CANCEL_OPTION);
                }
                st = cn.prepareStatement("INSERT INTO cliente_directo VALUES(?, ?, ?, ?, ?)");
                st.setString(1, txtnombre.getText());
                st.setString(2, txtapellidos.getText());
                st.setString(3, txtdui.getText());
                st.setString(4, txttelefono.getText());
                st.setString(5, txtdireccion.getText());
                st.executeUpdate();
                JOptionPane.showMessageDialog(this, "Datos agregados", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                MostrarDatos();
                limpiar();
            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConsultarActionPerformed
        MostrarDatos();
    }//GEN-LAST:event_BtnConsultarActionPerformed

    private void MenuLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLimpiarActionPerformed
        limpiar();
        Tabla.setModel(new DefaultTableModel());
    }//GEN-LAST:event_MenuLimpiarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        if("".equals(txtcodigo.getText())) {
            JOptionPane.showMessageDialog(this, "¡Debe realizar una consulta para eliminar!", "AVISO", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try{
            PreparedStatement st = cn.prepareStatement("DELETE FROM cliente_directo WHERE codigo_cliente = ?");
            st.setInt(1, Integer.parseInt(txtcodigo.getText()));
            int eliminar = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar?", "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(eliminar == 0){
                st.execute();
                    int filaselecionada= Tabla.getSelectedRow();
                    if(filaselecionada>=0){
                    modelo.removeRow(filaselecionada);
                    JOptionPane.showMessageDialog(this, "Datos eliminados");
                    limpiar();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Error al eliminar");
                    }
                }
            }catch(SQLException | NumberFormatException | HeadlessException e){
                JOptionPane.showMessageDialog(this, "ERROR: " + e, "AVISO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        if(txtnombre.getText().isEmpty() || txtapellidos.getText().isEmpty() || txttelefono.getText().isEmpty() || txtdui.getText().isEmpty() || txtdireccion.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "No puedes dejar campos en blanco", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if (!ClsValidaciones.ComprobarNumeroTelefono(txttelefono.getText())) {
            JOptionPane.showMessageDialog(this, "Numero de telefono incorrecto", "AVISO", JOptionPane.CANCEL_OPTION);
            txttelefono.setText(null);
        }
        else{
            try {
                PreparedStatement st = cn.prepareStatement("SELECT nombres FROM cliente_directo WHERE nombre = ? AND NOT codigo_cliente = ?");
                st.setString(1, txtnombre.getText());
                st.setInt(2, Integer.parseInt(txtcodigo.getText()));
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Ya existe este cliente", "AVISO", JOptionPane.CANCEL_OPTION);
                }
                else{
                    st = cn.prepareStatement("UPDATE cliente_directo SET nombres = ?, apellidos = ?, dui = ?, telefono = ?, direccion = ? WHERE codigo_cliente = ?");
                    st.setString(1, txtnombre.getText());
                    st.setString(2, txtapellidos.getText());
                    st.setString(3, txtdui.getText());
                    st.setString(4, txttelefono.getText());
                    st.setString(5, txtdireccion.getText());
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void txtduiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtduiKeyTyped
        if (txtdui.getText().length() == 10) {
            evt.consume();
        }
        else if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == '-')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtduiKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        if (txtnombre.getText().length() >= 80) {
            evt.consume();
        }
        char car = evt.getKeyChar();    
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)){
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosKeyTyped
        if (txtapellidos.getText().length() >= 50) {
            evt.consume();
        }
        char car = evt.getKeyChar();    
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)){
            evt.consume();
        }
    }//GEN-LAST:event_txtapellidosKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        if (txttelefono.getText().length() == 9) {
            evt.consume();
        }
        else if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == '-')) {
            evt.consume();
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        if (txtapellidos.getText().length() >= 100) {
            evt.consume();
        }
        char car = evt.getKeyChar();    
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)){
            evt.consume();
        }
    }//GEN-LAST:event_txtdireccionKeyTyped

    public void MostrarDatos(){
    modelo= new DefaultTableModel();
    modelo.addColumn("Codigo");
    modelo.addColumn("Nombres");
    modelo.addColumn("Apellidos");
    modelo.addColumn("DUI");
    modelo.addColumn("Telefono");
    modelo.addColumn("Direccion");
    Tabla.setModel(modelo);
    String sql="SELECT * FROM cliente_directo";
    String []datos = new String [6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                modelo.addRow(datos);
            }
            Tabla.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(AgenciaViaje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void limpiar(){
        txtapellidos.setText(null);
        txtcodigo.setText(null);
        txtdireccion.setText(null);
        txtdui.setText(null);
        txtnombre.setText(null);
        txttelefono.setText(null);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteDirecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteDirecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteDirecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteDirecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClienteDirecto dialog = new ClienteDirecto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnConsultar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JPopupMenu MenuEmergente;
    private javax.swing.JMenuItem MenuLimpiar;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private javax.swing.JTextField txtapellidos;
    private java.awt.TextField txtcodigo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtdui;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
ClsConexion cc= new ClsConexion();
Connection cn= cc.conectar();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Clases.ClsConexion;
import Clases.ClsSQLQuery;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Will Vasquez
 */
public class FrmMotocicletas extends javax.swing.JDialog {
String mark2;
    /**
     * Creates new form FrmMotocicletas
     * @param parent
     * @param modal
     */
    public FrmMotocicletas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Vehiculos VIP");
        setLocationRelativeTo(null);
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Diseño/Moto.jpeg")); 
        JLabel fondo= new JLabel(); fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        Tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            @SuppressWarnings({"null", "BroadCatchBlock", "TooBroadCatch"})
            public void valueChanged(ListSelectionEvent event) {
                try {
                    lblcodigo.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString());
                    lbltipo.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 1).toString());
                    lblplaca.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 2).toString());
                    lblmarca.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 3).toString());
                    lblmodelo.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 4).toString());
                    lblaño.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 5).toString());
                    lblprecio.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 6).toString());
                    lblalquiler.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 7).toString());
                    String Ubicacion = (new File("ImagenesMotos")).getAbsolutePath() + "\\" + Tabla.getValueAt(Tabla.getSelectedRow(), 8);
                    @SuppressWarnings("UnusedAssignment")
                    BufferedImage Imagen = null;
                    try {
                        Imagen = ImageIO.read(new File(Ubicacion));
                        Image ImagenRedimensionada;
                        ImagenRedimensionada = Imagen.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ImagenFinal = new ImageIcon(ImagenRedimensionada);  
                        lblPicture.setIcon(ImagenFinal);
                    }
                    catch (IOException e) {
                        try {
                            JOptionPane.showMessageDialog(null, "¡La imagen del vehiculo ha sido eliminada, considere modificarla!", "AVISO", JOptionPane.ERROR_MESSAGE);
                            Ubicacion = (new File("ImagenesMotos")).getAbsolutePath() + "\\error.png";
                            Imagen = ImageIO.read(new File(Ubicacion));
                            Image ImagenRedimensionada;
                            ImagenRedimensionada = Imagen.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon ImagenFinal = new ImageIcon(ImagenRedimensionada);  
                            lblPicture.setIcon(ImagenFinal);
                        }
                        catch (IOException a) {
                            lblPicture.setIcon(null);
                        }
                    }
                }
                catch (Exception e) {
                    lblcodigo.setText(null);
                    lbltipo.setText(null);
                    lblplaca.setText(null);
                    lblmarca.setText(null);
                    lblmodelo.setText(null);
                    lblaño.setText(null);
                    lblprecio.setText(null);
                    lblalquiler.setText(null);
                    lblPicture.setIcon(null);
                }
            }
        });
    }
    
     public String getMark2() {
        return mark2;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbldato = new javax.swing.JLabel();
        panelTranslucido1 = new org.edisoncor.gui.panel.PanelTranslucido();
        lblcodigo2 = new javax.swing.JLabel();
        lbltipo2 = new javax.swing.JLabel();
        lblplaca2 = new javax.swing.JLabel();
        lblmarca2 = new javax.swing.JLabel();
        lblmodelo2 = new javax.swing.JLabel();
        lblaño2 = new javax.swing.JLabel();
        lblprecio2 = new javax.swing.JLabel();
        lblalquiler2 = new javax.swing.JLabel();
        lblprecio = new javax.swing.JLabel();
        lblalquiler = new javax.swing.JLabel();
        lblaño = new javax.swing.JLabel();
        lblmodelo = new javax.swing.JLabel();
        lblmarca = new javax.swing.JLabel();
        lblplaca = new javax.swing.JLabel();
        lbltipo = new javax.swing.JLabel();
        BtnEscoger = new javax.swing.JButton();
        lblcodigo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblPicture = new javax.swing.JLabel();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        lbldato.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblcodigo2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblcodigo2.setForeground(new java.awt.Color(255, 255, 255));
        lblcodigo2.setText("Codigo:");

        lbltipo2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lbltipo2.setForeground(new java.awt.Color(255, 255, 255));
        lbltipo2.setText("Tipo vehiculo:");

        lblplaca2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblplaca2.setForeground(new java.awt.Color(255, 255, 255));
        lblplaca2.setText("N° matricula:");

        lblmarca2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblmarca2.setForeground(new java.awt.Color(255, 255, 255));
        lblmarca2.setText("Marca:");

        lblmodelo2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblmodelo2.setForeground(new java.awt.Color(255, 255, 255));
        lblmodelo2.setText("Modelo:");

        lblaño2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblaño2.setForeground(new java.awt.Color(255, 255, 255));
        lblaño2.setText("Año:");

        lblprecio2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblprecio2.setForeground(new java.awt.Color(255, 255, 255));
        lblprecio2.setText("Precio vehiculo(US$):");

        lblalquiler2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblalquiler2.setForeground(new java.awt.Color(255, 255, 255));
        lblalquiler2.setText("Precio alquiler(US$):");

        lblprecio.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblprecio.setForeground(new java.awt.Color(255, 255, 255));

        lblalquiler.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblalquiler.setForeground(new java.awt.Color(255, 255, 255));

        lblaño.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblaño.setForeground(new java.awt.Color(255, 255, 255));

        lblmodelo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblmodelo.setForeground(new java.awt.Color(255, 255, 255));

        lblmarca.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblmarca.setForeground(new java.awt.Color(255, 255, 255));

        lblplaca.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblplaca.setForeground(new java.awt.Color(255, 255, 255));

        lbltipo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbltipo.setForeground(new java.awt.Color(255, 255, 255));

        BtnEscoger.setBackground(new java.awt.Color(0, 0, 0));
        BtnEscoger.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnEscoger.setForeground(new java.awt.Color(255, 255, 255));
        BtnEscoger.setText("Aceptar");
        BtnEscoger.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BtnEscoger.setContentAreaFilled(false);
        BtnEscoger.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEscoger.setFocusable(false);
        BtnEscoger.setOpaque(true);
        BtnEscoger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnEscogerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnEscogerMouseExited(evt);
            }
        });
        BtnEscoger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEscogerActionPerformed(evt);
            }
        });

        lblcodigo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblcodigo.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelTranslucido1Layout = new javax.swing.GroupLayout(panelTranslucido1);
        panelTranslucido1.setLayout(panelTranslucido1Layout);
        panelTranslucido1Layout.setHorizontalGroup(
            panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucido1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnEscoger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTranslucido1Layout.createSequentialGroup()
                        .addComponent(lblprecio2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblprecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelTranslucido1Layout.createSequentialGroup()
                        .addComponent(lblalquiler2)
                        .addGap(15, 15, 15)
                        .addComponent(lblalquiler, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                    .addGroup(panelTranslucido1Layout.createSequentialGroup()
                        .addComponent(lblaño2)
                        .addGap(95, 95, 95)
                        .addComponent(lblaño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelTranslucido1Layout.createSequentialGroup()
                        .addComponent(lblmodelo2)
                        .addGap(76, 76, 76)
                        .addComponent(lblmodelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelTranslucido1Layout.createSequentialGroup()
                        .addComponent(lblmarca2)
                        .addGap(85, 85, 85)
                        .addComponent(lblmarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelTranslucido1Layout.createSequentialGroup()
                        .addComponent(lblplaca2)
                        .addGap(53, 53, 53)
                        .addComponent(lblplaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelTranslucido1Layout.createSequentialGroup()
                        .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltipo2)
                            .addComponent(lblcodigo2))
                        .addGap(47, 47, 47)
                        .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelTranslucido1Layout.setVerticalGroup(
            panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucido1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodigo2)
                    .addComponent(lblcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbltipo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbltipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblplaca2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblplaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblmarca2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblmarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblmodelo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblmodelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblaño2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblaño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblprecio2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblprecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblalquiler2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblalquiler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnEscoger, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Vehiculo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10), java.awt.Color.white)); // NOI18N
        jPanel1.setOpaque(false);

        lblPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelCurves1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCurves1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEscogerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEscogerMouseEntered
        BtnEscoger.setForeground(new java.awt.Color(51, 153, 255));
    }//GEN-LAST:event_BtnEscogerMouseEntered

    private void BtnEscogerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEscogerMouseExited
        BtnEscoger.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_BtnEscogerMouseExited

    private void BtnEscogerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEscogerActionPerformed
        if(lblcodigo.getText() == null){
            JOptionPane.showMessageDialog(this, "Debes seleccionar un vehiculo para alquilar", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else{
            try {
                int pregunta = JOptionPane.showConfirmDialog(this, "¿Desea llevar este vehiculo?", "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(pregunta == 0){
                    PreparedStatement st = cn.prepareStatement("SELECT marca + ', ' + modelo FROM motocicletas WHERE codigo_moto = ?");
                    st.setInt(1, Integer.parseInt(lblcodigo.getText()));
                    ResultSet rs = st.executeQuery();
                    rs.next();
                    String marca = rs.getString(1);
                    lbldato.setText(marca);
                    JOptionPane.showMessageDialog(this, "El vehiculo ha sido agregado a la orden");
                    mark2 = this.lbldato.getText();
                    this.dispose();
                }
            }catch(HeadlessException | SQLException | NumberFormatException e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_BtnEscogerActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        MostrarDatos();
    }//GEN-LAST:event_formWindowOpened

    void limpiar(){
        lblcodigo.setText(null);
        lbltipo.setText(null);
        lblplaca.setText(null);
        lblmarca.setText(null);
        lblmodelo.setText(null);
        lblaño.setText(null);
        lblprecio.setText(null);
        lblalquiler.setText(null);
        lblPicture.setIcon(null);
    }
    
    void MostrarDatos()
    {
        limpiar();
        try{
        PreparedStatement st = cn.prepareStatement("SELECT codigo_moto, tipo, placa, marca, modelo, año, CONVERT(decimal(7,2), precio_vehiculo, 0), CONVERT(decimal(7,2), precio_alquiler, 0), foto FROM motocicletas");
        ResultSet rs = st.executeQuery();
        rs.next();
        Tabla = ClsSQLQuery.MtoCargarTabla(st, Tabla);
        Tabla.getColumnModel().getColumn(0).setHeaderValue(lblcodigo2.getText());
        Tabla.getColumnModel().getColumn(1).setHeaderValue(lbltipo2.getText());
        Tabla.getColumnModel().getColumn(2).setHeaderValue(lblplaca2.getText());
        Tabla.getColumnModel().getColumn(3).setHeaderValue(lblmarca2.getText());
        Tabla.getColumnModel().getColumn(4).setHeaderValue(lblmodelo2.getText());
        Tabla.getColumnModel().getColumn(5).setHeaderValue(lblaño2.getText());
        Tabla.getColumnModel().getColumn(6).setHeaderValue(lblprecio2.getText());
        Tabla.getColumnModel().getColumn(7).setHeaderValue(lblalquiler2.getText());
        Tabla.getColumnModel().getColumn(8).setMinWidth(0);
        Tabla.getColumnModel().getColumn(8).setMaxWidth(0);
        }catch(SQLException e){
            System.out.println(e);
        }
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
            java.util.logging.Logger.getLogger(FrmMotocicletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMotocicletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMotocicletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMotocicletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmMotocicletas dialog = new FrmMotocicletas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnEscoger;
    private javax.swing.JTable Tabla;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JLabel lblalquiler;
    private javax.swing.JLabel lblalquiler2;
    private javax.swing.JLabel lblaño;
    private javax.swing.JLabel lblaño2;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lblcodigo2;
    private javax.swing.JLabel lbldato;
    private javax.swing.JLabel lblmarca;
    private javax.swing.JLabel lblmarca2;
    private javax.swing.JLabel lblmodelo;
    private javax.swing.JLabel lblmodelo2;
    private javax.swing.JLabel lblplaca;
    private javax.swing.JLabel lblplaca2;
    private javax.swing.JLabel lblprecio;
    private javax.swing.JLabel lblprecio2;
    private javax.swing.JLabel lbltipo;
    private javax.swing.JLabel lbltipo2;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelTranslucido panelTranslucido1;
    // End of variables declaration//GEN-END:variables
ClsConexion cc= new ClsConexion();
Connection cn= cc.conectar();
}

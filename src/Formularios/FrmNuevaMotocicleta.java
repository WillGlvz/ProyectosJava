/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Clases.ClsConexion;
import Clases.ClsSQLQuery;
import Clases.ClsSonidos;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Will Vasquez
 */
public class FrmNuevaMotocicleta extends javax.swing.JDialog {

    /**
     * Creates new form FrmNuevaMotocicleta
     * @param parent
     * @param modal
     */
    public FrmNuevaMotocicleta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Motocicletas");
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Diseño/Moto2.jpeg")); 
        JLabel fondo= new JLabel(); fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        FileFilter FiltroImagenes = new FileNameExtensionFilter("ImágenUsuario","png", "jpg", "jpeg");
        FileChooserAbrir.setFileFilter(FiltroImagenes);
        Tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            @SuppressWarnings({"null", "BroadCatchBlock", "TooBroadCatch"})
            public void valueChanged(ListSelectionEvent event) {
                try {
                    txtcodigo.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString());
                    lbltipo.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 1).toString());
                    txtmatricula.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 2).toString());
                    txtmarca.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 3).toString());
                    txtmodelo.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 4).toString());
                    txtaño.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 5).toString());
                    txtpreciovehiculo.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 6).toString());
                    txtprecioalquiler.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 7).toString());
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
                            JOptionPane.showMessageDialog(null, "¡La imagen asociada al vehiculo ha sido eliminada, considere modificarla!", "AVISO", JOptionPane.ERROR_MESSAGE);
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
                    txtcodigo.setText(null);
                    txtmatricula.setText(null);
                    txtmarca.setText(null);
                    txtmodelo.setText(null);
                    txtaño.setText(null);
                    txtprecioalquiler.setText(null);
                    txtpreciovehiculo.setText(null);
                    lblPicture.setIcon(null);
                }
            }
        });
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileChooserAbrir = new javax.swing.JFileChooser();
        panelTranslucido1 = new org.edisoncor.gui.panel.PanelTranslucido();
        lblcodigo = new javax.swing.JLabel();
        txtcodigo = new java.awt.TextField();
        lbltipo2 = new javax.swing.JLabel();
        lbltipo = new javax.swing.JLabel();
        lblmatricula = new javax.swing.JLabel();
        txtmatricula = new org.edisoncor.gui.textField.TextFieldRound();
        lblmarca = new javax.swing.JLabel();
        txtmarca = new org.edisoncor.gui.textField.TextFieldRound();
        lblmodelo = new javax.swing.JLabel();
        txtmodelo = new org.edisoncor.gui.textField.TextFieldRound();
        lblaño = new javax.swing.JLabel();
        txtaño = new org.edisoncor.gui.textField.TextFieldRound();
        lblpreciovehiculo = new javax.swing.JLabel();
        txtpreciovehiculo = new org.edisoncor.gui.textField.TextFieldRound();
        lblprecioalquiler = new javax.swing.JLabel();
        txtprecioalquiler = new org.edisoncor.gui.textField.TextFieldRound();
        jPanel1 = new javax.swing.JPanel();
        lblPicture = new javax.swing.JLabel();
        BtnExaminar = new org.edisoncor.gui.button.ButtonAction();
        BtnConsultar = new org.edisoncor.gui.button.ButtonAction();
        BtnAgregar = new org.edisoncor.gui.button.ButtonAction();
        BtnLimpiar = new org.edisoncor.gui.button.ButtonAction();
        BtnEliminar = new org.edisoncor.gui.button.ButtonAction();
        BtnModificar = new org.edisoncor.gui.button.ButtonAction();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblcodigo.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblcodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblcodigo.setText("Codigo:");

        txtcodigo.setEditable(false);
        txtcodigo.setEnabled(false);

        lbltipo2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lbltipo2.setForeground(new java.awt.Color(255, 255, 255));
        lbltipo2.setText("Tipo vehiculo:");

        lbltipo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbltipo.setForeground(new java.awt.Color(255, 255, 255));

        lblmatricula.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblmatricula.setForeground(new java.awt.Color(255, 255, 255));
        lblmatricula.setText("N° matricula:");

        txtmatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmatriculaKeyTyped(evt);
            }
        });

        lblmarca.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblmarca.setForeground(new java.awt.Color(255, 255, 255));
        lblmarca.setText("Marca:");

        lblmodelo.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblmodelo.setForeground(new java.awt.Color(255, 255, 255));
        lblmodelo.setText("Modelo:");

        lblaño.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblaño.setForeground(new java.awt.Color(255, 255, 255));
        lblaño.setText("Año:");

        txtaño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtañoKeyTyped(evt);
            }
        });

        lblpreciovehiculo.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblpreciovehiculo.setForeground(new java.awt.Color(255, 255, 255));
        lblpreciovehiculo.setText("Precio vehiculo(US$):");

        txtpreciovehiculo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpreciovehiculoFocusLost(evt);
            }
        });
        txtpreciovehiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpreciovehiculoKeyTyped(evt);
            }
        });

        lblprecioalquiler.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblprecioalquiler.setForeground(new java.awt.Color(255, 255, 255));
        lblprecioalquiler.setText("Precio alquiler(US$):");

        txtprecioalquiler.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtprecioalquilerFocusLost(evt);
            }
        });
        txtprecioalquiler.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioalquilerKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelTranslucido1Layout = new javax.swing.GroupLayout(panelTranslucido1);
        panelTranslucido1.setLayout(panelTranslucido1Layout);
        panelTranslucido1Layout.setHorizontalGroup(
            panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucido1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTranslucido1Layout.createSequentialGroup()
                        .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltipo2)
                            .addComponent(lblcodigo)
                            .addComponent(lblmatricula)
                            .addComponent(lblmarca)
                            .addComponent(lblmodelo))
                        .addGap(18, 18, 18)
                        .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmarca, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbltipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtmatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                            .addComponent(txtmodelo, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
                    .addGroup(panelTranslucido1Layout.createSequentialGroup()
                        .addComponent(lblprecioalquiler)
                        .addGap(23, 23, 23)
                        .addComponent(txtprecioalquiler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelTranslucido1Layout.createSequentialGroup()
                        .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblpreciovehiculo)
                            .addComponent(lblaño))
                        .addGap(18, 18, 18)
                        .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtaño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtpreciovehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelTranslucido1Layout.setVerticalGroup(
            panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucido1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcodigo))
                .addGap(18, 18, 18)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltipo2)
                    .addComponent(lbltipo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmatricula)
                    .addComponent(txtmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmarca)
                    .addComponent(txtmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmodelo)
                    .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblaño)
                    .addComponent(txtaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpreciovehiculo)
                    .addComponent(txtpreciovehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprecioalquiler)
                    .addComponent(txtprecioalquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(lblPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );

        BtnExaminar.setText("Examinar");
        BtnExaminar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExaminarActionPerformed(evt);
            }
        });

        BtnConsultar.setText("Consultar");
        BtnConsultar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConsultarActionPerformed(evt);
            }
        });

        BtnAgregar.setText("Agregar");
        BtnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnModificar.setText("Modificar");
        BtnModificar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnExaminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelCurves1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelCurves1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmatriculaKeyTyped
        if (txtmatricula.getText().length() == 6) {
            evt.consume();
        }
        else if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtmatriculaKeyTyped

    private void txtañoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtañoKeyTyped
        if (txtaño.getText().length() == 4) {
            evt.consume();
        }
        else if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtañoKeyTyped

    private void txtpreciovehiculoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpreciovehiculoFocusLost
        if(txtpreciovehiculo.getText().isEmpty()){
        }
        else{
            DecimalFormat df = new DecimalFormat("0.00");
            String precio = df.format(Double.parseDouble(txtpreciovehiculo.getText()));
            precio = precio.replaceAll(",",".");
            try {
                txtpreciovehiculo.setText(precio);
            }catch (NumberFormatException e) {txtpreciovehiculo.setText(null);}
        }
    }//GEN-LAST:event_txtpreciovehiculoFocusLost

    private void txtpreciovehiculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpreciovehiculoKeyTyped
        try {
            if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == '.')) {
                evt.consume();
            }Double.parseDouble(txtpreciovehiculo.getText() + evt.getKeyChar());
        }catch (NumberFormatException e) {evt.consume();}
    }//GEN-LAST:event_txtpreciovehiculoKeyTyped

    private void txtprecioalquilerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtprecioalquilerFocusLost
        if(txtprecioalquiler.getText().isEmpty()){
        }
        else{
            DecimalFormat df = new DecimalFormat("0.00");
            String precio = df.format(Double.parseDouble(txtprecioalquiler.getText()));
            precio = precio.replaceAll(",",".");
            try {
                txtprecioalquiler.setText(precio);
            }catch (NumberFormatException e) {txtprecioalquiler.setText(null);}
        }
    }//GEN-LAST:event_txtprecioalquilerFocusLost

    private void txtprecioalquilerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioalquilerKeyTyped
        try {
            if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == '.')) {
                evt.consume();
            }Double.parseDouble(txtprecioalquiler.getText() + evt.getKeyChar());
        }catch (NumberFormatException e) {evt.consume();}
    }//GEN-LAST:event_txtprecioalquilerKeyTyped

    private void BtnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExaminarActionPerformed
        int ArchivoAbierto;
        ArchivoAbierto = FileChooserAbrir.showOpenDialog(this);
        if (ArchivoAbierto == JFileChooser.APPROVE_OPTION) {
            File ArchivoSeleccionado = FileChooserAbrir.getSelectedFile();
            String ruta = ArchivoSeleccionado.getAbsolutePath();
            BufferedImage Imagen = null;
            try {
                Imagen = ImageIO.read(new File(ruta));
            }
            catch (IOException e) {
            }
            Image ImagenRedimensionada;
            ImagenRedimensionada = Imagen.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ImagenFinal = new ImageIcon(ImagenRedimensionada);
            lblPicture.setIcon(ImagenFinal);
        }
        else {
            lblPicture.setIcon(null);
        }
    }//GEN-LAST:event_BtnExaminarActionPerformed

    private void BtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConsultarActionPerformed
        MostrarDatos();
    }//GEN-LAST:event_BtnConsultarActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        if (txtmarca.getText().trim().equals("") || txtmodelo.getText().trim().equals("") || txtaño.getText().trim().equals("") || txtprecioalquiler.getText().trim().equals("") || txtpreciovehiculo.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "¡No puedes dejar campos en blanco!", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if(lblPicture.getIcon() == null){
            JOptionPane.showMessageDialog(this, "¡Debes agregar una imagen!", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if(txtaño.getText().length() < 4){
            JOptionPane.showMessageDialog(this, "¡El año debe ser de cuatro digitos!", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if(Double.parseDouble(txtpreciovehiculo.getText()) >  9999.00){
            JOptionPane.showMessageDialog(this, "El precio del vehiculo no puede ser mayor que $9999.00", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if (Double.parseDouble(txtpreciovehiculo.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "¡El precio del vehiculo debe ser mayor a 0!", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if (Double.parseDouble(txtprecioalquiler.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "¡El precio del alquiler debe ser mayor a 0!", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if(Double.parseDouble(txtprecioalquiler.getText()) >  999.00){
            JOptionPane.showMessageDialog(this, "El precio del alquiler no puede ser mayor que $999.00", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else{
            try {
                String url = "\\no_disponible.png";
                PreparedStatement st = cn.prepareStatement("SELECT placa FROM motocicletas WHERE placa = ?");
                st.setString(1, txtmatricula.getText());
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "¡Ingrese otro numero de placa!", "AVISO", JOptionPane.CANCEL_OPTION);
                }
                else{
                    st = cn.prepareStatement("INSERT INTO motocicletas VALUES(?, ?, ?, ?, ?, ?, ?, ?, 0)");
                    st.setString(1, lbltipo.getText());
                    st.setString(2, txtmatricula.getText());
                    st.setString(3, txtmarca.getText());
                    st.setString(4, txtmodelo.getText());
                    st.setString(5, txtaño.getText());
                    st.setDouble(6, Double.parseDouble(txtpreciovehiculo.getText()));
                    st.setDouble(7, Double.parseDouble(txtprecioalquiler.getText()));
                    st.setString(8, url);
                    st.executeUpdate();
                    ClsSonidos.AgregarDatos();
                    JOptionPane.showMessageDialog(this, "Vehiculo agregado con exito", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    MostrarDatos();
                    st = cn.prepareStatement("SELECT MAX(codigo_moto) FROM motocicletas");
                    ResultSet rs3 = st.executeQuery();
                    rs3.next();
                    txtcodigo.setText(rs3.getString(1));
                    if (lblPicture.getIcon() != null){
                        String destino = (new File("ImagenesMotos")).getAbsolutePath() + "\\" + txtcodigo.getText() + ".png";
                        ImageIcon ImagenLabel = (ImageIcon) lblPicture.getIcon();
                        BufferedImage Imagen_en_buffer = new BufferedImage(ImagenLabel.getIconWidth(), ImagenLabel.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                        ImagenLabel.paintIcon(null, Imagen_en_buffer.getGraphics(), 0, 0);
                        try {
                            File ImagenDestino = new File(destino);
                            ImageIO.write(Imagen_en_buffer, "png", ImagenDestino);
                        } catch (IOException e) {}
                        url = "\\" + txtcodigo.getText() + ".png";
                        st = cn.prepareStatement("UPDATE motocicletas SET foto = ? WHERE codigo_moto = ?");
                        st.setString(1, url);
                        st.setInt(2, Integer.parseInt(txtcodigo.getText()));
                        st.executeUpdate();
                    }
                }
            } catch (HeadlessException | NumberFormatException | SQLException e) {JOptionPane.showMessageDialog(this, "ERROR: " + e, "AVISO", JOptionPane.ERROR_MESSAGE);}
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        if(txtcodigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro para eliminar", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else{
            try {
                PreparedStatement st = cn.prepareStatement("DELETE FROM motocicletas WHERE codigo_moto = ?");
                st.setInt(1, Integer.parseInt(txtcodigo.getText()));
                int eliminar = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar?", "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(eliminar == 0){
                    st.execute();
                    String UbicacionImagen = (new File("ImagenesMotos")).getAbsolutePath() + "\\" + txtcodigo.getText() + ".png";
                    File Imagen = new File(UbicacionImagen);
                    Imagen.delete();
                    JOptionPane.showMessageDialog(this, "Vehiculo eliminado con exito");
                    MostrarDatos();
                }
            } catch (HeadlessException | NumberFormatException | SQLException e) {JOptionPane.showMessageDialog(this, "ERROR: " + e, "AVISO", JOptionPane.ERROR_MESSAGE);}
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        if (txtmarca.getText().trim().equals("") || txtmodelo.getText().trim().equals("") || txtaño.getText().trim().equals("") || txtprecioalquiler.getText().trim().equals("") || txtpreciovehiculo.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "¡No puedes dejar campos en blanco!", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if(lblPicture.getIcon() == null){
            JOptionPane.showMessageDialog(this, "¡Debes agregar una imagen!", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if(txtaño.getText().length() < 4){
            JOptionPane.showMessageDialog(this, "¡El año debe ser de cuatro digitos!", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if(Double.parseDouble(txtpreciovehiculo.getText()) >  9999.00){
            JOptionPane.showMessageDialog(this, "El precio del vehiculo no puede ser mayor que $9999.00", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if (Double.parseDouble(txtpreciovehiculo.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "¡El precio del vehiculo debe ser mayor a 0!", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if (Double.parseDouble(txtprecioalquiler.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "¡El precio del alquiler debe ser mayor a 0!", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if(Double.parseDouble(txtprecioalquiler.getText()) >  999.00){
            JOptionPane.showMessageDialog(this, "El precio del alquiler no puede ser mayor que $999.00", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else{
            try {
                String url;
                if (lblPicture.getIcon() != null) {
                    String destino = (new File("ImagenesMotos")).getAbsolutePath() + "\\" + txtcodigo.getText() + ".png";
                    ImageIcon ImagenLabel = (ImageIcon) lblPicture.getIcon();
                    BufferedImage Imagen_en_buffer = new BufferedImage(ImagenLabel.getIconWidth(), ImagenLabel.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                    ImagenLabel.paintIcon(null, Imagen_en_buffer.getGraphics(), 0, 0);
                    try {
                        File ImagenDestino = new File(destino);
                        ImageIO.write(Imagen_en_buffer, "png", ImagenDestino);
                    } catch (IOException e) {}
                    url = "\\" + txtcodigo.getText() + ".png";
                }
                else{
                    url = "\\no_disponible.png";
                }
                PreparedStatement st = cn.prepareStatement("UPDATE motocicletas SET placa = ?, marca = ?, modelo = ?, año = ?, precio_vehiculo = ?, precio_alquiler = ?, foto = ? WHERE codigo_moto = ?");
                st.setString(1, txtmatricula.getText());
                st.setString(2, txtmarca.getText());
                st.setString(3, txtmodelo.getText());
                st.setString(4, txtaño.getText());
                st.setDouble(5, Double.parseDouble(txtpreciovehiculo.getText()));
                st.setDouble(6, Double.parseDouble(txtprecioalquiler.getText()));
                st.setString(7, url);
                st.setInt(8, Integer.parseInt(txtcodigo.getText()));
                st.executeUpdate();
                ClsSonidos.ModificarDatos();
                JOptionPane.showMessageDialog(this, "Datos del vehiculo modificados", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                MostrarDatos();
            } catch (HeadlessException | NumberFormatException | SQLException e) {JOptionPane.showMessageDialog(this,"ERROR: " +  e, "AVISO", JOptionPane.ERROR_MESSAGE);}
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    void Limpiar(){
        txtcodigo.setText(null);
        txtmatricula.setText(null);
        txtmarca.setText(null);
        txtmodelo.setText(null);
        txtaño.setText(null);
        txtprecioalquiler.setText(null);
        txtpreciovehiculo.setText(null);
        lblPicture.setIcon(null);
    }
    
    void MostrarDatos()
    {
        Limpiar();
        try{
        PreparedStatement st = cn.prepareStatement("SELECT codigo_moto, tipo, placa, marca, modelo, año, CONVERT(decimal(7,2), precio_vehiculo, 0), CONVERT(decimal(7,2), precio_alquiler, 0), foto FROM motocicletas");
        ResultSet rs = st.executeQuery();
        rs.next();
        Tabla = ClsSQLQuery.MtoCargarTabla(st, Tabla);
        Tabla.getColumnModel().getColumn(0).setHeaderValue(lblcodigo.getText());
        Tabla.getColumnModel().getColumn(1).setHeaderValue(lbltipo2.getText());
        Tabla.getColumnModel().getColumn(2).setHeaderValue(lblmatricula.getText());
        Tabla.getColumnModel().getColumn(3).setHeaderValue(lblmarca.getText());
        Tabla.getColumnModel().getColumn(4).setHeaderValue(lblmodelo.getText());
        Tabla.getColumnModel().getColumn(5).setHeaderValue(lblaño.getText());
        Tabla.getColumnModel().getColumn(6).setHeaderValue(lblpreciovehiculo.getText());
        Tabla.getColumnModel().getColumn(7).setHeaderValue(lblprecioalquiler.getText());
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
            java.util.logging.Logger.getLogger(FrmNuevaMotocicleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNuevaMotocicleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNuevaMotocicleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNuevaMotocicleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmNuevaMotocicleta dialog = new FrmNuevaMotocicleta(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.button.ButtonAction BtnAgregar;
    private org.edisoncor.gui.button.ButtonAction BtnConsultar;
    private org.edisoncor.gui.button.ButtonAction BtnEliminar;
    private org.edisoncor.gui.button.ButtonAction BtnExaminar;
    private org.edisoncor.gui.button.ButtonAction BtnLimpiar;
    private org.edisoncor.gui.button.ButtonAction BtnModificar;
    private javax.swing.JFileChooser FileChooserAbrir;
    private javax.swing.JTable Tabla;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JLabel lblaño;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lblmarca;
    private javax.swing.JLabel lblmatricula;
    private javax.swing.JLabel lblmodelo;
    private javax.swing.JLabel lblprecioalquiler;
    private javax.swing.JLabel lblpreciovehiculo;
    private javax.swing.JLabel lbltipo;
    private javax.swing.JLabel lbltipo2;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelTranslucido panelTranslucido1;
    private org.edisoncor.gui.textField.TextFieldRound txtaño;
    private java.awt.TextField txtcodigo;
    private org.edisoncor.gui.textField.TextFieldRound txtmarca;
    private org.edisoncor.gui.textField.TextFieldRound txtmatricula;
    private org.edisoncor.gui.textField.TextFieldRound txtmodelo;
    private org.edisoncor.gui.textField.TextFieldRound txtprecioalquiler;
    private org.edisoncor.gui.textField.TextFieldRound txtpreciovehiculo;
    // End of variables declaration//GEN-END:variables
ClsConexion cc= new ClsConexion();
Connection cn= cc.conectar();
}

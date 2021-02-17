/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Clases.ClsConexion;
import Clases.ClsSQLQuery;
import com.sun.awt.AWTUtilities;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Will Vasquez
 */
public class Vehiculos extends javax.swing.JDialog {
int x,y;
    /**
     * Creates new form Vehiculos
     * @param parent
     * @param modal
     */
    public Vehiculos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Registro de vehiculos");
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Diseño/Vehiculos.jpg")); 
        JLabel fondo= new JLabel(); fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        FileFilter FiltroImagenes = new FileNameExtensionFilter("ImagenVehiculos","png", "jpg", "jpeg");
        FileChooserAbrir.setFileFilter(FiltroImagenes);
        Tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            @SuppressWarnings({"null", "BroadCatchBlock", "TooBroadCatch"})
            public void valueChanged(ListSelectionEvent event) {
                try {
                    txtcodigo.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString());
                    cmbtipo.setSelectedItem(Tabla.getValueAt(Tabla.getSelectedRow(), 1).toString());
                    txtplaca.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 2).toString());
                    txtmarca.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 3).toString());
                    txtmodelo.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 4).toString());
                    txtaño.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 5).toString());
                    txtprecio.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 6).toString());
                    String Ubicacion = (new File("ImagenVehiculos")).getAbsolutePath() + "\\" + Tabla.getValueAt(Tabla.getSelectedRow(), 7);
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
                        System.out.println(e);
                        try {
                            JOptionPane.showMessageDialog(null, "¡La imagen del vehiculo ha sido eliminada, considere modificarla!", "AVISO", JOptionPane.ERROR_MESSAGE);
                            Ubicacion = (new File("ImagenVehiculos")).getAbsolutePath() + "\\error.png";
                            Imagen = ImageIO.read(new File(Ubicacion));
                            Image ImagenRedimensionada;
                            ImagenRedimensionada = Imagen.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon ImagenFinal = new ImageIcon(ImagenRedimensionada);  
                            lblPicture.setIcon(ImagenFinal);
                        }
                        catch (IOException a) {
                            lblPicture.setIcon(null);
                            System.out.println(a);
                        }
                    }
                }
                catch (Exception e) {
                    txtcodigo.setText(null);
                    txtplaca.setText(null);
                    txtmarca.setText(null);
                    txtmodelo.setText(null);
                    txtaño.setText(null);
                    txtprecio.setText(null);
                    lblPicture.setIcon(null);
                    System.out.println(e);
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
        jPanel1 = new javax.swing.JPanel();
        lblcodigo = new javax.swing.JLabel();
        txtcodigo = new java.awt.TextField();
        lblplaca = new javax.swing.JLabel();
        txtplaca = new javax.swing.JTextField();
        lblmarca = new javax.swing.JLabel();
        txtmarca = new javax.swing.JTextField();
        lblmodelo = new javax.swing.JLabel();
        txtmodelo = new javax.swing.JTextField();
        lblaño = new javax.swing.JLabel();
        txtaño = new javax.swing.JTextField();
        lblprecio = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        lbltipo = new javax.swing.JLabel();
        cmbtipo = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        lblPicture = new javax.swing.JLabel();
        BtnExaminar = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnConsultar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10), java.awt.Color.white)); // NOI18N
        jPanel1.setOpaque(false);

        lblcodigo.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblcodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblcodigo.setText("Codigo:");

        txtcodigo.setEditable(false);
        txtcodigo.setEnabled(false);
        txtcodigo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        lblplaca.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblplaca.setForeground(new java.awt.Color(255, 255, 255));
        lblplaca.setText("N° placa:");

        txtplaca.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtplaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtplacaKeyTyped(evt);
            }
        });

        lblmarca.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblmarca.setForeground(new java.awt.Color(255, 255, 255));
        lblmarca.setText("Marca:");

        txtmarca.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtmarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmarcaKeyTyped(evt);
            }
        });

        lblmodelo.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblmodelo.setForeground(new java.awt.Color(255, 255, 255));
        lblmodelo.setText("Modelo:");

        txtmodelo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtmodelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmodeloKeyTyped(evt);
            }
        });

        lblaño.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblaño.setForeground(new java.awt.Color(255, 255, 255));
        lblaño.setText("Año:");

        txtaño.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtaño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtañoKeyTyped(evt);
            }
        });

        lblprecio.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblprecio.setForeground(new java.awt.Color(255, 255, 255));
        lblprecio.setText("Precio(US$):");

        txtprecio.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtprecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtprecioFocusLost(evt);
            }
        });
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });

        lbltipo.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lbltipo.setForeground(new java.awt.Color(255, 255, 255));
        lbltipo.setText("Tipo uso:");

        cmbtipo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblcodigo)
                            .addComponent(lbltipo))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbtipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblplaca)
                                    .addComponent(lblmarca)
                                    .addComponent(lblmodelo))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmodelo)
                                    .addComponent(txtplaca)
                                    .addComponent(txtmarca)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblprecio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblaño)
                                        .addGap(47, 47, 47)
                                        .addComponent(txtaño, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 125, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcodigo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltipo)
                    .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblplaca)
                    .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmarca)
                    .addComponent(txtmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmodelo)
                    .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblaño)
                    .addComponent(txtaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprecio)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Imagen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10), java.awt.Color.white)); // NOI18N
        jPanel2.setOpaque(false);

        BtnExaminar.setBackground(new java.awt.Color(0, 0, 0));
        BtnExaminar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnExaminar.setForeground(new java.awt.Color(255, 255, 255));
        BtnExaminar.setText("Examinar");
        BtnExaminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BtnExaminar.setContentAreaFilled(false);
        BtnExaminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnExaminar.setFocusable(false);
        BtnExaminar.setOpaque(true);
        BtnExaminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnExaminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnExaminarMouseExited(evt);
            }
        });
        BtnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExaminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnExaminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnAgregar.setBackground(new java.awt.Color(0, 0, 0));
        BtnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregar.setText("Agregar");
        BtnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BtnAgregar.setContentAreaFilled(false);
        BtnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAgregar.setFocusable(false);
        BtnAgregar.setOpaque(true);
        BtnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnAgregarMouseExited(evt);
            }
        });
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
        BtnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnModificarMouseExited(evt);
            }
        });
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
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
        BtnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnEliminarMouseExited(evt);
            }
        });
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
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
        BtnConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnConsultarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnConsultarMouseExited(evt);
            }
        });
        BtnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConsultarActionPerformed(evt);
            }
        });

        BtnLimpiar.setBackground(new java.awt.Color(0, 0, 0));
        BtnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BtnLimpiar.setContentAreaFilled(false);
        BtnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLimpiar.setFocusable(false);
        BtnLimpiar.setOpaque(true);
        BtnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnLimpiarMouseExited(evt);
            }
        });
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
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
        Tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //JFormattedTextField Nulo =((JSpinner.DefaultEditor)SpinnerCantidad.getEditor()).getTextField(); 
        //Nulo.setEditable(false);
        CargarDatos();
        cmbtipo.setSelectedIndex(-1);
    }//GEN-LAST:event_formWindowOpened

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        if("".equals(txtplaca.getText().trim()) || "".equals(txtmodelo.getText().trim()) || "".equals(txtmarca.getText().trim()) || "".equals(txtaño.getText().trim()) || "".equals(txtprecio.getText().trim())){
            JOptionPane.showMessageDialog(this, "No puedes dejar campos en blanco", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if(cmbtipo.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(this, "Debes seleccionar un tipo", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if(lblPicture.getIcon() == null){
            JOptionPane.showMessageDialog(this, "Debes subir una imagen para el vehiculo", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if (Double.parseDouble(txtprecio.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "¡El precio del alquiler debe ser mayor a 0!", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else{
            try {
                String url = "\\no_disponible.png";
                PreparedStatement st = cn.prepareStatement("SELECT numero_placa, modelo FROM vehiculos WHERE numero_placa = ? AND modelo = ?");
                st.setString(1, txtplaca.getText());
                st.setString(2, txtmodelo.getText());
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "El numero de placa o modelo ya existen", "AVISO", JOptionPane.CANCEL_OPTION);
                }
                else{
                    st = cn.prepareStatement("SELECT codigo_tipo_vehiculo FROM tipo_vehiculo WHERE nombre = ?");
                    st.setString(1, cmbtipo.getSelectedItem().toString());
                    ResultSet rs2 = st.executeQuery();
                    rs2.next();
                    String tipo_uso = rs2.getString(1);
                    st = cn.prepareStatement("INSERT INTO vehiculos(numero_placa, marca, modelo, año, precio, foto, estado, codigo_tipo_vehiculo) VALUES(?, ?, ?, ?, ?, ?, 1, ?)");
                    st.setString(1, txtplaca.getText());
                    st.setString(2, txtmarca.getText());
                    st.setString(3, txtmodelo.getText());
                    st.setString(4, txtaño.getText());
                    st.setDouble(5, Double.parseDouble(txtprecio.getText()));
                    st.setString(6, url);
                    st.setInt(7, Integer.parseInt(tipo_uso));
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Datos Agregados", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    st = cn.prepareStatement("SELECT MAX(codigo_vehiculo) FROM vehiculos");
                    ResultSet rs3 = st.executeQuery();
                    rs3.next();
                    txtcodigo.setText(rs3.getString(1));
                    if (lblPicture.getIcon() != null){
                    String destino = (new File("ImagenVehiculos")).getAbsolutePath() + "\\" + txtcodigo.getText() + ".png";
                    ImageIcon ImagenLabel = (ImageIcon) lblPicture.getIcon();
                    BufferedImage Imagen_en_buffer = new BufferedImage(ImagenLabel.getIconWidth(), ImagenLabel.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                    ImagenLabel.paintIcon(null, Imagen_en_buffer.getGraphics(), 0, 0);
                    try {
                       File ImagenDestino = new File(destino);
                       ImageIO.write(Imagen_en_buffer, "png", ImagenDestino);
                    } catch (IOException a) {}
                       url = "\\" + txtcodigo.getText() + ".png";
                       st = cn.prepareStatement("UPDATE vehiculos SET foto = ? WHERE codigo_vehiculo = ?");
                       st.setString(1, url);
                       st.setInt(2, Integer.parseInt(txtcodigo.getText()));
                       st.executeUpdate();
                       MostrarDatos();
                       RevisionVehiculos obj = new RevisionVehiculos(null, true);
                       obj.setVisible(true);
                   }
                }
            } catch (SQLException | HeadlessException | NumberFormatException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

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

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
        try {
            if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == '.')) {
                evt.consume();
            }
            Double.parseDouble(txtprecio.getText() + evt.getKeyChar());
        }
        catch (NumberFormatException e) {
            evt.consume();
        }
    }//GEN-LAST:event_txtprecioKeyTyped

    private void txtprecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtprecioFocusLost
        if(txtprecio.getText().isEmpty()){
        }
        else{
        DecimalFormat df = new DecimalFormat("0.00");
        String precio = df.format(Double.parseDouble(txtprecio.getText()));
        precio = precio.replaceAll(",",".");
        try {
            txtprecio.setText(precio);
        }
        catch (NumberFormatException e) {
            txtprecio.setText(null);
        }
        }
    }//GEN-LAST:event_txtprecioFocusLost

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        if(txtcodigo.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro para modificar", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else{
            try {
                PreparedStatement st = cn.prepareStatement("DELETE FROM vehiculos WHERE codigo_vehiculo = ?");
                st.setInt(1, Integer.parseInt(txtcodigo.getText()));
                int eliminar = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar?", "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(eliminar == 0){
                st.execute();
                String UbicacionImagen = (new File("ImagenVehiculos")).getAbsolutePath() + "\\" + txtcodigo.getText() + ".png";
                File Imagen = new File(UbicacionImagen);
                JOptionPane.showMessageDialog(this, "Datos eliminados", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                Imagen.delete();
                MostrarDatos();
                }
            } catch (NumberFormatException | SQLException e) {
            }
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        limpiar();
        limpiarTabla();
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        if("".equals(txtplaca.getText().trim()) || "".equals(txtmodelo.getText().trim()) || "".equals(txtmarca.getText().trim()) || "".equals(txtaño.getText().trim()) || "".equals(txtprecio.getText().trim())){
            JOptionPane.showMessageDialog(this, "No puedes dejar campos en blanco", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if(cmbtipo.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(this, "Debes seleccionar un tipo", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if(lblPicture.getIcon() == null){
            JOptionPane.showMessageDialog(this, "Debes subir una imagen para el vehiculo", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if (Double.parseDouble(txtprecio.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "¡El precio del alquiler debe ser mayor a 0!", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else{
            try {
                String url;
                    if (lblPicture.getIcon() != null) {
                        String destino = (new File("ImagenVehiculos")).getAbsolutePath() + "\\" + txtcodigo.getText() + ".png";
                        ImageIcon ImagenLabel = (ImageIcon) lblPicture.getIcon();
                        BufferedImage Imagen_en_buffer = new BufferedImage(ImagenLabel.getIconWidth(), ImagenLabel.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                        ImagenLabel.paintIcon(null, Imagen_en_buffer.getGraphics(), 0, 0);
                        try {
                            File ImagenDestino = new File(destino);
                            ImageIO.write(Imagen_en_buffer, "png", ImagenDestino);
                        }
                        catch (IOException e) { }
                        url = "\\" + txtcodigo.getText() + ".png";
                    }
                    else
                    {
                        url = "\\no_disponible.png";
                    }
                    PreparedStatement st = cn.prepareStatement("SELECT codigo_tipo_vehiculo FROM tipo_vehiculo WHERE nombre = ?");
                    st.setString(1, cmbtipo.getSelectedItem().toString());
                    ResultSet rs2 = st.executeQuery();
                    rs2.next();
                    String tipo_uso = rs2.getString(1);
                    st = cn.prepareStatement("UPDATE vehiculos SET numero_placa = ?, marca = ?, modelo = ?, año = ?, precio = ?, foto = ?, estado = 1,  codigo_tipo_vehiculo = ? WHERE codigo_vehiculo = ?");
                    st.setString(1, txtplaca.getText());
                    st.setString(2, txtmarca.getText());
                    st.setString(3, txtmodelo.getText());
                    st.setString(4, txtaño.getText());
                    st.setDouble(5, Double.parseDouble(txtprecio.getText()));
                    st.setString(6, url);
                    st.setInt(7, Integer.parseInt(tipo_uso));
                    st.setInt(8, Integer.parseInt(txtcodigo.getText()));
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Datos modificados");
                    MostrarDatos();
            } catch (HeadlessException | NumberFormatException | SQLException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void txtplacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtplacaKeyTyped
        if (txtplaca.getText().length() == 8) {
            evt.consume();
        }
        else if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == '-')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtplacaKeyTyped

    private void txtmarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmarcaKeyTyped
        if (txtmarca.getText().length() == 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtmarcaKeyTyped

    private void txtmodeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmodeloKeyTyped
        if (txtmodelo.getText().length() == 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtmodeloKeyTyped

    private void txtañoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtañoKeyTyped
        if (txtaño.getText().length() == 4) {
            evt.consume();
        }
        else if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtañoKeyTyped

    private void BtnExaminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnExaminarMouseEntered
        BtnExaminar.setForeground(new java.awt.Color(51, 153, 255));
    }//GEN-LAST:event_BtnExaminarMouseEntered

    private void BtnAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAgregarMouseEntered
        BtnAgregar.setForeground(new java.awt.Color(51, 153, 255));
    }//GEN-LAST:event_BtnAgregarMouseEntered

    private void BtnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnModificarMouseEntered
        BtnModificar.setForeground(new java.awt.Color(51, 153, 255));
    }//GEN-LAST:event_BtnModificarMouseEntered

    private void BtnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEliminarMouseEntered
        BtnEliminar.setForeground(new java.awt.Color(51, 153, 255));
    }//GEN-LAST:event_BtnEliminarMouseEntered

    private void BtnConsultarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnConsultarMouseEntered
        BtnConsultar.setForeground(new java.awt.Color(51, 153, 255));
    }//GEN-LAST:event_BtnConsultarMouseEntered

    private void BtnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLimpiarMouseEntered
        BtnLimpiar.setForeground(new java.awt.Color(51, 153, 255));
    }//GEN-LAST:event_BtnLimpiarMouseEntered

    private void BtnExaminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnExaminarMouseExited
        BtnExaminar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_BtnExaminarMouseExited

    private void BtnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAgregarMouseExited
        BtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_BtnAgregarMouseExited

    private void BtnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnModificarMouseExited
        BtnModificar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_BtnModificarMouseExited

    private void BtnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEliminarMouseExited
        BtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_BtnEliminarMouseExited

    private void BtnConsultarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnConsultarMouseExited
        BtnConsultar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_BtnConsultarMouseExited

    private void BtnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLimpiarMouseExited
        BtnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_BtnLimpiarMouseExited

    void limpiar(){
        txtcodigo.setText(null);
        txtplaca.setText(null);
        txtmarca.setText(null);
        txtmodelo.setText(null);
        txtaño.setText(null);
        txtprecio.setText(null);
        lblPicture.setIcon(null);
        cmbtipo.setSelectedIndex(-1);
    }
    
    void limpiarTabla(){
        Tabla.setModel(new DefaultTableModel());
    }
    
    void MostrarDatos()
    {
        limpiar();
        try{
        PreparedStatement st = cn.prepareStatement("SELECT codigo_vehiculo, nombre, numero_placa, marca, modelo, año, format(precio, '0.00'), foto FROM vehiculos AS v, tipo_vehiculo AS t WHERE v.codigo_tipo_vehiculo=t.codigo_tipo_vehiculo");
        ResultSet rs = st.executeQuery();
        rs.next();
        Tabla = ClsSQLQuery.MtoCargarTabla(st, Tabla);
        Tabla.getColumnModel().getColumn(0).setHeaderValue(lblcodigo.getText());
        Tabla.getColumnModel().getColumn(1).setHeaderValue(lbltipo.getText());
        Tabla.getColumnModel().getColumn(2).setHeaderValue(lblplaca.getText());
        Tabla.getColumnModel().getColumn(3).setHeaderValue(lblmarca.getText());
        Tabla.getColumnModel().getColumn(4).setHeaderValue(lblmodelo.getText());
        Tabla.getColumnModel().getColumn(5).setHeaderValue(lblaño.getText());
        Tabla.getColumnModel().getColumn(6).setHeaderValue(lblprecio.getText());
        Tabla.getColumnModel().getColumn(7).setMinWidth(0);
        Tabla.getColumnModel().getColumn(7).setMaxWidth(0);
        }catch(SQLException e){
        }
    }
    
    public void CargarDatos() 
    {
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre FROM tipo_vehiculo ORDER BY nombre");
            cmbtipo.removeAllItems();
            while(rs.next())
            {
                cmbtipo.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vehiculos.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Vehiculos dialog = new Vehiculos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnExaminar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JFileChooser FileChooserAbrir;
    private javax.swing.JTable Tabla;
    private javax.swing.JComboBox cmbtipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JLabel lblaño;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lblmarca;
    private javax.swing.JLabel lblmodelo;
    private javax.swing.JLabel lblplaca;
    private javax.swing.JLabel lblprecio;
    private javax.swing.JLabel lbltipo;
    private javax.swing.JTextField txtaño;
    private java.awt.TextField txtcodigo;
    private javax.swing.JTextField txtmarca;
    private javax.swing.JTextField txtmodelo;
    private javax.swing.JTextField txtplaca;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
ClsConexion cc= new ClsConexion();
Connection cn= cc.conectar();
}

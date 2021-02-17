/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Clases.ClsConexion;
import Clases.ClsSQLQuery;
import Clases.ClsSonidos;
import Clases.ClsValidaciones;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Will Vasquez
 */
public final class FrmUsuarios extends javax.swing.JDialog {
DefaultTableModel modelo;
    /**
     * Creates new form FrmUsuarios
     * @param parent
     * @param modal
     */
    public FrmUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.DARK_GRAY);
        FileFilter FiltroImagenes = new FileNameExtensionFilter("ImágenUsuario","png", "jpg", "jpeg");
        FileChooserAbrir.setFileFilter(FiltroImagenes);
        this.JDCNacimiento.setEnabled(false);
        this.JDCNacimiento.getCalendarButton().setEnabled(true);
        GregorianCalendar fechaMaxima = new GregorianCalendar((Calendar.getInstance().get(Calendar.YEAR))-9,(Calendar.getInstance().get(Calendar.MONTH))-12,(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
        JDCNacimiento.setMaxSelectableDate(fechaMaxima.getTime());
        GregorianCalendar fechaMinima = new GregorianCalendar((Calendar.getInstance().get(Calendar.YEAR))-99,(Calendar.getInstance().get(Calendar.MONTH))-12,(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
        JDCNacimiento.setMinSelectableDate(fechaMinima.getTime());
        JDCNacimiento.setDate(fechaMaxima.getTime());
        Tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            @SuppressWarnings({"null", "BroadCatchBlock", "TooBroadCatch"})
            public void valueChanged(ListSelectionEvent event) {
                try {
                    txtcodigo.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString());
                    txtnombres.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 1).toString());
                    txtapellidos.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 2).toString());
                    JDCNacimiento.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(Tabla.getValueAt(Tabla.getSelectedRow(), 3).toString()));
                    txtusuario.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 4).toString());
                    txtcorreo.setText(Tabla.getValueAt(Tabla.getSelectedRow(), 5).toString());
                    cmbtipousuario.setSelectedItem(Tabla.getValueAt(Tabla.getSelectedRow(), 6).toString());
                    String Ubicacion = (new File("ImagenUsuario")).getAbsolutePath() + "\\" + Tabla.getValueAt(Tabla.getSelectedRow(), 7);
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
                            JOptionPane.showMessageDialog(null, "¡La imagen asociada a tu perfil ha sido eliminada, considere modificarla!", "AVISO", JOptionPane.ERROR_MESSAGE);
                            Ubicacion = (new File("ImagenUsuario")).getAbsolutePath() + "\\error.png";
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
                catch (ParseException | HeadlessException e) {
                    txtcodigo.setText(null);
                    txtnombres.setText(null);
                    txtapellidos.setText(null);
                    txtusuario.setText(null);
                    txtcorreo.setText(null);
                    txtcontra.setText(null);
                    txtconfirmar.setText(null);
                    cmbtipousuario.setSelectedItem(null);
                    lblPicture.setIcon(null);
                }
            }
        });
        ClsSQLQuery obj = new ClsSQLQuery();
        if(obj.ConsultarIdioma()){
            if(obj.getIdioma() == 1){
                IdiomaEspañol();
            }
            else{
                IdiomaEnglish();
            }
        }
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
        FileChooserAbrir = new javax.swing.JFileChooser();
        panelTranslucido1 = new org.edisoncor.gui.panel.PanelTranslucido();
        lblcodigo = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        txtusuario = new org.edisoncor.gui.textField.TextFieldRound();
        lblcorreo = new javax.swing.JLabel();
        txtcorreo = new org.edisoncor.gui.textField.TextFieldRound();
        lblcontraseña = new javax.swing.JLabel();
        txtcontra = new org.edisoncor.gui.passwordField.PasswordFieldRound();
        lblconfirmar = new javax.swing.JLabel();
        txtcodigo = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtconfirmar = new org.edisoncor.gui.passwordField.PasswordFieldRound();
        lbltipo = new javax.swing.JLabel();
        cmbtipousuario = new javax.swing.JComboBox();
        lblnombres = new javax.swing.JLabel();
        lblapellidos = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        JDCNacimiento = new com.toedter.calendar.JDateChooser();
        txtapellidos = new org.edisoncor.gui.textField.TextFieldRound();
        txtnombres = new org.edisoncor.gui.textField.TextFieldRound();
        BtnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        BtnModificar = new javax.swing.JButton();
        BtnConsultar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        jPanel1 = new javax.swing.JPanel();
        BtnFoto = new org.edisoncor.gui.button.ButtonSeven();
        BtnExaminar = new org.edisoncor.gui.button.ButtonSeven();
        lblPicture = new javax.swing.JLabel();

        MenuLimpiar.setText("Limpiar");
        MenuLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLimpiarActionPerformed(evt);
            }
        });
        MenuEmergente.add(MenuLimpiar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(645, 489));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblcodigo.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblcodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblcodigo.setText("Codigo:");

        lblusuario.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblusuario.setForeground(new java.awt.Color(255, 255, 255));
        lblusuario.setText("Usuario:");

        txtusuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });

        lblcorreo.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblcorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblcorreo.setText("Correo:");

        txtcorreo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblcontraseña.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblcontraseña.setForeground(new java.awt.Color(255, 255, 255));
        lblcontraseña.setText("Contraseña:");

        txtcontra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblconfirmar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblconfirmar.setForeground(new java.awt.Color(255, 255, 255));
        lblconfirmar.setText("Confirmar contraseña:");

        txtcodigo.setDescripcion("");
        txtcodigo.setEnabled(false);
        txtcodigo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        txtconfirmar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lbltipo.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lbltipo.setForeground(new java.awt.Color(255, 255, 255));
        lbltipo.setText("Tipo usuario:");

        cmbtipousuario.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N

        lblnombres.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblnombres.setForeground(new java.awt.Color(255, 255, 255));
        lblnombres.setText("Nombres:");

        lblapellidos.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblapellidos.setForeground(new java.awt.Color(255, 255, 255));
        lblapellidos.setText("Apellidos:");

        lblfecha.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblfecha.setForeground(new java.awt.Color(255, 255, 255));
        lblfecha.setText("Fecha de nacimiento;");

        txtapellidos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtapellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidosKeyTyped(evt);
            }
        });

        txtnombres.setBackground(new java.awt.Color(240, 240, 240));
        txtnombres.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtnombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombresKeyTyped(evt);
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
                            .addComponent(lblfecha)
                            .addComponent(lblusuario)
                            .addComponent(lblcorreo)
                            .addComponent(lblcontraseña))
                        .addGap(23, 23, 23)
                        .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtusuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcontra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JDCNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
                    .addGroup(panelTranslucido1Layout.createSequentialGroup()
                        .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblcodigo)
                            .addComponent(lblapellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(lblnombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTranslucido1Layout.createSequentialGroup()
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtapellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelTranslucido1Layout.createSequentialGroup()
                        .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblconfirmar)
                            .addComponent(lbltipo))
                        .addGap(18, 18, 18)
                        .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtconfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbtipousuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelTranslucido1Layout.setVerticalGroup(
            panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucido1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodigo)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnombres)
                    .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblapellidos)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblfecha)
                    .addComponent(JDCNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblusuario)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcorreo)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcontraseña)
                    .addComponent(txtcontra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblconfirmar)
                    .addComponent(txtconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltipo)
                    .addComponent(cmbtipousuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        BtnModificar.setBackground(new java.awt.Color(0, 0, 0));
        BtnModificar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnModificar.setForeground(new java.awt.Color(255, 255, 255));
        BtnModificar.setText("Modifcar");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Imagen de perfil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        BtnFoto.setText("Tomar foto");
        BtnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFotoActionPerformed(evt);
            }
        });

        BtnExaminar.setText("Examinar");
        BtnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExaminarActionPerformed(evt);
            }
        });

        lblPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(BtnExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelCurves1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelCurves1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAgregarMouseEntered
        BtnAgregar.setForeground(new java.awt.Color(51, 153, 255));
    }//GEN-LAST:event_BtnAgregarMouseEntered

    private void BtnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAgregarMouseExited
        BtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_BtnAgregarMouseExited

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        if(txtusuario.getText().isEmpty() || txtcorreo.getText().isEmpty() || txtcontra.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "No puedes dejar campos en blanco", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if (!txtcontra.getText().equals(txtconfirmar.getText())) {
            JOptionPane.showMessageDialog(this, "¡Las contraseñas no coinciden!", "AVISO", JOptionPane.CANCEL_OPTION);
            txtcontra.setText(null);
            txtconfirmar.setText(null);
            txtcontra.requestFocusInWindow();
        }
        else if(cmbtipousuario.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(this, "¡Debe seleccionar un tipo de usuario!", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if (!ClsValidaciones.ComprobarCoreeoElectronico(txtcorreo.getText())) {
            JOptionPane.showMessageDialog(this, "Correo electrónico incorrecto", "AVISO", JOptionPane.CANCEL_OPTION);
            txtcorreo.setText(null);
            txtcorreo.requestFocusInWindow();
        }
        else if(lblPicture.getIcon() == null){
            JOptionPane.showMessageDialog(this, "Debe agregar una imagen de usuario", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if (!ClsValidaciones.ComprobarContraseña(txtcontra.getText())) {
            JOptionPane.showMessageDialog(this, "La contraseña debe tener numeros, letras con una longitud entre 4 a 8 caracteres", "AVISO", JOptionPane.CANCEL_OPTION);
            txtcontra.setText(null);
            txtcontra.requestFocusInWindow();
        }
        else{
            try {
                String url = "\\no_disponible.png";
                PreparedStatement st = cn.prepareStatement("SELECT usuario FROM usuarios WHERE usuario = ?");
                st.setString(1, txtusuario.getText());
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "El nombre de usuario que ingresaste ya existe", "AVISO", JOptionPane.CANCEL_OPTION);
                }
                else{
                st = cn.prepareStatement("SELECT codigo_tipo_usuario FROM tipo_usuario WHERE nombre_tipo = ?");
                st.setString(1, cmbtipousuario.getSelectedItem().toString());
                ResultSet rs2 = st.executeQuery();
                rs2.next();
                String tipo_usuario = rs2.getString(1);
                st = cn.prepareStatement("INSERT INTO usuarios VALUES(?, ?, ?, ?, ?, CONVERT(VARCHAR(32), HashBytes('MD5', ?), 2), ?, ?)");
                st.setString(1, txtnombres.getText());
                st.setString(2, txtapellidos.getText());
                st.setDate(3, new java.sql.Date(JDCNacimiento.getDate().getTime()));
                st.setString(4, txtusuario.getText());
                st.setString(5, txtcorreo.getText());
                st.setString(6, txtcontra.getText());
                st.setString(7, url);
                st.setInt(8, Integer.parseInt(tipo_usuario));
                st.executeUpdate();
                JOptionPane.showMessageDialog(this, "Datos agregados", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                st = cn.prepareStatement("SELECT MAX(codigo_usuario) FROM usuarios");
                ResultSet rs3 = st.executeQuery();
                rs3.next();
                txtcodigo.setText(rs3.getString(1));
                if (lblPicture.getIcon() != null){
                   String destino = (new File("ImagenUsuario")).getAbsolutePath() + "\\" + txtcodigo.getText() + ".png";
                   ImageIcon ImagenLabel = (ImageIcon) lblPicture.getIcon();
                   BufferedImage Imagen_en_buffer = new BufferedImage(ImagenLabel.getIconWidth(), ImagenLabel.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                   ImagenLabel.paintIcon(null, Imagen_en_buffer.getGraphics(), 0, 0);
                   try {
                       File ImagenDestino = new File(destino);
                       ImageIO.write(Imagen_en_buffer, "png", ImagenDestino);
                   } catch (IOException a) {}
                       url = "\\" + txtcodigo.getText() + ".png";
                       st = cn.prepareStatement("UPDATE usuarios SET foto = ? WHERE codigo_usuario = ?");
                       st.setString(1, url);
                       st.setInt(2, Integer.parseInt(txtcodigo.getText()));
                       st.executeUpdate();
                   }
                MostrarDatos();
                Limpiar();
                bloquear();
                }
            } catch (SQLException | NumberFormatException | HeadlessException e) {
                System.out.println(e);
            }
       }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnModificarMouseEntered
        BtnModificar.setForeground(new java.awt.Color(51, 153, 255));
    }//GEN-LAST:event_BtnModificarMouseEntered

    private void BtnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnModificarMouseExited
        BtnModificar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_BtnModificarMouseExited

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        if(txtusuario.getText().isEmpty() || txtcorreo.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "No puedes dejar campos en blanco", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if (!ClsValidaciones.ComprobarCoreeoElectronico(txtcorreo.getText())) {
            JOptionPane.showMessageDialog(this, "Correo electrónico incorrecto", "AVISO", JOptionPane.CANCEL_OPTION);
            txtcorreo.setText(null);
            txtcorreo.requestFocusInWindow();
        }
        else{
            try {
                String url;
                if (lblPicture.getIcon() != null) {
                        String destino = (new File("ImagenUsuario")).getAbsolutePath() + "\\" + txtcodigo.getText() + ".png";
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
                PreparedStatement st = cn.prepareStatement("SELECT usuario FROM usuarios WHERE usuario = ? AND NOT codigo_usuario = ?");
                st.setString(1, txtusuario.getText());
                st.setInt(2, Integer.parseInt(txtcodigo.getText()));
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Ya existe este usuario", "AVISO", JOptionPane.CANCEL_OPTION);
                }
                else{
                    st = cn.prepareStatement("SELECT codigo_tipo_usuario FROM tipo_usuario WHERE nombre_tipo = ?");
                    st.setString(1, cmbtipousuario.getSelectedItem().toString());
                    ResultSet rs2 = st.executeQuery();
                    rs2.next();
                    String tipo_usuario = rs2.getString(1);
                    st = cn.prepareStatement("UPDATE usuarios SET nombres = ?, apellidos = ?, fecha_nacimiento = ?, usuario = ?, correo = ?, foto = ?,  codigo_tipo_usuario = ? WHERE codigo_usuario = ?");
                    st.setString(1, txtnombres.getText());
                    st.setString(2, txtapellidos.getText());
                    st.setDate(3, new java.sql.Date(JDCNacimiento.getDate().getTime()));
                    st.setString(4, txtusuario.getText());
                    st.setString(5, txtcorreo.getText());
                    st.setString(6, url);
                    st.setInt(7, Integer.parseInt(tipo_usuario));
                    st.setInt(8, Integer.parseInt(txtcodigo.getText()));
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Datos modificados", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    MostrarDatos();
                    Limpiar();
                }
            } catch (SQLException | NumberFormatException | HeadlessException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnConsultarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnConsultarMouseEntered
        BtnConsultar.setForeground(new java.awt.Color(51, 153, 255));
    }//GEN-LAST:event_BtnConsultarMouseEntered

    private void BtnConsultarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnConsultarMouseExited
        BtnConsultar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_BtnConsultarMouseExited

    private void BtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConsultarActionPerformed
        MostrarDatos();
        bloquear();
    }//GEN-LAST:event_BtnConsultarActionPerformed

    private void BtnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEliminarMouseEntered
        BtnEliminar.setForeground(new java.awt.Color(51, 153, 255));
    }//GEN-LAST:event_BtnEliminarMouseEntered

    private void BtnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEliminarMouseExited
        BtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_BtnEliminarMouseExited

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        if("".equals(txtcodigo.getText())) {
            JOptionPane.showMessageDialog(this, "¡Debe realizar una consulta para eliminar!", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if("1".equals(txtcodigo.getText())){
            JOptionPane.showMessageDialog(this, "No puedes eliminar al administrador del sistema", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else if(Integer.parseInt(txtcodigo.getText()) == ClsSQLQuery.ProCodigoUsuario){
            JOptionPane.showMessageDialog(this, "No puedes eliminar tu propio usuario -_-", "AVISO", JOptionPane.CANCEL_OPTION);
        }
        else{
            try{
            PreparedStatement st = cn.prepareStatement("DELETE FROM usuarios WHERE codigo_usuario = ?");
            st.setInt(1, Integer.parseInt(txtcodigo.getText()));
            int eliminar = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar?", "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(eliminar == 0){
                st.execute();
                String UbicacionImagen = (new File("ImagenUsuario")).getAbsolutePath() + "\\" + txtcodigo.getText() + ".png";
                File Imagen = new File(UbicacionImagen);
                Imagen.delete();
                JOptionPane.showMessageDialog(this, "Datos eliminados");
                MostrarDatos();
                Limpiar();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Error al eliminar");
            }
            }catch(SQLException | NumberFormatException | HeadlessException e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CargarDatos();
        cmbtipousuario.setSelectedIndex(-1);
    }//GEN-LAST:event_formWindowOpened

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (evt.getButton() == 3)
        {
            MenuEmergente.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_formMouseClicked

    private void MenuLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLimpiarActionPerformed
        Limpiar();
        Tabla.setModel(new DefaultTableModel());
        txtcontra.setEnabled(true);
        txtconfirmar.setEnabled(true);
    }//GEN-LAST:event_MenuLimpiarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ClsSonidos.CerrarVentana();
    }//GEN-LAST:event_formWindowClosing

    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
        if (txtusuario.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void txtapellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosKeyTyped
        if (txtapellidos.getText().length() >= 80) {
            evt.consume();
        }
        char car = evt.getKeyChar();    
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)){
            evt.consume();
        }
    }//GEN-LAST:event_txtapellidosKeyTyped

    private void txtnombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombresKeyTyped
        if (txtnombres.getText().length() >= 80) {
            evt.consume();
        }
        char car = evt.getKeyChar();    
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)){
            evt.consume();
        }
    }//GEN-LAST:event_txtnombresKeyTyped

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

    private void BtnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFotoActionPerformed
        ImageIcon image = new FrmCamara(null, true).getImagen();
        if(!(image == null)){
        int w = image.getIconWidth();
        int h = image.getIconHeight();
        GraphicsConfiguration gc = lblPicture.getGraphicsConfiguration();
        BufferedImage image2 = gc.createCompatibleImage(w,h);
        Graphics2D g = image2.createGraphics();
        image.paintIcon(lblPicture, g, 0, 0);
        Image img = image2.getScaledInstance(277, 180, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(img);
        lblPicture.setIcon(icon);
        }
        else{
        }
    }//GEN-LAST:event_BtnFotoActionPerformed

    void Limpiar(){
        txtcodigo.setText(null);
        txtnombres.setText(null);
        txtapellidos.setText(null);
        txtusuario.setText(null);
        txtcorreo.setText(null);
        txtcontra.setText(null);
        txtconfirmar.setText(null);
        cmbtipousuario.setSelectedItem(null);
        lblPicture.setIcon(null);
    }
    public void CargarDatos() 
    {
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre_tipo FROM tipo_usuario ORDER BY nombre_tipo");
            cmbtipousuario.removeAllItems();
            while(rs.next())
            {
                cmbtipousuario.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void MostrarDatos()
    {
        Limpiar();
        try{
        PreparedStatement st = cn.prepareStatement("SELECT codigo_usuario, nombres, apellidos, fecha_nacimiento, usuario, correo, nombre_tipo, foto FROM usuarios AS us, tipo_usuario AS tu WHERE us.codigo_tipo_usuario = tu.codigo_tipo_usuario");
        ResultSet rs = st.executeQuery();
        rs.next();
        Tabla = ClsSQLQuery.MtoCargarTabla(st, Tabla);
        Tabla.getColumnModel().getColumn(0).setHeaderValue(lblcodigo.getText());
        Tabla.getColumnModel().getColumn(1).setHeaderValue(lblnombres.getText());
        Tabla.getColumnModel().getColumn(2).setHeaderValue(lblapellidos.getText());
        Tabla.getColumnModel().getColumn(3).setHeaderValue(lblfecha.getText());
        Tabla.getColumnModel().getColumn(4).setHeaderValue(lblusuario.getText());
        Tabla.getColumnModel().getColumn(5).setHeaderValue(lblcorreo.getText());
        Tabla.getColumnModel().getColumn(6).setHeaderValue(lbltipo.getText());
        Tabla.getColumnModel().getColumn(7).setMinWidth(0);
        Tabla.getColumnModel().getColumn(7).setMaxWidth(0);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    void bloquear(){
        txtcontra.setEnabled(false);
        txtconfirmar.setEnabled(false);
    }
    
    void IdiomaEnglish(){
        lblcodigo.setText("Code:");
        lblnombres.setText("Name:");
        lblapellidos.setText("Last name:");
        lblfecha.setText("Date of birth:");
        lblusuario.setText("User:");
        lblcontraseña.setText("Pass:");
        lblcorreo.setText("E-mail:");
        lblconfirmar.setText("Confirm pass:");
        BtnAgregar.setText("Add");
        BtnConsultar.setText("Consult");
        BtnModificar.setText("Edit");
        BtnEliminar.setText("Remove");
        lbltipo.setText("Type user:");
        this.setTitle("User registration");
    }
    
    void IdiomaEspañol(){
        lblcodigo.setText("Codigo:");
        lblnombres.setText("Nombres:");
        lblapellidos.setText("Apellidos:");
        lblfecha.setText("Fecha de nacimiento:");
        lblusuario.setText("Usuario:");
        lblcontraseña.setText("Contraseña:");
        lblcorreo.setText("Correo:");
        lblconfirmar.setText("Confirmar contraseña:");
        BtnAgregar.setText("Agregar:");
        BtnConsultar.setText("Consultar:");
        BtnModificar.setText("Modificar:");
        BtnEliminar.setText("Eliminar:");
        lbltipo.setText("Tipo usuario:");
        this.setTitle("Registro de usuarios");
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmUsuarios dialog = new FrmUsuarios(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.button.ButtonSeven BtnExaminar;
    private org.edisoncor.gui.button.ButtonSeven BtnFoto;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JFileChooser FileChooserAbrir;
    private com.toedter.calendar.JDateChooser JDCNacimiento;
    private javax.swing.JPopupMenu MenuEmergente;
    private javax.swing.JMenuItem MenuLimpiar;
    private javax.swing.JTable Tabla;
    private javax.swing.JComboBox cmbtipousuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JLabel lblapellidos;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lblconfirmar;
    private javax.swing.JLabel lblcontraseña;
    private javax.swing.JLabel lblcorreo;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblnombres;
    private javax.swing.JLabel lbltipo;
    private javax.swing.JLabel lblusuario;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelTranslucido panelTranslucido1;
    private org.edisoncor.gui.textField.TextFieldRound txtapellidos;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtcodigo;
    private org.edisoncor.gui.passwordField.PasswordFieldRound txtconfirmar;
    private org.edisoncor.gui.passwordField.PasswordFieldRound txtcontra;
    private org.edisoncor.gui.textField.TextFieldRound txtcorreo;
    private org.edisoncor.gui.textField.TextFieldRound txtnombres;
    private org.edisoncor.gui.textField.TextFieldRound txtusuario;
    // End of variables declaration//GEN-END:variables
ClsConexion cc= new ClsConexion();
Connection cn= cc.conectar();
}

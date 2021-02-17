/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Clases.ClsConexion;
import Clases.ClsCorreo;
import Clases.ClsSonidos;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Will Vasquez
 */
public class FrmRecuperarViaCelular extends javax.swing.JDialog {
    String mensajeFinal;

    /**
     * Creates new form FrmRecuperarViaCelular
     * @param parent
     * @param modal
     */
    public FrmRecuperarViaCelular(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Recuperacion de contraseña");
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Diseño/Celu.jpg")); 
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

        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        jLabel1 = new javax.swing.JLabel();
        txttelefono = new org.edisoncor.gui.textField.TextFieldRound();
        jLabel2 = new javax.swing.JLabel();
        cmbcompañia = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtusuario = new org.edisoncor.gui.textField.TextFieldRound();
        BtnEnviar = new org.edisoncor.gui.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese su numero telefonico:");

        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Escoga la compañia de su telefono:");

        cmbcompañia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tigo", "Claro", "Digicel" }));
        cmbcompañia.setSelectedIndex(-1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingrese su usuario:");

        javax.swing.GroupLayout panelRectTranslucido1Layout = new javax.swing.GroupLayout(panelRectTranslucido1);
        panelRectTranslucido1.setLayout(panelRectTranslucido1Layout);
        panelRectTranslucido1Layout.setHorizontalGroup(
            panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbcompañia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtusuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelRectTranslucido1Layout.setVerticalGroup(
            panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbcompañia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        BtnEnviar.setText("Enviar nueva contraseña");
        BtnEnviar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEnviar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnviarActionPerformed
        if(cmbcompañia.getSelectedIndex() == -1){
            ClsSonidos.Validar();
            JOptionPane.showMessageDialog(this, "Debe seleccionar una compañia", "Atención", JOptionPane.CANCEL_OPTION);
        }
        else if(txttelefono.getText().isEmpty() || txtusuario.getText().isEmpty()){
            ClsSonidos.Validar();
            JOptionPane.showMessageDialog(this, "No puedes dejar campos en blanco", "Atención", JOptionPane.CANCEL_OPTION);
        }
        else{
            try {
            if(cmbcompañia.getSelectedIndex() == 0){
                mensajeFinal = txttelefono.getText() + "@tigo.com.sv";
                PreparedStatement st = cn.prepareStatement("SELECT codigo_usuario FROM usuarios WHERE usuario = ?");
                st.setString(1, txtusuario.getText());
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    int codigo_usuario = rs.getInt(1);
                    String Contraseña = mthGenerarContraseña();
                    st = cn.prepareStatement("UPDATE usuarios SET contraseña = CONVERT(VARCHAR(32), HashBytes('MD5', ?), 2) WHERE codigo_usuario = ?");
                    st.setString(1, Contraseña);
                    st.setInt(2, codigo_usuario);
                    st.executeUpdate();
                    ClsCorreo.mthEnviar(mensajeFinal, Contraseña);
                    ClsSonidos.AgregarDatos();
                    JOptionPane.showMessageDialog(this, "Se ha enviado su contraseña al numero: " + txttelefono.getText(), "Atención", JOptionPane.INFORMATION_MESSAGE);
                    txttelefono.setText("");
                    txtusuario.setText("");
                    cmbcompañia.setSelectedIndex(-1);
                }
                else{
                    ClsSonidos.Validar();
                    JOptionPane.showMessageDialog(this, "Datos incorrectos", "AVISO", JOptionPane.CANCEL_OPTION);
                    txttelefono.setText("");
                    txtusuario.setText("");
                    cmbcompañia.setSelectedIndex(-1);
                }
            }
            else if(cmbcompañia.getSelectedIndex() == 1){
                mensajeFinal = txttelefono.getText() + "@sms.claro.com.sv";
                PreparedStatement st = cn.prepareStatement("SELECT codigo_usuario FROM usuarios WHERE usuario = ?");
                st.setString(1, txtusuario.getText());
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    int codigo_usuario = rs.getInt(1);
                    String Contraseña = mthGenerarContraseña();
                    st = cn.prepareStatement("UPDATE usuarios SET contraseña = CONVERT(VARCHAR(32), HashBytes('MD5', ?), 2) WHERE codigo_usuario = ?");
                    st.setString(1, Contraseña);
                    st.setInt(2, codigo_usuario);
                    st.executeUpdate();
                    ClsCorreo.mthEnviar(mensajeFinal, Contraseña);
                    ClsSonidos.AgregarDatos();
                    JOptionPane.showMessageDialog(this, "Se ha enviado su contraseña al numero: " + txttelefono.getText(), "Atención", JOptionPane.INFORMATION_MESSAGE);
                    txttelefono.setText("");
                    txtusuario.setText("");
                    cmbcompañia.setSelectedIndex(-1);
                }
                else{
                    ClsSonidos.Validar();
                    JOptionPane.showMessageDialog(this, "Datos incorrectos", "AVISO", JOptionPane.CANCEL_OPTION);
                    txttelefono.setText("");
                    txtusuario.setText("");
                    cmbcompañia.setSelectedIndex(-1);
                }
            }
            else if(cmbcompañia.getSelectedIndex() == 2){
                mensajeFinal = "503" + txttelefono.getText() + "@digimensajes.com";
                PreparedStatement st = cn.prepareStatement("SELECT codigo_usuario FROM usuarios WHERE usuario = ?");
                st.setString(1, txtusuario.getText());
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    int codigo_usuario = rs.getInt(1);
                    String Contraseña = mthGenerarContraseña();
                    st = cn.prepareStatement("UPDATE usuarios SET contraseña = CONVERT(VARCHAR(32), HashBytes('MD5', ?), 2) WHERE codigo_usuario = ?");
                    st.setString(1, Contraseña);
                    st.setInt(2, codigo_usuario);
                    st.executeUpdate();
                    ClsCorreo.mthEnviar(mensajeFinal, Contraseña);
                    ClsSonidos.AgregarDatos();
                    JOptionPane.showMessageDialog(this, "Se ha enviado su contraseña al numero: " + txttelefono.getText(), "Atención", JOptionPane.INFORMATION_MESSAGE);
                    txttelefono.setText("");
                    txtusuario.setText("");
                    cmbcompañia.setSelectedIndex(-1);
                }
                else{
                    ClsSonidos.Validar();
                    JOptionPane.showMessageDialog(this, "Datos incorrectos", "AVISO", JOptionPane.CANCEL_OPTION);
                    txttelefono.setText("");
                    txtusuario.setText("");
                    cmbcompañia.setSelectedIndex(-1);
                }
            }
            }catch(HeadlessException | SQLException e){JOptionPane.showMessageDialog(this, "ERROR: " + e, "Atención", JOptionPane.ERROR_MESSAGE);}
        }
    }//GEN-LAST:event_BtnEnviarActionPerformed

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        if (txttelefono.getText().length() == 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    String mthGenerarContraseña(){
        String Contraseña = "";
        long milisegundos = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milisegundos);
        int i = 0;
        while (i < 20){
            char c = (char)r.nextInt(255);
            if ((c >= '0' && c <='9') || (c >='A' && c <='Z')) {
                Contraseña += c;
                i++;
            }
        }
        return Contraseña;
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
            java.util.logging.Logger.getLogger(FrmRecuperarViaCelular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRecuperarViaCelular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRecuperarViaCelular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRecuperarViaCelular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmRecuperarViaCelular dialog = new FrmRecuperarViaCelular(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.button.ButtonAction BtnEnviar;
    private javax.swing.JComboBox cmbcompañia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    private org.edisoncor.gui.textField.TextFieldRound txttelefono;
    private org.edisoncor.gui.textField.TextFieldRound txtusuario;
    // End of variables declaration//GEN-END:variables
ClsConexion cc= new ClsConexion();
Connection cn= cc.conectar();
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Clases.ClsSonidos;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Will Vasquez
 */
public class FrmReproductorMP3 extends javax.swing.JDialog {
    ClsSonidos musica = new ClsSonidos();
    public int estado = 0;
    public String song;

    /**
     * Creates new form FrmR
     * @param parent
     * @param modal
     */
    public FrmReproductorMP3(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Reproductor MP3");
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Diseño/Musicx.jpg")); 
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

        lblestado = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        BtnAbrir = new javax.swing.JButton();
        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        BtnParar = new javax.swing.JButton();
        BtnReproducir = new javax.swing.JButton();
        BtnPausa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblestado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblnombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        BtnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño/Abrir.png"))); // NOI18N
        BtnAbrir.setBorder(null);
        BtnAbrir.setBorderPainted(false);
        BtnAbrir.setContentAreaFilled(false);
        BtnAbrir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAbrir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño/Abrir1.png"))); // NOI18N
        BtnAbrir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño/Abrir3.png"))); // NOI18N
        BtnAbrir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAbrirActionPerformed(evt);
            }
        });

        BtnParar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño/Parar1.png"))); // NOI18N
        BtnParar.setBorder(null);
        BtnParar.setBorderPainted(false);
        BtnParar.setContentAreaFilled(false);
        BtnParar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnParar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnPararMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnPararMouseExited(evt);
            }
        });
        BtnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPararActionPerformed(evt);
            }
        });

        BtnReproducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño/Reproducir1.png"))); // NOI18N
        BtnReproducir.setBorder(null);
        BtnReproducir.setBorderPainted(false);
        BtnReproducir.setContentAreaFilled(false);
        BtnReproducir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnReproducir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnReproducirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnReproducirMouseExited(evt);
            }
        });
        BtnReproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReproducirActionPerformed(evt);
            }
        });

        BtnPausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño/Pausa1.png"))); // NOI18N
        BtnPausa.setBorder(null);
        BtnPausa.setBorderPainted(false);
        BtnPausa.setContentAreaFilled(false);
        BtnPausa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnPausa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnPausaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnPausaMouseExited(evt);
            }
        });
        BtnPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPausaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRectTranslucido1Layout = new javax.swing.GroupLayout(panelRectTranslucido1);
        panelRectTranslucido1.setLayout(panelRectTranslucido1Layout);
        panelRectTranslucido1Layout.setHorizontalGroup(
            panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(BtnParar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(BtnReproducir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(BtnPausa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        panelRectTranslucido1Layout.setVerticalGroup(
            panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnPausa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnReproducir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnParar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblnombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblestado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnAbrir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblestado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAbrirActionPerformed
        FileFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");
        JFileChooser chooser = new JFileChooser("F:\\Music");
        chooser.addChoosableFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File myFile = chooser.getSelectedFile();
            song = myFile + "";
            String name = chooser.getSelectedFile().getName();
            lblnombre.setText(name);
            lblestado.setText("En reproduccion");
            musica.Stop();
            musica.Play(song);
            estado = 1;
        }
    }//GEN-LAST:event_BtnAbrirActionPerformed

    private void BtnPararMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPararMouseEntered
        BtnParar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño/Parar2.png")));
    }//GEN-LAST:event_BtnPararMouseEntered

    private void BtnPararMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPararMouseExited
        BtnParar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño/Parar1.png")));
    }//GEN-LAST:event_BtnPararMouseExited

    private void BtnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPararActionPerformed
        if(estado == 0){}
        else{
            musica.Stop();
            lblestado.setText("En pausa");
            estado = 1;
        }
    }//GEN-LAST:event_BtnPararActionPerformed

    private void BtnReproducirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnReproducirMouseEntered
        BtnReproducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño/Reproducir2.png")));
    }//GEN-LAST:event_BtnReproducirMouseEntered

    private void BtnReproducirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnReproducirMouseExited
        BtnReproducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño/Reproducir1.png")));
    }//GEN-LAST:event_BtnReproducirMouseExited

    private void BtnReproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReproducirActionPerformed
        if (estado == 0) {
        } else if (estado == 1) {
            if (song == "") {
            } else {
                musica.Stop();
                musica.Play(song);
                lblestado.setText("En Reproduccion");
                estado = 4;
            }
        } else if(estado == 2){
            musica.Resume();
            lblestado.setText("En reproduccion");
            estado = 3;
        }
    }//GEN-LAST:event_BtnReproducirActionPerformed

    private void BtnPausaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPausaMouseEntered
        BtnPausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño/Pausa2.png")));
    }//GEN-LAST:event_BtnPausaMouseEntered

    private void BtnPausaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPausaMouseExited
        BtnPausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño/Pausa1.png")));
    }//GEN-LAST:event_BtnPausaMouseExited

    private void BtnPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPausaActionPerformed
        if(estado == 0){}
        else{
            if (song == "") {
            } else if (estado == 1) {
                musica.Pause();
                lblestado.setText("En pausa");
                estado = 2;
            }
            else if(estado == 3){
                musica.Pause();
                lblestado.setText("En pausa");
                estado = 2;
            }
            else{
                musica.Pause();
                lblestado.setText("En pausa");
                estado = 2;
            }
        }
    }//GEN-LAST:event_BtnPausaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        musica.Stop();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(FrmReproductorMP3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReproductorMP3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReproductorMP3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReproductorMP3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmReproductorMP3 dialog = new FrmReproductorMP3(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnAbrir;
    private javax.swing.JButton BtnParar;
    private javax.swing.JButton BtnPausa;
    private javax.swing.JButton BtnReproducir;
    private javax.swing.JLabel lblestado;
    private javax.swing.JLabel lblnombre;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    // End of variables declaration//GEN-END:variables
}

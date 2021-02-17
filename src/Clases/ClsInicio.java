/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import Formularios.Administrador;
import Formularios.Login;
import Formularios.SplasScreen;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Will Vasquez
 */
public class ClsInicio {
    public static SplasScreen SplashScreen;
    
    public ClsInicio() {
        try {
            javax.swing.UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public void iniciar() {
        if (!comprobarUsuarios()) {
            if (JOptionPane.showConfirmDialog(null, "¡No hay ningun usuario registrado!\n¿Deseas crear al administrador?", "Bienvenido", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                new Administrador().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "¡No podrás usar el sistema si no te registras!", "AVISO", JOptionPane.CANCEL_OPTION);
                System.exit(0);
            }
        } else {
            SplashScreen = new SplasScreen();
            SplashScreen.setVisible(true);
        }
    }
    
    private boolean comprobarUsuarios() {
        ClsSQLQuery obj = new ClsSQLQuery();
        return obj.CantidadUsuario() > 0;
    }
    
    public static void main (String[] args) {
        new ClsInicio().iniciar();
    }
    
}

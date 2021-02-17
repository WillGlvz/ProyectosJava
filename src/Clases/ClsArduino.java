/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Will Vasquez
 */
public class ClsArduino {
    public static int est = 1;
    public static OutputStream salida = null;
    
    
    
    public static void EnviarDatos(String Datos){
        try {
            if(salida == null){}
            else{
            salida.write(Datos.getBytes());
            }
        } catch (IOException e) {JOptionPane.showMessageDialog(null, "ERROR: " + e, "Atención", JOptionPane.ERROR_MESSAGE);}
    }
    
}

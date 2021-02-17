/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Will Vasquez
 */
public class ClsValidaciones {
    public static boolean ComprobarCoreeoElectronico(String correo) {
        Pattern Patron = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        Matcher Comparar = Patron.matcher(correo);        
        return Comparar.find();
    }
    
    public static boolean ComprobarNumeroTelefono(String telefono) {
        Pattern Patron = Pattern.compile("^[2^6-7]{1}[0-9]{3}-[0-9]{4}$");
        Matcher Comparar = Patron.matcher(telefono); 
        return Comparar.find();
    }
    
    public static boolean ComprobarDUI(String dui) {
        if (dui.length() != 10) {
            return false;
        }
        int[] Numeros = new int[8];
        for (int i = 0; i < 8; i++) {
            Numeros[i] = Integer.parseInt(String.valueOf(dui.charAt(i)));
            System.out.println(Numeros[i]);
        }
        int suma = 0;
        int a = 9;
        for (int i : Numeros) {
            suma+= (i*a);
            a--;
        }
        int modulo = suma%10;
        int verificador = Integer.parseInt(String.valueOf(dui.charAt(9)));
        System.out.println(verificador);
        int resultado = 10 - modulo;
        return resultado == verificador || resultado == 0;
    }
    
    public static boolean ComprobarContraseña(String contraseña) {
        Pattern Patron = Pattern.compile("^(?=.*\\d).{4,8}$");
        Matcher Comparar = Patron.matcher(contraseña); 
        return Comparar.find();
    }
    
}

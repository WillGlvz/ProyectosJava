/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Will Vasquez
 */
public class ClsCorreo {
    public static void mthEnviar(String destino, String mensaje) {
        try {
            Properties Propiedades = new Properties();
            Session Sesión;
            Propiedades.put("mail.smtp.host", "smtp.gmail.com");
            Propiedades.put("mail.smtp.starttls.enable", "true");
            Propiedades.put("mail.smtp.port", 587);
            Propiedades.put("mail.smtp.mail.sender", "easyparkingsystem7@gmail.com");
            Propiedades.put("mail.smtp.password", "will01king");
            Propiedades.put("mail.smtp.user", "easyparkingsystem7@gmail.com");
            Propiedades.put("mail.smtp.auth", "true");
            Sesión = Session.getDefaultInstance(Propiedades);
            MimeMessage message = new MimeMessage(Sesión);
            message.setFrom(new InternetAddress((String) Propiedades.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            message.setSubject("Recuperación de contraseña.");
            message.setText(mensaje);
            Transport Cuenta = Sesión.getTransport("smtp");
            Cuenta.connect((String) Propiedades.get("mail.smtp.user"), (String) Propiedades.get("mail.smtp.password"));
            Cuenta.sendMessage(message, message.getAllRecipients());
            Cuenta.close();
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al enviar el correo", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }
    
}

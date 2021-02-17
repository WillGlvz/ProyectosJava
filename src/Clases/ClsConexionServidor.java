/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import Formularios.FrmServidor;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Will Vasquez
 */
public class ClsConexionServidor extends Thread{
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader EntradaSocket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int puerto = 62118;
    
    public ClsConexionServidor(String nombre){
        super(nombre);
    }
    
    public void EnviarMSG(String msg){
        try {
            salida.writeUTF(msg + "\n");
        } catch (IOException e) {System.out.println(e);}
    }
    
    @Override
    public void run(){
        String text = "test";
        try {
            this.ss = new ServerSocket(puerto);
            this.s = ss.accept();
            this.EntradaSocket = new InputStreamReader(s.getInputStream());
            this.entrada = new BufferedReader(EntradaSocket);
            this.salida = new DataOutputStream(s.getOutputStream());
            while(true){
                text = this.entrada.readLine();
                System.out.println(text);
                FrmServidor.txtChat.setText(FrmServidor.txtChat.getText() + "\n" + text);
            }
        } catch (IOException e) {Logger.getLogger(ClsConexionServidor.class.getName()).log(Level.SEVERE, null, e);}
    }
    
    
    
    public void Desconectar(){
        try {
            s.close();
        } catch (IOException e) {System.out.println(e);}
        try {
            ss.close();
        } catch (IOException e) {System.out.println(e);}
    }
    
}

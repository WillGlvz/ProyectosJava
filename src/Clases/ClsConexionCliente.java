/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import Formularios.FrmCliente;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Will Vasquez
 */
public class ClsConexionCliente extends Thread{
    private Socket Socket;
    private ServerSocket ServerSocket;
    private InputStreamReader EntradaSocket;
    private DataOutputStream Salida;
    private BufferedReader Entrada;
    final int Puerto = 62118;
    
    public ClsConexionCliente(String ip){
        try {
            this.Socket = new Socket(ip, this.Puerto);
            this.EntradaSocket = new InputStreamReader(Socket.getInputStream());
            this.Entrada = new BufferedReader(EntradaSocket);
            this.Salida = new DataOutputStream(Socket.getOutputStream());
            this.Salida.writeUTF("Conectado \n");
        } catch (IOException e) {System.out.println(e);}
    }
    
    public void EnviarMSG(String msg){
        System.out.println("Enviado");
        try {
            this.Salida = new DataOutputStream(Socket.getOutputStream());
            this.Salida.writeUTF(msg + "\n");
        } catch (IOException e) {System.out.println(e);}
    }
    
    @Override
   public void run(){
        String texto;
        while(true){
        try {
            texto =  Entrada.readLine();
            FrmCliente.txtChat.setText(FrmCliente.txtChat.getText() + "\n" + texto);
        } catch (IOException e) {System.out.println(e);}
        }
    }
        
   public String LeerMSG(){
        try {
            return Entrada.readLine();
        } catch (IOException e) {System.out.println(e);}
        return null;
    }
   
   public void Desconectar(){
        try {
            Socket.close();
        } catch (IOException e) {System.out.println(e);}
        try {
            ServerSocket.close();
        } catch (IOException e) {System.out.println(e);}
    }
    
}

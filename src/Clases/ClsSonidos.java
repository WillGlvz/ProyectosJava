/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import Formularios.FrmIntro;
import Formularios.FrmSesión;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Will Vasquez
 */
public class ClsSonidos {
    private static File file;
    private static String ruta;
    public static Thread hilo;
    FileInputStream FIS;
    BufferedInputStream BIS;
    public Player player;
    public long pauseLocation;
    public long songtotalLength;
    public String fileLocation;
    
    public static void BienvenidoAdmin() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        hilo = new Thread() {
            @Override
            public void run() {
                try {
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/Sonidos/Bienvenida.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/Bienvenida.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (JavaLayerException | FileNotFoundException e) {
                    System.out.println(e);
                }
            }
        };
        hilo.start();
    }
    
    public static void AgregarDatos() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/Sonidos/Agregar.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/Agregar.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    System.out.println(e);
                }
            }
        };
        hilo.start();
    }
    
    public static void Splash() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/Sonidos/Splash.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/Splash.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    System.out.println(e);
                }
            }
        };
        hilo.start();
    }
    
    public static void ModificarDatos() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/Sonidos/Modificar.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/Modificar.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    System.out.println(e);
                }
            }
        };
        hilo.start();
    }
    
    public static void Validar() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/Sonidos/Validar.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/Validar.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    System.out.println(e);
                }
            }
        };
        hilo.start();
    }
    
    public static void AbrirVentana() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/Sonidos/Open.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/Open.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    System.out.println(e);
                }
            }
        };
        hilo.start();
    }
    
    public static void CerrarVentana() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/Sonidos/Close.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/Close.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    System.out.println(e);
                }
            }
        };
        hilo.start();
    }
    
    public static void Sesion() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/Sonidos/Sesión.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/Sesión.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    System.out.println(e);
                }
            }
        };
        hilo.start();
    }
    
    public static void IntentosFallidos() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/Sonidos/IntentosFallidos.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/IntentosFallidos.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    System.out.println(e);
                }
            }
        };
        hilo.start();
    }
    
    public static void FrmBase() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/Sonidos/FrmDatabase.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/FrmDatabase.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    System.out.println(e);
                }
            }
        };
        hilo.start();
    }
    
    public static void EliminarBase() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/Sonidos/EliminarBase.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/EliminarBase.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    System.out.println(e);
                }
            }
        };
        hilo.start();
    }
    
    public void Stop(){
        if(player != null){
            player.close();
            pauseLocation = 0;
            songtotalLength = 0;
        }
    }
    
    public void Pause(){
        if(player != null){
            try {
                pauseLocation =FIS.available();
                player.close();
            } catch (IOException ex) {JOptionPane.showMessageDialog(null,"Error: " + ex, "Atención", JOptionPane.ERROR_MESSAGE);}
        }
    }
    
    public void Resume(){
        try{
            FIS = new FileInputStream(fileLocation);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            FIS.skip(songtotalLength - pauseLocation);
        }catch (FileNotFoundException | JavaLayerException ex){JOptionPane.showMessageDialog(null," Error: " + ex);
        }catch (IOException ex) {JOptionPane.showMessageDialog(null,"Error: " + ex);}
        new Thread(){
            @Override
            public void run(){
                try {
                    player.play();
                } catch (JavaLayerException ex) {JOptionPane.showMessageDialog(null,"Error: " + ex);}
            }
        }.start();
    }
    
    public void Play(String path){
        try{
            FIS = new FileInputStream(path);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            songtotalLength = FIS.available();
            fileLocation = path + "";
        }
        catch (FileNotFoundException | JavaLayerException ex){JOptionPane.showMessageDialog(null," Error: " + ex);} catch (IOException ex) {}
        new Thread(){
            @Override
            public void run(){
                try {
                    player.play();
                } catch (JavaLayerException ex) {JOptionPane.showMessageDialog(null,"Error: " + ex);}
            }
        }.start();
    }
}

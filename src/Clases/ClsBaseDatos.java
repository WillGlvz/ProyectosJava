/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import static Clases.ClsSQLQuery.cn;
import Formularios.FrmIntro;
import Formularios.FrmPrimerUsuario;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Will Vasquez
 */
public class ClsBaseDatos {
    public static String AutenticacionWindows = "jdbc:sqlserver://localhost:1433;integratedSecurity=true";
    public static FrmIntro SplashScren;
    
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
            cn = new ClsConexion().conectar2();
            PreparedStatement st = cn.prepareStatement("use master; if exists (select * from sys.databases where [name] = 'EasyParkingDB') SELECT 1; else SELECT 0;");
            ResultSet rs = st.executeQuery();
            rs.next();
            boolean ExisteDB = rs.getBoolean(1);
            if(ExisteDB){}
            else{
                String PruebaDB = "USE [master] \n" +
                        "CREATE DATABASE [EasyParkingDB]";
                st = cn.prepareStatement(PruebaDB);
                st.executeUpdate();
                PruebaDB = "USE [EasyParkingDB] \n" +
                        "CREATE TABLE DatosParqueo( \n" +
                        "codigo_parqueo int identity(1,1) primary key, \n" +
                        "Nombre varchar(40), \n" +
                        "NIT varchar(20), \n" +
                        "Direccion varchar(100), \n" +
                        "Telefono varchar(10)) \n" +
                        "insert into DatosParqueo \n" +
                        "values ('Parqueo Ricaldone', '0614-290209-000-0', 'San Salvador', '7790-3451') \n" +
                        "CREATE TABLE tipo_vehiculos( \n" +
                        "codigo_tipo int identity(1,1) primary key, \n" +
                        "nombre_tipo varchar(20), \n" +
                        "tarifa_tipo money, \n" +
                        "porcentaje int) \n" +
                        "insert into tipo_vehiculos \n" +
                        "values('Liviano', 5.00, 30) \n" +
                        "insert into tipo_vehiculos \n" +
                        "values('Comercial', 8.00, 50) \n" +
                        "insert into tipo_vehiculos \n" +
                        "values('VIP', 10.00, 80) \n" +
                        "insert into tipo_vehiculos \n" +
                        "values('Motocicletas', 2.00, 20) \n" +
                        "CREATE TABLE puesto( \n" +
                        "puesto int primary key, \n" +
                        "estado varchar(10), \n" +
                        "estado2 int)\n" +
                        "CREATE TABLE parquear( \n" +
                        "codigo_parquear int identity(1,1) primary key, \n" +
                        "placa varchar(12), \n" +
                        "codigo_tipo int, \n" +
                        "fecha_ingreso datetime, \n" +
                        "hora_ingreso varchar(15), \n" +
                        "tarifa money, \n" +
                        "nombres_cliente varchar(30), \n" +
                        "apellidos_cliente varchar(30), \n" +
                        "telefono varchar(10), \n" +
                        "puesto int, \n" +
                        "estado varchar(10), \n" +
                        "estado_vehiculo varchar(10), \n" +
                        "horas int, \n" +
                        "minutos int, \n" +
                        "segundos int, \n" +
                        "estado2 int, \n" +
                        "foreign key (codigo_tipo) references tipo_vehiculos(codigo_tipo), \n" +
                        "foreign key (puesto) references puesto(puesto) on delete cascade on update cascade) \n" +
                        "CREATE TABLE retirar_vehiculo( \n" +
                        "codigo_retiro int identity(1,1) primary key, \n" +
                        "placa varchar(12), \n" +
                        "tipo_vehiculo varchar(80), \n" +
                        "fecha_inicio datetime, \n" +
                        "hora_ingreso varchar(15), \n" +
                        "tarifa money, \n" +
                        "nombres_cliente varchar(30), \n" +
                        "apellidos_cliente varchar(30), \n" +
                        "telefono varchar(10), \n" +
                        "fecha_salida datetime, \n" +
                        "hora_salida varchar(15), \n" +
                        "horas_transcurridas int, \n" +
                        "monto_total money, \n" +
                        "estado_vehiculo varchar(10), \n" +
                        "numero_puesto int, \n" +
                        "estado_puesto varchar(10)) \n" +
                        "CREATE TABLE tipo_usuario( \n" +
                        "codigo_tipo_usuario int identity(1,1) primary key, \n" +
                        "nombre_tipo varchar(30), \n" +
                        "descripcion varchar(100), \n" +
                        "establecimiento bit, \n" +
                        "contaduria bit, \n" +
                        "parqueo bit, \n" +
                        "reportes bit,  \n" +
                        "usuarios bit) \n" +
                        "CREATE TABLE usuarios( \n" +
                        "codigo_usuario int identity(1,1) primary key, \n" +
                        "nombres varchar(50), \n" +
                        "apellidos varchar(50), \n" +
                        "fecha_nacimiento date, \n" +
                        "usuario varchar(30), \n" +
                        "correo varchar(50), \n" +
                        "contraseña varchar(64),  \n" +
                        "foto varchar(max),  \n" +
                        "codigo_tipo_usuario int, \n" +
                        "foreign key (codigo_tipo_usuario) references tipo_usuario(codigo_tipo_usuario) on delete cascade on update cascade) \n" +
                        "CREATE TABLE liviano( \n" +
                        "codigo_liviano int identity(1,1) primary key, \n" +
                        "tipo varchar(20), \n" +
                        "placa varchar(6), \n" +
                        "marca varchar(20), \n" +
                        "modelo varchar(20),  \n" +
                        "año varchar(4), \n" +
                        "precio_vehiculo money, \n" +
                        "precio_alquiler money, \n" +
                        "foto varchar(max),  \n" +
                        "estado int) \n" +
                        "CREATE TABLE vip( \n" +
                        "codigo_vip int identity(1,1) primary key, \n" +
                        "tipo varchar(20), \n" +
                        "placa varchar(6), \n" +
                        "marca varchar(20), \n" +
                        "modelo varchar(20),  \n" +
                        "año varchar(4), \n" +
                        "precio_vehiculo money, \n" +
                        "precio_alquiler money, \n" +
                        "foto varchar(max),  \n" +
                        "estado int) \n" +
                        "CREATE TABLE comercial( \n" +
                        "codigo_comercial int identity(1,1) primary key, \n" +
                        "tipo varchar(20), \n" +
                        "placa varchar(6), \n" +
                        "marca varchar(20), \n" +
                        "modelo varchar(20),  \n" +
                        "año varchar(4), \n" +
                        "precio_vehiculo money, \n" +
                        "precio_alquiler money, \n" +
                        "foto varchar(max),  \n" +
                        "estado int) \n" +
                        "CREATE TABLE historial( \n" +
                        "codigo_historial int identity(1,1) primary key, \n" +
                        "usuario varchar(max), \n" +
                        "hora varchar(max), \n" +
                        "fecha varchar(max)) \n" +
                        "CREATE TABLE motocicletas( \n" +
                        "codigo_moto int identity(1,1) primary key, \n" +
                        "tipo varchar(20), \n" +
                        "placa varchar(6), \n" +
                        "marca varchar(20), \n" +
                        "modelo varchar(20),  \n" +
                        "año varchar(4), \n" +
                        "precio_vehiculo money, \n" +
                        "precio_alquiler money, \n" +
                        "foto varchar(max),  \n" +
                        "estado int) \n" +
                        "CREATE TABLE Lenguaje( \n" +
                        "idioma int) \n" +
                        "insert into Lenguaje \n" +
                        "values(1) \n" +
                        "CREATE TABLE alquileres( \n" +
                        "codigo_alquiler int identity(1,1) primary key, \n" +
                        "codigo_parquear int, \n" +
                        "fecha_inicio datetime, \n" +
                        "fecha_fin datetime, \n" +
                        "codigo_tipo int,  \n" +
                        "precio_dia money, \n" +
                        "dias int, \n" +
                        "monto_fianza money, \n" +
                        "total money,  \n" +
                        "estado int, \n" +
                        "codigo_liviano int, \n" +
                        "codigo_vip int, \n" +
                        "codigo_comercial int, \n" +
                        "codigo_moto int,  \n" +
                        "foreign key(codigo_parquear) references parquear(codigo_parquear), \n" +
                        "foreign key(codigo_liviano) references liviano(codigo_liviano), \n" +
                        "foreign key(codigo_vip) references vip(codigo_vip),  \n" +
                        "foreign key(codigo_comercial) references comercial(codigo_comercial), \n" +
                        "foreign key(codigo_moto) references motocicletas(codigo_moto),  \n" +
                        "foreign key(codigo_tipo) references tipo_vehiculos(codigo_tipo) on delete cascade on update cascade) \n" +
                        "insert into motocicletas \n" +
                        "values('Motocicletas', '634294', 'Ranger', 'Orange', '2003', 1100.00, 10.00, '\\1.png', 0) \n" +
                        "insert into motocicletas \n" +
                        "values('Motocicletas', '984324', 'King', 'Speedy', '2006', 1300.00, 13.00, '\\2.png', 0) \n" +
                        "insert into motocicletas \n" +
                        "values('Motocicletas', '994244', 'Ducati', 'Corse', '2006', 1300.00, 14.00, '\\3.png', 0) \n" +
                        "insert into motocicletas \n" +
                        "values('Motocicletas', '239042', 'Volt', 'Metal', '2008', 1400.00, 14.00, '\\4.png', 0) \n" +
                        "insert into motocicletas \n" +
                        "values('Motocicletas', '874823', 'Honda', 'DN01', '2010', 1600.00, 16.00, '\\5.png', 0) \n" +
                        "insert into motocicletas \n" +
                        "values('Motocicletas', '634225', 'Bluu', 'Queen', '2012', 1700.00, 17.00, '\\6.png', 0) \n" +
                        "insert into motocicletas \n" +
                        "values('Motocicletas', '634564', 'Mrs', 'Logan', '2003', 1200.00, 12.00, '\\7.png', 0) \n" +
                        "insert into motocicletas \n" +
                        "values('Motocicletas', '129304', 'Sanchez', 'Hight', '2012', 1400.00, 14.00, '\\8.png', 0) \n" +
                        "insert into motocicletas \n" +
                        "values('Motocicletas', '748375', 'Kawasaki', 'Ninja', '2013', 1600.00, 16.00, '\\9.png', 0) \n" +
                        "insert into motocicletas \n" +
                        "values('Motocicletas', '124555', 'Yamaha', 'Quiht', '2009', 1500.00, 15.00, '\\10.png', 0) \n" +
                        "insert into comercial \n" +
                        "values('Comercial', '928301', 'Power', 'BOQ', '2007', 1500.00, 15.00, '\\1.png', 0) \n" +
                        "insert into comercial \n" +
                        "values('Comercial', '888343', 'Redick', 'jouck', '2001', 1400.00, 14.00, '\\2.png', 0) \n" +
                        "insert into comercial \n" +
                        "values('Comercial', '093489', 'Mazda', 'Comers', '2003', 1600.00, 16.00, '\\3.png', 0) \n" +
                        "insert into comercial \n" +
                        "values('Comercial', '889293', 'Redick', 'liverpool', '2005', 1700.00, 17.00, '\\4.png', 0) \n" +
                        "insert into comercial \n" +
                        "values('Comercial', '876567', 'Casera', 'Drink', '2009', 1400.00, 14.00, '\\5.png', 0) \n" +
                        "insert into comercial \n" +
                        "values('Comercial', '889883', 'Delivery', 'Cout', '2004', 1500.00, 15.00, '\\6.png', 0) \n" +
                        "insert into comercial \n" +
                        "values('Comercial', '893845', 'Titan', 'Dash', '2010', 1600.00, 16.00, '\\7.png', 0) \n" +
                        "insert into comercial \n" +
                        "values('Comercial', '344233', 'Nissan', 'Dairl', '2004', 1800.00, 18.00, '\\8.png', 0) \n" +
                        "insert into comercial \n" +
                        "values('Comercial', '988343', 'Mazda', 'gray', '2005', 1500.00, 15.00, '\\9.png', 0) \n" +
                        "insert into comercial \n" +
                        "values('Comercial', '888343', 'Windget', 'Depor', '2002', 1300.00, 13.00, '\\10.png', 0) \n" +
                        "insert into vip \n" +
                        "values('VIP', '873423', 'Ferry', 'Cornsten', '2012', 2000.00, 26.00, '\\1.png', 0) \n" +
                        "insert into vip \n" +
                        "values('VIP', '871823', 'Lamborghini', 'Embolado', '2014', 3000.00, 50.00, '\\2.png', 0) \n" +
                        "insert into vip \n" +
                        "values('VIP', '328493', 'Ferrari', 'Redk', '2011', 2400.00, 30.00, '\\3.png', 0) \n" +
                        "insert into vip \n" +
                        "values('VIP', '128939', 'Reatek', 'speed', '2012', 2300.00, 23.00, '\\4.png', 0) \n" +
                        "insert into vip \n" +
                        "values('VIP', '323874', 'Ferrari', 'Deport', '2013', 2200.00, 22.00, '\\5.png', 0) \n" +
                        "insert into vip \n" +
                        "values('VIP', '239934', 'Lucios', 'Fromal', '2014', 2600.00, 26.00, '\\6.png', 0) \n" +
                        "insert into vip \n" +
                        "values('VIP', '332445', 'Blanck', 'Deport', '2010', 2800.00, 28.00, '\\7.png', 0) \n" +
                        "insert into vip \n" +
                        "values('VIP', '493044', 'Aeclipse', 'Scape', '2014', 3000.00, 35.00, '\\8.png', 0) \n" +
                        "insert into vip \n" +
                        "values('VIP', '345493', 'Limuss', 'Fitali', '2011', 3000.00, 40.00, '\\9.png', 0) \n" +
                        "insert into vip \n" +
                        "values('VIP', '459135', 'Blanck', 'Speedy', '2013', 2900.00, 29.00, '\\10.png', 0) \n" +
                        "insert into liviano \n" +
                        "values('Liviano', '283716', 'Honda', 'Civic', '2002', 1100.00, 10.00, '\\1.png', 0) \n" +
                        "insert into liviano \n" +
                        "values('Liviano', '320402', 'Honda', 'Chevz', '2009', 1300.00, 13.00, '\\2.png', 0) \n" +
                        "insert into liviano \n" +
                        "values('Liviano', '982374', 'Audi', 'Guiz', '2006', 1200.00, 12.00, '\\3.png', 0) \n" +
                        "insert into liviano \n" +
                        "values('Liviano', '090344', 'Honda', 'XYZ', '2007', 1400.00, 14.00, '\\4.png', 0) \n" +
                        "insert into liviano \n" +
                        "values('Liviano', '987943', 'Honda', '4x4', '2008', 1500.00, 15.00, '\\5.png', 0) \n" +
                        "insert into liviano \n" +
                        "values('Liviano', '283716', 'Audi', 'Livic', '2009', 1000.00, 10.00, '\\6.png', 0) \n" +
                        "insert into liviano \n" +
                        "values('Liviano', '873242', 'Ford', 'focus', '2010', 1400.00, 13.00, '\\7.png', 0) \n" +
                        "insert into liviano \n" +
                        "values('Liviano', '762832', 'Honda', 'Gric', '2011', 1300.00, 13.00, '\\8.png', 0) \n" +
                        "insert into liviano \n" +
                        "values('Liviano', '203948', 'Toyota', 'Chiki', '2011', 1000.00, 112.00, '\\9.png', 0) \n" +
                        "insert into liviano \n" +
                        "values('Liviano', '283716', 'Chevrolet', 'Amarix', '2013', 1400.00, 14.00, '\\10.png', 0) \n" +
                        "insert into puesto \n" +
                        "values (1, 'Libre', 1) \n" +
                        "insert into puesto \n" +
                        "values (2, 'Libre', 1) \n" +
                        "insert into puesto \n" +
                        "values (3, 'Libre', 1) \n" +
                        "insert into puesto \n" +
                        "values (4, 'Libre', 1) \n" +
                        "insert into puesto \n" +
                        "values (5, 'Libre', 1) \n" +
                        "insert into puesto \n" +
                        "values (6, 'Libre', 1) \n" +
                        "insert into puesto \n" +
                        "values (7, 'Libre', 1) \n" +
                        "insert into puesto \n" +
                        "values (8, 'Libre', 1) \n" +
                        "insert into puesto \n" +
                        "values (9, 'Libre', 1)\n" +
                        "insert into puesto \n" +
                        "values (10, 'Libre', 1) \n" +
                        "USE [master] \n" +
                        "ALTER DATABASE [EasyParkingDB] SET  READ_WRITE";
                st = cn.prepareStatement(PruebaDB);
                st.executeUpdate(); 
                cn.close();
            }
            cn = new ClsConexion().conectar();
            ClsSQLQuery.Url = "jdbc:sqlserver://192.168.0.1:1433;databaseName=EasyParkingDB;user=sa;password=1234;selectMethod=Direct;";
            ClsSQLQuery.AutenticacionWindows2 = "jdbc:sqlserver://localhost:1433;databaseName=EasyParkingDB;integratedSecurity=true";
            st = cn.prepareStatement("SELECT COUNT(*) FROM usuarios");
            ResultSet rs2 = st.executeQuery();
            rs2.next();
            if (rs2.getInt(1) <= 0) {
                if (JOptionPane.showConfirmDialog(null, "¡No hay ningun usuario registrado!\n¿Deseas crear al administrador?", "Bienvenido", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    FrmPrimerUsuario Administrador = new FrmPrimerUsuario();
                    Administrador.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "¡No podrás usar el sistema si no te registras!", "AVISO", JOptionPane.CANCEL_OPTION);
                    System.exit(0);
                }
            }
            else {
                SplashScren = new FrmIntro(null, true);
                SplashScren.setVisible(true);
            }
        } catch (SQLException | UnsupportedLookAndFeelException e) {System.out.println(e);}
    }
}
   

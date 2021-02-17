create database EasyParkingDB

use EasyParkingDB
go

create table DatosParqueo(
codigo_parqueo int identity(1,1) primary key,
Nombre varchar(40),
NIT varchar(20),
Direccion varchar(100),
Telefono varchar(10))

insert into DatosParqueo
values ('Parqueo Ricaldone', '0614-290209-000-0', 'San Salvador', '7790-3451')

create table tipo_vehiculos(
codigo_tipo int identity(1,1) primary key,
nombre_tipo varchar(20),
tarifa_tipo money,
porcentaje int)

insert into tipo_vehiculos
values('Liviano', 5.00, 30)

insert into tipo_vehiculos
values('Comercial', 8.00, 50)

insert into tipo_vehiculos
values('VIP', 10.00, 80)

insert into tipo_vehiculos
values('Motocicletas', 2.00, 20)

create table puesto(
puesto int primary key,
estado varchar(10),
estado2 int)

create table parquear(
codigo_parquear int identity(1,1) primary key,
placa varchar(12),
codigo_tipo int,
fecha_ingreso datetime,
hora_ingreso varchar(15),
tarifa money,
nombres_cliente varchar(30),
apellidos_cliente varchar(30),
telefono varchar(10),
puesto int,
estado varchar(10),
estado_vehiculo varchar(10),
horas int,
minutos int,
segundos int,
foreign key (codigo_tipo) references tipo_vehiculos(codigo_tipo),
foreign key (puesto) references puesto(puesto) on delete cascade on update cascade)

create table retirar_vehiculo(
codigo_retiro int identity(1,1) primary key,
placa varchar(12),
tipo_vehiculo varchar(80),
fecha_inicio datetime,
hora_ingreso varchar(15),
tarifa money,
nombres_cliente varchar(30),
apellidos_cliente varchar(30),
telefono varchar(10),
fecha_salida datetime,
hora_salida varchar(15),
horas_transcurridas int,
monto_total money,
estado_vehiculo varchar(10),
numero_puesto int,
estado_puesto varchar(10))

create table tipo_usuario(
codigo_tipo_usuario int identity(1,1) primary key,
nombre_tipo varchar(30),
descripcion varchar(100),
establecimiento bit,
contaduria bit,
parqueo bit,
reportes bit, 
usuarios bit)

create table usuarios(
codigo_usuario int identity(1,1) primary key,
nombres varchar(50),
apellidos varchar(50),
fecha_nacimiento date,
usuario varchar(30),
correo varchar(50),
contraseña varchar(64),
codigo_tipo_usuario int,
foreign key (codigo_tipo_usuario) references tipo_usuario(codigo_tipo_usuario) on delete cascade on update cascade)

select * from usuarios

create table liviano(
codigo_liviano int primary key,
tipo varchar(20),
placa varchar(6),
marca varchar(20),
modelo varchar(20),
año varchar(4),
precio_vehiculo money,
precio_alquiler money,
foto varchar(max),
estado int)

create table vip(
codigo_vip int primary key,
tipo varchar(20),
placa varchar(6),
marca varchar(20),
modelo varchar(20),
año varchar(4),
precio_vehiculo money,
precio_alquiler money,
foto varchar(max),
estado int)

create table comercial(
codigo_comercial int primary key,
tipo varchar(20),
placa varchar(6),
marca varchar(20),
modelo varchar(20),
año varchar(4),
precio_vehiculo money,
precio_alquiler money,
foto varchar(max),
estado int)

create table motocicletas(
codigo_moto int primary key,
tipo varchar(20),
placa varchar(6),
marca varchar(20),
modelo varchar(20),
año varchar(4),
precio_vehiculo money,
precio_alquiler money,
foto varchar(max),
estado int)

create table alquileres(
codigo_alquiler int identity(1,1) primary key,
codigo_parquear int,
fecha_inicio datetime,
fecha_fin datetime,
codigo_tipo int,
precio_dia money,
dias int,
monto_fianza money,
total money,
estado int,
codigo_liviano int,
codigo_vip int,
codigo_comercial int,
codigo_moto int,
foreign key(codigo_parquear) references parquear(codigo_parquear),
foreign key(codigo_liviano) references liviano(codigo_liviano),
foreign key(codigo_vip) references vip(codigo_vip),
foreign key(codigo_comercial) references comercial(codigo_comercial),
foreign key(codigo_moto) references motocicletas(codigo_moto),
foreign key(codigo_tipo) references tipo_vehiculos(codigo_tipo) on delete cascade on update cascade)

insert into motocicletas
values(1, 'Motocicletas', '634294', 'Ranger', 'Orange', '2003', 1100.00, 10.00, '\1.png', 0)

insert into motocicletas
values(2, 'Motocicletas', '984324', 'King', 'Speedy', '2006', 1300.00, 13.00, '\2.png', 0)

insert into motocicletas
values(3, 'Motocicletas', '994244', 'Ducati', 'Corse', '2006', 1300.00, 14.00, '\3.png', 0)

insert into motocicletas
values(4, 'Motocicletas', '239042', 'Volt', 'Metal', '2008', 1400.00, 14.00, '\4.png', 0)

insert into motocicletas
values(5, 'Motocicletas', '874823', 'Honda', 'DN01', '2010', 1600.00, 16.00, '\5.png', 0)

insert into motocicletas
values(6, 'Motocicletas', '634225', 'Bluu', 'Queen', '2012', 1700.00, 17.00, '\6.png', 0)

insert into motocicletas
values(7, 'Motocicletas', '634564', 'Mrs', 'Logan', '2003', 1200.00, 12.00, '\7.png', 0)

insert into motocicletas
values(8, 'Motocicletas', '129304', 'Sanchez', 'Hight', '2012', 1400.00, 14.00, '\8.png', 0)

insert into motocicletas
values(9, 'Motocicletas', '748375', 'Kawasaki', 'Ninja', '2013', 1600.00, 16.00, '\9.png', 0)

insert into motocicletas
values(10, 'Motocicletas', '124555', 'Yamaha', 'Quiht', '2009', 1500.00, 15.00, '\10.png', 0)

insert into comercial
values(1, 'Comercial', '928301', 'Power', 'BOQ', '2007', 1500.00, 15.00, '\1.png', 0)

insert into comercial
values(2, 'Comercial', '888343', 'Redick', 'jouck', '2001', 1400.00, 14.00, '\2.png', 0)

insert into comercial
values(3, 'Comercial', '093489', 'Mazda', 'Comers', '2003', 1600.00, 16.00, '\3.png', 0)

insert into comercial
values(4, 'Comercial', '889293', 'Redick', 'liverpool', '2005', 1700.00, 17.00, '\4.png', 0)

insert into comercial
values(5, 'Comercial', '876567', 'Casera', 'Drink', '2009', 1400.00, 14.00, '\5.png', 0)

insert into comercial
values(6, 'Comercial', '889883', 'Delivery', 'Cout', '2004', 1500.00, 15.00, '\6.png', 0)

insert into comercial
values(7, 'Comercial', '893845', 'Titan', 'Dash', '2010', 1600.00, 16.00, '\7.png', 0)

insert into comercial
values(8, 'Comercial', '344233', 'Nissan', 'Dairl', '2004', 1800.00, 18.00, '\8.png', 0)

insert into comercial
values(9, 'Comercial', '988343', 'Mazda', 'gray', '2005', 1500.00, 15.00, '\9.png', 0)

insert into comercial
values(10, 'Comercial', '888343', 'Windget', 'Depor', '2002', 1300.00, 13.00, '\10.png', 0)

insert into vip
values(1, 'VIP', '873423', 'Ferry', 'Cornsten', '2012', 2000.00, 26.00, '\1.png', 0)

insert into vip
values(2, 'VIP', '871823', 'Lamborghini', 'Embolado', '2014', 3000.00, 50.00, '\2.png', 0)

insert into vip
values(3, 'VIP', '328493', 'Ferrari', 'Redk', '2011', 2400.00, 30.00, '\3.png', 0)

insert into vip
values(4, 'VIP', '128939', 'Reatek', 'speed', '2012', 2300.00, 23.00, '\4.png', 0)

insert into vip
values(5, 'VIP', '323874', 'Ferrari', 'Deport', '2013', 2200.00, 22.00, '\5.png', 0)

insert into vip
values(6, 'VIP', '239934', 'Lucios', 'Fromal', '2014', 2600.00, 26.00, '\6.png', 0)

insert into vip
values(7, 'VIP', '332445', 'Blanck', 'Deport', '2010', 2800.00, 28.00, '\7.png', 0)

insert into vip
values(8, 'VIP', '493044', 'Aeclipse', 'Scape', '2014', 3000.00, 35.00, '\8.png', 0)

insert into vip
values(9, 'VIP', '345493', 'Limuss', 'Fitali', '2011', 3000.00, 40.00, '\9.png', 0)

insert into vip
values(10, 'VIP', '459135', 'Blanck', 'Speedy', '2013', 2900.00, 29.00, '\10.png', 0)

insert into liviano
values(1, 'Liviano', '283716', 'Honda', 'Civic', '2002', 1100.00, 10.00, '\1.png', 0)

insert into liviano
values(2, 'Liviano', '320402', 'Honda', 'Chevz', '2009', 1300.00, 13.00, '\2.png', 0)

insert into liviano
values(3, 'Liviano', '982374', 'Audi', 'Guiz', '2006', 1200.00, 12.00, '\3.png', 0)

insert into liviano
values(4, 'Liviano', '090344', 'Honda', 'XYZ', '2007', 1400.00, 14.00, '\4.png', 0)

insert into liviano
values(5, 'Liviano', '987943', 'Honda', '4x4', '2008', 1500.00, 15.00, '\5.png', 0)

insert into liviano
values(6, 'Liviano', '283716', 'Audi', 'Livic', '2009', 1000.00, 10.00, '\6.png', 0)

insert into liviano
values(7, 'Liviano', '873242', 'Ford', 'focus', '2010', 1400.00, 13.00, '\7.png', 0)

insert into liviano
values(8, 'Liviano', '762832', 'Honda', 'Gric', '2011', 1300.00, 13.00, '\8.png', 0)

insert into liviano
values(9, 'Liviano', '203948', 'Toyota', 'Chiki', '2011', 1000.00, 112.00, '\9.png', 0)

insert into liviano
values(10, 'Liviano', '283716', 'Chevrolet', 'Amarix', '2013', 1400.00, 14.00, '\10.png', 0)

insert into puesto
values (1, 'Libre', 1)

insert into puesto
values (2, 'Libre', 1)

insert into puesto
values (3, 'Libre', 1)

insert into puesto
values (4, 'Libre', 1)

insert into puesto
values (5, 'Libre', 1)

insert into puesto
values (6, 'Libre', 1)

insert into puesto
values (7, 'Libre', 1)

insert into puesto
values (8, 'Libre', 1)

insert into puesto
values (9, 'Libre', 1)

insert into puesto
values (10, 'Libre', 1)

select *from comercial

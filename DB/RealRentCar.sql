create database RealRentCar

use RealRentCar
go

create table tipo_usuario(
codigo_tipo_usuario int identity(1,1) primary key,
nombre varchar(30),
descripcion varchar(70),
usuario bit,
tipo_usuario bit,
flota bit,
clientes bit,
alquileres bit,
reportes bit, 
contaduria bit)

create table usuarios(
codigo_usuario int identity(1,1) primary key,
usuariox varchar(40),
correo varchar(40),
contraseña varchar(64),
foto varchar(max),
codigo_tipo_usuario int,
foreign key (codigo_tipo_usuario) references tipo_usuario(codigo_tipo_usuario) on delete cascade on update cascade)

select *from tipo_usuario

create table cliente_directo(
codigo_cliente_directo int identity(1,1) primary key,
nombres varchar(80),
apellidos varchar(80),
dui varchar(10),
telefono varchar(10),
direccion varchar(100))

create table agencia_viaje(
codigo_agencia int identity(1,1) primary key,
nombre varchar(100),
nit varchar(50),
nrc varchar(50),
telefono varchar(10),
direccion varchar(100))

create table tipo_vehiculo(
codigo_tipo_vehiculo int identity(1,1) primary key,
nombre varchar(50),
porcentaje int,
descripcion varchar(100))

create table vehiculos(
codigo_vehiculo int identity(1,1) primary key,
numero_placa varchar(8),
marca varchar(30),
modelo varchar(30),
año varchar(4),
precio money,
foto varchar(max),
estado int,
codigo_tipo_vehiculo int,
foreign key (codigo_tipo_vehiculo) references tipo_vehiculo(codigo_tipo_vehiculo) on delete cascade on update cascade)

select * from vehiculos

create table alquiler_cliente(
codigo_alquiler_cliente int identity(1,1) primary key,
fecha_inicio datetime,
fecha_fin datetime,
precio_dia varchar(30),
tipo_pago varchar(30),
monto_fianza money,
codigo_cliente_directo int,
codigo_vehiculo int,
estado int,
foreign key (codigo_cliente_directo) references cliente_directo(codigo_cliente_directo),
foreign key (codigo_vehiculo) references vehiculos(codigo_vehiculo) on delete cascade on update cascade)

select * from alquiler_cliente

create table alquiler_agencia(
codigo_alquiler_agencia int identity(1,1) primary key,
fecha_inicio datetime,
fecha_fin datetime,
precio_dia varchar(30),
tipo_pago varchar(30),
monto_fianza money,
codigo_agencia int,
codigo_vehiculo int,
estado int,
foreign key (codigo_agencia) references agencia_viaje(codigo_agencia),
foreign key (codigo_vehiculo) references vehiculos(codigo_vehiculo) on delete cascade on update cascade)

create table vehiculos_alquilados(
codig_vehiculo_alquilado int identity(1,1) primary key,
numero_placa varchar(8),
marca varchar(30),
modelo varchar(30),
año varchar(4),
cliente varchar(200),
fecha_inicio datetime, 
fecha_fin datetime)
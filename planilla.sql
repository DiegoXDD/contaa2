create database planilla
use planilla
go 

create table cargos
(
id_cargo int identity(1,1) not null primary key,
nombre_cargo varchar(50),
descripcion_cargo varchar(150),
salario money,
)

create table descuentos
(
id_descuento int identity(1,1) not null primary key,
isss money,
isr money,
total money,
salario_final money,
id_cargo int not null references cargos(id_cargo),
)

create table trabajador
(
id_trabajador int identity(1,1) not null primary key,
nombre_trabajador varchar(50),
apellido_trabajador varchar(50),
dui_trabajador varchar(150),
nit_trabajador varchar(150),
telefono_trabajador varchar(150),
correo_trabajador varchar(150),
direccion_trabajador varchar(150),
id_cargo int not null references cargos(id_cargo),
)
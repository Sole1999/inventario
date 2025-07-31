drop table if exists categorias cascade;
create table categorias(
codigo_cat serial not null,
nombre varchar(100) not null,
categoria_padre int,
constraint categorias_pk primary key (codigo_cat),
constraint categorias_fk foreign key (categoria_padre)
references categorias(codigo_cat)
);

insert into categorias(nombre, categoria_padre)
values('Materia Prima', null);
insert into categorias(nombre, categoria_padre)
values('Proteina', 1);
insert into categorias(nombre, categoria_padre)
values('Salsas', 1);
insert into categorias(nombre, categoria_padre)
values('Punto de Venta', null);
insert into categorias(nombre, categoria_padre)
values('Bebidas', 4);
insert into categorias(nombre, categoria_padre)
values('Con Alcohol', 5);
insert into categorias(nombre, categoria_padre)
values('Sin Alcohol', 5);

select * from categorias;

drop table if exists categorias_unidad_medida cascade;
create table categorias_unidad_medida(
codigo_udm char(1) not null,
nombre varchar(100) not null,
constraint codigo_udm_pk primary key (codigo_udm)
);
insert into categorias_unidad_medida(codigo_udm, nombre)
values('U', 'Unidades');
insert into categorias_unidad_medida(codigo_udm, nombre)
values('V', 'Volumen');
insert into categorias_unidad_medida(codigo_udm, nombre)
values('P', 'Peso');
select * from categorias_unidad_medida;

drop table if exists unidades_medida cascade;
create table unidades_medida(
nombre varchar(10) not null,
descripcion varchar(100) not null,
categoria_udm char(1) not null,
constraint nombre_pk primary key (nombre),
constraint categoria_udm_fk foreign key (categoria_udm)
references categorias_unidad_medida(codigo_udm)
);

insert into unidades_medida(nombre, descripcion, categoria_udm)
values('ml', 'mililitros', 'V');
insert into unidades_medida(nombre, descripcion, categoria_udm)
values('l', 'litros', 'V');
insert into unidades_medida(nombre, descripcion, categoria_udm)
values('u', 'unidad', 'U');
insert into unidades_medida(nombre, descripcion, categoria_udm)
values('d', 'docena', 'U');
insert into unidades_medida(nombre, descripcion, categoria_udm)
values('g', 'gramos', 'P');
insert into unidades_medida(nombre, descripcion, categoria_udm)
values('kg', 'kilogramos', 'P');
insert into unidades_medida(nombre, descripcion, categoria_udm)
values('lb', 'libras', 'P');

select * from unidades_medida;

drop table if exists productos cascade;
create table productos(
codigo_producto serial,
nombre varchar(100) not null,
udm varchar(10) not null,
precio_de_venta money not null,
tiene_iva  boolean,
coste money not null,
categoria int not null,
stock int,
constraint codigo_producto_pk primary key (codigo_producto),
constraint categoria_fk foreign key (categoria)
references categorias(codigo_cat),
constraint udm_fk foreign key (udm)
references unidades_medida (nombre)
);

insert into productos(nombre, udm, precio_de_venta, tiene_iva, coste, categoria, stock)
values('Coca cola pequeña', 'u', 0.5804, true, 0.3729, 7, 105);
insert into productos(nombre, udm, precio_de_venta, tiene_iva, coste, categoria, stock)
values('Salsa de tomate', 'kg', 0.95, true, 0.8736, 3, 0);
insert into productos(nombre, udm, precio_de_venta, tiene_iva, coste, categoria, stock)
values('Mostaza', 'kg', 0.95, true, 0.89, 3, 0);
insert into productos(nombre, udm, precio_de_venta, tiene_iva, coste, categoria, stock)
values('Fuze Tea', 'u', 0.8, true, 0.7, 7, 49);

select * from productos;

drop table if exists tipo_documentos cascade;
create table tipo_documentos(
codigo char(1) not null,
descripcion varchar(6),
constraint codigo_pk primary key (codigo)
);

insert into tipo_documentos (codigo, descripcion)
values('C', 'CEDULA');
insert into tipo_documentos (codigo, descripcion)
values('R', 'RUC');

select * from tipo_documentos;


drop table if exists proveedores cascade;
create table proveedores(
identificador varchar(13) not null,
tipo_de_documento_fk char(1)  not null,
nombre varchar(100) not null,
telefono varchar(10) not null,
correo varchar(50) not null,
direccion varchar(100) not null,
constraint identificador_pk primary key (identificador),
constraint tipo_de_documento_fk foreign key (tipo_de_documento_fk)
references tipo_documentos (codigo)
);

insert into proveedores (identificador,tipo_de_documento_fk,nombre,telefono,correo,direccion)
values('1792285747','C','Santiago Mosquera','0992920306','zantycb89@gmail.com', 'Cumbayork');
insert into proveedores (identificador,tipo_de_documento_fk,nombre,telefono,correo,direccion)
values('1792285747001','R','Snacks SA','0992920398','snacks@gmail.com', 'La Tola');
insert into proveedores (identificador,tipo_de_documento_fk,nombre,telefono,correo,direccion)
values('0925417560','C','Comida SA','0978956320','cimda@gmail.com', 'La Botanica');

select * from proveedores;

drop table if exists estados_pedido cascade;
create table estados_pedido(
codigo char(1) not null,
descripcion varchar(10),
constraint codigo_pedido_pk primary key (codigo)
);

insert into estados_pedido(codigo,descripcion)
values('S','Solicitado');
insert into estados_pedido(codigo,descripcion)
values('R','Recibido');

select * from estados_pedido;

drop table if exists cabecera_pedido cascade;
create table cabecera_pedido(
numero serial,
proveedor varchar(13) not null,
fecha TIMESTAMP without time zone not null,
estado_fk char(1) not null,
constraint numero_pk primary key (numero),
constraint proveedor_fk foreign key (proveedor)
references proveedores(identificador),
constraint estado_fk foreign key (estado_fk)
references estados_pedido(codigo)
);

insert into cabecera_pedido(proveedor,fecha,estado_fk)
values('1792285747', '20/11/2023', 'R');
insert into cabecera_pedido(proveedor,fecha,estado_fk)
values('1792285747', '20/11/2023', 'R');
insert into cabecera_pedido(proveedor,fecha,estado_fk)
values('0925417560', '18/12/2023', 'R');

select * from cabecera_pedido;

drop table if exists detalle_pedido;
create table detalle_pedido(
codigo serial,
cabecera_pedido int not null,
producto int not null, 
cantidad_solicitada int not null,
cantidad_recibida int not null,
subtotal money,
constraint codigo_detalle_pk primary key (codigo),
constraint cabecera_pedido_fk foreign key (cabecera_pedido)
references cabecera_pedido(numero)
);

insert into detalle_pedido(cabecera_pedido,producto,cantidad_solicitada,cantidad_recibida,subtotal)
values(1,1,100,100,37.29);
insert into detalle_pedido(cabecera_pedido,producto,cantidad_solicitada,cantidad_recibida,subtotal)
values(1,4,50,50,11.80);
insert into detalle_pedido(cabecera_pedido,producto,cantidad_solicitada,cantidad_recibida,subtotal)
values(2,1,10,10,3.73);
insert into detalle_pedido(cabecera_pedido,producto,cantidad_solicitada,cantidad_recibida,subtotal)
values(16,3,40,40,51.20);

select * from detalle_pedido;

drop table if exists historial_stocks;
create table historial_stocks(
codigo  serial,
fecha TIMESTAMP without time zone not null,
referencia varchar(20) not null,
producto_fk int not null,
cantidad int not null,
constraint codigo_historial_pk primary key (codigo),
constraint producto_fk foreign key (producto_fk)
references productos(codigo_producto)
);

insert into historial_stocks(fecha,referencia,producto_fk,cantidad)
values('20/11/2023 19:59','PEDIDO 1',1,100);
insert into historial_stocks(fecha,referencia,producto_fk,cantidad)
values('20/11/2023 19:59','PEDIDO 1',4,50);
insert into historial_stocks(fecha,referencia,producto_fk,cantidad)
values('20/11/2023 20:00','PEDIDO 2',1,10);
insert into historial_stocks(fecha,referencia,producto_fk,cantidad)
values('20/11/2023 20:00','VENTA 1',1,-5);
insert into historial_stocks(fecha,referencia,producto_fk,cantidad)
values('20/11/2023 20:00','VENTA 1',4,1);
insert into historial_stocks(fecha,referencia,producto_fk,cantidad)
values('18/12/2023 10:00','PEDIDO 3',3,40);

select * from historial_stocks;

drop table if exists cabecera_ventas cascade;
create table cabecera_ventas(
codigo serial,
fecha TIMESTAMP without time zone not null,
total_sin_iva  money,
iva  money,
total  money,
constraint codigo_cab_ventas_pk primary key (codigo)
);

insert into cabecera_ventas(fecha,total_sin_iva,iva,total)
values('20/11/2023 20:00', 3.26, 0.39, 3.65);

select * from cabecera_ventas;

drop table if exists detalle_ventas;
create table detalle_ventas(
codigo serial,
cabecera_ventas int not null,
producto_fk int not null,
cantidad int not null,
precio_ventas money,
subtotal money,
subtotal_con_iva money,
constraint codigo_ventas_pk primary key (codigo),
constraint cabecera_ventas_fk foreign key (cabecera_ventas)
references cabecera_ventas (codigo),
constraint producto_fk foreign key (producto_fk)
references productos(codigo_producto)
);

insert into detalle_ventas(cabecera_ventas,producto_fk,cantidad,precio_ventas,subtotal,subtotal_con_iva)
values(1,1,5,0.58,2.9,3.25);
insert into detalle_ventas(cabecera_ventas,producto_fk,cantidad,precio_ventas,subtotal,subtotal_con_iva)
values(1,4,1,0.36,0.36,0.40);

select * from detalle_ventas;
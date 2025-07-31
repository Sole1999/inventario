select identificador, tipo_de_documento_fk, nombre, telefono, correo, direccion
from proveedores
where upper(nombre) like '%SA%'


select identificador, tipo_de_documento_fk, td.descripcion, nombre, telefono, correo, direccion
from proveedores prov, tipo_documentos td
where prov.tipo_de_documento_fk = td.codigo
and upper(nombre) like '%SA%'

select * from tipo_documentos

insert into tipo_documentos(codigo, descripcion)
values('P', 'PASAP')


select prod.codigo_producto, prod.nombre as nombre_producto,
udm.nombre as nombre_udm, udm.descripcion as descripcion_udm,
cast(prod.precio_de_venta as decimal(6,2)), prod.tiene_iva, 
cast(prod.coste as decimal(5,4)),
prod.categoria, cat.nombre as nombre_categoria, stock
from productos prod, unidades_medida udm, categorias cat
where prod.udm = udm.nombre
and prod.categoria = cat.codigo_cat
and upper(prod.nombre) like '%M%'


select * from productos prod, unidades_medida udm, categorias cat
where prod.udm = udm.nombre
and prod.categoria = cat.codigo_cat

select * from proveedores
select * from cabecera_pedido
select * from detalle_pedido

select dt.*, prov.* from detalle_pedido dt, proveedores prov, cabecera_pedido cb
where dt.cabecera_pedido = cb.numero
and cb.proveedor like '0925417560' 
and cb.proveedor = prov.identificador

select dt.* from detalle_pedido dt, proveedores prov, cabecera_pedido cb
where dt.cabecera_pedido = cb.numero
and cb.proveedor like '0925417560' 
and cb.proveedor = prov.identificador

select * from proveedores where identificador like '0925417560'

select * from productos where codigo_producto = 6


select * from productos;
select * from categorias;
select * from proveedores;
select * from productos;
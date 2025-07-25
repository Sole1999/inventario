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
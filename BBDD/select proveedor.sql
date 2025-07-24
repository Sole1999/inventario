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
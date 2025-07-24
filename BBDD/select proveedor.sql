select identificador, tipo_de_documento_fk, nombre, telefono, correo, direccion
from proveedores
where upper(nombre) like '%SA%'
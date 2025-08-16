---CREATE DATABASE hospital_db

drop table if exists especialidades cascade;
CREATE TABLE especialidades(
id serial PRIMARY KEY,
nombre varchar(100) not null,
descripcion varchar(150) not null
);

insert into especialidades(nombre, descripcion) values
('Cardiología', 'Se encarga del diagnóstico y tratamiento de enfermedades del corazón y sistema circulatorio.'),
('Neurología', 'Estudia y trata los trastornos del sistema nervioso (cerebro, médula espinal, nervios).'),
('Pediatría', 'Atiende la salud y enfermedades de los niños y adolescentes.'),
('Dermatología', 'Especializada en el cuidado y tratamiento de la piel, cabello y uñas.'),
('Ginecología y Obstetricia', 'Centrada en la salud reproductiva de la mujer, embarazo y parto.'),
('Traumatología y Ortopedia', 'Trata lesiones y enfermedades de huesos, articulaciones, músculos y ligamentos.');

select * from especialidades;


drop table if exists medicos cascade;
CREATE TABLE medicos (
id VARCHAR(13) PRIMARY KEY,
especialidades_id INT NOT NULL,
nombre varchar(50) not null,
apellido varchar(50) not null,
telefono varchar(10) not null,
correo varchar(50) not null,
FOREIGN KEY (especialidades_id) REFERENCES especialidades(id)
);

insert into medicos(id, especialidades_id, nombre, apellido, telefono, correo) values
('1718137159', 3, 'Ana María', 'García López', '0991234567', 'ana.maria.garcia@gmail.com' ),
('0928374651', 1, 'Luis Fernando', 'López Martínez', '0987654321', 'luis.fernando.lopez@yahoo.com' ),
('1102345678', 6, 'María José', 'Pérez Rodríguez', '0961122334', 'maria.jose.perez@hotmail.com' ),
('0509876543', 2, 'Carlos Andrés', 'Torres Ramírez', '0955566778', 'carlos.andres.torres@outlook.com' ),
('1801234987', 4, 'Sofía Valentina', 'Mendoza Herrera', '0934455667', 'sofia.valentina.mendoza@gmail.com' ),
('0912345675', 2, 'Juan Sebastián', 'Rodríguez Morales', '0998765432', 'juan.sebastian.rodriguez@yahoo.com' ),
('0609873214', 5, 'Valeria Alejandra', 'Ramírez Castro', '0971239876', 'valeria.alejandra.ramirez@hotmail.com' ),
('0801237654', 2, 'Diego Armando', 'Castillo Vargas', '0942233445', 'diego.armando.castillo@outlook.com' ),
('0209876541', 1, 'Camila Fernanda', 'Herrera Romero', '0923344556', 'camila.fernanda.herrera@gmail.com' ),
('1002345679', 6, 'Pedro Antonio', 'Morales Delgado', '0983344556', 'pedro.antonio.morales@yahoo.com' );


select * from medicos;

--- AUTOR: PATSY RIOS RON

select md.*, esp.nombre from medicos md, especialidades esp
					where md.especialidades_id = esp.id
					and md.id like '1102345678'
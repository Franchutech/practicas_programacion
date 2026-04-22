DROP DATABASE IF EXISTS ministerio_magia_db;
CREATE DATABASE ministerio_magia_db;
USE ministerio_magia_db;

CREATE TABLE casas (
id INT PRIMARY KEY,
nombre VARCHAR(50) NOT NULL UNIQUE,
fundador VARCHAR(50) NOT NULL,
animal_representativo VARCHAR(30),
color_primario VARCHAR(20),
color_secundario VARCHAR(20)
);

INSERT INTO casas (id, nombre, fundador, animal_representativo, color_primario, color_secundario) VALUES
(1, 'GRYFFINDOR', 'Godric Gryffindor', 'León', 'Red', 'Gold'),
(2, 'SLYTHERIN', 'Salazar Slytherin', 'Serpiente', 'Green', 'Silver'),
(3, 'RAVENCLAW', 'Rowena Ravenclaw', 'Águila', 'Blue', 'Bronze'),
(4, 'HUFFLEPUFF', 'Helga Hufflepuff', 'Tejón', 'Yellow', 'Black');

SELECT * FROM casas;

CREATE TABLE cualidades (
id_cualidad INT PRIMARY KEY, -- este numero es para el usuario (el id de cada cualidad)
nombre_cualidad VARCHAR(50) NOT NULL UNIQUE,
id_casa_afinidad INT NOT NULL,
CONSTRAINT fk_cualidad_casa FOREIGN KEY (id_casa_afinidad) REFERENCES casas(id)
);

INSERT INTO cualidades (id_cualidad, nombre_cualidad, id_casa_afinidad) VALUES
(1, 'VALOR', 1),
(2, 'AMBICION', 2),
(3, 'INTELIGENCIA', 3),
(4, 'LEALTAD', 4),
(5, 'CABALLEROSIDAD', 1),
(6, 'ASTUCIA', 2),
(7, 'CURIOSIDAD', 3),
(8, 'PACIENCIA', 4),
(9, 'OSADIA', 1),
(10, 'LIDERAZGO', 2),
(11, 'CREATIVIDAD', 3),
(12, 'TRABAJO DURO', 4);

CREATE TABLE ser_vivo (
id_ser_vivo INT AUTO_INCREMENT PRIMARY KEY,
nombre_ser_vivo VARCHAR(100) NOT NULL,
nacionalidad_ser_vivo VARCHAR(50),
tipo_ser_vivo ENUM('MAGO', 'MUGGLE', 'CRIATURA') NOT NULL
);

CREATE TABLE magos(
    id_ser_vivo INT PRIMARY KEY,
    id_casa INT,
    patronus VARCHAR(50),
    estatus_sangre ENUM('SANGRE_PURA', 'MESTIZO', 'PADRES_MUGGLES') NOT NULL,
    es_mortifago BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_mago_base FOREIGN KEY (id_ser_vivo) REFERENCES ser_vivo(id_ser_vivo) ON
    DELETE CASCADE,
    CONSTRAINT fk_mago_casa FOREIGN KEY (id_casa) REFERENCES casas(id)
    );

CREATE TABLE muggles (
    id_ser_vivo INT PRIMARY KEY,
    profesion VARCHAR(100),
    conoce_mundo_magico BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_muggle_base FOREIGN KEY (id_ser_vivo) REFERENCES ser_vivo(id_ser_vivo) ON DELETE CASCADE
);

CREATE TABLE criaturas (
    id_ser_vivo INT PRIMARY KEY,
    nivel_peligrosidad INT,
    es_domesticable BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_criatura_base FOREIGN KEY (id_ser_vivo) REFERENCES ser_vivo(id_ser_vivo) ON DELETE CASCADE
);




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
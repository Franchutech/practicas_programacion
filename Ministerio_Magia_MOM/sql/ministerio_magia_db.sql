DROP DATABASE IF EXISTS ministerio_magia_db;
CREATE DATABASE ministerio_magia_db;
USE ministerio_magia_db;

DROP TABLE IF EXISTS casas;

/*TABLA CASAS - DEFINIDA POR MI*/

CREATE TABLE casas(
    id INT PRIMARY KEY, -- Tú decides el número ahora
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

/*TABLA DE CUALIDADES, QUE DEPENDE DE CASAS*/
CREATE TABLE cualidades(
    id_cualidad INT AUTO_INCREMENT PRIMARY KEY,
    nombre_cualidad VARCHAR(50) NOT NULL UNIQUE,
    id_casa_afinidad INT NOT NULL,
    CONSTRAINT fk_cualidad_casa FOREIGN KEY (id_casa_afinidad) REFERENCES casas(id)
);

/*No he ejecutado esta tabla, estoy definiendola con IA primero*/
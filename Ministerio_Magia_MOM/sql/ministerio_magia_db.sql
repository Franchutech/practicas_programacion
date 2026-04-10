CREATE DATABASE IF NOT EXISTS ministerio_magia_db;
USE ministerio_magia_db;

CREATE TABLE IF NOT EXISTS casas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    escuela VARCHAR(50),
    cualidad_requerida VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS hechizos (
    id_hechizo INT AUTO_INCREMENT PRIMARY KEY,
    nombre_hechizo VARCHAR(50) NOT NULL,
    tipo_hechizo VARCHAR(30),
    nivel_minimo INT
    );
    
-- TABLA CENTRAL PARA LA HERENCIA 
CREATE TABLE IF NOT EXISTS ser_vivo (
    id_ser_vivo INT AUTO_INCREMENT PRIMARY KEY,
    nombre_ser_vivo VARCHAR(100) NOT NULL,
    nacionalidad_ser_vivo VARCHAR(50),
    tipo_ser_vivo VARCHAR(20),

    -- Atributos de MAGO
    id_casa INT,
    patronus VARCHAR(50),
    nivel_magico INT,
    es_mortifago TINYINT(1),

    -- Atributos de MUGGLE
    profesion VARCHAR(100),
    conoce_mundo_magico TINYINT(1),

    -- Atributos de CRIATURA
    nivel_peligrosidad INT,
    es_domesticable TINYINT(1),

    -- CLAVE FORÁNEA: Conecta con la tabla 'casas' que habia hecho al principio
    CONSTRAINT fk_ser_casa FOREIGN KEY (id_casa) REFERENCES casas(id)
);

-- INSERTO DATOS DE PRUEBA
INSERT INTO casas (nombre, escuela, cualidad_requerida) 
VALUES ('Gryffindor', 'Hogwarts', 'Valor'), ('Slytherin', 'Hogwarts', 'Ambición');

INSERT INTO casas (nombre, escuela, cualidad_requerida) VALUES 
('Ravenclaw', 'Hogwarts', 'Sabiduría'),
('Hufflepuff', 'Hogwarts', 'Lealtad'),
('Castelobruxo', 'Brasil', 'Herbología'),
('Mahoutokoro', 'Japón', 'Excelencia');

INSERT INTO hechizos (nombre_hechizo, tipo_hechizo, nivel_minimo) VALUES 
('Expecto Patronum', 'DEFENSA', 7),
('Avada Kedavra', 'MALDICION', 9),
('Alohomora', 'ENCANTAMIENTO', 1),
('Wingardium Leviosa', 'ENCANTAMIENTO', 1),
('Sectumsempra', 'MALDICION', 8),
('Expelliarmus', 'DEFENSA', 2);

-- Insertar MAGOS
INSERT INTO ser_vivo (nombre_ser_vivo, nacionalidad_ser_vivo, tipo_ser_vivo, id_casa, patronus, nivel_magico, es_mortifago) VALUES 
('Harry Potter', 'INGLATERRA', 'MAGO', 1, 'Ciervo', 8, 0),
('Severus Snape', 'INGLATERRA', 'MAGO', 2, 'Cierva', 9, 1),
('Luna Lovegood', 'INGLATERRA', 'MAGO', 3, 'Liebre', 6, 0);

-- Insertar MUGGLES
INSERT INTO ser_vivo (nombre_ser_vivo, nacionalidad_ser_vivo, tipo_ser_vivo, profesion, conoce_mundo_magico) VALUES 
('Vernon Dursley', 'INGLATERRA', 'MUGGLE', 'Director de empresa de taladros', 1),
('Hermione Parents', 'INGLATERRA', 'MUGGLE', 'Dentistas', 1);

-- Insertar CRIATURAS
INSERT INTO ser_vivo (nombre_ser_vivo, nacionalidad_ser_vivo, tipo_ser_vivo, nivel_peligrosidad, es_domesticable) VALUES 
('Colacuerno Húngaro', 'HUNGRIA', 'CRIATURA', 5, 0),
('Escarbato', 'INGLATERRA', 'CRIATURA', 2, 1);

UPDATE casas SET escuela = 'Castelobruxo' WHERE nombre = 'Castelobruxo';
UPDATE casas SET escuela = 'Mahoutokoro' WHERE nombre = 'Mahoutokoro';

UPDATE casas SET nombre = 'Gryffindor', escuela = 'Castelobruxo' WHERE id = 5;

ALTER TABLE casas DROP INDEX nombre;

UPDATE casas SET nombre = 'Gryffindor', escuela = 'Castelobruxo' WHERE id = 5;
UPDATE casas SET nombre = 'Slytherin', escuela = 'Castelobruxo' WHERE id = 7;
UPDATE casas SET nombre = 'Ravenclaw', escuela = 'Mahoutokoro' WHERE id = 6;
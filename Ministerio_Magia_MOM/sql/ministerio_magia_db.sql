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

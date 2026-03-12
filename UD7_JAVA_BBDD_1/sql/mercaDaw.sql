CREATE DATABASE IF NOT EXISTS mercadaw;
USE mercadaw;

CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    referencia VARCHAR(50) UNIQUE NOT NULL, 
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    tipo_id INT,
    cantidad INT DEFAULT 0,
    precio DOUBLE DEFAULT 0.0,
    descuento INT DEFAULT 0,
    iva INT DEFAULT 21,
    aplicar_dto BOOLEAN DEFAULT FALSE
);

INSERT INTO productos (referencia, nombre, descripcion, cantidad, precio) 
VALUES ('REF001', 'Teclado Mecanico', 'RGB Switch Red', 5, 85.50);
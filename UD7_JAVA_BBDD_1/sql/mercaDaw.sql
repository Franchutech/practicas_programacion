CREATE DATABASE IF NOT EXISTS mercadaw;
USE mercadaw;

CREATE TABLE IF NOT EXISTS tipos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_tipo VARCHAR(50) NOT NULL UNIQUE
);

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

INSERT INTO tipos (nombre_tipo) VALUES 
('Almacenamiento'), 
('Monitores'), 
('Audio'), 
('Perifericos'), 
('Hardware'), 
('Conectores'), 
('Limpieza'), 
('Componentes');

INSERT INTO productos (referencia, nombre, descripcion, tipo_id, cantidad, precio) 
VALUES 
('REF002', 'Ratón Óptico', 'Inalámbrico 1600 DPI', 4, 15, 25.99),
('REF003', 'Disco SSD 1TB', 'SSD NVMe ultra rápido', 1, 8, 89.90),
('REF004', 'Monitor 27"', 'Panel IPS 4K 60Hz', 2, 4, 249.00),
('REF005', 'Cascos Gaming', 'Sonido 7.1 con micro', 3, 12, 45.00),
('REF006', 'Memoria RAM 16GB', 'DDR4 3200MHz RGB', 8, 20, 75.25),
('REF007', 'Tarjeta Gráfica', 'RTX 4060 8GB GDDR6', 8, 3, 320.00),
('REF008', 'Cable HDMI 2.1', 'Longitud 2 metros 8K', 6, 30, 14.99),
('REF009', 'Spray Aire Comprimido', 'Limpieza de teclados', 7, 10, 8.50),
('REF010', 'Placa Base B550', 'Socket AM4 ATX', 5, 2, 125.00);

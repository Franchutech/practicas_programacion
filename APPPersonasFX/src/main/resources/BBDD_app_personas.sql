CREATE SCHEMA dawpeople;

CREATE TABLE `dawpeople`.`person` (
`dni` VARCHAR(10) NOT NULL,
`name` VARCHAR(45) NOT NULL,
`surname` VARCHAR(75) NOT NULL,
`email` VARCHAR(75) NOT NULL,
`age` INT UNSIGNED NOT NULL,
`phone` VARCHAR(45) NOT NULL,
PRIMARY KEY (`dni`),
UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE,
UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);

INSERT INTO `dawpeople`.`person` 
(`dni`, `name`, `surname`, `email`, `age`, `phone`) 
VALUES 
('12345678A', 'Ana', 'García López', 'ana.garcia@email.com', 28, '+34600123456'),
('87654321B', 'Carlos', 'Martínez Ruiz', 'cmartinez88@email.com', 35, '+34611987654'),
('11223344C', 'Laura', 'Fernández Gómez', 'laura.fg@email.com', 42, '+34622112233'),
('44332211D', 'David', 'Sánchez Pérez', 'david.sanchez@email.com', 25, '+34633445566'),
('55667788E', 'María', 'Rodríguez Silva', 'mrodriguez.silva@email.com', 30, '+34644778899'),
('99887766F', 'Javier', 'López Domínguez', 'javier.lopezd@email.com', 45, '+34655223344'),
('22334455G', 'Elena', 'Gómez Martín', 'elena.gomez99@email.com', 22, '+34666998877'),
('66778899H', 'Alejandro', 'Pérez Castillo', 'aleperez.castillo@email.com', 38, '+34677554433'),
('33445566I', 'Carmen', 'Ruiz Navarro', 'carmen.ruizn@email.com', 50, '+34688112233'),
('77889900J', 'Daniel', 'Martín Romero', 'daniel.martinr@email.com', 29, '+34699667788');
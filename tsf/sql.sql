CREATE TABLE `tsf`.`pena` (
  `id` INT NOT NULL,
  `cif` VARCHAR(45),
  `nombre` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45),
  `web` VARCHAR(45),
  `telefono` VARCHAR(45),
  `sede` VARCHAR(45),
  `numCuenta` VARCHAR(45),
  PRIMARY KEY (`id`));

CREATE TABLE `tsf`.`socio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numregistro` INT NULL,
  `dni` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `localidad` VARCHAR(45) NULL,
  `provincia` VARCHAR(45) NULL,
  `telefono` INT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `tsf`.`temporada` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `precioalta` INT NULL,
  `preciorenovacion` INT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `foto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `tsf`.`bandera` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `color` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `idFoto` INT NULL,
  PRIMARY KEY (`id`));
ALTER TABLE bandera ADD CONSTRAINT fk_bandera_foto FOREIGN KEY (idFoto) REFERENCES Foto(id);

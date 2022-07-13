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


CREATE TABLE `tsf`.`pancarta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `color` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `fotoid` INT NULL,
  PRIMARY KEY (`id`));
ALTER TABLE bandera ADD CONSTRAINT fk_bandera_foto FOREIGN KEY (fotoid) REFERENCES Foto(id);

CREATE TABLE `tsf`.`publico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `telefono` INT NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `tsf`.`sociotemporada` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idsocio` INT NOT NULL,
  `idtemporada`INT NOT NULL,
  `iscuotapagada` TINYINT NULL,
  `numsfc` INT NULL,
  `numtsf` INT NULL,
  `fecharenovacion` datetime DEFAULT NULL,
  `metodopago` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  ALTER TABLE sociotemporada ADD CONSTRAINT fk_socio_temporada_socio FOREIGN KEY (idsocio) REFERENCES Socio(id);
  ALTER TABLE sociotemporada ADD CONSTRAINT fk_socio_temporada_temporada FOREIGN KEY (idtemporada) REFERENCES Temporada(id);


CREATE TABLE `tsf`.`competicion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `ronda` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `tsf`.`equipo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `estadio` VARCHAR(45) NULL,
  `distancia` INT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `tsf`.`viaje` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `equipoid` INT NULL,
  `competicionid` INT NULL,
  `cartelid` INT NULL,
  `fecha` DATETIME NULL,
  `precioentrada` INT NULL,
  `isfinalizado` TINYINT NULL,
  `resultadolocal` INT NULL,
  `resultadovisitante` INT NULL,
  `comentarios` MEDIUMTEXT NULL,
  `horasalida` VARCHAR(45) NULL,
  `horallegada` VARCHAR(45) NULL,
  `lugarsalida` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  ALTER TABLE viaje ADD CONSTRAINT fk_viaje_equipo FOREIGN KEY (equipoid) REFERENCES Equipo(id);
  ALTER TABLE viaje ADD CONSTRAINT fk_viaje_competicion FOREIGN KEY (competicionid) REFERENCES Competicion(id);
  ALTER TABLE viaje ADD CONSTRAINT fk_viaje_cartel FOREIGN KEY (cartelid) REFERENCES Foto(id);

CREATE TABLE `tsf`.`socioviaje` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `socioid` INT NULL,
  `viajeid` INT NULL,
  `ispagadobus` TINYINT NULL,
  `isentradapedida` TINYINT NULL,
  `istieneentrada` TINYINT NULL,
  `isentradapagada` TINYINT NULL,
  `islistanegra` TINYINT NULL,
  `comentarios` MEDIUMTEXT NULL,
  `fecha` DATETIME NULL,
  PRIMARY KEY (`id`));
  ALTER TABLE socioviaje ADD CONSTRAINT fk_socio_viaje FOREIGN KEY (socioid) REFERENCES Socio(id);
  ALTER TABLE socioviaje ADD CONSTRAINT fk_viaje_socio FOREIGN KEY (viajeid) REFERENCES Viaje(id);

CREATE TABLE `tsf`.`publicoviaje` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `publicoid` INT NULL,
  `viajeid` INT NULL,
  `ispagadobus` TINYINT NULL,
  `istieneentrada` TINYINT NULL,
  `islistaespera` TINYINT NULL,
  `islistanegra` TINYINT NULL,
  `comentarios` MEDIUMTEXT NULL,
  `fecha` DATETIME NULL,
  PRIMARY KEY (`id`));
  ALTER TABLE publicoviaje ADD CONSTRAINT fk_publico_viaje FOREIGN KEY (publicoid) REFERENCES Publico(id);
  ALTER TABLE publicoviaje ADD CONSTRAINT fk_viaje_publico FOREIGN KEY (viajeid) REFERENCES Viaje(id);

CREATE TABLE `tsf`.`amigo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `socioid` INT NULL,
  `publicoid` INT NULL,
  `fecha` DATETIME NULL,
  PRIMARY KEY (`id`));
  ALTER TABLE amigo ADD CONSTRAINT fk_publico_amigo FOREIGN KEY (publicoid) REFERENCES Publico(id);
  ALTER TABLE amigo ADD CONSTRAINT fk_socio_amigo FOREIGN KEY (socioid) REFERENCES Socio(id);

  CREATE TABLE `tsf`.`bus` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `viajeid` INT NULL,
  `categoria` VARCHAR(45) NULL,
  `preciobus` INT NULL,
  `preciosocio` INT NULL,
  `preciopublico` INT NULL,
  `empresa` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  ALTER TABLE bus ADD CONSTRAINT fk_viaje_bus FOREIGN KEY (viajeid) REFERENCES Viaje(id);
  
CREATE TABLE `tsf`.`actividad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `temporadaid` INT NULL,
  `viajeid` INT NULL,
  `nombre` VARCHAR(45) NULL,
  `coste` DOUBLE NULL,
  `preciosocio` INT NULL,
  `preciopublico` INT NULL,
  `fecha` DATETIME NULL,
  `premios` MEDIUMTEXT NULL,
  PRIMARY KEY (`id`));
  ALTER TABLE actividad ADD CONSTRAINT fk_viaje_actividad FOREIGN KEY (viajeid) REFERENCES Viaje(id);
  ALTER TABLE actividad ADD CONSTRAINT fk_temporada_actividad FOREIGN KEY (temporadaid) REFERENCES Temporada(id);

  CREATE TABLE `tsf`.`actividadsocio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `actividadid` INT NULL,
  `socioid` INT NULL,
  `resultado` VARCHAR(45) NULL,
  `comentarios` MEDIUMTEXT NULL,
  PRIMARY KEY (`id`));
  ALTER TABLE actividadsocio ADD CONSTRAINT fk_actividadsocio_socio FOREIGN KEY (socioid) REFERENCES Socio(id);
  ALTER TABLE actividadsocio ADD CONSTRAINT fk_actividadsocio_actividad FOREIGN KEY (actividadid) REFERENCES Actividad(id);

  CREATE TABLE `tsf`.`sociobandera` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `socioid` INT NULL,
  `banderaid` INT NULL,
  `viajeid` INT NULL,
  `actividadid` INT NULL,
  `fecha` DATETIME NULL,
  PRIMARY KEY (`id`));
  ALTER TABLE sociobandera ADD CONSTRAINT fk_sociobandera_bandera FOREIGN KEY (banderaid) REFERENCES Pancarta(id);
  ALTER TABLE sociobandera ADD CONSTRAINT fk_sociobandera_viaje FOREIGN KEY (viajeid) REFERENCES Viaje(id);
  ALTER TABLE sociobandera ADD CONSTRAINT fk_sociobandera_socio FOREIGN KEY (socioid) REFERENCES Socio(id);
  ALTER TABLE sociobandera ADD CONSTRAINT fk_sociobandera_actividad FOREIGN KEY (actividadid) REFERENCES Actividad(id);

CREATE TABLE `tsf`.`cargojunta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `puesto` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `tsf`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


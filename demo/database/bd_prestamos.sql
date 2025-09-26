-- Crear la base de datos
DROP DATABASE IF EXISTS ims_prestamos;
CREATE DATABASE ims_prestamos CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE ims_prestamos;

-- ==========================================
-- Tabla: tbl_usuarios
-- ==========================================
DROP TABLE IF EXISTS tbl_usuarios;
CREATE TABLE tbl_usuarios (
  id_usuario BIGINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  documento VARCHAR(20) NOT NULL,
  contrasena VARCHAR(200) NOT NULL,
  is_admin TINYINT(1) DEFAULT 0,
  fecha_creacion TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  created_at DATETIME(6) DEFAULT NULL,
  updated_at DATETIME(6) DEFAULT NULL,
  PRIMARY KEY (id_usuario),
  UNIQUE KEY documento (documento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO tbl_usuarios (id_usuario, nombre, documento, contrasena, is_admin, fecha_creacion)
VALUES
(1,'Sara Torres','12345','1234',0,'2025-09-23 20:45:41'),
(2,'Administrador IMS','99999','admin123',1,'2025-09-23 20:45:41'),
(3,'Luis','12323032','1002',0,'2025-09-23 20:45:41');

-- ==========================================
-- Tabla: tbl_herramienta
-- ==========================================
DROP TABLE IF EXISTS tbl_herramienta;
CREATE TABLE tbl_herramienta (
  id_herramienta BIGINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  fecha_creacion TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  created_at DATETIME(6) DEFAULT NULL,
  PRIMARY KEY (id_herramienta)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO tbl_herramienta (id_herramienta, nombre, fecha_creacion)
VALUES
(1,'Martillo','2025-09-23 20:45:46'),
(2,'Destornillador','2025-09-23 20:45:46'),
(3,'Taladro','2025-09-23 20:45:46');

-- ==========================================
-- Tabla: tbl_prestamo
-- ==========================================
DROP TABLE IF EXISTS tbl_prestamo;
CREATE TABLE tbl_prestamo (
  id_prestamo BIGINT NOT NULL AUTO_INCREMENT,
  fecha_prestamo DATETIME(6) NOT NULL,
  fecha_devolucion DATETIME(6) DEFAULT NULL,
  estado INT DEFAULT NULL,
  id_usuario BIGINT DEFAULT NULL,
  id_herramienta BIGINT DEFAULT NULL,
  devuelto BIT(1) NOT NULL,
  PRIMARY KEY (id_prestamo),
  KEY id_usuario (id_usuario),
  KEY id_herramienta (id_herramienta),
  CONSTRAINT tbl_prestamo_ibfk_1 FOREIGN KEY (id_usuario) REFERENCES tbl_usuarios (id_usuario),
  CONSTRAINT tbl_prestamo_ibfk_2 FOREIGN KEY (id_herramienta) REFERENCES tbl_herramienta (id_herramienta)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO tbl_prestamo (id_prestamo, fecha_prestamo, fecha_devolucion, estado, id_usuario, id_herramienta, devuelto)
VALUES
(3,'2025-09-24 05:00:00.000000','2025-10-01 04:59:00.000000',1,1,1,b'0'),
(4,'2025-09-26 05:00:00.000000','2025-10-02 04:59:00.000000',0,3,3,b'1'),
(5,'2025-09-27 05:00:00.000000','2025-10-04 04:59:00.000000',0,1,2,b'1'),
(6,'2025-09-25 05:00:00.000000','2025-09-29 04:59:00.000000',1,3,1,b'0');

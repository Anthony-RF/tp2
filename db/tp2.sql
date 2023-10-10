CREATE DATABASE IF NOT EXISTS tp2;

USE tp2;

-- DROP TABLE IF EXISTS Medico_Persona;
-- DROP TABLE IF EXISTS Medicamento_Cita;
-- DROP TABLE IF EXISTS Medico_Medico;
-- DROP TABLE IF EXISTS Cita;
-- DROP TABLE IF EXISTS Medicamento;
-- DROP TABLE IF EXISTS Medico;
-- DROP TABLE IF EXISTS Persona;


CREATE TABLE IF NOT EXISTS Persona(
    cedula INT PRIMARY KEY UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    tipo INT
);

CREATE TABLE IF NOT EXISTS Medico(
    id INT PRIMARY KEY UNIQUE NOT NULL,
    especialidad VARCHAR(100),
    cedula INT,
    FOREIGN KEY (cedula) REFERENCES Persona(cedula)
);

CREATE TABLE IF NOT EXISTS Medicamento(
    nombre VARCHAR(100) PRIMARY KEY NOT NULL
);

CREATE TABLE IF NOT EXISTS Cita(
    fecha DATETIME PRIMARY KEY UNIQUE NOT NULL,
    padecimiento VARCHAR(100) NOT NULL,
    procedimiento VARCHAR(100) NOT NULL,
    cedula_Persona INT NOT NULL,
    id_Medico INT NOT NULL,
    FOREIGN KEY (cedula_Persona) REFERENCES Persona(cedula),
    FOREIGN KEY (id_Medico) REFERENCES Medico(id)
);

CREATE TABLE IF NOT EXISTS Medico_Persona(
    id_Medico INT NOT NULL,
    cedula_Persona INT NOT NULL,
    PRIMARY KEY (cedula_Persona, id_Medico),
    FOREIGN KEY (id_Medico) REFERENCES Medico(id),
    FOREIGN KEY (cedula_Persona) REFERENCES Persona(cedula)
);

CREATE TABLE IF NOT EXISTS Medico_Medico(
    id_Medico INT NOT NULL,
    id_Especialista INT NOT NULL,
    PRIMARY KEY (id_Especialista, id_Medico),
    FOREIGN KEY (id_Medico) REFERENCES Medico(id),
    FOREIGN KEY (id_Especialista) REFERENCES Medico(id)
);

CREATE TABLE IF NOT EXISTS Medicamento_Cita(
    nombre_Medicamento VARCHAR(100),
    fecha_Cita DATETIME NOT NULL,
    PRIMARY KEY (nombre_Medicamento, fecha_Cita),
    FOREIGN KEY (nombre_Medicamento) REFERENCES Medicamento(nombre),
    FOREIGN KEY (fecha_Cita) REFERENCES Cita(fecha)
);

INSERT INTO Persona (cedula, nombre, apellido, correo, tipo)
VALUES
(0, 'Juan', 'Pérez', 'juan.perez@example.com', 0),
(1, 'Ana', 'Gómez', 'ana.gomez@example.com', 0),
(2, 'Pedro', 'Rodríguez', 'pedro.rodriguez@example.com', 0),
(3, 'María', 'López', 'maria.lopez@example.com', 0),
(4, 'Carlos', 'Sánchez', 'carlos.sanchez@example.com', 0),
(5, 'Laura', 'Martínez', 'laura.martinez@example.com', 1),
(6, 'José', 'Fernández', 'jose.fernandez@example.com', 1),
(7, 'Sofía', 'Hernández', 'sofia.hernandez@example.com', 1),
(8, 'Daniel', 'Díaz', 'daniel.diaz@example.com', 1),
(9, 'Isabel', 'García', 'isabel.garcia@example.com', 1);

INSERT INTO Medico (id, especialidad, cedula)
VALUES
(0, 'Cirugía', 5),
(1, 'Cardiología', 6),
(2, NULL, 7),
(3, 'Dermatología', 8),
(4, 'Oftalmología', 9);

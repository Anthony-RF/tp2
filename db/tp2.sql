CREATE DATABASE IF NOT EXISTS tp2;

USE tp2;

DROP TABLE IF EXISTS Medico_Persona;
DROP TABLE IF EXISTS Medicamento_Cita;
DROP TABLE IF EXISTS Medico_Medico;
DROP TABLE IF EXISTS Cita;
DROP TABLE IF EXISTS Medicamento;
DROP TABLE IF EXISTS Medico;


CREATE TABLE IF NOT EXISTS Persona(
    cedula INT PRIMARY KEY UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS Medico(
    cedula INT PRIMARY KEY,
    identificador INT UNIQUE NOT NULL,
    especialidad VARCHAR(100),
    FOREIGN KEY (cedula) REFERENCES Persona(cedula)
);

CREATE TABLE IF NOT EXISTS Medicamento(
    nombre VARCHAR(100) PRIMARY KEY NOT NULL
);

CREATE TABLE IF NOT EXISTS Cita(
    fecha DATETIME PRIMARY KEY UNIQUE NOT NULL,
    padecimiento VARCHAR(100) NOT NULL,
    cedula_Persona INT NOT NULL,
    cedula_Medico INT NOT NULL,
    FOREIGN KEY (cedula_Persona) REFERENCES Persona(cedula),
    FOREIGN KEY (cedula_Medico) REFERENCES Medico(cedula)
);

CREATE TABLE IF NOT EXISTS Medico_Persona(
    cedula_Medico INT NOT NULL,
    cedula_Persona INT NOT NULL,
    PRIMARY KEY (cedula_Persona, cedula_Medico),
    FOREIGN KEY (cedula_Medico) REFERENCES Medico(cedula),
    FOREIGN KEY (cedula_Persona) REFERENCES Persona(cedula)
);

CREATE TABLE IF NOT EXISTS Medico_Medico(
    cedula_Medico INT NOT NULL,
    cedula_Especialista INT NOT NULL,
    PRIMARY KEY (cedula_Especialista, cedula_Medico),
    FOREIGN KEY (cedula_Medico) REFERENCES Medico(cedula),
    FOREIGN KEY (cedula_Especialista) REFERENCES Medico(cedula)
);

CREATE TABLE IF NOT EXISTS Medicamento_Cita(
    nombre_Medicamento VARCHAR(100),
    fecha_Cita DATETIME NOT NULL,
    PRIMARY KEY (nombre_Medicamento, fecha_Cita),
    FOREIGN KEY (nombre_Medicamento) REFERENCES Medicamento(nombre),
    FOREIGN KEY (fecha_Cita) REFERENCES Cita(fecha)
);

INSERT INTO Persona (cedula, nombre, apellido, correo)
VALUES
(0, 'Juan', 'Pérez', 'juan.perez@example.com'),
(1, 'Ana', 'Gómez', 'ana.gomez@example.com'),
(2, 'Pedro', 'Rodríguez', 'pedro.rodriguez@example.com'),
(3, 'María', 'López', 'maria.lopez@example.com'),
(4, 'Carlos', 'Sánchez', 'carlos.sanchez@example.com'),
(5, 'Laura', 'Martínez', 'laura.martinez@example.com'),
(6, 'José', 'Fernández', 'jose.fernandez@example.com'),
(7, 'Sofía', 'Hernández', 'sofia.hernandez@example.com'),
(8, 'Daniel', 'Díaz', 'daniel.diaz@example.com'),
(9, 'Isabel', 'García', 'isabel.garcia@example.com');

INSERT INTO Medico (cedula, identificador, especialidad)
VALUES
(0, 0, 'Cirugía'),
(1, 1, 'Cardiología'),
(2, 2, NULL),
(3, 3, 'Dermatología'),
(4, 4, 'Oftalmología'),
(5, 5, NULL),
(6, 6, 'Neurología'),
(7, 7, 'Ortopedia'),
(8, 8, 'Endocrinología'),
(9, 9, NULL);

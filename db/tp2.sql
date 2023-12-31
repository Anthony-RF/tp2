CREATE DATABASE IF NOT EXISTS tp2;

USE tp2;

DROP TABLE IF EXISTS Medico_Persona;
DROP TABLE IF EXISTS Medicamento_Cita;
DROP TABLE IF EXISTS Medico_Medico;
DROP TABLE IF EXISTS Cita;
DROP TABLE IF EXISTS Medicamento;
DROP TABLE IF EXISTS Medico;
DROP TABLE IF EXISTS Persona;


CREATE TABLE IF NOT EXISTS Persona(
    cedula INT PRIMARY KEY UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS Medico(
    id INT PRIMARY KEY UNIQUE NOT NULL,
    especialidad VARCHAR(100),
    cedula INT UNIQUE NOT NULL,
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

INSERT INTO Medico (id, especialidad, cedula)
VALUES
(1, 'Cirugía', 5),
(2, 'Cardiología', 6),
(3, 'MG', 7),
(4, 'Dermatología', 8),
(5, 'Oftalmología', 9);

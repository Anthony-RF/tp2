CREATE DATABASE IF NOT EXISTS tp2;

USE tp2;

DROP TABLE IF EXISTS Medico_Paciente;
DROP TABLE IF EXISTS Medicamento_Cita;
DROP TABLE IF EXISTS Medico_Medico;
DROP TABLE IF EXISTS Cita;
DROP TABLE IF EXISTS Medicamento;
DROP TABLE IF EXISTS Paciente;
DROP TABLE IF EXISTS Medico;

CREATE TABLE IF NOT EXISTS Medico(
    cedula INT PRIMARY KEY UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL, 
    identificador INT UNIQUE NOT NULL,
    especialidad VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Paciente(
    cedula INT PRIMARY KEY UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS Medicamento(
	nombre VARCHAR(100) PRIMARY KEY NOT NULL
);

CREATE TABLE IF NOT EXISTS Cita(
	Fecha DATETIME PRIMARY KEY UNIQUE NOT NULL,
    Padecimiento VARCHAR(100) NOT NULL,
    cedula_Paciente INT NOT NULL,
	FOREIGN KEY (cedula_Paciente) REFERENCES Paciente(cedula),
	cedula_Medico INT NOT NULL,
	FOREIGN KEY (cedula_Medico) REFERENCES Medico(cedula)
);

CREATE TABLE IF NOT EXISTS Medico_Paciente(
	cedula_Medico INT NOT NULL,
	FOREIGN KEY (cedula_Medico) REFERENCES Medico(cedula),
    cedula_Paciente INT NOT NULL,
	FOREIGN KEY (cedula_Paciente) REFERENCES Paciente(cedula),
    PRIMARY KEY (cedula_Paciente, cedula_Medico)
);

CREATE TABLE IF NOT EXISTS Medico_Medico(
    cedula_Medico INT NOT NULL,
	FOREIGN KEY (cedula_Medico) REFERENCES Medico(cedula),
	cedula_Especialista INT NOT NULL,
	FOREIGN KEY (cedula_Especialista) REFERENCES Medico(cedula),
    PRIMARY KEY (cedula_Especialista, cedula_Medico)
);

CREATE TABLE IF NOT EXISTS Medicamento_Cita(
    nombre_Medicamento CHAR(100),
	FOREIGN KEY (nombre_Medicamento) REFERENCES Medicamento(nombre),
	Fecha_Cita DATETIME NOT NULL,
	FOREIGN KEY (Fecha_Cita) REFERENCES Cita(Fecha),
    PRIMARY KEY (nombre_Medicamento, Fecha_Cita)
);

INSERT INTO Medico (cedula, nombre, apellido, correo, identificador, especialidad)
VALUES
(0, 'Juan', 'Pérez', 'juan.perez@example.com', 0, 'Cirugía'),
(1, 'Ana', 'Gómez', 'ana.gomez@example.com', 1, 'Cardiología'),
(2, 'Pedro', 'Rodríguez', 'pedro.rodriguez@example.com', 2, NULL),
(3, 'María', 'López', 'maria.lopez@example.com', 3, 'Dermatología'),
(4, 'Carlos', 'Sánchez', 'carlos.sanchez@example.com', 4, 'Oftalmología'),
(5, 'Laura', 'Martínez', 'laura.martinez@example.com', 5, NULL),
(6, 'José', 'Fernández', 'jose.fernandez@example.com', 6, 'Neurología'),
(7, 'Sofía', 'Hernández', 'sofia.hernandez@example.com', 7, 'Ortopedia'),
(8, 'Daniel', 'Díaz', 'daniel.diaz@example.com', 8, 'Endocrinología'),
(9, 'Isabel', 'García', 'isabel.garcia@example.com', 9, NULL);
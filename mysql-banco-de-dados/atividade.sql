CREATE DATABASE TesteBanco;

USE TesteBanco;

CREATE TABLE tbl_Usuario(
	idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nomeUsuario VARCHAR(50) NOT NULL,
    idade VARCHAR(3),
    noCpf VARCHAR(14) NOT NULL,
    dsEmail VARCHAR(50) NOT NULL,
    sexo VARCHAR(10) NOT NULL
);
SELECT * FROM tbl_Usuario;

CREATE TABLE tbl_Adm(
	idAdm INT PRIMARY KEY AUTO_INCREMENT,
    nomeAdm VARCHAR(50) NOT NULL,
    cpfAdm VARCHAR(14) NOT NULL
);
SELECT * FROM tbl_Adm;

CREATE TABLE tbl_Evento(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nomeEvento VARCHAR(50),
    descricao VARCHAR(100),
    dataInicio DATE,
    dataFinal DATE
);
SELECT * FROM tbl_Evento;


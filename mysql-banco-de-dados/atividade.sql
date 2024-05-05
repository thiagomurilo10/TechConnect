CREATE DATABASE techconnect;

USE techconnect;

CREATE TABLE tbl_Usuario(
	idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nomeUsuario VARCHAR(50) NOT NULL,
    login VARCHAR(50) NOT NULL,
    senha VARCHAR(60) NOT NULL,
    idade VARCHAR(3) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    email VARCHAR(50) NOT NULL,
    sexo VARCHAR(10) NOT NULL
);

INSERT INTO tbl_Usuario(nomeUsuario, login, senha, idade, cpf, email, sexo) VALUES ("José", "usuario", "123", "23", "12345678912", "usuario@email.com", "Masculino");
SELECT * FROM tbl_Usuario;

CREATE TABLE tbl_Adm(
	idAdm INT PRIMARY KEY AUTO_INCREMENT,
    nomeAdm VARCHAR(50) NOT NULL,
    login VARCHAR(50) NOT NULL,
    senha VARCHAR(60) NOT NULL,
    cpfAdm VARCHAR(14) NOT NULL
);

INSERT INTO tbl_Adm(nomeAdm, login, senha, cpfAdm) VALUES ("Jonas", "admin", "123", "11122233344");
SELECT * FROM tbl_Adm;

CREATE TABLE tbl_Evento(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nomeEvento VARCHAR(50),
    descricao VARCHAR(100),
    dataInicio DATE,
    dataFinal DATE
);
SELECT * FROM tbl_Evento;


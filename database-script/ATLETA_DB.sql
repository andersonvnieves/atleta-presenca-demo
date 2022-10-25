CREATE DATABASE [ATLETA_DB];
GO

USE [ATLETA_DB];
GO

CREATE TABLE [ATLETA] (
	ID INT IDENTITY PRIMARY KEY,
	NOME_COMPLETO VARCHAR(100) NOT NULL,
	DATA_NASCIMENTO DATE NOT NULL,
	EMAIL VARCHAR(256) NOT NULL,
	CELULAR VARCHAR(11) NOT NULL
);

CREATE TABLE [ESTADO] (
	ID INT IDENTITY PRIMARY KEY,
	SIGLA CHAR(2) NOT NULL,
	ESTADO VARCHAR(25) NOT NULL
);
CREATE TABLE [ENDERECO] (
	ID INT IDENTITY PRIMARY KEY,
	ESTADO_ID INT FOREIGN KEY REFERENCES [ESTADO]([ID]),
	CIDADE VARCHAR(50) NOT NULL,
	BAIRRO VARCHAR(50) NOT NULL,
	RUA VARCHAR(100) NOT NULL,
	CEP CHAR(8) NOT NULL,
	NUMERO VARCHAR(15) NOT NULL,
	COMPLEMENT0 VARCHAR(200) NULL
);


ALTER TABLE [ATLETA] 
	ADD ENDERECO_ID INT FOREIGN KEY REFERENCES [ENDERECO]([ID]) NOT NULL;

INSERT INTO [ESTADO] ([SIGLA],[ESTADO])
VALUES ('AC', 'Acre'),
('AL', 'Alagoas'),
('AP', 'Amapá'),
('AM', 'Amazonas'),
('BA', 'Bahia'),
('CE', 'Ceará'),
('DF', 'Distrito Federal'),
('ES', 'Espírito Santo'),
('GO', 'Goiás'),
('MA', 'Maranhão'),
('MT', 'Mato Grosso'),
('MS', 'Mato Grosso do Sul'),
('MG', 'Minas Gerais'),
('PA', 'Pará'),
('PB', 'Paraíba'),
('PR', 'Paraná'),
('PE', 'Pernambuco'),
('PI', 'Piauí'),
('RJ', 'Rio de Janeiro'),
('RN', 'Rio Grande do Norte'),
('RS', 'Rio Grande do Sul'),
('RO', 'Rondônia'),
('RR', 'Roraima'),
('SC', 'Santa Catarina'),
('SP', 'São Paulo'),
('SE', 'Sergipe'),
('TO', 'Tocantins');
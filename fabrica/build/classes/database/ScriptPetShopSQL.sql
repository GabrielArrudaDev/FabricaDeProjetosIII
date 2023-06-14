create database petshop;
use petshop;

create table funcionario(
idFuncionario int primary key auto_increment,
email VARCHAR(60) unique,
senha VARCHAR(30)
);

create table agendamento(
idDono int auto_increment primary key,
nomeDono varchar(45),
nomeAnimal varchar(45),
telefone varchar(45),
animal varchar(45),
servico varchar(45),
hora varchar(45),
kilos varchar(45),
agenda varchar(45),
cpf varchar(45) not null 
);




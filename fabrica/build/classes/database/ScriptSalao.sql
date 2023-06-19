DROP database IF EXISTS salao;
create database salao;
use salao;

create table funcionario(
idFuncionario int primary key auto_increment,
email VARCHAR(60) unique,
senha VARCHAR(30)
);

create table agendamento(
nome varchar(45),
telefone varchar(45),
servico varchar(45),
hora varchar(45),
valor varchar(45),
agenda varchar(45),
cpf varchar(45) not null 
);




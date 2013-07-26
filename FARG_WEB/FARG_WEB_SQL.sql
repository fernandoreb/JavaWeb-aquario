CREATE TABLE PROJETO (ID INTEGER NOT NULL,
	nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    PRIMARY KEY (ID));
    
CREATE TABLE AQUARIO (ID INTEGER NOT NULL AUTO_INCREMENT,
	dataMedicao varchar(15),
    horaMedicao varchar(15),
    tempAgua float,
    tempTampa float,
    tempAmb float,
    nivelSump integer,
    nivelRepo integer,
    luzLigada integer,
    PRIMARY KEY (ID));     
      
DROP TABLE AQUARIO;

delete from aquario;
select * from aquario;

DELETE a FROM aquario a, aquario b WHERE a.dataMedicao = b.dataMedicao AND a.tempAgua = b.tempAgua AND a.tempTampa = b.tempTampa AND a.tempAmb = b.tempAmb AND a.nivelRepo = b.nivelRepo AND b.id IS NOT NULL AND a.id <> b.id;

create table users (
 user_name         varchar(15) not null primary key,
 user_pass         varchar(15) not null
);
create table user_roles (
 user_name         varchar(15) not null,
 role_name         varchar(15) not null,
 primary key (user_name, role_name)
);

insert into users (user_name, user_pass) values ('user1', 'mypass');
insert into user_roles (user_name, role_name) values ('user1', 'member');

insert into users (user_name, user_pass) values ('fernandoreb', 'fernandoreb');
insert into user_roles (user_name, role_name) values ('fernandoreb', 'member');

select * from users;




 
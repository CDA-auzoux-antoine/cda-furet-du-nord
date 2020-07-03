create database cda_librairie;
use cda_librairie;


create table livre (id_livre int(6) auto_increment not null,
titre varchar(50) not null,
auteur varchar(50),
nombreDePages int(4),
genre varchar(50),
prix  decimal(5,2) not null,
quantite int(3),
primary key (id_livre)) ENGINE = InnoDB;

create table personne (id_personne int(6) auto_increment not null,
nom varchar(50) not null,
prenom varchar(50) not null,

login varchar(100) unique not null ,
password varchar(200) not null,
id_adresse int(6) not null,
isActived Bool DEFAULT false,
isClient Bool default true, #1 = client 2=libraire
primary key (id_personne)) ENGINE = InnoDB;

create table adresse (id_adresse int(10) auto_increment not null,
numeroDeRue int(5) not null,
rue varchar(50) not null,
cp int(5) not null,
ville varchar(30),
primary key (id_adresse)) ENGINE = InnoDB;

create table Commande (id_commande int(10) auto_increment not null,
id_personne int(6) not null ,
date_Commande date,
primary key (id_commande,id_personne)) ENGINE = InnoDB;

create table detailsCommande (
id_commande int(10) not null,
id_livre int(6) not null,
quantite int(3) not null ,
prixUnitaire  decimal(5,2)
) ENGINE = InnoDB;

insert into adresse (numeroDeRue,rue,cp,  ville)values(123,"rue","5900","lille");

insert into personne (nom,prenom ,id_adresse ,login ,password, isActived ) values("client1","client1", 1, "client1","client1", true);
insert into personne (nom,prenom ,id_adresse ,login ,password, isActived ) values("client2","client2", 1, "client2","client2", false);
insert into personne (nom,prenom ,id_adresse ,login ,password ,isActived ,isClient ) values("libraireN","libraireP", 1, "libraire","libraire",true,false);


select * from personne;

select * from personne where login="client" and password="client";
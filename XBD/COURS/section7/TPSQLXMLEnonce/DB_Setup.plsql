-- Tables pour la partie SQLXML
-------------------------------

-- Création des tables
create table Villes (
	IdVille int primary key,
	NPA int not null,
	Nom varchar(100) not null);

create table Radios (
	IdRadio int primary key,
	Nom varchar(50) not null,
	Genre varchar (100));

create table Frequences (
	IdFreq int primary key,
	IdVille int not null,
	IdRadio int not null,
	Frequence decimal(10,2) not null,
	constraint FK1 foreign key (IdVille) references Villes(IdVille),
	constraint FK2 foreign key (IdRadio) references Radios(IdRadio));

-- Insertion des données
insert into Radios (IdRadio,Nom,Genre) values (1,'La Première','Radio principale de Suisse romande');
insert into Radios (IdRadio,Nom,Genre) values (2,'Couleur 3','Programme de la RSR');
insert into Radios (IdRadio,Nom,Genre) values (3,'Radio Fribourg','Radio de la région de Fribourg');
insert into Radios (IdRadio,Nom,Genre) values (4,'Espace 2','Deuxième programme de la RSR');
insert into Radios (IdRadio,Nom,Genre) values (5,'DRS 1','Radio suisse alémanique');
insert into Radios (IdRadio,Nom,Genre) values (6,'DRS 2','Radio suisse alémanique');
insert into Radios (IdRadio,Nom,Genre) values (7,'DRS 3','Radio suisse alémanique');
insert into Radios (IdRadio,Nom,Genre) values (8,'Option musique','Programme de ls RSR');
insert into Radios (IdRadio,Nom,Genre) values (9,'Rete Uno','Radio tessinoise');
insert into Radios (IdRadio,Nom,Genre) values (10,'Rete Due','Radio tessinoise');
insert into Radios (IdRadio,Nom,Genre) values (11,'Rete Tre','Radio tessinoise');
insert into Radios (IdRadio,Nom,Genre) values (12,'Radio Swiss Jazz','Programme de jazz');
insert into Radios (IdRadio,Nom,Genre) values (13,'Radio Swiss Classic','Programme de musique classique');
insert into Radios (IdRadio,Nom,Genre) values (14,'Radio Swiss Pop','Programme pop');
insert into Radios (IdRadio,Nom,Genre) values (15,'Radio Rumantsch','Radio romanche');
insert into Radios (IdRadio,Nom,Genre) values (16,'DRS Musigwälle','Programme musical');
insert into Radios (IdRadio,Nom,Genre) values (17,'Virus','Programme suisse alémanique');

insert into Villes (IdVille,NPA,Nom) values (1,1700,'Fribourg');
insert into Villes (IdVille,NPA,Nom) values (2,1000,'Lausanne');
insert into Villes (IdVille,NPA,Nom) values (3,1200,'Genève');
insert into Villes (IdVille,NPA,Nom) values (4,2000,'Neuchatel');
insert into Villes (IdVille,NPA,Nom) values (5,2502,'Bienne');
insert into Villes (IdVille,NPA,Nom) values (6,1950,'Sion');
insert into Villes (IdVille,NPA,Nom) values (7,3000,'Berne');
insert into Villes (IdVille,NPA,Nom) values (8,8000,'Zurich');
insert into Villes (IdVille,NPA,Nom) values (9,6000,'Lucerne');
insert into Villes (IdVille,NPA,Nom) values (10,4000,'Bâle');
insert into Villes (IdVille,NPA,Nom) values (11,6900,'Lugano');
insert into Villes (IdVille,NPA,Nom) values (12,2800,'Delémont');
insert into Villes (IdVille,NPA,Nom) values (13,9000,'St-Gall');
insert into Villes (IdVille,NPA,Nom) values (14,7000,'Coire');
insert into Villes (IdVille,NPA,Nom) values (15,6500,'Bellinzone');
insert into Villes (IdVille,NPA,Nom) values (16,3600,'Thoune');
insert into Villes (IdVille,NPA,Nom) values (17,6300,'Zoug');

insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(1,1,1,102.6);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(2,1,2,88.6);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(3,1,3,89.4);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(4,1,5,103.0);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(5,1,6,97.0);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(6,1,7,105.3);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(7,2,1,102.6);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(8,2,2,98.5);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(9,2,4,96.2);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(10,2,5,88.1);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(11,2,9,97.8);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(12,3,1,94.9);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(13,3,2,104.4);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(14,3,4,100.1);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(15,4,1,95.1);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(16,4,2,104.2);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(17,4,4,92.0);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(18,4,5,88.2);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(19,4,9,107.3);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(20,5,1,95.1);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(21,5,2,105.0);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(22,5,4,102.7);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(23,5,5,88.2);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(24,5,9,103.3);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(25,6,1,94.4);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(26,6,2,106.0);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(27,6,4,96.5);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(28,6,5,88.2);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(29,7,5,88.2);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(30,7,6,93.2);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(31,7,7,99.3);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(32,7,1,95.1);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(33,7,16,531);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(34,8,5,90.9);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(35,8,6,95.4);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(36,8,7,103.8);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(37,8,9,106.2);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(38,8,1,99.9);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(39,8,16,531);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(40,9,5,90.9);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(41,9,6,96.6);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(42,9,7,103.8);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(43,10,5,90.6);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(44,10,6,99.0);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(45,10,7,103.6);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(46,11,5,96.3);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(47,11,9,88.1);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(48,11,10,91.5);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(49,11,11,106.0);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(50,11,1,104.0);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(51,12,1,89.6);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(52,12,2,104.8);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(53,12,4,93.0);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(54,13,5,96.0);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(55,13,6,104.1);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(56,13,7,106.0);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(57,14,5,90.9);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(58,14,6,100.4);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(59,14,7,106.0);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(60,14,15,88.6);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(61,14,9,95.8);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(62,15,9,89.4);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(63,15,10,93.5);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(64,15,11,107.4);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(65,16,5,89.5);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(66,16,6,98.1);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(67,16,7,105.8);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(68,17,5,90.9);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(69,17,6,96.6);
insert into Frequences(IdFreq,IdVille,IdRadio,Frequence) values(70,17,7,103.8);

-- Tables pour la partie XQuery
-------------------------------

CREATE TABLE BD(
	BD_PK int primary key not null,
	BD_List XMLType);

CREATE TABLE Personnes(
	PER_PK int primary key not null,
	PER_List XMLType);

CREATE TABLE Distributeurs(
	DIS_PK int primary key not null,
	DIS_List XMLType);

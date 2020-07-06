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
date_Commande TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
primary key (id_commande,id_personne)) ENGINE = InnoDB;


create table detailsCommande (
id_commande int(10) not null,
id_livre int(6) not null,
quantite int(3) not null ,
prixUnitaire  decimal(5,2),
commande_livree bool default false # permet de voir si la commande a été livrée ou pas afin de pouvoir l annuler
) ENGINE = InnoDB;

insert into adresse (numeroDeRue,rue,cp,  ville)values(123,"rue","5900","lille");

insert into personne (nom,prenom ,id_adresse ,login ,password, isClient ) values("libraire","libraire", 1, "libraire3",md5("libraire3"),false);
insert into personne (nom,prenom ,id_adresse ,login ,password, isActived ) values("client2","client2", 1, "client2","client2", false);
insert into personne (nom,prenom ,id_adresse ,login ,password ,isActived ,isClient ) values("libraireN","libraireP", 1, "libraire","libraire",true,false);


#random clients:

insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Nelle', 'O''Halleghane', 1, 'nohalleghane0', '6ee18f359ce7c30dae92d3a289d35748', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Cayla', 'Trelease', 2, 'ctrelease1', '632c5cf025f9c52508e50ae98b784f0a', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Boy', 'Trott', 3, 'btrott2', '0a4eadec487841a52ea8ec199685ad68', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Adriane', 'Fergyson', 4, 'afergyson3', 'ed7c1a2d93a4902f0cdb47f0abe77e32', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Sheri', 'McKennan', 5, 'smckennan4', '10165f6c9a97f824bd374417cde00c06', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Florrie', 'Rivlin', 6, 'frivlin5', '8ca41127c715bf157398f0ea3f250f98', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Garold', 'Choldcroft', 7, 'gcholdcroft6', 'df3a6a17a09a68f6358367e0209a2438', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Garek', 'Bockmaster', 8, 'gbockmaster7', 'c4d5b580a558a9ac04f70aa21656e26c', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Byrann', 'Jantzen', 9, 'bjantzen8', 'ac9074a12a882a420c353d0f67cc3716', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Mac', 'Stickells', 10, 'mstickells9', '09d6daefd48e75e1728565d070fe4e66', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Candra', 'Hopkynson', 11, 'chopkynsona', 'd0bc4e35fb8c255f35222e2140a4781d', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Meyer', 'Dassindale', 12, 'mdassindaleb', '03d604beb258ead4b1a9b6618ac50eda', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Kristos', 'Kliment', 13, 'kklimentc', 'a91c9d48dc9b3545c12a6b4e8c9298e2', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Basilio', 'Connerry', 14, 'bconnerryd', 'b30ee8c12fab54c4c007cfcd71a6f569', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Avigdor', 'Claiden', 15, 'aclaidene', 'f6d9b51afd97d2c30444b25bf7cdb722', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Paulette', 'Chidley', 16, 'pchidleyf', '5c59c1496c0bea95afcad222bd6acc40', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Clarice', 'Mawditt', 17, 'cmawdittg', '5246c70e2ac7b70b1ca2591de66e9753', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Madelon', 'Curro', 18, 'mcurroh', '933050f4fa40075f99d830f2de3c45f4', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Lynnet', 'Melanaphy', 19, 'lmelanaphyi', '2cb0335e112ae305febf791f7894b917', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Saxon', 'Fedorski', 20, 'sfedorskij', 'ee4c3c7e9c991b61e5e1ab2f64e834ed', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Dav', 'Rottcher', 21, 'drottcherk', '6c36f5132788f30e24d5b6ed4962766d', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Tedman', 'Ridding', 22, 'triddingl', '125b51728f387928bc362196206818d2', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Wit', 'Bocken', 23, 'wbockenm', 'a61082e839f338b9b3b94a255b455718', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Gerhardine', 'Casacchia', 24, 'gcasacchian', 'c9dd3c31de812a06fa3e94a8e956abfa', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Gun', 'Marston', 25, 'gmarstono', 'f1430121828c163ad17fa2dbd9420724', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Lorrie', 'Charteris', 26, 'lcharterisp', '8be5d98a14a5ff92288775304445be62', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Katerine', 'Affuso', 27, 'kaffusoq', '22b7dc7849e67801f87b34ed4093265e', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Lucila', 'Remer', 28, 'lremerr', 'b4f617818ec6a9c7d112b01b70823d2f', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Norton', 'Wandrich', 29, 'nwandrichs', 'a002a80146d85098be1f70a6d0006ad5', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Moria', 'Tunnicliffe', 30, 'mtunnicliffet', 'b450d7890415363839be721d61c36535', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Calv', 'Westmoreland', 31, 'cwestmorelandu', '046bfc86b14539633f4bd13ac940ba10', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Oates', 'Borthe', 32, 'oborthev', '9683b3a1909f99f10a441ffde8dc1ed3', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Ned', 'Darleston', 33, 'ndarlestonw', '64e6682e80fc7679d9d473603b4ca352', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Gawain', 'Darwood', 34, 'gdarwoodx', 'c475788f0e1caf7e12293fbbbd97a358', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Tamera', 'Boschmann', 35, 'tboschmanny', '5ad92160567a811e98813fcbfe0128c5', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Josiah', 'Benford', 36, 'jbenfordz', 'd06bd4f2ddbac9c20cd341005dff20c8', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Ian', 'Caesar', 37, 'icaesar10', '0ee8d5a7d6731540a1be1d618e661007', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Radcliffe', 'Blaby', 38, 'rblaby11', '30bac93c6d3a678b37f6d44e879d9743', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Terra', 'Wapples', 39, 'twapples12', '2b15eb86b603a8ea372b3715762833e3', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Shanta', 'Raybould', 40, 'sraybould13', '7365044c3fa1d35171fdb2081fa0bd78', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Corbett', 'Matthensen', 41, 'cmatthensen14', 'de2888a02e3cc4bdacc76469bf224c65', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Ariel', 'McEvay', 42, 'amcevay15', '737f9e70c523de44d951fc9d0d7e2dc6', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Gilli', 'Lacknor', 43, 'glacknor16', 'd6af9d4a9ea8eb4f4a14885d0d315799', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Erma', 'Asey', 44, 'easey17', 'ef3ede2719e1a22af71c1cbef05a3910', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Burg', 'Tuohy', 45, 'btuohy18', 'c6fb1792338c8efd4c35c2f96ba19c99', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Markus', 'Duddin', 46, 'mduddin19', '5907b653c44cc9cb63d96b282d3c362b', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Ange', 'Wordsley', 47, 'awordsley1a', '8e3ace0b26bbbf6d527881f68eca2726', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Riva', 'Baniard', 48, 'rbaniard1b', '0f9cc5af4c3f327ab6ea6b2c1b38a23e', true);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Winny', 'Poston', 49, 'wposton1c', 'f7891f660a6cc9b5182044207435e6ed', false);
insert into personne (nom, prenom, id_adresse, login, password, isActived) values ('Clementina', 'Brixham', 50, 'cbrixham1d', 'ee0a4d8df1973993676710bf8a645164', true);



#random adresse


insert into adresse (numeroDeRue, rue, ville, cp) values ('91325', 'Waywood', 'General Jos� de San Mart�n', 19235);
insert into adresse (numeroDeRue, rue, ville, cp) values ('01493', 'Calypso', 'Promna', 13233);
insert into adresse (numeroDeRue, rue, ville, cp) values ('53386', 'Ryan', 'Muang Long', 74387);
insert into adresse (numeroDeRue, rue, ville, cp) values ('760', 'Knutson', 'Padhahegha', 93672);
insert into adresse (numeroDeRue, rue, ville, cp) values ('85', 'Washington', 'Lyon', 44111);
insert into adresse (numeroDeRue, rue, ville, cp) values ('281', 'Beilfuss', 'Malaga', 50273);
insert into adresse (numeroDeRue, rue, ville, cp) values ('87', 'Nobel', 'Leiden', 97501);
insert into adresse (numeroDeRue, rue, ville, cp) values ('05', 'Kingsford', 'Xianhe', 54495);
insert into adresse (numeroDeRue, rue, ville, cp) values ('2', 'Macpherson', 'Maca�ba', 17966);
insert into adresse (numeroDeRue, rue, ville, cp) values ('36', 'Oakridge', 'Krajan', 18791);
insert into adresse (numeroDeRue, rue, ville, cp) values ('0', 'David', 'Chinameca', 37446);
insert into adresse (numeroDeRue, rue, ville, cp) values ('3', 'Old Shore', 'Otyn', 80334);
insert into adresse (numeroDeRue, rue, ville, cp) values ('9', 'Forster', 'Dingbu', 93134);
insert into adresse (numeroDeRue, rue, ville, cp) values ('86518', 'Crest Line', 'Leczyce', 69236);
insert into adresse (numeroDeRue, rue, ville, cp) values ('3', 'Thompson', 'Nanmen', 80384);
insert into adresse (numeroDeRue, rue, ville, cp) values ('603', 'Dennis', 'Pakel', 72202);
insert into adresse (numeroDeRue, rue, ville, cp) values ('4', 'Mendota', 'Mahaplag', 69005);
insert into adresse (numeroDeRue, rue, ville, cp) values ('5', 'Monument', 'Goya', 18689);
insert into adresse (numeroDeRue, rue, ville, cp) values ('50075', 'David', 'Dimitrovgrad', 21945);
insert into adresse (numeroDeRue, rue, ville, cp) values ('44', 'Eagan', 'Lamadong', 63762);
insert into adresse (numeroDeRue, rue, ville, cp) values ('6', '1st', 'Antsiranana', 48305);
insert into adresse (numeroDeRue, rue, ville, cp) values ('4056', 'Pennsylvania', 'Erdaobaihe', 90520);
insert into adresse (numeroDeRue, rue, ville, cp) values ('2454', 'Cordelia', 'Heerlen', 12830);
insert into adresse (numeroDeRue, rue, ville, cp) values ('8464', 'Sullivan', 'Cielmice', 65701);
insert into adresse (numeroDeRue, rue, ville, cp) values ('7', 'Boyd', 'La Concepcion', 63790);
insert into adresse (numeroDeRue, rue, ville, cp) values ('1750', 'Old Gate', 'Muli', 24084);
insert into adresse (numeroDeRue, rue, ville, cp) values ('543', 'Leroy', 'El Arenal', 47285);
insert into adresse (numeroDeRue, rue, ville, cp) values ('3', 'Kropf', 'Lahar', 62348);
insert into adresse (numeroDeRue, rue, ville, cp) values ('76', 'Del Mar', 'Shuijiang', 39686);
insert into adresse (numeroDeRue, rue, ville, cp) values ('79', 'Northland', 'Kabir', 95353);
insert into adresse (numeroDeRue, rue, ville, cp) values ('587', 'Miller', 'Bafq', 17216);
insert into adresse (numeroDeRue, rue, ville, cp) values ('1', 'Pennsylvania', 'Svetlyy', 95834);
insert into adresse (numeroDeRue, rue, ville, cp) values ('653', 'Packers', 'Pyh�selk�', 44087);
insert into adresse (numeroDeRue, rue, ville, cp) values ('642', '5th', 'Nong Khai', 80718);
insert into adresse (numeroDeRue, rue, ville, cp) values ('6023', '7th', 'Riangkroko', 50399);
insert into adresse (numeroDeRue, rue, ville, cp) values ('63', 'Carberry', 'Faqus', 94834);
insert into adresse (numeroDeRue, rue, ville, cp) values ('31', 'Red Cloud', 'Cibinong', 90907);
insert into adresse (numeroDeRue, rue, ville, cp) values ('413', 'Trailsway', 'Prachuap Khiri Khan', 50544);
insert into adresse (numeroDeRue, rue, ville, cp) values ('02649', 'Calypso', 'Talghar', 47915);
insert into adresse (numeroDeRue, rue, ville, cp) values ('12', 'Raven', 'Caen', 78858);
insert into adresse (numeroDeRue, rue, ville, cp) values ('44453', 'Maywood', 'Frei Paulo', 28032);
insert into adresse (numeroDeRue, rue, ville, cp) values ('72644', 'Corben', 'Liangli', 43653);
insert into adresse (numeroDeRue, rue, ville, cp) values ('0', 'Elmside', 'Lat Yao', 15000);
insert into adresse (numeroDeRue, rue, ville, cp) values ('087', 'Fuller', 'Cocachacra', 47579);
insert into adresse (numeroDeRue, rue, ville, cp) values ('5', 'Gale', 'Constance', 45512);
insert into adresse (numeroDeRue, rue, ville, cp) values ('117', 'Orin', 'Tayang', 58834);
insert into adresse (numeroDeRue, rue, ville, cp) values ('70689', 'Holmberg', 'Cijapar', 89704);
insert into adresse (numeroDeRue, rue, ville, cp) values ('43', 'Meadow Valley', 'Artemivs�k', 48633);
insert into adresse (numeroDeRue, rue, ville, cp) values ('65', 'New Castle', 'V�stra Fr�lunda', 18857);
insert into adresse (numeroDeRue, rue, ville, cp) values ('5', 'Green', 'Bhalwal', 87980);

#random livre
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('District, The (Ny�cker!)', 'Oph�lie', 302, 'Animation Comedy', 32.87, 195);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Land of Happines (Onnen maa)', 'Mich�le', 405, 'Drama', 45.36, 97);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Death Wish 3', 'S�verine', 431, 'Action Drama', 25.55, 71);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Point Blank (� bout portant)', 'Ru�', 498, 'Action Crime Thriller', 24.43, 117);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Innocence', 'Oph�lie', 264, 'Drama', 5.30, 312);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Trade', 'Alo�s', 119, 'Crime Drama Thriller', 41.12, 465);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Wild Party, The', 'L�a', 261, 'Comedy Drama', 33.97, 188);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Pok�mon 3: The Movie', 'Cun�gonde', 289, 'Animation Children', 8.35, 273);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Chambermaid on the Titanic', 'Marie-h�l�ne', 421, 'Romance', 46.72, 368);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Snow Beast ', 'Illustr�e', 495, 'Drama Sci-Fi Thriller', 11.35, 464);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Blade, The (Dao)', 'Elo�se', 288, 'Action Drama', 34.94, 486);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('I''ll Do Anything', 'Ang�lique', 243, 'Comedy Drama', 6.01, 286);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('I''ll Be Home For Christmas', 'G�ran', 275, 'Comedy Romance', 21.54, 112);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Peter Pan', 'Marie-h�l�ne', 462, 'Animation Children Fantasy Musical', 8.48, 221);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Biloxi Blues', 'Andr�anne', 496, 'Comedy Drama', 34.86, 98);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Vibes', 'La�la', 194, 'Adventure Comedy Romance', 22.28, 72);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Heavy Metal 2000', 'D�', 127, 'Action Adventure Animation Fantasy Sci-Fi', 7.11, 113);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Prata Palomares', 'Ma�lys', 464, 'Horror Thriller', 32.37, 423);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Thin Blue Lie, The', 'Marie-th�r�se', 251, 'Drama', 7.99, 63);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('White Material', 'Ang�le', 423, 'Drama Mystery Thriller War', 7.11, 275);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Ilsa, She Wolf of the SS', 'Ana�s', 364, 'Horror', 39.75, 338);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Golden Boys, The', 'Ma�lis', 437, 'Comedy Romance', 19.58, 449);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Tristan & Isolde', 'V�ronique', 364, 'Drama Romance', 24.77, 440);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Sukiyaki Western Django', 'C�cile', 337, 'Action Western', 29.43, 373);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Last Lions, The', 'Cin�ma', 344, 'Documentary', 11.59, 290);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Grey Fox, The', 'B�r�nice', 238, 'Romance Western', 13.01, 454);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Next Stop Wonderland', 'R�serv�s', 467, 'Comedy Drama Romance', 6.55, 379);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Made in Britain', 'Aur�lie', 109, 'Crime Drama', 27.67, 403);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Ghost Adventures', 'Cr��z', 398, 'Documentary', 49.73, 332);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Chicken, the Fish and the King Crab', 'Doroth�e', 127, 'Documentary', 47.07, 61);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Turn Me On, Dammit! (F� meg p�, for faen)', 'Cl�mence', 128, 'Comedy', 21.91, 408);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Private Lives', 'St�phanie', 307, 'Comedy Drama', 43.87, 378);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Sammy and Rosie Get Laid', '�ke', 413, 'Comedy Drama', 23.40, 53);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Sex Positive', 'Ru�', 145, 'Documentary', 15.30, 132);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Beerfest', 'Marie-h�l�ne', 143, 'Comedy', 28.23, 308);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Bird of Prey', 'Ru�', 319, 'Action', 15.64, 311);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Hipnos', 'Ma�lle', 111, 'Horror Thriller', 41.84, 235);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Muddy River', 'H�l�ne', 415, 'Drama', 27.10, 86);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Return with Honor', 'G�rald', 400, 'Documentary', 40.64, 345);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Compulsion', 'Ma�ly', 357, 'Crime Drama Thriller', 43.93, 440);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Elephant Man, The', 'Cam�lia', 340, 'Drama', 31.83, 487);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Cyrus', 'B�r�nice', 461, 'Comedy Drama Romance', 17.58, 181);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Killer (Tueur � gages)', 'R�o', 212, 'Action Crime Thriller', 36.01, 438);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('King Ralph', 'Ma�line', 109, 'Comedy', 17.43, 261);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('After...', 'Cl�lia', 495, 'Horror Thriller', 37.54, 413);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Pepi, Luci, Bom ', 'B�cassine', 466, 'Comedy', 35.82, 230);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Dead Outside, The', 'Alm�rinda', 314, 'Horror Mystery Thriller', 18.43, 149);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Backstage', 'Zo�', 293, 'Drama', 49.71, 313);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('Trouble the Water', 'Marl�ne', 345, 'Documentary', 42.62, 155);
insert into livre (titre, auteur, nombreDePages, genre, prix, quantite) values ('On the Edge', 'Gis�le', 192, 'Drama', 33.09, 326);


select * from personne;


#CREATE TABLE myTable (  ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP );

select * from personne p ;



select * from commande c ;

insert into commande (id_personne, date_Commande )values(1, CURRENT_TIMESTAMP);



select * from detailscommande d ;
insert into detailscommande values(1,1, 15, 20, false);
insert into detailscommande values(2,1, 15, 20, true);
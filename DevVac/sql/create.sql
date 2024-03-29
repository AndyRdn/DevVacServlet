CREATE TABLE commande (
    idcommande serial primary key ,
    idsakafo smallint,
    idemployer smallint,
    idtable smallint,
    dateT timestamp,
    montant numeric(18,2)
);

CREATE TABLE employer(
    idemployer serial primary key ,
    nom varchar(50),
    age smallint
);

CREATE TABLE sakafo(
    idsakafo serial primary key ,
    nomSakafo varchar(30) ,
    prix  numeric(18,2)
);

CREATE TABLE restotable(
    idtable serial primary key ,
    nom varchar(30)
);

CREATE TABLE login(
    iduser serial primary key ,
    email varchar(50),
    mdp varchar(16)
);

ALTER TABLE commande add foreign key (idsakafo) references sakafo(idsakafo);
ALTER TABLE commande add foreign key (idemployer) references employer(idemployer);
ALTER TABLE commande add foreign key (idtable) references restotable(idtable);
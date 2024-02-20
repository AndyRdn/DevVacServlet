CREATE TABLE commande (
    idcommande serial primary key ,
    idplat smallint,
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

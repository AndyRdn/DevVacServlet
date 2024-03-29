INSERT INTO employer (nom, age) VALUES
                                    ('John Doe', 35),
                                    ('Alice Smith', 28),
                                    ('Bob Johnson', 42);

INSERT INTO sakafo (nomSakafo, prix) VALUES
                                         ('Pizza Hut', 15.99),
                                         ('McDonalds', 10.50),
                                         ('Subway', 8.75);

INSERT INTO restotable (nom) VALUES
                                 ('Table 1'),
                                 ('Table 2'),
                                 ('Table 3');

INSERT INTO commande (idsakafo, idemployer, idtable, dateT, montant) VALUES
                                                                         (1, 1, 1, '2024-02-24 12:00:00', 25.50),
                                                                         (2, 2, 2, '2024-02-24 12:30:00', 12.75),
                                                                         (3, 3, 3, '2024-02-24 13:00:00', 18.99);
insert into login values
                      (DEFAULT,'user1@gmail.com','1231'),
                      (DEFAULT,'user1@gmail.com','2342');

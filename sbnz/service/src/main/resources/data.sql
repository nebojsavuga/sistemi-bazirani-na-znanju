insert into Users
(email, password, first_name, last_name, role, age, gender, height)
values ( 'nebojsavuga01@gmail.com', 'Nebojsa123', 'Nebojsa', 'Vuga', 'Admin', 22, 'Musko', 183.0);
insert into Users
( email, password, first_name, last_name, role, age, gender, height)
values ( 'bogdanjanosevic@gmail.com', 'Bogdan123', 'Bogdan', 'Janosevic', 'User', 22, 'Musko', 178.0);
insert into Users
(email, password, first_name, last_name, role, age, gender, height)
values ( 'dusanbibin@gmail.com', 'Dusan123', 'Dusan', 'Bibin', 'User', 22, 'Musko', 183.0);

INSERT INTO Injury (name) 
VALUES ('Povreda skocnog zgloba');
INSERT INTO Injury (name) 
VALUES ('Povreda kolena');
INSERT INTO Injury (name) 
VALUES ('Povreda lakta');
INSERT INTO Injury (name) 
VALUES ('Povreda rucnog zgloba');


INSERT INTO Article (name, price, gender, brand_name, DTYPE) 
VALUES ('Wilson Pro Overgrip', 5.99, 'Unisex', 'Wilson', 'Grip');

INSERT INTO Article (name, price, gender, brand_name, DTYPE) 
VALUES ('Icebug Acceleritas8 RB9X', 139.99, 'Unisex', 'Icebug', 'BigCramponOrientiringShoe');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE) 
VALUES ('Silva kamasne za orijentiring', 29.99, 'Unisex', 'Silva', 'Kamasne', 'OrientiringGear');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE) 
VALUES ('Silva Race Jet Compass Glasses', 89.99, 'Unisex', 'Silva', 'Naocare', 'OrientiringGear');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE) 
VALUES ('Suunto M-3 Global Compass', 59.99, 'Unisex', 'Suunto', 'Busola', 'OrientiringGear');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE) 
VALUES ('SportIdent 6', 109.99, 'Unisex', 'SportIdent', 'Cip', 'OrientiringGear');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE) 
VALUES ('SportIdent 7', 139.99, 'Unisex', 'SportIdent', 'Cip', 'OrientiringGear');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE) 
VALUES ('SportIdent 8', 189.99, 'Unisex', 'SportIdent', 'Cip', 'OrientiringGear');
INSERT INTO Article (name, price, gender, brand_name, type, DTYPE) 
VALUES ('SportIdent 9', 199.99, 'Unisex', 'SportIdent', 'Cip', 'OrientiringGear');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE) 
VALUES ('SportIdent Elastic Finger Strap', 4.99, 'Unisex', 'SportIdent', 'KanapZaCip', 'OrientiringGear');

INSERT INTO Article (name, price, gender, brand_name, gear_type, DTYPE) 
VALUES ('Znojnica 1', 5.00, 'Unisex', 'Nike', 'Znojnica', 'TenisGear');
INSERT INTO Article (name, price, gender, brand_name, gear_type, DTYPE) 
VALUES ('Babolat Custom Damp', 7.99, 'Unisex', 'Babolat', 'Vibrastop', 'TenisGear');

INSERT INTO Article (name, price, gender, brand_name, gear_type, DTYPE) 
VALUES ('Wilson oprema US Open 3tball', 9.00, 'Unisex', 'Wilson', 'Loptice', 'TenisGear');

INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE) 
VALUES ('Pure Areo 2023', 250.00, 'Unisex', 'Babolat', 300.0,'Profesionalni','Tvrdo',27.0, 'Racket');
INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE) 
VALUES ('Wilson Clash 100', 220.00, 'Unisex', 'Wilson', 295.0,'Profesionalni','Meko',27.0, 'Racket');
INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE) 
VALUES ('Wilson Tour Slam Lite', 79.99, 'Unisex', 'Wilson', 280.0,'Klasik','Meko',27.0, 'Racket');

INSERT INTO Article (name, price, gender, brand_name, sole, DTYPE) 
VALUES ('NikeCourt Air Zoom Zero HC Grass', 150.00, 'Unisex', 'Nike', 'Kramponi', 'TenisShoe');
INSERT INTO Article (name, price, gender, brand_name, sole, DTYPE) 
VALUES ('NikeCourt Air Zoom Vapor X Clay', 135.00, 'Unisex', 'Nike', 'RibljaKost', 'TenisShoe');
INSERT INTO Article (name, price, gender, brand_name, sole, DTYPE) 
VALUES ('NikeCourt Lite 2', 65.00, 'Unisex', 'Nike', 'Ravan', 'TenisShoe');

INSERT INTO Article (name, price, gender, brand_name, DTYPE) 
VALUES ('Luxilon ALU Power Rough', 23.99, 'Unisex', 'Luxilon', 'RacketString');

INSERT INTO Article (name, price, gender, brand_name, eb_weight, DTYPE) 
VALUES ('Elasticna Traka', 40.00, 'Unisex', 'Joga', 25.0, 'ElasticBand');
INSERT INTO Article (name, price, gender, brand_name, number_Of_Crampsons, DTYPE) 
VALUES ('Kramponi x6', 10.00, 'Unisex', 'Nike', 6, 'GrassFootbalShoe');

INSERT INTO Article (name, price, gender, brand_name, DTYPE) 
VALUES ('Hard padding shoes M', 49.99, 'Male', 'Nike', 'WeightliftingShoe');
INSERT INTO Article (name, price, gender, brand_name, DTYPE) 
VALUES ('Hard padding shoes F', 47.99, 'Female', 'Nike', 'WeightliftingShoe');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight) 
VALUES ('Dumbell 5kg', 10.99, 'Unisex', 'Nike', 'Dumbell', 5.0);
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight) 
VALUES ('Dumbell 3kg', 8.99, 'Unisex', 'Nike', 'Dumbell', 3.0);
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight) 
VALUES ('Dumbell 2kg', 7.99, 'Unisex', 'Nike', 'Dumbell', 2.0);
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight) 
VALUES ('Dumbell 10kg', 13.99, 'Unisex', 'Nike', 'Dumbell', 10.0);
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight) 
VALUES ('Dumbell 15kg', 16.99, 'Unisex', 'Nike', 'Dumbell', 15.0);
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight) 
VALUES ('Dumbell 20kg', 18.99, 'Unisex', 'Nike', 'Dumbell', 20.0);
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight) 
VALUES ('Elastic Band 15kg', 7.99, 'Unisex', 'Nike', 'ElasticBand', 15.0);
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight) 
VALUES ('Elastic Band 20kg', 8.99, 'Unisex', 'Nike', 'ElasticBand', 20.0);
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight) 
VALUES ('Elastic Band 30kg', 9.99, 'Unisex', 'Nike', 'ElasticBand', 30.0);
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight) 
VALUES ('Elastic Band 45kg', 11.99, 'Unisex', 'Nike', 'ElasticBand', 45.0);
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight) 
VALUES ('Elastic Band 60kg', 13.99, 'Unisex', 'Nike', 'ElasticBand', 60.0);
INSERT INTO Article (name, price, gender, brand_name, DTYPE, glove_size) 
VALUES ('WL Gloves M', 12.99, 'Unisex', 'Nike', 'WeightliftingGlove', 'M');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, glove_size) 
VALUES ('WL Gloves XL', 14.99, 'Unisex', 'Nike', 'WeightliftingGlove', 'XL');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, glove_size) 
VALUES ('WL GLoves L', 13.99, 'Unisex', 'Nike', 'WeightliftingGlove', 'L');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type) 
VALUES ('Chalk 200g', 5.99, 'Unisex', 'Thor', 'WeightliftingGear', 'Chalk');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type) 
VALUES ('Chalk 500g', 5.99, 'Unisex', 'T hor', 'WeightliftingGear', 'Chalk');

-- lopte
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type) 
VALUES ('Venum X TG', 24.99, 'Unisex', 'Adidas', 'Ball', 'CetiriSaTegom');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type) 
VALUES ('Rapid', 14.99, 'Unisex', 'Adidas', 'Ball', 'Decija');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type) 
VALUES ('Rapid AM', 15.99, 'Unisex', 'Adidas', 'Ball', 'Amaterska');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type) 
VALUES ('Rapid TR', 19.99, 'Unisex', 'Adidas', 'Ball', 'Trening');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type) 
VALUES ('Rapid PRO', 24.99, 'Unisex', 'Adidas', 'Ball', 'Profesionalna');

-- patike
INSERT INTO Article (name, price, gender, brand_name, DTYPE) 
VALUES ('Venum Max Sprint', 84.99, 'Male', 'Adidas', 'FootbalShoeNoCrampons');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type) 
VALUES ('Kostobran SK ZGL', 45.99, 'Unisex', 'Adidas', 'FootballGear', 'KostobranSaStitnikomZaSkocniZglob');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type) 
VALUES ('Kostobran Bez SSZ', 45.99, 'Unisex', 'Adidas', 'FootballGear', 'KostobranBezStitnika');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type) 
VALUES ('Nike MatchFit Crew Socks', 25.99, 'Unisex', 'Nike', 'FootballGear', 'Stucne');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type) 
VALUES ('Nike Guard Stay II', 8.99, 'Unisex', 'Nike', 'FootballGear', 'Podvezice');

-- kupovine
INSERT INTO Purchase (user_id, article_id, execution_time, price) 
VALUES (2, 1, '2024-05-18', 5.99);
INSERT INTO Purchase (user_id, article_id, execution_time, price) 
VALUES (2, 2, '2024-05-17', 139.99);
INSERT INTO Purchase (user_id, article_id, execution_time, price) 
VALUES (2, 3, '2024-02-16', 29.99);

-- rejtinzi
INSERT INTO Rating (user_id, article_id, execution_time, rating) 
VALUES (2, 41, '2024-05-18', 2);
INSERT INTO Rating (user_id, article_id, execution_time, rating) 
VALUES (2, 42, '2024-05-19', 2);
INSERT INTO Rating (user_id, article_id, execution_time, rating) 
VALUES (2, 43, '2024-05-17', 2);
INSERT INTO Rating (user_id, article_id, execution_time, rating) 
VALUES (2, 44, '2024-05-16', 2);
INSERT INTO Rating (user_id, article_id, execution_time, rating) 
VALUES (2, 45, '2022-05-15', 2);

-- tegovi
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight) 
VALUES ('Titan Fitness Gumirane Olimpijske Ploče', 59.99, 'Unisex', 'Titan Fitness', 'Weight', 20.0);
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, type) 
VALUES ('Titan Fitness', 159.99, 'Unisex', 'Titan Fitness', 'Barbel', 20.0, 'Olimpijska');
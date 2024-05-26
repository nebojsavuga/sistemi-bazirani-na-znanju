insert into Users
(email, password, first_name, last_name, role, age, gender, height)
values ( 'nebojsavuga01@gmail.com', '$2a$12$wT7i3RLuhGjjRt5YdQSjduO7PWwX6tARkVmgO5MHU7nTGViQ5YXwW', 'Nebojsa', 'Vuga', 'Admin', 22, 'Musko', 183.0);
insert into Users
( email, password, first_name, last_name, role, age, gender, height)
values ( 'bogdanjanosevic@gmail.com', '$2a$12$rfUmZnFiuGzkfCrtIZDKIOoTFF4r6khp7GPJQna8I0HJBck/.JyQu', 'Bogdan', 'Janosevic', 'User', 22, 'Musko', 178.0);
insert into Users
(email, password, first_name, last_name, role, age, gender, height)
values ( 'dusanbibin@gmail.com', '$2a$12$2A4nm5f/FhFXq4fb/RD7LOOnfPcHZn3S5SlwdCvvyMgJrdTPRNJSK', 'Dusan', 'Bibin', 'User', 22, 'Musko', 183.0);

INSERT INTO Injury (name) 
VALUES ('Povreda skocnog zgloba');
INSERT INTO Injury (name) 
VALUES ('Povreda kolena');
INSERT INTO Injury (name) 
VALUES ('Povreda lakta');
INSERT INTO Injury (name) 
VALUES ('Povreda rucnog zgloba');

-- Povrede
insert into Concrete_Injury(user_id, injury_id, execution_time)
values(1, 1, '2022-08-18');
insert into Concrete_Injury(user_id, injury_id, execution_time)
values(1, 2, '2022-08-18');
insert into Concrete_Injury(user_id, injury_id, execution_time)
values(2, 3, '2023-08-18');
insert into Concrete_Injury(user_id, injury_id, execution_time)
values(2, 3, '2023-08-18');
insert into Concrete_Injury(user_id, injury_id, execution_time)
values(2, 3, '2023-08-18');
insert into Concrete_Injury(user_id, injury_id, execution_time)
values(2, 3, '2023-07-18');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('Wilson Pro Overgrip', 5.99, 'Unisex', 'Wilson', 'Grip', 'Tenis', '1.jpeg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('Icebug Acceleritas8 RB9X', 139.99, 'Unisex', 'Icebug', 'BigCramponOrientiringShoe', 'orijentiring', '2.jpeg');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('Silva kamasne za orijentiring', 29.99, 'Unisex', 'Silva', 'Kamasne', 'OrientiringGear', 'orijentiring', '3.jpg');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('Balega Hidden Comfort No-Show Running Socks', 15.99, 'Unisex', 'Balega', 'KratkeCarape', 'OrientiringGear', 'orijentiring', '4.jpeg');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('Vapro Sport Reading Glasses SRG-13', 37.99, 'Unisex', 'Vapro', 'Naocare', 'OrientiringGear', 'orijentiring', '5.jpeg');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('Trimtex Basic O-Pants', 60.99, 'Unisex', 'Trimtex', 'Poludugacko', 'Sweatpants', 'orijentiring', '6.jpeg');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('Trimtex Basic Short Orienteering Pants', 33.99, 'Unisex', 'Trimtex', 'Sorc', 'Sweatpants', 'orijentiring', '7.jpeg');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('Trimtex Trainer 2.0 Training Pants', 69.99, 'Unisex', 'Trimtex', 'Dugacko', 'Sweatpants', 'orijentiring', '8.jpg');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('Suunto M-3 Global Compass', 59.99, 'Unisex', 'Suunto', 'Busola', 'OrientiringGear', 'orijentiring', '9.jpeg');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('SportIdent 6', 109.99, 'Unisex', 'SportIdent', 'Cip', 'OrientiringGear', 'orijentiring', '10.jpg');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('SportIdent 7', 139.99, 'Unisex', 'SportIdent', 'Cip', 'OrientiringGear', 'orijentiring', '11.png');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('SportIdent 8', 189.99, 'Unisex', 'SportIdent', 'Cip', 'OrientiringGear', 'orijentiring', '12.jpg');
INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('SportIdent 9', 199.99, 'Unisex', 'SportIdent', 'Cip', 'OrientiringGear', 'orijentiring', '13.jpg');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('SportIdent Elastic Finger Strap', 4.99, 'Unisex', 'SportIdent', 'KanapZaCip', 'OrientiringGear', 'orijentiring', '14.jpg');

INSERT INTO Article (name, price, gender, brand_name, gear_type, DTYPE, sport, path_to_image) 
VALUES ('Znojnica 1', 5.00, 'Unisex', 'Nike', 'Znojnica', 'TenisGear', 'tenis', '15.jpeg');
INSERT INTO Article (name, price, gender, brand_name, gear_type, DTYPE, sport, path_to_image) 
VALUES ('Babolat Custom Damp', 7.99, 'Unisex', 'Babolat', 'Vibrastop', 'TenisGear', 'tenis', '16.png');

INSERT INTO Article (name, price, gender, brand_name, gear_type, DTYPE, sport, path_to_image) 
VALUES ('Wilson Ultralight II', 32.99, 'Unisex', 'Wilson', 'Kacket', 'TenisGear', 'tenis', '17.jpg');

INSERT INTO Article (name, price, gender, brand_name, gear_type, DTYPE, sport, path_to_image) 
VALUES ('Wilson oprema US Open 3tball', 9.00, 'Unisex', 'Wilson', 'Loptice', 'TenisGear','tenis', '18.jpg');

INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Pure Areo 2023', 250.00, 'Unisex', 'Babolat', 300.0,'Profesionalni','Tvrdo',27.0, 'Racket', 'tenis', '19.png');
INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Babolat Pure Drive', 200.00, 'Unisex', 'Babolat', 315.0,'Profesionalni','Tvrdo',27.0, 'Racket', 'tenis', '20.jpg');
INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Wilson Clash 100', 220.00, 'Unisex', 'Wilson', 295.0,'Profesionalni','Meko',27.0, 'Racket', 'tenis', '21.jpg');
INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Wilson Tour Slam Lite', 79.99, 'Unisex', 'Wilson', 280.0,'Klasik','Meko',27.0, 'Racket', 'tenis', '22.jpg');

INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Wilson Pro Staff RF97 Autograph', 250.99, 'Unisex', 'Wilson', 340.0,'Profesionalni','Tvrdo',27.0, 'Racket', 'tenis', '23.jpg');
INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Wilson 19', 79.99, 'Unisex', 'Wilson', 280.0,'Klasik','Meko',19.0, 'Racket', 'tenis', '24.jpg');
INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Wilson 21', 79.99, 'Unisex', 'Wilson', 280.0,'Klasik','Meko',21.0, 'Racket', 'tenis', '25.jpg');
INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Wilson 23', 79.99, 'Unisex', 'Wilson', 280.0,'Klasik','Meko',23.0, 'Racket', 'tenis', '26.jpg');
INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Wilson 25', 79.99, 'Unisex', 'Wilson', 280.0,'Klasik','Meko',25.0, 'Racket', 'tenis', '27.jpeg');
INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Wilson 27.5', 79.99, 'Unisex', 'Wilson', 280.0,'Klasik','Meko',27.5, 'Racket', 'tenis', '28.jpg');

INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport) 
VALUES ('Wilson Ultra 25 V4 Tennis Racket', 129.99, 'Unisex', 'Wilson', 280.0,'Klasik','Meko',25.0, 'Racket', 'tenis');

INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport) 
VALUES ('Wilson Pro Staff Precision Jr 19', 38.99, 'Unisex', 'Wilson', 170.0,'Klasik','Meko',19.0, 'Racket', 'tenis');

INSERT INTO Article (name, price, gender, brand_name, sole, DTYPE, sport) 
VALUES ('NikeCourt Air Zoom Zero HC Grass', 150.00, 'Unisex', 'Nike', 'Kramponi', 'TenisShoe', 'tenis');
INSERT INTO Article (name, price, gender, brand_name, sole, DTYPE, sport) 
VALUES ('NikeCourt Air Zoom Vapor X Clay', 135.00, 'Unisex', 'Nike', 'RibljaKost', 'TenisShoe', 'tenis');
INSERT INTO Article (name, price, gender, brand_name, sole, DTYPE, sport) 
VALUES ('NikeCourt Lite 2', 65.00, 'Unisex', 'Nike', 'Ravan', 'TenisShoe', 'tenis');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport) 
VALUES ('Luxilon ALU Power Rough', 23.99, 'Unisex', 'Luxilon', 'RacketString', 'tenis');

INSERT INTO Article (name, price, gender, brand_name, eb_weight, DTYPE, sport) 
VALUES ('Elasticna Traka', 40.00, 'Unisex', 'Joga', 25.0, 'ElasticBand', 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, number_Of_Crampsons, DTYPE, sport) 
VALUES ('Kramponi x6', 10.00, 'Unisex', 'Nike', 6, 'GrassFootbalShoe', 'fudbal');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport) 
VALUES ('Hard padding shoes M', 49.99, 'Male', 'Nike', 'WeightliftingShoe', 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport) 
VALUES ('Hard padding shoes F', 47.99, 'Female', 'Nike', 'WeightliftingShoe', 'dizanjeTegova');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport) 
VALUES ('Dumbell 5kg', 10.99, 'Unisex', 'Nike', 'Dumbell', 5.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport) 
VALUES ('Dumbell 3kg', 8.99, 'Unisex', 'Nike', 'Dumbell', 3.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport) 
VALUES ('Dumbell 2kg', 7.99, 'Unisex', 'Nike', 'Dumbell', 2.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport) 
VALUES ('Dumbell 10kg', 13.99, 'Unisex', 'Nike', 'Dumbell', 10.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport) 
VALUES ('Dumbell 15kg', 16.99, 'Unisex', 'Nike', 'Dumbell', 15.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport) 
VALUES ('Dumbell 20kg', 18.99, 'Unisex', 'Nike', 'Dumbell', 20.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport) 
VALUES ('Dumbell 45kg', 18.99, 'Unisex', 'Nike', 'Dumbell', 45.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport) 
VALUES ('Dumbell 60kg', 18.99, 'Unisex', 'Nike', 'Dumbell', 60.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport) 
VALUES ('Dumbell 80kg', 18.99, 'Unisex', 'Nike', 'Dumbell', 80.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight, sport) 
VALUES ('Elastic Band 15kg', 7.99, 'Unisex', 'Nike', 'ElasticBand', 15.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight, sport) 
VALUES ('Elastic Band 20kg', 8.99, 'Unisex', 'Nike', 'ElasticBand', 20.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight, sport) 
VALUES ('Elastic Band 30kg', 9.99, 'Unisex', 'Nike', 'ElasticBand', 30.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight, sport) 
VALUES ('Elastic Band 45kg', 11.99, 'Unisex', 'Nike', 'ElasticBand', 45.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight, sport) 
VALUES ('Elastic Band 60kg', 13.99, 'Unisex', 'Nike', 'ElasticBand', 60.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, glove_size, sport) 
VALUES ('WL Gloves M', 12.99, 'Unisex', 'Nike', 'WeightliftingGlove', 'M', 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, glove_size, sport) 
VALUES ('WL Gloves XL', 14.99, 'Unisex', 'Nike', 'WeightliftingGlove', 'XL', 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, glove_size, sport) 
VALUES ('WL GLoves L', 13.99, 'Unisex', 'Nike', 'WeightliftingGlove', 'L', 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Chalk 200g', 5.99, 'Unisex', 'Thor', 'WeightliftingGear', 'Chalk', 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Chalk 500g', 5.99, 'Unisex', 'T hor', 'WeightliftingGear', 'Chalk', 'dizanjeTegova');

-- lopte
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Venum X TG', 24.99, 'Unisex', 'Adidas', 'Ball', 'CetiriSaTegom', 'fudbal');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Rapid', 14.99, 'Unisex', 'Adidas', 'Ball', 'Decija', 'fudbal');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Rapid AM', 15.99, 'Unisex', 'Adidas', 'Ball', 'Amaterska', 'fudbal');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Rapid TR', 19.99, 'Unisex', 'Adidas', 'Ball', 'Trening', 'fudbal');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Rapid PRO', 24.99, 'Unisex', 'Adidas', 'Ball', 'Profesionalna', 'fudbal');

-- patike
INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, number_of_crampons) 
VALUES ('Venum Max Shoe 6 Crampson', 82.99, 'Male', 'Adidas', 'FootbalShoeCrampons', 'fudbal', 6);
INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, number_of_crampons) 
VALUES ('Venum Max Shoe 7 Crampson', 85.99, 'Male', 'Adidas', 'FootbalShoeCrampons', 'fudbal', 7);
INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport) 
VALUES ('Venum Max Sprint', 84.99, 'Male', 'Adidas', 'FootbalShoeNoCrampons', 'fudbal');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Kostobran SK ZGL', 45.99, 'Unisex', 'Adidas', 'FootballGear', 'KostobranSaStitnikomZaSkocniZglob', 'fudbal');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Kostobran Bez SSZ', 45.99, 'Unisex', 'Adidas', 'FootballGear', 'KostobranBezStitnika', 'fudbal');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Nike MatchFit Crew Socks', 25.99, 'Unisex', 'Nike', 'FootballGear', 'Stucne', 'fudbal');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Nike Guard Stay II', 8.99, 'Unisex', 'Nike', 'FootballGear', 'Podvezice', 'fudbal');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Kramponi x3', 3.99, 'Unisex', 'Nike', 'FootballGear', 'Krampon', 'fudbal');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Kramponi x5', 5.99, 'Unisex', 'Nike', 'FootballGear', 'Krampon', 'fudbal');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Kjuc za odvrtanje i zavrtanje krampona', 12.99, 'Unisex', 'Owasp', 'FootballGear', 'KljucZaKrampone', 'fudbal');

-- dresovi

INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Ronaldinho Milan', 20.99, 'Unisex', 'Nike', 'FootballGear', 'Dres', 'fudbal');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Ronaldo Real Madrid 7', 20.99, 'Unisex', 'Nike', 'FootballGear', 'Dres', 'fudbal');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Messi PSG', 24.99, 'Unisex', 'Adidas', 'FootballGear', 'Dres', 'fudbal');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Ibrahimovic LA Galaxy', 24.99, 'Unisex', 'Puma', 'FootballGear', 'Dres', 'fudbal');

-- kupovine
INSERT INTO Purchase (user_id, article_id, execution_time,is_processed_for_sport_code,is_processed_for_favorite_code, price) 
VALUES (2, 1, '2024-05-18', false, false, 5.99);
INSERT INTO Purchase (user_id, article_id, execution_time,is_processed_for_sport_code,is_processed_for_favorite_code, price) 
VALUES (2, 2, '2024-05-17',false, false, 139.99);
INSERT INTO Purchase (user_id, article_id, execution_time,is_processed_for_sport_code,is_processed_for_favorite_code, price) 
VALUES (2, 3, '2024-02-16',false, false, 29.99);

INSERT INTO Purchase (user_id, article_id, execution_time,is_processed_for_sport_code,is_processed_for_favorite_code, price) 
VALUES (1, 21, '2022-02-16',false, false, 38.99);
INSERT INTO Purchase (user_id, article_id, execution_time,is_processed_for_sport_code,is_processed_for_favorite_code, price) 
VALUES (1, 21, '2022-02-16',false, false, 38.99);

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
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport) 
VALUES ('Titan Fitness Gumirane Olimpijske Ploce', 59.99, 'Unisex', 'Titan Fitness', 'Weight', 20.0, 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, type, sport) 
VALUES ('Titan Fitness', 159.99, 'Unisex', 'Titan Fitness', 'Barbel', 20.0, 'Olimpijska', 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('Rogue Fitness Ohio Lifting Belt', 119.99, 'Unisex', 'Rogue Fitness', 'WeightliftingGear', 'Belt', 'dizanjeTegova');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport) 
VALUES ('SBD Knee Sleeves', 89.99, 'Unisex', 'SBD', 'WeightliftingGear', 'KneeWrap', 'dizanjeTegova');
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
VALUES ('Sportident Active Card SIAC Red', 59.99, 'Unisex', 'SportIdent', 'Cip', 'OrientiringGear', 'orijentiring', '10.jpg');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('Sportident Active Card SIAC Lynx', 58.99, 'Unisex', 'SportIdent', 'Cip', 'OrientiringGear', 'orijentiring', '11.png');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('SportIdent Card 8', 27.99, 'Unisex', 'SportIdent', 'Cip', 'OrientiringGear', 'orijentiring', '12.jpg');
INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('SportIdent Card 9', 35.99, 'Unisex', 'SportIdent', 'Cip', 'OrientiringGear', 'orijentiring', '13.jpg');

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
VALUES ('Wilson 19', 79.99, 'Unisex', 'Wilson', 200.0,'Klasik','Meko',19.0, 'Racket', 'tenis', '24.jpg');
INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Wilson 21', 79.99, 'Unisex', 'Wilson', 220.0,'Klasik','Meko',21.0, 'Racket', 'tenis', '25.jpg');
INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Wilson 23', 79.99, 'Unisex', 'Wilson', 240.0,'Klasik','Meko',23.0, 'Racket', 'tenis', '26.jpg');
INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Wilson 25', 79.99, 'Unisex', 'Wilson', 280.0,'Klasik','Meko',25.0, 'Racket', 'tenis', '27.jpeg');
INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Wilson 27.5', 79.99, 'Unisex', 'Wilson', 300.0,'Klasik','Meko',27.5, 'Racket', 'tenis', '28.jpg');

INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Wilson Ultra 25 V4 Tennis Racket', 129.99, 'Unisex', 'Wilson', 250.0,'Klasik','Meko',25.0, 'Racket', 'tenis', '29.png');

INSERT INTO Article (name, price, gender, brand_name, weight, type, spanning_type, size, DTYPE, sport, path_to_image) 
VALUES ('Wilson Pro Staff Precision Jr 19', 38.99, 'Unisex', 'Wilson', 170.0,'Klasik','Meko',19.0, 'Racket', 'tenis', '30.jpg');

INSERT INTO Article (name, price, gender, brand_name, sole, DTYPE, sport, path_to_image) 
VALUES ('NikeCourt Air Zoom Zero HC Grass', 150.00, 'Unisex', 'Nike', 'Kramponi', 'TenisShoe', 'tenis', '31.jpg');
INSERT INTO Article (name, price, gender, brand_name, sole, DTYPE, sport, path_to_image) 
VALUES ('NikeCourt Air Zoom Vapor X Clay', 135.00, 'Unisex', 'Nike', 'RibljaKost', 'TenisShoe', 'tenis', '32.jpg');
INSERT INTO Article (name, price, gender, brand_name, sole, DTYPE, sport, path_to_image) 
VALUES ('NikeCourt Lite 2', 65.00, 'Unisex', 'Nike', 'Ravan', 'TenisShoe', 'tenis', '33.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('Luxilon ALU Power Rough', 23.99, 'Unisex', 'Luxilon', 'RacketString', 'tenis', '34.jpg');

INSERT INTO Article (name, price, gender, brand_name, eb_weight, DTYPE, sport, path_to_image) 
VALUES ('Elasticna Traka', 40.00, 'Unisex', 'Joga', 25.0, 'ElasticBand', 'dizanjeTegova', '35.jpg');
INSERT INTO Article (name, price, gender, brand_name, number_Of_Crampsons, DTYPE, sport, path_to_image) 
VALUES ('Kramponi x6', 10.00, 'Unisex', 'Nike', 6, 'GrassFootbalShoe', 'fudbal', '36.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('Nike Savaleos Weightlifting Shoes', 125.99, 'Male', 'Nike', 'WeightliftingShoe', 'dizanjeTegova', '37.jpeg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('Weightlifting Shoes Nike Romaleos 4', 199.99, 'Female', 'Nike', 'WeightliftingShoe', 'dizanjeTegova', '38.png');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport, path_to_image) 
VALUES ('Dumbell 5kg', 31.99, 'Unisex', 'NC FITNESS', 'Dumbell', 5.0, 'dizanjeTegova', '39.jpeg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport, path_to_image) 
VALUES ('Dumbell 3kg', 21.99, 'Unisex', 'NC FITNESS', 'Dumbell', 3.0, 'dizanjeTegova', '40.jpeg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport, path_to_image) 
VALUES ('Dumbell 2kg', 14.99, 'Unisex', 'NC FITNESS', 'Dumbell', 2.0, 'dizanjeTegova', '41.jpeg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport, path_to_image) 
VALUES ('Dumbell 10kg', 120.99, 'Unisex', 'NC FITNESS', 'Dumbell', 10.0, 'dizanjeTegova', '42.jpeg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport, path_to_image) 
VALUES ('Dumbell 15kg', 169.99, 'Unisex', 'NC FITNESS', 'Dumbell', 15.0, 'dizanjeTegova', '43.jpeg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport, path_to_image) 
VALUES ('Dumbell 20kg', 200.99, 'Unisex', 'Cyberfit', 'Dumbell', 20.0, 'dizanjeTegova', '44.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport, path_to_image) 
VALUES ('Dumbell 45kg', 700.00, 'Unisex', 'Pulse fitness', 'Dumbell', 45.0, 'dizanjeTegova', '45.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport, path_to_image) 
VALUES ('Dumbell 60kg', 900.00, 'Unisex', 'NC FITNESS', 'Dumbell', 60.0, 'dizanjeTegova', '46.jpeg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport, path_to_image) 
VALUES ('Dumbell 80kg', 822.99, 'Unisex', 'Fitness power', 'Dumbell', 80.0, 'dizanjeTegova', '47.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight, sport, path_to_image) 
VALUES ('Elastic Band 15kg', 7.99, 'Unisex', 'Decathlon', 'ElasticBand', 15.0, 'dizanjeTegova', '48.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight, sport, path_to_image) 
VALUES ('Elastic Band 20kg', 17.99, 'Unisex', 'Sveltus', 'ElasticBand', 20.0, 'dizanjeTegova', '49.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight, sport, path_to_image) 
VALUES ('Elastic Band 30kg', 29.99, 'Unisex', 'Sveltus', 'ElasticBand', 30.0, 'dizanjeTegova', '50.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight, sport, path_to_image) 
VALUES ('Elastic Band 45kg', 64.99, 'Unisex', 'Y&Y', 'ElasticBand', 45.0, 'dizanjeTegova', '51.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, eb_weight, sport, path_to_image) 
VALUES ('Elastic Band 60kg', 22.99, 'Unisex', 'Decathlon', 'ElasticBand', 60.0, 'dizanjeTegova', '52.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, glove_size, sport, path_to_image) 
VALUES ('WL Gloves M', 20.99, 'Unisex', 'Nike', 'WeightliftingGlove', 'M', 'dizanjeTegova', '53.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, glove_size, sport, path_to_image) 
VALUES ('Nike Premium Training Gloves XL', 32.99, 'Unisex', 'Nike', 'WeightliftingGlove', 'XL', 'dizanjeTegova', '54.jpeg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, glove_size, sport, path_to_image) 
VALUES ('Nike Extreme Fitness Gloves Black', 29.99, 'Unisex', 'Nike', 'WeightliftingGlove', 'L', 'dizanjeTegova', '55.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Chalk 200g', 10.99, 'Unisex', 'Black diamond', 'WeightliftingGear', 'Chalk', 'dizanjeTegova', '56.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Chalk 500g', 12.99, 'Unisex', 'Power system', 'WeightliftingGear', 'Chalk', 'dizanjeTegova', '57.jpg');

-- lopte
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Forza weighted football', 24.99, 'Unisex', 'Forza', 'Ball', 'CetiriSaTegom', 'fudbal', '58.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Picador kids ball', 17.99, 'Unisex', 'Picador', 'Ball', 'Decija', 'fudbal', '59.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Nike Nk Academy', 40.99, 'Unisex', 'Nike', 'Ball', 'Amaterska', 'fudbal', '60.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Nike Flight Soccer Ball', 160.99, 'Unisex', 'Nike', 'Ball', 'Profesionalna', 'fudbal', '61.png');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Adidas tango rosario', 27.99, 'Unisex', 'Adidas', 'Ball', 'Trening', 'fudbal', '62.png');

-- patike
INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, number_of_crampons, path_to_image) 
VALUES ('Nike Phantom GX 2 Elite', 270.99, 'Male', 'Nike', 'FootbalShoeCrampons', 'fudbal', 6, '63.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, number_of_crampons, path_to_image) 
VALUES ('Adidas PREDATOR LEAGUE SG', 85.99, 'Male', 'Adidas', 'FootbalShoeCrampons', 'fudbal', 7, '64.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('Nike Mercurial Superfly 8 Elite TF', 79.99, 'Male', 'Nike', 'FootbalShoeNoCrampons', 'fudbal', '65.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Nike Mercurial Flylite Superlock SSZ', 29.99, 'Unisex', 'Nike', 'FootballGear', 'KostobranSaStitnikomZaSkocniZglob', 'fudbal', '66.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Nike Protegga Pro No SSZ', 35.99, 'Unisex', 'Nike', 'FootballGear', 'KostobranBezStitnika', 'fudbal', '67.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Nike Stadium Over-the-Calf Football Socks', 15.99, 'Unisex', 'Nike', 'FootballGear', 'Stucne', 'fudbal','68.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Nike Guard Stay II', 10.99, 'Unisex', 'Nike', 'FootballGear', 'Podvezice', 'fudbal', '69.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Adidas kramponi TPU STUDS', 20.99, 'Unisex', 'Adidas', 'FootballGear', 'Krampon', 'fudbal', '70.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Adidas kramponi SOFT GROUND', 21.99, 'Unisex', 'Adidas', 'FootballGear', 'Krampon', 'fudbal', '71.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Kjuc za odvrtanje i zavrtanje krampona', 8.99, 'Unisex', 'Standard', 'FootballGear', 'KljucZaKrampone', 'fudbal', '72.jpg');

-- dresovi

INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Nike Practice football jersey', 21.99, 'Unisex', 'Nike', 'FootballGear', 'Dres', 'fudbal', '73.jpeg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('NIKE DRI FOOTBALL CLUB F.C. SOCCER TRAINING JERSEY', 59.99, 'Unisex', 'Nike', 'FootballGear', 'Dres', 'fudbal', '74.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Adidas Soccer Juventus FC Home Jersey', 79.99, 'Unisex', 'Adidas', 'FootballGear', 'Dres', 'fudbal', '75.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Puma Team Glory Jersey', 35.99, 'Unisex', 'Puma', 'FootballGear', 'Dres', 'fudbal', '76.jpeg');

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
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, sport, path_to_image) 
VALUES ('20KG Olympic Weight plates 5cm Rubber Coated', 79.99, 'Unisex', 'Power Gym', 'Weight', 20.0, 'dizanjeTegova', '77.jpeg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, type, sport, path_to_image) 
VALUES ('Olympic Bar 20Kg', 159.99, 'Unisex', 'BOOMFIT', 'Barbel', 20.0, 'Olimpijska', 'dizanjeTegova', '78.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Weightlifting Belt Shaped', 119.99, 'Unisex', 'GYMSTICK', 'WeightliftingGear', 'Belt', 'dizanjeTegova','79.jpg');
INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Iron Bull Strength Knee Wraps', 29.99, 'Unisex', 'SBD', 'WeightliftingGear', 'KneeWrap', 'dizanjeTegova','80.jpg');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('SILVA ARC JET S Thumb Compass', 62.99, 'Unisex', 'Silva', 'Busola', 'OrientiringGear', 'orijentiring', '81.jpg');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('Trimtex Extreme O-Pants Navy', 40.99, 'Unisex', 'Trimtex', 'Poludugacko', 'Sweatpants', 'orijentiring', '82.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('INOV8 Oroc Ultra 290 Orienteering Shoes', 124.99, 'Unisex', 'INOV8', 'BigCramponOrientiringShoe', 'orijentiring', '83.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('INOV8 Oroc 280 V3 Shoes', 107.99, 'Unisex', 'INOV8', 'BigCramponOrientiringShoe', 'orijentiring', '84.jpg');

INSERT INTO Article (name, price, gender, brand_name, type, DTYPE, sport, path_to_image) 
VALUES ('Kampela Short Tights', 15.99, 'Unisex', 'Kampela', 'Sorc', 'Sweatpants', 'orijentiring', '85.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('Nano Cyber Power 1.25 Mm', 4.99, 'Unisex', 'Pros pro', 'RacketString', 'tenis', '86.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('Nike Downshifter 13', 70.99, 'Male', 'Nike', 'NoCramponOrientiringShoe', 'orijentiring', '87.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('Nike Revolution 7', 65.99, 'Male', 'Nike', 'NoCramponOrientiringShoe', 'orijentiring', '88.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('Nike Vomero 17', 150.99, 'Male', 'Nike', 'NoCramponOrientiringShoe', 'orijentiring', '89.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('Nike React Pegasus Trail 4', 99.99, 'Male', 'Nike', 'NoCramponOrientiringShoe', 'orijentiring', '90.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('VJ Integrator 18 Orienteering Shoes', 99.99, 'Unisex', 'VJ', 'BigCramponOrientiringShoe', 'orijentiring', '91.jpg');

INSERT INTO Article (name, price, gender, brand_name, gear_type, DTYPE, sport, path_to_image) 
VALUES ('Head Znojnice Bele', 10.00, 'Unisex', 'Head', 'Znojnica', 'TenisGear', 'tenis', '92.jpg');

INSERT INTO Article (name, price, gender, brand_name, gear_type, DTYPE, sport, path_to_image) 
VALUES ('Head Znojnice Crne', 10.00, 'Unisex', 'Head', 'Znojnica', 'TenisGear', 'tenis', '93.jpg');

INSERT INTO Article (name, price, gender, brand_name, sole, DTYPE, sport, path_to_image) 
VALUES ('Challenge Pro Clay Black', 110.00, 'Unisex', 'Nike', 'RibljaKost', 'TenisShoe', 'tenis', '94.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, weight, type, sport, path_to_image) 
VALUES ('Duga šipka za tegove 13kg', 60.99, 'Unisex', 'Gorilla', 'Barbel', 13.0, 'Klasik', 'dizanjeTegova', '95.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('Nike Women Soccer Norway Home Jersey', 80.99, 'Female', 'Nike', 'FootballGear', 'Dres', 'fudbal', '96.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('adidas Argentina 22 Home Jersey Women', 80.99, 'Female', 'Nike', 'FootballGear', 'Dres', 'fudbal', '97.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, type, sport, path_to_image) 
VALUES ('PUMA Santiago TG Women Jersey', 55.99, 'Female', 'Nike', 'FootballGear', 'Dres', 'fudbal', '98.jpg');

INSERT INTO Article (name, price, gender, brand_name, gear_type, DTYPE, sport, path_to_image) 
VALUES ('Wilson Rg Dampeners vibrastop', 2.99, 'Unisex', 'Wilson', 'Vibrastop', 'TenisGear', 'tenis', '99.jpg');

INSERT INTO Article (name, price, gender, brand_name, sole, DTYPE, sport, path_to_image) 
VALUES ('Adizero Ubersonic 4 Grass Court Shoe Men', 130.00, 'Male', 'Adidas', 'Kramponi', 'TenisShoe', 'tenis', '100.jpg');

INSERT INTO Article (name, price, gender, brand_name, DTYPE, sport, path_to_image) 
VALUES ('RPM Blast String Reel 200m', 134.99, 'Unisex', 'Babolat', 'RacketString', 'tenis', '101.jpg');

INSERT INTO Article (name, price, gender, brand_name, sole, DTYPE, sport, path_to_image) 
VALUES ('Court FF 3 Clay Court Shoe Men', 165.00, 'Male', 'ASICS', 'RibljaKost', 'TenisShoe', 'tenis', '102.jpg');




DELETE FROM batch;
ALTER TABLE batch AUTO_INCREMENT = 1;
DELETE FROM user;
ALTER TABLE user AUTO_INCREMENT = 1;
INSERT INTO user VALUES (1, "nelly-o", "password", "Neils", "Bohr", "11122", "1885-07-10", 2);
INSERT INTO user VALUES (2, "BigAl", "password", "Albert", "Einstein", "11223", "1879-03-14", 2);
INSERT INTO user VALUES (3, "Brauny", "password", "Wernher", "von Braun", "12233", "1912-03-23", 1);
INSERT INTO user VALUES (4, "uncertain", "password", "Werner-Karl", "Heisenberg", "12334", "1901-12-05", 3);
INSERT INTO batch VALUES (1, "batch title", "recipe name", "2019-03-01", "2019-03-06", "2019-04-20", "2019-10-20", 1.105, 1.055, 2), (2, "Christmas 2018", "Begian Dubbel", "2019-03-01", "2019-03-06", "2019-04-20", "2019-10-20", 1.105, 1.055, 1), (3, "Summer 2018", "Golden Lager", "2018-03-01", "2018-03-06", "2018-04-20", "2018-10-20", 1.105, 1.055, 2);

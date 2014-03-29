INSERT INTO plasticine (id) VALUES (2);
--橡皮泥2

INSERT INTO plasticine (id) VALUES (3);
--橡皮泥3

INSERT INTO plasticine (id) VALUES (4);
--橡皮泥4

INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (1, 2, 3);
INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (2, 2, 4);
--橡皮泥3和4是由2拆出来的
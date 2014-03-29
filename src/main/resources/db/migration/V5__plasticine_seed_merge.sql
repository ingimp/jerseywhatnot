INSERT INTO plasticine (id) VALUES (5);
--橡皮泥5

INSERT INTO plasticine (id) VALUES (6);
--橡皮泥6

INSERT INTO plasticine (id) VALUES (7);
--橡皮泥7

INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (3, 5, 7);
INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (4, 6, 7);
--橡皮泥7是由5和6合并出来的

--最后的结果里面应该是： (5,6,7)
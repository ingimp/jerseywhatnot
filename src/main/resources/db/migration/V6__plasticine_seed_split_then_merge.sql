INSERT INTO plasticine (id) VALUES (8);
--橡皮泥8

INSERT INTO plasticine (id) VALUES (9);
--橡皮泥9

INSERT INTO plasticine (id) VALUES (10);
--橡皮泥10

INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (5, 8, 9);
INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (6, 8, 10);
--橡皮泥8拆出了9和10

INSERT INTO plasticine (id) VALUES (11);
--橡皮泥11

INSERT INTO plasticine (id) VALUES (12);
--橡皮泥12

INSERT INTO plasticine (id) VALUES (13);
--橡皮泥13

INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (7, 11, 12);
INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (8, 11, 13);
--橡皮泥11拆出了12和13

INSERT INTO plasticine (id) VALUES (14);
--橡皮泥14

INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (9, 9, 14);
INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (10, 12, 14);
--最后，9和12合并成了14

--这里面9和12是中间状态，其他的要么是原始橡皮泥，要么是最终成果的橡皮泥
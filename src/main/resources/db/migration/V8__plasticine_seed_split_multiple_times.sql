INSERT INTO plasticine (id) VALUES (20);
--橡皮泥20

INSERT INTO plasticine (id) VALUES (21);
--橡皮泥21

INSERT INTO plasticine (id) VALUES (22);
--橡皮泥22

INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (15, 20, 21);
INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (16, 20, 22);
--20被拆分成了21,22

INSERT INTO plasticine (id) VALUES (23);
INSERT INTO plasticine (id) VALUES (24);
INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (17, 21, 23);
INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (18, 21, 24);
--21被拆分成了23,24

INSERT INTO plasticine (id) VALUES (25);
--橡皮泥25

INSERT INTO plasticine (id) VALUES (26);
--橡皮泥26

INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (19, 23, 25);
INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (20, 23, 26);
--23被拆分成了25,26

--这里面21,23是中间状态，其他的要么是原始橡皮泥，要么是最终成果的橡皮泥

--最后的结果里面应该是： (20,22,24,25,26)
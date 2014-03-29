INSERT INTO plasticine (id) VALUES (15);
--橡皮泥15

INSERT INTO plasticine (id) VALUES (16);
--橡皮泥16

INSERT INTO plasticine (id) VALUES (17);
--橡皮泥17

INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (11, 15, 17);
INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (12, 16, 17);
--15和16合并成了17

INSERT INTO plasticine (id) VALUES (18);
--橡皮泥18

INSERT INTO plasticine (id) VALUES (19);
--橡皮泥19

INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (13, 17, 18);
INSERT INTO plasticine_relation (id, oldPlasticineId, newPlasticineId) VALUES (14, 17, 19);
--17被拆分成了18和19

--这里面17是中间状态，其他的要么是原始橡皮泥，要么是最终成果的橡皮泥

--最后的结果里面应该是： (15,16,18,19)
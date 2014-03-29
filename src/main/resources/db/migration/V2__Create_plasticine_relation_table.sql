CREATE TABLE plasticine_relation (
  id             SERIAL NOT NULL,
  oldPlasticineId INT,
  newPlasticineId INT,
  PRIMARY KEY (id)
);
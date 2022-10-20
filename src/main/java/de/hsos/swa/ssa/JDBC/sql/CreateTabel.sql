-- Active: 1649604676347@@127.0.0.1@3306@test_simple_shop

CREATE TABLE
    ware (
        warenummer int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
        warename VARCHAR(45) NOT NULL,
        ware_preis VARCHAR(45),
        ware_beschreibung VARCHAR(77)
    ) COMMENT '';

CREATE TABLE
    wareinformation (
        wareinfo_nr int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
        wareinfo_bezeichnung VARCHAR(77),
        wareinfo_information VARCHAR(77),
        warenummer int,
        CONSTRAINT fk_wareinfo_ware FOREIGN KEY (warenummer) REFERENCES ware (warenummer)
    ) COMMENT '';

DROP TABLE IF EXISTS ware;

DROP TABLE IF EXISTS wareinformation;
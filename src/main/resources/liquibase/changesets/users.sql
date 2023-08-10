--liquibase formatted sql
--changeset bizin:1

CREATE TABLE IF NOT EXISTS users (
                                     id              SERIAL PRIMARY KEY,
                                     username        VARCHAR(50) UNIQUE NOT NULL,
    first_name      VARCHAR(50) NOT NULL,
    last_name       VARCHAR(50) NOT NULL,
    phone           VARCHAR(20) NOT NULL,
    password        VARCHAR(100) NOT NULL,
    enabled         BOOLEAN,
    role            VARCHAR(10),
    avatar_id       INTEGER REFERENCES avatar(id)
    );
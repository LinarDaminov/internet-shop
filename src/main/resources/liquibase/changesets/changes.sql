--liquibase formatted sql
--changeset linar:1
CREATE TABLE avatar(
    id SERIAL PRIMARY KEY ,
    media_type VARCHAR(200),
    file_size BIGINT,
    data BYTEA
);
CREATE TABLE users(
    id         SERIAL PRIMERY KEY,
    username   VARCHAR(64) UNIQUE NOT NULL,
    first_name VARCHAR(50)        NOT NULL,
    last_name  VARCHAR(50)        NOT NULL,
    phone      VARCHAR(20)        NOT NULL,
    password   VARCHAR(100)       NOT NULL ,
    enabled BOOLEAN
    role VARCHAR(10),
    avatar_id INTEGER REFERENCES  avatar(id)
);
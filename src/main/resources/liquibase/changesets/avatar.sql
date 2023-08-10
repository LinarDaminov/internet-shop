--liquibase formatted sql
--changeset bizin:2

CREATE TABLE IF NOT EXISTS avatar(
                                     id              SERIAL PRIMARY KEY,
                                     media_type      VARCHAR(200),
    file_size       BIGINT,
    data            BYTEA
    );
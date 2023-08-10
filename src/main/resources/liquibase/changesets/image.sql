--liquibase formatted sql
--changeset bizin:3

CREATE TABLE IF NOT EXISTS image(
                                    id              SERIAL PRIMARY KEY,
                                    media_type      VARCHAR(200),
    file_size       BIGINT,
    data            BYTEA
    );
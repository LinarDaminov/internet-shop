--liquibase formatted sql
--changeset linar:1
CREATE TABLE avatar
(
    id         SERIAL PRIMARY KEY,
    media_type VARCHAR(200),
    file_size  BIGINT,
    data       BYTEA
);
CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    username   VARCHAR(64) UNIQUE NOT NULL,
    first_name VARCHAR(50)        NOT NULL,
    last_name  VARCHAR(50)        NOT NULL,
    phone      VARCHAR(20)        NOT NULL,
    password   VARCHAR(100)       NOT NULL,
    enabled    BOOLEAN,
    role VARCHAR (10) NOT NULL,
    avatar_id  INTEGER REFERENCES avatar (id)
);
CREATE TABLE IF NOT EXISTS image(
                                    id              SERIAL PRIMARY KEY,
                                    media_type      VARCHAR(200),
    file_size       BIGINT,
    data            BYTEA
    );


CREATE TABLE IF NOT EXISTS ads(
                                  id              SERIAL PRIMARY KEY,
                                  title           VARCHAR (200) NOT NULL,
    description     TEXT,
    price           INTEGER NOT NULL,
    author_id       INTEGER REFERENCES users(id),
    image_id        INTEGER REFERENCES image(id)
    );
CREATE TABLE IF NOT EXISTS comment(
                                      id              SERIAL PRIMARY KEY,
                                      created_at      TIMESTAMP,
                                      text            TEXT NOT NULL,
                                      ads_id          INTEGER REFERENCES ads(id),
    author_id       INTEGER REFERENCES users(id)
    );
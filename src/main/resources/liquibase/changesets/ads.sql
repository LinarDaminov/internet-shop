--liquibase formatted sql
--changeset bizin:4

CREATE TABLE IF NOT EXISTS ads(
                                  id              SERIAL PRIMARY KEY,
                                  title           VARCHAR (200) NOT NULL,
                                  description     TEXT,
                                  price           INTEGER NOT NULL,
                                  author_id       INTEGER REFERENCES users(id),
                                  image_id        INTEGER REFERENCES image(id)
);
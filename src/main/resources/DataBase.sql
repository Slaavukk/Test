CREATE DATABASE resume;

CREATE TABLE resume
(
    id                BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name              VARCHAR(30),
    lastname          VARCHAR(40),
    birthday          DATE,
    experience        VARCHAR(500),
    contacts          VARCHAR(50),
    about_me          VARCHAR(1000),
    movie_description VARCHAR(500)

);

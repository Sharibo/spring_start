CREATE TABLE hibernate_sequence
(
    NEXT_VAL bigint
);

INSERT INTO hibernate_sequence
VALUES (1);
INSERT INTO hibernate_sequence
VALUES (1);

CREATE TABLE user
(
    id       bigint      NOT NULL AUTO_INCREMENT,
    password varchar(64) NOT NULL,
    username varchar(64) NOT NULL,
    UNIQUE(username),
    PRIMARY KEY (id)
);

CREATE TABLE todo
(
    id       bigint      NOT NULL AUTO_INCREMENT,
    title varchar(64) NOT NULL,
    completed boolean NOT NULL,
    PRIMARY KEY (id)
);
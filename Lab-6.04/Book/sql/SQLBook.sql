CREATE SCHEMA book_format;
USE book_format;

CREATE SCHEMA book_table;
USE book_table;

CREATE TABLE book_table (
isbn VARCHAR(255),
title VARCHAR(255),
author VARCHAR(255),
genre VARCHAR(255),
PRIMARY KEY (isbn)
);

INSERT INTO book_table (isbn, title, author, genre) VALUES ("libroa", "Librob", "Libroc", "Librod");

CREATE TABLE book_format (
formats VARCHAR(255)
CONSTRAINT CHECK (formats IN ('HARDCOVER','PAPERBACK','ELECTRONIC','AUDIO')),
isbn VARCHAR(255),
PRIMARY KEY (isbn, formats)
);

INSERT INTO book_format (formats, isbn) VALUES ("PAPERBACK", "libroa");

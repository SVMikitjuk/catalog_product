
CREATE TABLE addrBook.group_product
(
  id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(250)  NOT NULL,
  dept varchar(100)  NOT NULL
);

CREATE TABLE addrBook.product
(
  id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  id_group INTEGER NOT NULL ,
  name varchar(250)  NOT NULL
);

ALTER TABLE addrBook.group_product
ADD FOREIGN KEY ( id_group ) REFERENCES addrBook.group_product ( id );
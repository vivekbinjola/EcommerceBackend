use product;
SELECT VERSION();

CREATE TABLE IF NOT EXISTS category (
    id INT AUTO_INCREMENT NOT NULL ,
    description VARCHAR(255),
    name        VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product (
    id                 INT AUTO_INCREMENT NOT NULL,
    available_quantity DOUBLE NOT NULL,
    description        VARCHAR(255),
    name               VARCHAR(255),
    price              DECIMAL(38,2),
    category_id        INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category(id)
);

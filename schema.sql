CREATE TABLE ingredient (
    id      INTEGER     NOT NULL    AUTO_INCREMENT,
    price   FLOAT       NOT NULL,
    name    VARCHAR(45) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE burger (
    id      INTEGER     NOT NULL    AUTO_INCREMENT,
    name    VARCHAR(45) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE burger_ingredient (
    burger_id       INTEGER NOT NULL,
    ingredient_id   INTEGER NOT NULL,
    quantity        INTEGER NOT NULL,
    PRIMARY KEY(burger_id, ingredient_id),
    INDEX   FKBurger(burger_id),
    INDEX   FKIngredient(ingredient_id),
    FOREIGN KEY(burger_id),
        REFERENCES burger(id)
            ON DELETE CASCADE
            ON UPDATE NO ACTION,
    FOREIGN KEY(ingredient_id),
        REFERENCES ingredient(id)
            ON DELETE CASCADE
            ON UPDATE NO ACTION,
);
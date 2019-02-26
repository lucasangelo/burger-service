INSERT IGNORE INTO ingredient VALUES (1, "Alface", 0.40);
INSERT IGNORE INTO ingredient VALUES (2, "Bacon", 2.00);
INSERT IGNORE INTO ingredient VALUES (3, "Hambúrguer de carne", 3.00);
INSERT IGNORE INTO ingredient VALUES (4, "Ovo", 0.80);
INSERT IGNORE INTO ingredient VALUES (5, "Queijo", 1.50);

INSERT IGNORE INTO burger VALUES (1, "X-Bacon");
INSERT IGNORE INTO burger VALUES (2, "X-Burger");
INSERT IGNORE INTO burger VALUES (3, "X-Egg");
INSERT IGNORE INTO burger VALUES (4, "X-Egg Bacon");

INSERT IGNORE INTO burger_ingredient VALUES (1, 2, 1);
INSERT IGNORE INTO burger_ingredient VALUES (1, 3, 1);
INSERT IGNORE INTO burger_ingredient VALUES (1, 5, 1);

INSERT IGNORE INTO burger_ingredient VALUES (2, 3, 1);
INSERT IGNORE INTO burger_ingredient VALUES (2, 5, 1);

INSERT IGNORE INTO burger_ingredient VALUES (3, 4, 1);
INSERT IGNORE INTO burger_ingredient VALUES (3, 3, 1);
INSERT IGNORE INTO burger_ingredient VALUES (3, 5, 1);

INSERT IGNORE INTO burger_ingredient VALUES (4, 4, 1);
INSERT IGNORE INTO burger_ingredient VALUES (4, 2, 1);
INSERT IGNORE INTO burger_ingredient VALUES (4, 3, 1);
INSERT IGNORE INTO burger_ingredient VALUES (4, 5, 1);
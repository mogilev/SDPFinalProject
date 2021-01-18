INSERT INTO items (name_item, quantity_item, description_item) VALUES ('banana', 10, 'Bananas da Madeira');
INSERT INTO items (name_item, quantity_item, description_item) VALUES ('pera', 15, 'rocha');
INSERT INTO items (name_item, quantity_item, description_item) VALUES ('chocolate', 400, '');
INSERT INTO items (name_item, quantity_item, description_item) VALUES ('amendoim', 400, 'sem casca');
INSERT INTO items (name_item, quantity_item, description_item) VALUES ('papel higiénico', 2,'dupla folha');
INSERT INTO items (name_item, quantity_item, description_item) VALUES ('caderno', 0,'quadriculado');
INSERT INTO items (name_item, quantity_item, description_item) VALUES ('aquecedor', 12,'1000W');
INSERT INTO items (name_item, quantity_item, description_item) VALUES ('álcool-Gel', 0, '');
INSERT INTO items (name_item, quantity_item, description_item) VALUES ('saco',  0, 'opacos');
INSERT INTO items (name_item, quantity_item, description_item) VALUES ('bronzeador', 78,'factor 50');


UPDATE items SET description_item = '' WHERE description_item is null;

INSERT INTO delivery (name_place) VALUES ('Lisboa');
INSERT INTO delivery (name_place) VALUES ('Torres Vedras');
INSERT INTO delivery (name_place) VALUES ('Coimbra');
INSERT INTO delivery (name_place) VALUES ('Faro');
INSERT INTO delivery (name_place) VALUES ('Porto');
INSERT INTO delivery (name_place) VALUES ('Santo António dos Cavaleiros');

INSERT INTO deposits (id_item, quantity_deposits) VALUES (1, 45);
INSERT INTO deposits (id_item, quantity_deposits) VALUES (3, 125);
INSERT INTO deposits (id_item, quantity_deposits) VALUES (5, 73);
INSERT INTO deposits (id_item, quantity_deposits) VALUES (6, 35);
INSERT INTO deposits (id_item, quantity_deposits) VALUES (7, 38);

UPDATE items SET quantity_item = 45 WHERE id_item = 1;
UPDATE items SET quantity_item = 125 WHERE id_item = 3;
UPDATE items SET quantity_item =73  WHERE id_item = 5;
UPDATE items SET quantity_item = 35 WHERE id_item = 6;
UPDATE items SET quantity_item = 38 WHERE id_item = 7;

INSERT INTO delivery_items (id_delivery, id_item, quantity_item) VALUES (1, 3, 3);
INSERT INTO delivery_items (id_delivery, id_item, quantity_item) VALUES (1, 1, 4);
INSERT INTO delivery_items (id_delivery, id_item, quantity_item) VALUES (1, 6, 6);
INSERT INTO delivery_items (id_delivery, id_item, quantity_item) VALUES (2, 5, 10);
INSERT INTO delivery_items (id_delivery, id_item, quantity_item) VALUES (3, 6, 2);
INSERT INTO delivery_items (id_delivery, id_item, quantity_item) VALUES (4, 6, 1);
INSERT INTO delivery_items (id_delivery, id_item, quantity_item) VALUES (5, 3, 4);
INSERT INTO delivery_items (id_delivery, id_item, quantity_item) VALUES (6, 1, 10);
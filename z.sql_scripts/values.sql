INSERT INTO items (name_item, quantity_item, description_item) VALUES ('Bananas', 10, 'Bananas da Madeira');
UPDATE items SET description_item = ('Bananas do Funchal') WHERE id_item = 1;
INSERT INTO place (name_place) VALUES ('Madeira');
INSERT INTO place (name_place) VALUES ('Porto');
INSERT INTO delivery (id_name_place) VALUES (1);
UPDATE delivery SET id_name_place = (2) WHERE id_delivery = 1;


INSERT INTO place (name_place) VALUES ('Lisboa'), ('Porto'), ('Coimbra'), ('Faro'), ('Santo António dos Cavaleiros');
INSERT INTO deposits (id_items, quantity_deposits) VALUES (1, 5), (2, 5), (3, 5);
INSERT INTO delivery (id_name_place) VALUES (1), (2);
INSERT INTO delivery_items (id_delivery, id_item, quantity_item) VALUES (1, 1, 5), (2, 2, 10);
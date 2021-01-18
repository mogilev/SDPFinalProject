create table items (
    id_item SERIAL PRIMARY KEY,
    name_item varchar (30) UNIQUE NOT NULL,
    quantity_item INT CHECK (quantity_item>=0),
    description_item varchar (50)
);

create table delivery (
    id_delivery SERIAL PRIMARY KEY,
    name_place varchar (50) NOT NULL

);

create table delivery_items (
    id_delivery INT NOT NULL,
    id_item INT NOT NULL,
    quantity_item INT,

    FOREIGN KEY (id_delivery)
        REFERENCES delivery (id_delivery),
    FOREIGN KEY (id_item)
        REFERENCES items (id_item)
);

create table deposits (
    id_deposits SERIAL PRIMARY KEY,
    id_item INT NOT NULL,
    quantity_deposits INT NOT NULL,

    FOREIGN KEY (id_item)
        REFERENCES items (id_item)
);
package app.controllers;


import app.models.Delivery;
import app.models.Deposit;
import app.models.Item;

import javax.json.JsonArrayBuilder;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface Warehouse {


    void deleteItem(Warehouse warehouse, HttpServletResponse resp,int i); // Elimina um determinado item, caso nunca tenha sido registado um depósito ou entrega com este.

    boolean itemIdExists(int itemId); // verifica se um item existe na base de dados

    boolean itemNameExists(String itemId); // verifica se um item existe na base de dados

    void createItem(HttpServletResponse resp, String itemName); // adiciona novo item

    void updateItem(Warehouse warehouse, HttpServletResponse resp, int itemId, String itemDescription);

    void buildItemsList(boolean bool);

    void jSonSingleOutputSender(HttpServletResponse resp, String key, String value);

    //  Listas

    List<Item> getItemsList();

    List<Deposit> getDepositsList();

    List<Delivery> getDeliveriesList();


    //  Criação de Json's

    JsonArrayBuilder jsonItemsCollectionSender();

    JsonArrayBuilder jsonDeliveriesCollectionSender();

}

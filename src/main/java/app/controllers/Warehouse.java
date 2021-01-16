package app.controllers;


import app.models.Delivery;
import app.models.Deposit;
import app.models.Item;

import javax.json.JsonArrayBuilder;
import java.util.List;

public interface Warehouse {

    void getItems(boolean bool); // Retorna coleção de items existentes

    void getStockItems(); // Retorna coleção de items cuja quantidade é >= 0

    void getItem(int i); // Retorna um item específico

    void changeItem(int i, String description);  // Altera a descrição de um determinado Item

    void createItems(Item item); // Cria um novo item

    void deleteItem(int i); // Elimina um determinado item, caso nunca tenha sido registado um depósito ou entrega com este.

    boolean itemExists(int itemId); // verifica se um item existe na base de dados


    //  Listas

    List<Item> getItemsList();

    List<Deposit> getDepositsList();

    List<Delivery> getDeliveriesList();


    void buildItemsList(boolean bool);

    //  Criação de Json's

    JsonArrayBuilder jsonItemsCollectionSender();

    JsonArrayBuilder jsonDeliveriesCollectionSender();

}

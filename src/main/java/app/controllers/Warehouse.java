package app.controllers;


import app.models.Item;

public interface Warehouse {

    void getItems(); // Retorna coleção de items existentes

    void getStockItems(); // Retorna coleção de items cuja quantidade é >= 0

    void getItem(int i); // Retorna um item específico

    void changeItem(int i, String description);  // Altera a descrição de um determinado Item

    void createItems(Item item); // Cria um novo item

    void deleteItem(int i); // Elimina um determinado item, caso nunca tenha sido registado um depósito ou entrega com este.

    // TODO

}

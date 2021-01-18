package app.controllers;


import app.models.Delivery;
import app.models.Deposit;
import app.models.Item;

import javax.json.JsonArrayBuilder;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface Warehouse {

    /**
     * Estabelece conexão com a base de dados.
     */
    void daoConnection();

    /**
     * Elimina um determinado item, caso nunca tenha sido registado um depósito ou entrega com este.
     * @param warehouse
     * @param resp
     * @param i
     */
    void deleteItem(Warehouse warehouse, HttpServletResponse resp,int i);

    /**
     * Verifica existência de um Item na Base de Dados pelo ID.
     * @param itemId
     * @return
     */
    boolean itemIdExists(int itemId);

    /**
     * Verifica existência de Item na Base de Dados pelo nome.
     * @param itemId
     * @return
     */
    boolean itemNameExists(String itemId);

    /**
     * Adiciona novo Item.
     * @param resp
     * @param itemName
     */
    void createItem(HttpServletResponse resp, String itemName);

    /**
     * Faz o update na descrição do Item.
     * @param warehouse
     * @param resp
     * @param itemId
     * @param itemDescription
     */
    void updateItem(Warehouse warehouse, HttpServletResponse resp, int itemId, String itemDescription);

    /**
     * Cria uma Lista de Items.
     * @param bool
     */
    void buildItemsList(boolean bool);

    /**
     * ??????? Cria um JSON ?????????????????????????????????????
     * @param resp
     * @param key
     * @param value
     */
    void jSonSingleOutputSender(HttpServletResponse resp, String key, String value);

    /**
     * Método que cria um depósito de item com a quantidade indicada.
     * @param warehouse
     * @param resp
     * @param itemId
     * @param quantity
     */
    void createDeposit(Warehouse warehouse,HttpServletResponse resp, int itemId, int quantity);


    //  Listas

    /**
     * Método que retorna uma lista com os Items existentes.
     * @return
     */
    List<Item> getItemsList();

    /**
     * Método que retorna uma lista com os depósitos realizados em cada Item.
     * @return
     */
    List<Deposit> getDepositsList();

    /**
     * Método que retorna uma lista com as entregas registadas.
     * @return
     */
    List<Delivery> getDeliveriesList();


    //  Criação de Json's

    /**
     * Método que cria um JSON com os Items registados.
     * @return
     */
    JsonArrayBuilder jsonItemsCollectionSender();

    /**
     * Método que cria um JSON com as entregas registadas.
     * @return
     */
    JsonArrayBuilder jsonDeliveriesCollectionSender();

}

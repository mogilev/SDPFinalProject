package app.controllers;

import app.models.*;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseClass implements Warehouse {

    private List<Item> itemsList;
    private List<Deposit> depositsList;
    private List<Delivery> deliveriesList;
    private Connection connection;

    public WarehouseClass() {
        this.itemsList = new ArrayList<Item>();
        this.depositsList = new ArrayList<Deposit>();
        this.deliveriesList = new ArrayList<Delivery>();
        this.daoConnection();

    }

    public void daoConnection(){
        ConnectionDAO dcm = new ConnectionDAO();

        /*DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                "hplussport", "postgres", "password");*/
        try{
            this.connection = dcm.getConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }



    @Override
    public void getItems(boolean bool) {

    }

    @Override
    public void getStockItems() {

    }

    @Override
    public void getItem(int i) {

    }

    @Override
    public void changeItem(int i, String description) {

    }

    @Override
    public void createItems(Item item) {

    }

    @Override
    public void deleteItem(int itemId) {

    } // TODO - aqui ficarão as regras de negócio (segundo o brainstorm na aula 05/01/2021 - 55min)

    @Override
    public boolean itemExists(int itemId) {
        // DAO.daoItemExists todo Artur
        return false;
    }

    @Override
    public List<Item> getItemsList() {
        return this.itemsList;
    }

    @Override
    public List<Deposit> getDepositsList() {
        return this.depositsList;
    }

    @Override
    public List<Delivery> getDeliveriesList() {
        return this.deliveriesList;
    }

    @Override
    public void buildItemsList(boolean stock) {
        ItemDAO itemDao = new ItemDAO(connection);
        if (stock){
           // itemDao.GetItemsStock(this.itemsList); //em stock
            // TODO Artur: necessário criar método no DAO(ou equivalente) que preencha this.itemsList só com items em stock
            return;
        }
        else{
            itemDao.getItemsCollection(this.itemsList); // preenche itemsList com todos os items
            return;
        }
    }


    @Override
    public JsonArrayBuilder jsonItemsCollectionSender() {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        for (Item item : this.getItemsList()){
            jsonBuilder.add("name", item.getDescription());
            jsonBuilder.add("description", item.getDescription());
            jsonBuilder.add("quantity", item.getDescription());
            jsonArrayBuilder.add(jsonBuilder);
        }
        return jsonArrayBuilder;
    }


    @Override
    public JsonArrayBuilder jsonDeliveriesCollectionSender() {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        for (Delivery delivery : this.getDeliveriesList()){
            jsonBuilder.add("deliveryId", delivery.getDeliveryId());
            jsonBuilder.add("description", delivery.getPlace());
            for (DeliveryItems deliveryItems: delivery.getDeliveryItemsList()){
                jsonBuilder.add("itemId", deliveryItems.getItem().getId());
                jsonBuilder.add("itemId", deliveryItems.getItem().getName());
                jsonBuilder.add("itemId", deliveryItems.getQuantity());
            }
            jsonArrayBuilder.add(jsonBuilder);
        }
        return jsonArrayBuilder;
    }


}

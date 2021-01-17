package app.controllers;

import app.models.*;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public boolean itemIdExists(int itemId) { // confirmar este método
        ItemDAO itemDAO = new ItemDAO(connection);
        Item item = itemDAO.getItemById(itemId);
        if (item.getId() == 0){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public boolean itemNameExists(String itemName) {
        ItemDAO itemDAO = new ItemDAO(connection);
        Item item = itemDAO.getItemByName(itemName);
        if(item.getName().contentEquals(itemName)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void createItem(HttpServletResponse resp, String itemName) {
        ItemDAO itemDao = new ItemDAO(connection);
        try {
            if(!itemDao.itemNameExists(itemName)){
                Item item = new ItemClass(0, itemName, null, 0);
                ItemDAO itemDAO = new ItemDAO(connection);
                itemDAO.insertItem(item);
                jSonSingleOutputSender(resp, itemName, "item guardado com sucesso");
            }
            else{
                jSonSingleOutputSender(resp, "Nome", "valor já existe!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
            itemDao.getItemsStock(this.itemsList); //em stock
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


    @Override
    public void jSonSingleOutputSender(HttpServletResponse resp, String key, String value) {
        resp.setContentType("application/json");
        try {
            JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
            jsonBuilder.add(key, value);
            JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
            jsonWriter.writeObject(jsonBuilder.build());
            jsonWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

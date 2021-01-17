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

        try{
            this.connection = dcm.getConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void deleteItem(Warehouse warehouse, HttpServletResponse resp, int itemId) {

        if (itemIdExists(itemId)){
            DeliveryDAO deliveryDao = new DeliveryDAO(connection);
   //       if (deliveryDao.deliveryExists)


        }
        else{
            jSonSingleOutputSender(resp, "Nome", "item inexistente!");
        }
    } // TODO - aqui ficarão as regras de negócio (segundo o brainstorm na aula 05/01/2021 - 55min)


    @Override
    public boolean itemIdExists(int itemId) { // confirmar este método
        ItemDAO itemDAO = new ItemDAO(connection);
        itemDAO.getItemById(itemsList, itemId);
        if (this.getItemsList().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }


    @Override
    public boolean itemNameExists(String itemName) {
        ItemDAO itemDAO = new ItemDAO(connection);
        itemDAO.getItemByName(itemsList, itemName);
        if (this.getItemsList().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public void createItem(HttpServletResponse resp, String itemName) {
        ItemDAO itemDao = new ItemDAO(connection);

        if(!itemNameExists(itemName)){
            Item item = new ItemClass(0, itemName, null, 0);
            ItemDAO itemDAO = new ItemDAO(connection);
            itemDAO.insertItem(item);
            jSonSingleOutputSender(resp, itemName, "item guardado com sucesso");
        }
        else{
            jSonSingleOutputSender(resp, "Nome", "valor já existe!");
        }
    }

    @Override
    public void updateItem(Warehouse warehouse, HttpServletResponse resp, int itemId, String description) {

        if(itemIdExists(itemId)){
            Item item = new ItemClass(itemId, null, description, 0);
            ItemDAO itemDAO = new ItemDAO(connection);
            itemDAO.updateItem(item, 4); //opção 4 - actualizar descrição
            jSonSingleOutputSender(resp, String.valueOf(itemId), "item guardado com sucesso");
        }
        else{
            jSonSingleOutputSender(resp, "Nome", "valor já existe!");
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
            jsonBuilder.add("quantity", item.getQuantity());
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
                jsonBuilder.add("name", deliveryItems.getItem().getName());
                jsonBuilder.add("quantity", deliveryItems.getQuantity());
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

    @Override
    public void createDeposit(Warehouse warehouse, HttpServletResponse resp, int itemId, int quantity) {
        ItemDAO itemDao = new ItemDAO(connection);

        if(!itemIdExists(itemId)){
            itemDao.getItemById(itemsList, itemId);
            Item item = getItemsList().get(0);
            item.setQuantity(item.getQuantity() + quantity);

            Deposit deposit = new DepositClass(0, item, quantity);
            DepositDAO depositDAO = new DepositDAO(connection);
            depositDAO.insertDeposit(deposit);
            jSonSingleOutputSender(resp, item.getName(), "item guardado com sucesso");
        }
        else{
            jSonSingleOutputSender(resp, "Nome", "item não existente!");
        }
    }


}

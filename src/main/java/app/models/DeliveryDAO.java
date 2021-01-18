package app.models;

import app.controllers.Warehouse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO {
    protected static Connection connection;


    public DeliveryDAO(Connection connection) { // construtor da classe
        super();
        this.connection = connection;
    }

    // GET/Delivey - Método que executa uma busca à tabele delevery  e delevery_items, da base de dados, retornando
    // todas as entregas e respetivos items que fazem parte da entrega
    public static void getDeliveries(List<Delivery> deliveryList) {

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSetDelivery = statement.executeQuery("SELECT * FROM delivery");
            while (resultSetDelivery.next()) {
                int idDelivery = resultSetDelivery.getInt(1);
                String place = resultSetDelivery.getString(2);
                Delivery delivery = new DeliveryClass(idDelivery, place);
                deliveryList.add(delivery);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }

/*
        //List<DeliveryItems> deliveryItems = new ArrayList<>();
        //INSERT INTO persons (lastname, firstname) VALUES ('Smith', 'John') RETURNING id;

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSetDelivery = statement.executeQuery("SELECT * FROM delivery");
            while (resultSetDelivery.next()) {
                int idDelivery = resultSetDelivery.getInt(1);
                String place = resultSetDelivery.getString(2);

                String id = String.valueOf(idDelivery);
                Delivery delivery = new DeliveryClass(idDelivery, place);
                ItemDAO itemDAO = new ItemDAO(connection);
                itemDAO.getItemById(warehouse.getItemsList(), idItem);
                ResultSet resultSetItem = statement.executeQuery("SELECT * FROM delivery_items WHERE id_delivery = " + id);
                while (resultSetItem.next()) {
                    int idDeliveryItem = resultSetItem.getInt(1);
                    int idItem = resultSetItem.getInt(2);
                    int quantity = resultSetItem.getInt(3);
                    //DeliveryItems deliveryItem = new DeliveryItemsClass(idItem, quantity);
                    //deliveryItems.add(deliveryItem);
                    DeliveryItems deliveryItems = new DeliveryItemsClass();
                    delivery.setDeliveryItems();
                }

                Delivery delivery = new DeliveryClass(idDelivery, place, deliveryItems);
                deliveries.add(delivery);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
*/
    }


    //POST/Delivery Método que insere uma nova encomenda dentro da na base de dados, na tabela delivery
    public static int insertDelivery(String place) {
        String INSERT = "INSERT INTO delivery (name_place) VALUES (?)";

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, place);
            statement.execute();
        }
        catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return 0;
    }
}

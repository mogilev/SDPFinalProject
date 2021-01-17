package app.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public static void getDeliveries(List<Delivery> deliveries) {
        List<DeliveryItems> deliveryItems = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSetDelivery = statement.executeQuery("SELECT * FROM delivery");
            while (resultSetDelivery.next()) {
                int idDelivery = resultSetDelivery.getInt(1);
                int place = resultSetDelivery.getInt(2);

                ResultSet resultSetItem = statement.executeQuery("SELECT * FROM delivery_items WHERE id_delivery = id_delivery");
                while (resultSetItem.next()) {
                    int idDeliveryItem = resultSetItem.getInt(1);
                    int idItem = resultSetItem.getInt(2);
                    int quantity = resultSetItem.getInt(3);
       //             DeliveryItems deliveryItem = new DeliveryItemsClass(idItem, quantity);
       //             deliveryItems.add(deliveryItem);
                }

                Delivery delivery = new DeliveryClass(idDelivery, place, deliveryItems);
                deliveries.add(delivery);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }


}

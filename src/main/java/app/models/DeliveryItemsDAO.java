package app.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class that makes the connection (DAO - Data Access Object) to the Postgres Database, for the delivery_items table
 */
public class DeliveryItemsDAO {
    protected static Connection connection;


    /**
     * Class DeliveryItemsDAO constructor
     *
     * @param connection    receive the connection to da database
     */
    public DeliveryItemsDAO(Connection connection) { // construtor da classe
        super();
        this.connection = connection;
    }


/*
    public static boolean getDeliveryItemsByItemId(int itemId) {
*/
/*
        String id = String.valueOf(itemId);

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM delivery_items WHERE id_item = " + id);
            if (resultSet == 0) { return false; }
            else { return true; }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
*//*

    }

    public static void getDeliveryItemsByIdDelivery(int deliveryID) {
*/
/*

        try {

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

*//*

    }

*/

}

package app.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemsDAO extends ConnectionDAO {

    public ItemsDAO() {
        super();
    }

    public void GetItemsCollection(List<Item> itemsList) {
        ConnectionDAO dcm = new ConnectionDAO();

        try {
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM items");

            while(resultSet.next()) {
                int id = resultSet.getInt("id_item");
                String name = resultSet.getString("name_item");
                String description = resultSet.getString("description_item");
                int quantity = resultSet.getInt("quantity_item");
                Item item = new ItemClass(id, name, description, quantity);
                itemsList.add(item);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }


}

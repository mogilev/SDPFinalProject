package app.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that makes the connection (DAO - Data Access Object) to the Postgres Database, in the items table
 */
public class ItemDAO extends ConnectionDAO {
    protected static Connection connection;


    /**
     * Class ItemDAO constructor
     * 
     * @param connection    provides a connection to database
     */
    public ItemDAO(Connection connection) { // construtor da classe
        super();
        this.connection = connection;
    }


    /**
     * GET/item
     * Method that queries the items table, and returns the complete collection of items in the database
     *
     * @param       itemsList   List of items to receive the SQl query
     * @exception   Error       on the SQL statement
     */
    public static void getItemsCollection(List<Item> itemsList) {

        try {
            //  Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items");

            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int quantity = resultSet.getInt(3);
                String description = resultSet.getString(4);
                Item item = new ItemClass(id, name, description, quantity);
                itemsList.add(item);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * GET/Item/Stock
     * Method that queries the items table, and returns the list of items that have stock > 0
     *
     * @param       itemsList   List of items that receive the SQL query
     * @exception   Error       SQL statement
     */
    public static void getItemsStock(List<Item> itemsList) { //

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items WHERE quantity_item > 0");

            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int quantity = resultSet.getInt(3);
                String description = resultSet.getString(4);
                Item item = new ItemClass(id, name, description, quantity);
                itemsList.add(item);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * GET/Item/1
     * Method that queries the items table, and returns the specific item, by Id
     *
     * @param       itemsList   List of items that receive de information
     * @param       searchId    specify Id for search item
     * @exception   Error       SQL statement
     */
    public static void getItemById(List<Item> itemsList, int searchId) {

        try {
            Statement statement = connection.createStatement();
            String strId = String.valueOf(searchId);
            String SELECT = "SELECT * FROM items WHERE id_item = " + strId;
          //  PreparedStatement statement = connection.prepareStatement(SELECT);
         //   String id1 = String.valueOf(searchId);
         //   SELECT = SELECT + id1;
         //   statement.setInt(1, searchId);
            ResultSet resultSet = statement.executeQuery(SELECT);
         //   statement.execute();

            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int quantity = resultSet.getInt(3);
                String description = resultSet.getString(4);
                Item item = new ItemClass(id, name, description, quantity);
                itemsList.add(item);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * GET/Item/#
     * Method that queries the items table, and returns the specific item, by name
     *
     * @param       itemsList   List of items that receive de information
     * @param       searchName  name of the specify item to search
     * @exception   Error       SQL statement
     */
    public static void getItemByName(List<Item> itemsList, String searchName) {

        try {
            Statement statement = connection.createStatement();
            String SELECT = "SELECT * FROM items WHERE name_item = ";
         //   PreparedStatement statement = connection.prepareStatement(SELECT);
            SELECT = SELECT+"'"+searchName+"'";
         //   statement.setString(1, searchName);
            ResultSet resultSet = statement.executeQuery(SELECT);
      //      statement.execute();

            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int quantity = resultSet.getInt(3);
                String description = resultSet.getString(4);
                Item item = new ItemClass(id, name, description, quantity);
                itemsList.add(item);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * PUT/Items
     * Method that changes information (quantity or description) of a certain item, in the Item table, by a given Id
     *
     * @param       item        information that will be updated in the item
     * @param       option      option to update:
     *                          3 - updates quantity of the item
     *                          4 - updates the item description
     * @return      int         check method
     * @exception   Error       SQL statement
     */
    public static int updateItem(Item item, int option) {
        String id = String.valueOf(item.getId());

        if(option == 3) {
            String quantity = String.valueOf(item.getQuantity());
            String UPDATEDESCRIPTION = "UPDATE items SET quantity_item = " + quantity + " WHERE id_item = " + id;
            try{
                Statement statement = connection.createStatement();
                statement.executeUpdate(UPDATEDESCRIPTION);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        else if(option == 4) {
            String description = item.getDescription();
            String UPDATEDESCRIPTION = "UPDATE items SET description_item = " + "'"+ description +"'" + " WHERE id_item = "+ id ;
            try{
                Statement statement = connection.createStatement();
                statement.executeUpdate(UPDATEDESCRIPTION);

            }
            catch(SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return 0;
    }


    /**
     * POST/Item
     * Method that inserts into the database a new item, in the Item table
     *
     * @param       item        object with the information of the item
     * @return      int         method control
     * @exception   Error       SQL statement
     *                          connection
     */
    public static int insertItem(Item item) {
        String INSERT = "INSERT INTO items (name_item, quantity_item, description_item) VALUES (?, ?, ?)";
        String name = item.getName();
        int qty = 0;
        String description = "";
        try(PreparedStatement statement = connection.prepareStatement(INSERT);) {
            statement.setString(1, name);
            statement.setInt(2, qty);
            statement.setString(3, description);
            statement.execute();
        }
        catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return 0;
    }


    /**
     * DELETE/Item
     * Method that deletes a particular item in the Item table of the database, through a given id
     *
     * @param       item      item that will be deleted form database
     * @exception   Error     SQL statement
     */
    public static void deleteItem(Item item) {
        String id = String.valueOf(item.getId());

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM items WHERE id_item = " + id);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

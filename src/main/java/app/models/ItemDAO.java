package app.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Classe que faz a ligação (DAO - Data Access Object) à Base de Dados Postgres, na tabela items
public class ItemDAO extends ConnectionDAO {
    protected static Connection connection;


    /**
     * Class ItemDAO constructor
     * 
     * @param connection    provides a connection
     */
    public ItemDAO(Connection connection) { // construtor da classe
        super();
        this.connection = connection;
    }


    //

    /**
     * GET/item
     * Método que faz uma consulta à tabela items, e retorna a coleção completa de items da base de dados
     *
     * @param itemsList
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
     * Método que faz uma consulta à tabela items, e retorna a lista de items que têm stock > 0
     *
     * @param itemsList List of items
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


    // GET/Item/1 Método que faz uma consulta à tabela items, e retorna o item especifico, através do Id
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


    // GET/Item/1 Método que faz uma consulta à tabela items, e retorna o item especifico, através do Id
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


    //

    /**
     * PUT/Items
     * Método que altera informações (quantidade ou descrição) de um certo item, na tabela item, para um dado Id
     *
     * @param   item    information that will be updated in the item
     * @param   option  option to update:
     *                  3 - updates quantity of the item
     *                  4 - updates the item description
     * @return  int     to check the method beaver
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


    // POST/Item Método que faz o insert na base de dados de um novo item, na tabela item
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


    // DELET/Item Método que apaga um determinado item na tabela item da base de dados, atravez de um dado id
    public static void deleteItem(Item item) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM items WHERE id_item = item.id");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

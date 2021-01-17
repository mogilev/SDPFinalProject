package app.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Classe que faz a ligação (DAO - Data Access Object) à Base de Dados Postgres, na tabela items
public class ItemDAO extends ConnectionDAO {
    protected static Connection connection;


    public ItemDAO(Connection connection) { // construtor da classe
        super();
        this.connection = connection;
    }


    // GET/item Método que faz uma consulta à tabela items, e retorna a coleção completa de items da base de dados
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


    // GET/Item/Stock Método que faz uma consulta à tabela items, e retorna a lista de items que têm stock > 0
    public static void getItemsStock(List<Item> itemsList) {

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


    // GET/Item/1 Método que faz uma consulta à tabela items, e retorna o item especifico, atravez do Id
    public static Item getItemById(int searchId) {
        int id = 0;
        String name = null;
        int quantity = 0;
        String description = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items WHERE id_item = searchId");

            id = resultSet.getInt(1);
            name = resultSet.getString(2);
            quantity = resultSet.getInt(3);
            description = resultSet.getString(4);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        Item item = new ItemClass(id, name, description, quantity);
        return item;
    }


    // GET/Item/1 Método que faz uma consulta à tabela items, e retorna o item especifico, atravez do Id
    public static Item getItemByName(String searchName) {
        int id = 0;
        String name = null;
        int quantity = 0;
        String description = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items WHERE id_name = searchName");

            id = resultSet.getInt(1);
            name = resultSet.getString(2);
            quantity = resultSet.getInt(3);
            description = resultSet.getString(4);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        Item item = new ItemClass(id, name, description, quantity);
        return item;
    }



    // PUT/Item Método que altera informações (quantidade ou descrição) de um certo item, na tabela item, para um dado Id
    public static void updateItem(Item item, int option) {
        int searchId = item.getId();
        int quantity = item.getQuantity();

        if (option == 1) {
            try {
                Statement statement = connection.createStatement();
                int resultSet = statement.executeUpdate("UPDATE items SET quantity_item = quantity WHERE id_item = searchId");
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                Statement statement = connection.createStatement();
                int resultSet = statement.executeUpdate("UPDATE items SET description_item = description WHERE id_item = searchId");
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }


    // POST/Item Método que faz o insert na base de dados de um novo item, na tabela item
    public static void insertItem(Item item) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO items (name_item, quantity_item, description_item) VALUES (item.name, item.quantity, item.description)");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
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

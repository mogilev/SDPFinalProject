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


    // Método que faz uma consulta à tabela items, e retorna a coleção completa de items da base de dados
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


    // Método que faz uma consulta à tabela items, e retorna a lista de items que têm stock > 0
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


    // Método que faz uma consulta à tabela items, e retorna o item especifico, atravez do Id
    public static void getItemById(List<Item> itemsList, int searchId) {

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items WHERE id_item = searchId");

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

}

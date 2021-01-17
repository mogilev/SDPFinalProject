package app.models;

import java.sql.*;
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


    // GET/Item/1 Método que faz uma consulta à tabela items, e retorna o item especifico, através do Id
    public static void getItemById(List<Item> itemsList, int searchId) {

        try {
            //Statement statement = connection.createStatement();
            String SELECT = "SELECT * FROM items WHERE id_name = ?";
            PreparedStatement statement = connection.prepareStatement(SELECT);
            ResultSet resultSet = statement.executeQuery(SELECT);
            statement.setInt(1, searchId);
            statement.execute();

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
            //Statement statement = connection.createStatement();
            String SELECT = "SELECT * FROM items WHERE id_name = ?";
            PreparedStatement statement = connection.prepareStatement(SELECT);
            ResultSet resultSet = statement.executeQuery(SELECT);
            statement.setString(1, searchName);
            statement.execute();

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


    // TODO necessários métodos separados: descrição é PUT /items, quantidade é POST /Deposit
 /*   // PUT/Item Método que altera informações (quantidade ou descrição) de um certo item, na tabela item, para um dado Id
    public static void updateItem(Item item) {
        int searchId = item.getId();

         try {
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate("UPDATE items SET quantity_item = quantity WHERE id_item = searchId");
         }
            catch(SQLException e) {
                e.printStackTrace();
            }

    }*/

    // PUT/Items Método que altera informações (quantidade ou descrição) de um certo item, na tabela item, para um dado Id
    public static int updateItem(Item item, int option) {
        int searchId = item.getId();

        if(option == 3) {
            String UPDATEQTY = "UPDATE items SET quantity_item = ? WHERE id_item = ?";
            int quantity = item.getQuantity();

            try(PreparedStatement statement = connection.prepareStatement(UPDATEQTY);) {
                statement.setInt(1, searchId);
                statement.setInt(2, quantity);
                statement.execute();
            }
            catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return 0;
                    //  código anterio
/*            try {
                Statement statement = connection.createStatement();
                int resultSet = statement.executeUpdate("UPDATE items SET quantity_item = quantity WHERE id_item = searchId");
            }
            catch(SQLException e) {
                e.printStackTrace();
            }*/
        }
        else if(option == 4) {
            String description = item.getDescription();
            String UPDATEDESCRIPTION = "UPDATE items SET description_item = ? WHERE id_item = ?";

            try(PreparedStatement statement = connection.prepareStatement(UPDATEDESCRIPTION);) {
                statement.setInt(1, searchId);
                statement.setString(2, description);
                statement.execute();
            }
            catch(SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return 0;

                // else IF com versão anterior
/*            try {
                Statement statement = connection.createStatement();
                int resultSet = statement.executeUpdate("UPDATE items SET description_item = description WHERE id_item = searchId");
            }
            catch(SQLException e) {
                e.printStackTrace();
            }*/
        }
        return 0;
    }


    // POST/Item Método que faz o insert na base de dados de um novo item, na tabela item
    public static int insertItem(Item item) {
        String INSERT = "INSERT INTO customer (name_item) VALUES (?)";

        try(PreparedStatement statement = connection.prepareStatement(INSERT);) {
            statement.setString(1, item.getName());
            statement.execute();
        }
        catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return 0;

        //código anterior
 /*       try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO items (name_item, quantity_item, description_item) VALUES (item.name, item.quantity, item.description)");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }*/
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

package app.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DeliveryDAO {
    protected static Connection connection;


    public DeliveryDAO(Connection connection) { // construtor da classe
        super();
        this.connection = connection;
    }


/*
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
*/
}

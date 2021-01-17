package app.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepositDAO {
    protected static Connection connection;


    public DepositDAO(Connection connection) { // construtor da classe
        super();
        this.connection = connection;
    }


    // POST/Item Método que faz o insert na base de dados de um novo item, na tabela item
    public static void insertItem(Deposit deposit) {
        try {
            Statement statement = connection.createStatement();
            int idItem = deposit.getItem().getId();
            int quantity = deposit.getQuantity();
            statement.executeUpdate("INSERT INTO deposits (id_item, quantity_deposits) VALUES (idItem, quantity)");
            Statement statement2 = connection.createStatement();

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }



}

package app.models;

import java.sql.*;
import static app.models.ItemDAO.updateItem;

public class DepositDAO {
    protected static Connection connection;


    public DepositDAO(Connection connection) { // construtor da classe
        super();
        this.connection = connection;
    }


    // POST/Item Método que faz o insert na base de dados de um deposito, actualizando a quantidade na tabela de items
    public static void insertDeposit(Deposit deposit) {
        String INSERT = "INSERT INTO deposits (id_item, quantity_deposits) VALUES (?,?)";

        try{
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, deposit.getItem().getId());
            statement.setInt(2, deposit.getQuantity());
            statement.execute();
            updateItem(deposit.getItem(), 3); // PUT/Items update quantidade na tabela de items
        }
        catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}

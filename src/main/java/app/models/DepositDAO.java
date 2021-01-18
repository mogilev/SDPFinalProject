package app.models;

import java.sql.*;
import static app.models.ItemDAO.updateItem;

public class DepositDAO {
    protected static Connection connection;

    /**
     * Class DepositDAO constructor
     *
     * @param connection    receive the connection to da database
     */
    public DepositDAO(Connection connection) {
        super();
        this.connection = connection;
    }


    /**
     * POST/Deposit and PUT/Items
     * Method that inserts into a deposit database, updating the quantity in the items table
     *
      * @param deposit      receive the an Deposit object
     */
    public static void insertDeposit(Deposit deposit) {
        String INSERT = "INSERT INTO deposits (id_item, quantity_deposits) VALUES (?, ?)";
        ItemDAO itemDAO = new ItemDAO(connection);

        try{
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, deposit.getItem().getId());
            statement.setInt(2, deposit.getQuantity());
            statement.execute();
            itemDAO.updateItem(deposit.getItem(), 3); // updating the quantity in the items table
        }
        catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}

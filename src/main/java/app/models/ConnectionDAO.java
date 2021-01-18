package app.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class that provides a connection to the database by required proprieties:
 *      - Database url
 *      - host
 *      - Database name
 *      - Username
 *      - Password
 */
public class ConnectionDAO {
    private String url;
    private Properties properties;
    private final String host = "sdp_db:5432";
    private final String databaseName = "amv_transports";
    private final String username = "postgres";
    private final String password = "sdp";

    /**
     * Class constructor
     */
    public ConnectionDAO() {
        this.url = "jdbc:postgresql://" + host + "/" + databaseName;
        this.properties = new Properties();
        this.properties.setProperty("user", username);
        this.properties.setProperty("password", password);
    }


    /**
     * Method to get a connection by the proprieties
     *
     * @return proprieties of the connection
     * @throws SQLException     trows an SQL exception to be handle
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url, this.properties);
    }
}

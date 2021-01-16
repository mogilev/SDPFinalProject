package app.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDAO {
    private String url;
    private Properties properties;
    private final String host = "sdp_db:5432";
    private final String databaseName = "amv_transports";
    private final String username = "postgres";
    private final String password = "sdp";

    public ConnectionDAO() {
        this.url = "jdbc:postgresql://" + host + "/" + databaseName;
        this.properties = new Properties();
        this.properties.setProperty("user", username);
        this.properties.setProperty("password", password);
        /*try {
            this.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url, this.properties);
    }
}

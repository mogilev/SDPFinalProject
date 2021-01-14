package app.views;

import app.models.Item;
import app.models.ItemClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBC {

    // Método que faz a ligação com a Base de Dados Postgres que está no container com Webserver Wildfly
    public Connection Connection() {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "sdp")) {
            return connection;
        }
        catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return null;
    }

    // Faz a query à base de dados para obter a coleção completa da tabela items
    public List<Item> GetItemsCollection() throws SQLException {
        List<Item> items = new ArrayList<>();
        Item item = new ItemClass();
        Connection connection = Connection();
        Statement statement = connection.createStatement();

        try (ResultSet resultSet = statement.executeQuery("SELECT * FROM public.items")) {
            while (resultSet.next()) {
                System.out.println(item.getName()); // print para testar a conectividade TODO: depois eliminar print
                item.setId(resultSet.getString("id_item")); // TODO: fazer o parce para inteiro
                item.setName(resultSet.getString("name_item"));
                item.setDescription(resultSet.getString("description_item"));
            //    item.setQuantity(resultSet.getString("quantity_item")); // TODO: fazer cast para inteiro
                items.add(item);
            }
            return items; // retorna a lista de instancias com todos os items da tabela items
        }
        catch (SQLException e) {
            System.out.println("Query failure.");
            e.printStackTrace();
        }
        return null;
    }

}

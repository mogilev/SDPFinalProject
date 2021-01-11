package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionJDBC {

    public void Connection () {
        List<Car> cars = new ArrayList<Car>();
        Car c = new Car();

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.cars");

            while (resultSet.next()) {
                c.setModel(resultSet.getString("model"));
                c.setPrice(resultSet.getString("price"));
                cars.add(c);
            }
            // return cars;
        }
        catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

}

package app.views;

import app.models.Data;
import app.models.DatabaseConnectionManager;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/items/*")
public class ItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json"); // TODO: 1/11/2021
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("sdp_db:5432",
                "amv_transports", "postgres", "sdp");
        try{
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM items");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1));
                JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
                jsonBuilder.add("name", "Sucesso");
                jsonBuilder.add("value", resultSet.getInt(1));

                JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
                jsonWriter.writeObject(jsonBuilder.build());
                jsonWriter.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }


//        if req.getHeader().equals('/items/stock'){
//
//            JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
//            jsonBuilder.add("pedido", "Items em Stock");
//            jsonBuilder.add("value", 0);
//
//            JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
//            jsonWriter.writeObject(jsonBuilder.build());
//            jsonWriter.close();
//
//        }
//        else {
//        Data data = new Data("doGet", 42.0);
//
//        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
//        jsonBuilder.add("name", data.getName());
//        jsonBuilder.add("value", data.getValue());
//
//        JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
//        jsonWriter.writeObject(jsonBuilder.build());
//        jsonWriter.close();
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json"); // TODO

        Data data = new Data("doPost", 42.0);

        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        jsonBuilder.add("name", data.getName());
        jsonBuilder.add("value", data.getValue());

        JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
        jsonWriter.writeObject(jsonBuilder.build());
        jsonWriter.close();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");  // TODO

        Data data = new Data("doPut", 42.0);

        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        jsonBuilder.add("name", data.getName());
        jsonBuilder.add("value", data.getValue());

        JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
        jsonWriter.writeObject(jsonBuilder.build());
        jsonWriter.close();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json"); // TODO

        Data data = new Data("doDelete", 42.0);

        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        jsonBuilder.add("name", data.getName());
        jsonBuilder.add("value", data.getValue());

        JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
        jsonWriter.writeObject(jsonBuilder.build());
        jsonWriter.close();
    }
}

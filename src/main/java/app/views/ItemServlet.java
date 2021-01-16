package app.views;

import app.controllers.Warehouse;
import app.controllers.WarehouseClass;
import app.models.ConnectionDAO;
import app.models.Data;

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
        Warehouse warehouse = new WarehouseClass();
        String pathInfo = req.getPathInfo();

 /*       ConnectionDAO cdao = new ConnectionDAO();
        try{
            Connection connection = cdao.getConnection();
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
        }*/


        if (!isInteger(pathInfo)) {
            switch (pathInfo) {
                case "/":
                    commandGetItemCollection(warehouse, resp, false); // consulta todos os items
                    break;
                case "/stock":
                    commandGetItemCollection(warehouse, resp, true); // consulta items com stock
                    break;
            }
        }
        else {
            int itemId = Integer.parseInt(pathInfo); // penso que não seja necessário consultar um item individualmente
            commandGetItem(warehouse, resp, itemId);
        }

/*
        // bloco de codigo de teste, antigo
        resp.setContentType("application/json"); // TODO: 1/11/2021
        String urInfo = req.getRequestURI();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();

        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        jsonBuilder.add("urInfo", urInfo);
        jsonBuilder.add("contextPath", contextPath);
        jsonBuilder.add("servletPath", servletPath);
        jsonBuilder.add("pathInfo", pathInfo);

        JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
        jsonWriter.writeObject(jsonBuilder.build());
        jsonWriter.close();*/

/*        resp.setContentType("application/json"); // ligaçao à bd testada com sucesso, manter este bloco de código enquanto por backup
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
        }*/
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


    public static boolean isInteger(String str) {
        str = str.substring(1);
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }


    private static void commandGetItemCollection(Warehouse warehouse, HttpServletResponse resp, boolean stock) {
       //     List<Item> itemsList = warehouse.getItems(bool); //TODO
       //     jsonSender(itemsList);
        warehouse.buildItemsList(stock);
        if (warehouse.getItemsList().isEmpty()){
            try {
                JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
                jsonBuilder.add("error", "no items found!");
                JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
                jsonWriter.writeObject(jsonBuilder.build());
                jsonWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
                jsonWriter.writeArray(warehouse.jsonItemsCollectionSender().build());
                jsonWriter.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void commandGetItem(Warehouse warehouse, HttpServletResponse resp, int itemId) { // TODO não parece ser necessário no enunciado, confirmar
        if(!warehouse.itemExists(itemId)) {
            try {
                JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
                jsonBuilder.add(String.valueOf(itemId), "item not found!");
                JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
                jsonWriter.writeObject(jsonBuilder.build());
                jsonWriter.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {}
    }


}

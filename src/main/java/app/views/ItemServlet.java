package app.views;

import app.controllers.Warehouse;
import app.controllers.WarehouseClass;

import javax.json.Json;
import javax.json.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/items/*")
public class ItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Warehouse warehouse = new WarehouseClass();
        String pathInfo = req.getPathInfo();


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
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Warehouse warehouse = new WarehouseClass();
        String itemName = req.getParameter("name");
        itemName.toLowerCase();

        commandCreateItem(warehouse, resp, itemName);
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Warehouse warehouse = new WarehouseClass();
        String pathInfo = req.getPathInfo();
        String itemComment = req.getParameter("description");
        itemComment.toLowerCase();
        commandUpdateItem(warehouse, resp, pathInfo, itemComment);
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Warehouse warehouse = new WarehouseClass();
        String pathInfo = req.getPathInfo();
        commandDeleteItem(warehouse, resp, pathInfo);
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

        warehouse.buildItemsList(stock);
        if (warehouse.getItemsList().isEmpty()){
            warehouse.jSonSingleOutputSender(resp,"error","no items found!");

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
        if(!warehouse.itemIdExists(itemId)) {
            warehouse.jSonSingleOutputSender(resp,String.valueOf(itemId),"item not found!");

        }
        else {}
    }


    private static void commandCreateItem(Warehouse warehouse, HttpServletResponse resp, String itemName){
        if (true){ //!itemName.isBlank() //TODO atenção a este método, não corrigir sem testar
            warehouse.createItem(resp, itemName);
        }
        else{
            warehouse.jSonSingleOutputSender(resp,"Nome","dado obrigatório do item em falta");

        }
    }


    private static void commandUpdateItem(Warehouse warehouse, HttpServletResponse resp, String pathInfo,String itemComment) {

        if (isInteger(pathInfo)) {
            pathInfo = pathInfo.substring(1);
            int itemId = Integer.parseInt(pathInfo);
            warehouse.updateItem(warehouse, resp, itemId,itemComment);
        }
        else {
            warehouse.jSonSingleOutputSender(resp, "erro", "opção indisponível");
        }
    }


    private void commandDeleteItem(Warehouse warehouse, HttpServletResponse resp, String pathInfo) {
        if (isInteger(pathInfo)) {
            pathInfo = pathInfo.substring(1);
            int itemId = Integer.parseInt(pathInfo);
            warehouse.deleteItem(warehouse, resp, itemId);
        }
        else {
            warehouse.jSonSingleOutputSender(resp, "erro", "opção indisponível");
        }
    }

}

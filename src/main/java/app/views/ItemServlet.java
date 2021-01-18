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


/**
 * Class that handle with all URLs for the items
 */
@WebServlet("/items/*")
public class ItemServlet extends HttpServlet {

    /**
     * Gets the collection of all items or (switch case) items with stock > 0
     *
     * @param   req   HttpServletResponse type used to receive an http request
     * @param   resp  HttpServletResponse type used to send an http response
     * @throws  ServletException
     * @throws  IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Warehouse warehouse = new WarehouseClass();
        String pathInfo = req.getPathInfo();

        if(!isInteger(pathInfo)) {
            switch (pathInfo) {
                case "/":
                    commandGetItemCollection(warehouse, resp, false); // all items
                    break;
                case "/stock":
                    commandGetItemCollection(warehouse, resp, true); // all items with stock
                    break;
            }
        }
        else {
            int itemId = Integer.parseInt(pathInfo);
            commandGetItem(warehouse, resp, itemId);
        }
    }


    /**
     * POST a new item in the database
     *
     * @param   req   HttpServletResponse type used to receive an http request
     * @param   resp  HttpServletResponse type used to send an http response
     * @throws  ServletException
     * @throws  IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Warehouse warehouse = new WarehouseClass();
        String itemName = req.getParameter("name");
        itemName.toLowerCase();

        commandCreateItem(warehouse, resp, itemName);
    }


    /**
     * PUT - Updates an item information
     *
     * @param   req   HttpServletResponse type used to receive an http request
     * @param   resp  HttpServletResponse type used to send an http response
     * @throws  ServletException
     * @throws  IOException
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Warehouse warehouse = new WarehouseClass();
        String pathInfo = req.getPathInfo();
        String itemComment = req.getParameter("description");
        itemComment.toLowerCase();
        commandUpdateItem(warehouse, resp, pathInfo, itemComment);
    }


    /**
     * DELETE an item
     *
     * @param   req   HttpServletResponse type used to receive an http request
     * @param   resp  HttpServletResponse type used to send an http response
     * @throws  ServletException
     * @throws  IOException
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Warehouse warehouse = new WarehouseClass();
        String pathInfo = req.getPathInfo();
        commandDeleteItem(warehouse, resp, pathInfo);
    }


    /**
     * Check String to parse to integer
     *
     * @param       str receive a string
     * @return      boolean
     * @exception   Error if can make parse
     */
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


    /**
     * Response to the client Get request with, a list of items in jSon format
     *
     * @param warehouse     Warehouse object
     * @param resp          response
     * @param stock         boolean true/false if have stock for the item
     * @exception           Error I/O Exception
     */
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
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Response to the client Get request for an item
     *
     * @param warehouse Warehouse object
     * @param resp      response
     * @param itemId    id of the item to get
     */
    private static void commandGetItem(Warehouse warehouse, HttpServletResponse resp, int itemId) {
        if(!warehouse.itemIdExists(itemId)) {
            warehouse.jSonSingleOutputSender(resp, String.valueOf(itemId),"item not found!");
        }
        else {}
    }


    /**
     * Response to client Put request to insert an item
     *
     * @param warehouse Warehouse object
     * @param resp      response
     * @param itemName  name of the item
     */
    private static void commandCreateItem(Warehouse warehouse, HttpServletResponse resp, String itemName){
        if(true){ //!itemName.isBlank() //método //!itemName.isBlank() com erro
            warehouse.createItem(resp, itemName);
        }
        else{
            warehouse.jSonSingleOutputSender(resp,"Nome","dado obrigatório do item em falta");
        }
    }


    /**
     * Response to a Put request for update item
     *
     * @param warehouse     Warehouse
     * @param resp          response
     * @param pathInfo      path information
     * @param itemComment   item comment
     */
    private static void commandUpdateItem(Warehouse warehouse, HttpServletResponse resp, String pathInfo,String itemComment) {

        if(isInteger(pathInfo)) {
            pathInfo = pathInfo.substring(1);
            int itemId = Integer.parseInt(pathInfo);
            warehouse.updateItem(warehouse, resp, itemId,itemComment);
        }
        else {
            warehouse.jSonSingleOutputSender(resp, "erro", "opção indisponível");
        }
    }


    /**
     * Response to a Delete request for delete item
     *
     * @param warehouse     Warehouse
     * @param resp          response
     * @param pathInfo      path information
     */
    private void commandDeleteItem(Warehouse warehouse, HttpServletResponse resp, String pathInfo) {

        if(isInteger(pathInfo)) {
            pathInfo = pathInfo.substring(1);
            int itemId = Integer.parseInt(pathInfo);
            warehouse.deleteItem(warehouse, resp, itemId);
        }
        else {
            warehouse.jSonSingleOutputSender(resp, "erro", "opção indisponível");
        }
    }

}

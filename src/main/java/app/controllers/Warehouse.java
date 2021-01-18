package app.controllers;


import app.models.Delivery;
import app.models.Deposit;
import app.models.Item;

import javax.json.JsonArrayBuilder;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 * Represents the controller of the API
 * Applies project's business rules
 */
public interface Warehouse {

    /**
     * Establishes connection with the Database
     *
     * @exception SQLException when connection fails
     */
    void daoConnection();

    /**
     * Deletes an Item
     *
     * @param warehouse A Warehouse object
     * @param resp #HttpServletResponse type used to send http response
     * @param i Id of the element to delete
     */
    void deleteItem(Warehouse warehouse, HttpServletResponse resp, int i);

    /**
     * Confirms if an element with a certain Id exists in the Database.
     *
     * @param itemId id of the item to check
     * @return true if exists, otherwise false
     */
    boolean itemIdExists(int itemId);

    /**
     * Confirms if an item with a certain name exists in the Database.
     *
     * @param itemName name of the item to check
     * @return true if exists, otherwise false
     */
    boolean itemNameExists(String itemName);

    /**
     * Adds a new item
     *
     * @param resp HttpServletResponse type used to send http response
     * @param itemName name of the item to create
     */
    void createItem(HttpServletResponse resp, String itemName);

    /**
     * Update item's description
     *
     * @param warehouse Warehouse object
     * @param resp HttpServletResponse type used to send http response
     * @param itemId id of the item
     * @param itemDescription new description
     */
    void updateItem(Warehouse warehouse, HttpServletResponse resp, int itemId, String itemDescription);

    /**
     * Populates the Warehouse items list
     * information saved in the database
     *
     * @param bool true populates only with items whose stock >0, false populates with all items in the database
     */
    void buildItemsList(boolean bool);



    /**
     * Creates Deposit object
     *
     * @param warehouse Warehouse object
     * @param resp HttpServletResponse type used to send http response
     * @param itemId item tha will receive the deposit
     * @param quantity quantity that will be deposited
     */
    void createDeposit(Warehouse warehouse,HttpServletResponse resp, int itemId, int quantity);


    //  Lists

    /**
     * Gets the deposits list
     *
     * @return itemsList
     */
    List<Item> getItemsList();

    /**
     * Gets the deposits list
     *
     * @return depositsList
     */
    List<Deposit> getDepositsList();

    /**
     * Gets the deliveries list
     *
     * @return deliveriesList
     */
    List<Delivery> getDeliveriesList();


    //  Json's

    /**
     * Creates and sends a Json file
     * Used to send error responses (no item, no delivery,...)
     *
     * @param resp HttpServletResponse type used to send http response
     * @param key json key to be sent
     * @param value json value to be sent
     */
    void jSonSingleOutputSender(HttpServletResponse resp, String key, String value);

    /**
     * Creates JSON file with the items collection
     * Collection may be total items or only items with stock
     *
     * @return a json file
     */
    JsonArrayBuilder jsonItemsCollectionSender();

    /**
     * Creates JSON file with the deliveries collection
     * #not implemented
     *
     * @return a json file
     */
    JsonArrayBuilder jsonDeliveriesCollectionSender();

}

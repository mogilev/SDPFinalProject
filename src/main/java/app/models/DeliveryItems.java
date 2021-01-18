package app.models;

public interface DeliveryItems {

    /**
     * Gets the item of the delivery
     * @return the item
     */
    Item getItem();

    /**
     * Gets the quantity of items
     * @return the quantity
     */
    int getQuantity();
}

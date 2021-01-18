package app.models;

/**
 * Represents one item of an specific delivery
 *
 */
public class DeliveryItemsClass implements DeliveryItems{
    private Item item;
    private int quantity;

    /**
     * Creates a new delivery item object
     *
     * @param item item delivered
     * @param quantity of the item delivered
     */
    public DeliveryItemsClass(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}

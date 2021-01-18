package app.models;

/**
 * Class of objects for the items_table
 */
public class DeliveryItemsClass implements DeliveryItems{
    private Item item;
    private int quantity;

    /**
     * Class constructor
     *
     * @param item      object of items of ItemsClass
     * @param quantity  int
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

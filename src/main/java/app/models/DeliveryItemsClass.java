package app.models;

public class DeliveryItemsClass implements DeliveryItems{
    private Item item;
    private int quantity;

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

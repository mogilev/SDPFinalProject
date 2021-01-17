package app.models;

public class DeliveryItemsClass implements DeliveryItems{
    private int delivery;
    private int item;
    private int quantity;

    public DeliveryItemsClass(int delivery, int item, int quantity) {
        this.delivery = delivery;
        this.item = item;
        this.quantity = quantity;
    }

    public int getDelivery() { return delivery; }

    public int getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}

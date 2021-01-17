package app.models;

public class DepositClass {
    int id;
    Item item;
    int quantity;

    public DepositClass(int id, Item item, int quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    int getId() { return id; }

    Item getItem() {
        return this.item;
    }

    int getQuantity() {
        return quantity;
    }

}

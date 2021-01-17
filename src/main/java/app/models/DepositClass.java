package app.models;

public class DepositClass implements Deposit{
    int id;
    Item item;
    int quantity;

    public DepositClass(int id, Item item, int quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }


    @Override
    public int getId() {
        return 0;
    }

    @Override
    public Item getItem() {
        return null;
    }

    @Override
    public int getQuantity() {
        return 0;
    }
}

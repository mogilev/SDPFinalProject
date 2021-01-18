package app.models;

/**
 * Represents a deposit
 *
 */
public class DepositClass implements Deposit{
    int id;
    Item item;
    int quantity;

    /**
     * Creates a new deposit with an Id, the item and specific quantity to be deposited
     *
     * @param id of the delivery
     * @param item item that'll receive the deposit
     * @param quantity to be deposited
     */
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

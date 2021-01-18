package app.models;

/**
 * Class for the Deposits table of the Database
 */
public class DepositClass implements Deposit{
    int id;
    Item item;
    int quantity;

    /**
     * Class constructor
     * @param id        int
     * @param item      object for items ItemClass
     * @param quantity  int
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

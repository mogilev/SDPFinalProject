package app.models;

public interface Deposit {

    /**
     * Get the deposit's Id
     *
     * @return Id
     */
    int getId();

    /**
     * Get the specific deposit's item
     *
     * @return item
     */
    Item getItem();

    /**
     * Get the specific deposit's quantity
     *
     * @return quantity
     */
    int getQuantity();
}

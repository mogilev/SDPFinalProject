package app.models;

public interface Item {

    /**
     * Gets the item's Id
     *
     * @return item Id
     */
    int getId();

    /**
     * Gets the item's name
     *
     * @return name
     */
    String getName();

    /**
     * Gets the item's description
     *
     * @return description
     */
    String getDescription();

    /**
     * Changes the item's description
     *
     * @param description
     */
    void setDescription(String description);

    /**
     * Gets the item's quantity(stock)
     *
     * @return
     */
    int getQuantity();

    /**
     * Changes the item's quantity(stock)
     *
     * @param quantity
     */
    void setQuantity(int quantity);
}

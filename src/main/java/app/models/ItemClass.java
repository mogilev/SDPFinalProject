package app.models;

/**
 * Represents an item available/possibly available to sell/send in the company
 */
public class ItemClass implements Item {
    int id;
    private String name;
    private String description;
    private int quantity;

    /**
     * Creates a new item object
     *
     * @param id  item's Id
     * @param name item's name
     * @param description item's description
     * @param quantity item's stock
     */
    public ItemClass(int id, String name, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
package app.models;

/**
 * Class for the Items table of the database
 */
public class ItemClass implements Item {
    int id;
    private String name;
    private String description;
    private int quantity;

    /**
     * Item class constructor
     *
     * @param id            int
     * @param name          String
     * @param description   String
     * @param quantity      int
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
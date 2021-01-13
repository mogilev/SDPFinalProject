package app.models;

public class ItemClass implements Item {
    int id;
    String name;
    String description;
    int quantity;

    public ItemClass() {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }
    public void setId(String id_item) { this.id = id; }

    public String getName() {
        return name;
    }
    public void setName(String name_item) { this.name = name; }

    public String getDescription() {
        return description;
    }
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

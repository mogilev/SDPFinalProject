package app.models;

public interface Item {

    public int getId();  // Retorna Id do Item

    public String getName();  // Retorna o nome do Item

    public String getDescription();  // Retorna a descrição do Item

    public void setDescription(String description);  // Altera a descrição do Item

    public int getQuantity(); // Retorna quantidade em stock do Item

    public void setQuantity(int quantity);  // altera a quantidade do item
}

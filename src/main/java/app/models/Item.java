package app.models;

public interface Item {

    int getId();  // Retorna Id do Item

    String getName();  // Retorna o nome do Item

    String getDescription();  // Retorna a descrição do Item

    void setDescription(String description);  // Altera a descrição do Item

    int getQuantity(); // Retorna quantidade em stock do Item

    void setQuantity(int quantity);  // altera a quantidade do item


}

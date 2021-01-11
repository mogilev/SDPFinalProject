package app.models;

public interface Deposit {

    int getId(); // Retorna o Id do depósito

    void setId(int id); // Altera o Id do depósito

    int getItemId(); // Retorna o id do Item

    void setItemId(int itemId); // Altera o Id do Item

    int getQuantity(); // Retorna a quantidade do Item

    void setQuantity(int quantity); // Altera a quantidade do Item
}

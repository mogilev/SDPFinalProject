package app.models;

public interface Item {

    /**
     * Método que retorna o Id do Item.
     * @return
     */
    int getId();

    /**
     * Método que retorna o Nome do Item.
     * @return
     */
    String getName();

    /**
     * Método que retorna a Descrição do Item.
     * @return
     */
    String getDescription();

    /**
     * Método que altera a descrição de Item.
     * @param description
     */
    void setDescription(String description);

    /**
     * Método que retorna a quantidade em Stock do Item.
     * @return
     */
    int getQuantity();

    /**
     * Método que altera a quantidade do Item.
     * @param quantity
     */
    void setQuantity(int quantity);
}

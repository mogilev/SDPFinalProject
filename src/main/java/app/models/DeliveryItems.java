package app.models;

public interface DeliveryItems {

    /**
     * Gets the item of the specific pair delivery item (item7quantity)
     * @return
     */
    Item getItem();

    /**
     * Método que retorna a quantidade de cada Item presente na tabela de entregas.
     * @return
     */
    int getQuantity();
}

package app.models;

public interface DeliveryItems {

    /**
     * Método que retorna o Item presente na tabela de Entregas.
     * @return
     */
    Item getItem();

    /**
     * Método que retorna a quantidade de cada Item presente na tabela de entregas.
     * @return
     */
    int getQuantity();
}

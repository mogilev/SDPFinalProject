package app.models;

import java.util.List;

public interface Delivery {

    /**
     * Método que retorna o número da Entrega.
     * @return the
     */
    int getDeliveryId();

    /**
     * Método que retorna o Local da Entrega.
     * @return
     */
    String getPlace();

    /**
     * Método que?????????????????
     * @param place
     */
    void setPlace(String place);

    /**
     * Método que retorna a Lista de Items para Entrega.
     * @return
     */
    List<DeliveryItems> getDeliveryItemsList();

    /**
     * Método que cria Lista de Items para Entrega.
     * @param deliveryItems
     */
    void setDeliveryItems(DeliveryItems deliveryItems);
}

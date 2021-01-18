package app.models;

import java.util.List;

public interface Delivery {

    /**
     * Método que retorna o número da Entrega.
     * @return the delivery id
     */
    int getDeliveryId();

    /**
     * The receiver address of this delivery
     * @return the address
     */
    String getPlace();

    /**
     * Changes the delivery's address
     * @param place the address
     */
    void setPlace(String place);

    /**
     * Gets the items (and its quantity) of the delivery
     * @return the deliveriesList
     */
    List<DeliveryItems> getDeliveryItemsList();

    /**
     * Creates a new set of items/quantity associated with this delivery
     * not implemented
     * @param deliveryItems receives an object DeliveryItems
     */
    void setDeliveryItems(DeliveryItems deliveryItems);
}

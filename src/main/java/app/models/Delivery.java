package app.models;

import java.util.List;

public interface Delivery {

    int getDeliveryId();

    String getPlace();

    void setPlace(String place);

    List<DeliveryItems> getDeliveryItemsList();

    void setDeliveryItems(DeliveryItems deliveryItems);

}

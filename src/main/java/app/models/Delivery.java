package app.models;

import java.util.List;

public interface Delivery {

    int getDeliveryId();

    int getPlace();

    List<DeliveryItems> getDeliveryItemsList();
}

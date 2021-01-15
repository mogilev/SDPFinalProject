package app.models;

import java.util.List;

public interface Delivery {

    int getDeliveryId();

    String getPlace();

    List<DeliveryItems> getDeliveryItemsList();


}

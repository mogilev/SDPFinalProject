package app.models;

import java.util.ArrayList;
import java.util.List;

public class DeliveryClass {
    int id;
    private String place;
    private List<DeliveryItems> deliveryItemsList;
    // TODO


    public DeliveryClass(int id, String place) {
        this.id = id;
        this.place = place;
        this.deliveryItemsList = new ArrayList<DeliveryItems>();
    }

    public int getDeliveryId() {
        return id;
    }

    public String getPlace() {
        return place;
    }

    public List<DeliveryItems> getDeliveryItemsList() {
        return deliveryItemsList;
    }
}

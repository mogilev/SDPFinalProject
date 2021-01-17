package app.models;

import java.util.ArrayList;
import java.util.List;

public class DeliveryClass implements Delivery {
    private int id;
    private int place;
    private List<DeliveryItems> deliveryItemsList;

    public DeliveryClass(int id, int place, List<DeliveryItems> deliveryItems) {
        this.id = id;
        this.place = place;
        this.deliveryItemsList = new ArrayList<DeliveryItems>();
    }

    public int getDeliveryId() {
        return id;
    }

    public int getPlace() {
        return place;
    }

    public List<DeliveryItems> getDeliveryItemsList() {
        return deliveryItemsList;
    }
}

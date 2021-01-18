package app.models;

import java.util.ArrayList;
import java.util.List;

public class DeliveryClass implements Delivery {
    private int id;
    private String place;
    private List<DeliveryItems> deliveryItemsList;


    public DeliveryClass(int id, String place, List<DeliveryItems> deliveryItems) {
        this.id = id;
        this.place = place;
        this.deliveryItemsList = new ArrayList<DeliveryItems>();
    }

    public DeliveryClass(int idDelivery, String place) {
        this.id = id;
        this.place = place;
    }

    public int getDeliveryId() {
        return id;
    }

    public String getPlace() {
        return place;
    }

    @Override
    public void setPlace(String place) { this.place = place; };

    public List<DeliveryItems> getDeliveryItemsList() {
        return deliveryItemsList;
    }

    @Override
    public void setDeliveryItems(DeliveryItems deliveryItems) { this.deliveryItemsList.add(deliveryItems); }

}

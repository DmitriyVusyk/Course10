package module7.deliveryService;

import module7.Fruit;

import java.util.ArrayList;

public class Delivery {

    private ArrayList<Fruit> fruitsDeliveryBasked;

    public Delivery(ArrayList<Fruit> fruitsDeliveryBasked) {
        this.fruitsDeliveryBasked = fruitsDeliveryBasked;
    }

    public ArrayList<Fruit> getFruitsDeliveryBasked() {
        return fruitsDeliveryBasked;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "fruitsDeliveryBasked=" + fruitsDeliveryBasked +
                '}';
    }
}

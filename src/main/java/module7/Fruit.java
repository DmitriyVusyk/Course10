package module7;

import module7.enumerated.Fruits;

import java.util.GregorianCalendar;


public class Fruit {
    private Fruits fruit;
    private GregorianCalendar expiryDate;
    private GregorianCalendar deliveryDate;
    private float prise;

    public Fruit(Fruits fruit, GregorianCalendar expiryDate, GregorianCalendar deliveryDate, float prise) {
        this.fruit = fruit;
        this.expiryDate = expiryDate;
        this.deliveryDate = deliveryDate;
        this.prise = prise;
    }
}

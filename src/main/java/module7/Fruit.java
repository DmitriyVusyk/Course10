package module7;

import module7.enumerated.Fruits;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


public class Fruit {

    private Fruits fruit;
    private int shelfLife;
    private String deliveryDate;
    private float prise;

    public Fruit(Fruits fruit, int shelfLife, Date deliveryDate, float prise) {
        this.fruit = fruit;
        this.shelfLife = shelfLife;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
        this.deliveryDate = sdf.format(deliveryDate);
        this.prise = prise;
    }

    public Fruits getFruit() {
        return fruit;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public float getPrise() {
        return prise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit1 = (Fruit) o;
        return shelfLife == fruit1.shelfLife &&
                Float.compare(fruit1.prise, prise) == 0 &&
                fruit == fruit1.fruit &&
                Objects.equals(deliveryDate, fruit1.deliveryDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fruit, shelfLife, deliveryDate, prise);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "fruit=" + fruit +
                ", shelfLife=" + shelfLife +
                ", deliveryDate=" + deliveryDate +
                ", prise=" + prise +
                '}';
    }
}

package module7;

import module7.deliveryService.Delivery;
import module7.deliveryService.DeliveryService;
import module7.enumerated.Fruits;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Test {

    private static final String STORE_LOCATION_FOR_DELIVERY_SERVICE = "src/main/java/module7/store/goodsReceipt";

    public static void main(String[] args) {

        GregorianCalendar gc = new GregorianCalendar();

        Fruit apple = new Fruit(Fruits.APPLE, 10, gc.getTime()
                , 1);
        Fruit banana = new Fruit(Fruits.BANANA, 15,
                gc.getTime(), 2);
        Fruit cherry = new Fruit(Fruits.CHERRY, 5,
                gc.getTime(), 1);
        Fruit grapefruit = new Fruit(Fruits.GRAPEFRUIT, 10,
                gc.getTime(), 1);
        Fruit grape = new Fruit(Fruits.GRAPES, 15,
                gc.getTime(), 2);
        Fruit mandarin = new Fruit(Fruits.MANDARIN, 5,
                gc.getTime(), 1);
        Fruit pear = new Fruit(Fruits.PEAR, 10,
                gc.getTime(), 1);
        Fruit pineapple = new Fruit(Fruits.PINEAPPLE, 15,
                gc.getTime(), 2);
        Fruit raspberry = new Fruit(Fruits.RASPBERRY, 5,
                gc.getTime(), 1);
        Fruit strawbarry = new Fruit(Fruits.STRAWBERRY, 5,
                gc.getTime(), 1);

        TradeShop ts = new TradeShop();
        DeliveryService ds = DeliveryService.getInstance();

        //First delivery
        ArrayList<Fruit> firstDelivery = new ArrayList<>();
        firstDelivery.add(apple);
        firstDelivery.add(cherry);
        firstDelivery.add(grape);

        Delivery delivery1 = new Delivery(firstDelivery);
        ds.configDelivery(STORE_LOCATION_FOR_DELIVERY_SERVICE, delivery1);
        ts.acceptDelivery(ds);

        //Second delivery
        ArrayList<Fruit> secondDelivery = new ArrayList<>();
        secondDelivery.add(banana);
        secondDelivery.add(grapefruit);
        secondDelivery.add(mandarin);
        secondDelivery.add(raspberry);

        Delivery delivery2 = new Delivery(secondDelivery);
        ds.configDelivery(STORE_LOCATION_FOR_DELIVERY_SERVICE, delivery2);
        ts.acceptDelivery(ds);

        ts.addFruits(STORE_LOCATION_FOR_DELIVERY_SERVICE, "Delivery_1");
        System.out.println(ts.getStore().toString());

        //save array to store
        ts.save();

        //load array from store
        System.out.println("Load Array from store");
        ts.load();
        System.out.println(ts.getStore());

        //get spoiled fruits
        System.out.println("get spoiled fruits");
        System.out.println(ts.getSpoiledFruits("2018_03_12"));

        //get spoiled fruits with type
        System.out.println("get spoiled with type apple fruits");
        System.out.println(ts.getSpoiledFruits("2018_03_12", Fruits.APPLE));

        //get ready fruits
        System.out.println("fruits ready to sell");
        System.out.println(ts.getAvailableFruits("2018_03_12"));

        //get ready fruits with type
        System.out.println("grapes ready to sell");
        System.out.println(ts.getAvailableFruits("2018_03_12", Fruits.GRAPES));

        //get fruits at date which was delivered at date
        System.out.println("продукты которые были доставлены в заданную дату");
        System.out.println(ts.getAddedFruits("2018_03_02"));

        //get cherry which was delivered at date
        System.out.println("Cherry которые были доставлены в заданную дату");
        System.out.println(ts.getAddedFruits("2018_03_04" , Fruits.CHERRY));
    }


}

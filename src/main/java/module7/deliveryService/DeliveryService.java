package module7.deliveryService;

public class DeliveryService {

    private static DeliveryService instance;

    private static final String DELIVERY_NAME = "Delivery";
    private int counter = 1;
    private String pathToFile;
    private Delivery delivery;

    private DeliveryService() {
    }

    public void configDelivery(String pathToFile, Delivery delivery){
        setDelivery(delivery);
        setDestinationAddress(pathToFile);
    }

    private void setDestinationAddress(String path) {
        StringBuilder sb = new StringBuilder();
        String str = sb.append(path).append("/").append(DELIVERY_NAME).append("_").append(counter).toString();
        counter++;
        this.pathToFile = str;
    }

    public static synchronized DeliveryService getInstance() {
        if (instance == null) {
            instance = new DeliveryService();
        }
        return instance;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    private void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}

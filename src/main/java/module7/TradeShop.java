package module7;

import com.google.gson.Gson;

public class TradeShop {

    private String pathToFIle;

    public TradeShop(String pathToFIle) {
        this.pathToFIle = pathToFIle;
    }

    private String serializeFruit(Fruit fruit) {
        Gson gson = new Gson();
        return gson.toJson(fruit);
    }

   private Fruit deserializeFruit(String fruitJson) {
        Gson gson = new Gson();
        return gson.fromJson(fruitJson, Fruit.class);
    }

    void addFruits(String pathToJsonFile) {

    }

    void save(String pathToJsonFile) {

    }

    void load(String pathToJsonFile) {

    }
}

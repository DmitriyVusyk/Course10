package module7;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import module7.deliveryService.DeliveryService;
import module7.enumerated.Fruits;

import java.io.*;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TradeShop {

    private static final String STORE_LOCATION = "src/main/java/module7/store/store.txt";
    private ArrayList<Fruit> store = new ArrayList<>();

    public TradeShop() {

    }

    private String serializeFruit(ArrayList fruit) {
        Gson gson = new Gson();
        return gson.toJson(fruit);
    }

    private ArrayList<Fruit> deserializeFruit(String fruitJson) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Fruit>>() {
        }.getType();
        return gson.fromJson(fruitJson, type);
    }

    /**
     * метод принимает путь к файлу внутри которого находится json с фруктами и датой поставки.
     * Один файл - одна поставка.
     *
     * @param pathToJsonFile
     */
    public void addFruits(String pathToJsonFile, String fileName) {
        StringBuilder sb = new StringBuilder();
        String filepath = sb.append(pathToJsonFile).append("/").append(fileName).toString();
        File file = new File(filepath);
        String string = "";


        try (BufferedReader br = new BufferedReader(new FileReader(file));) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = br.readLine();
            }
            string = stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        store.addAll(deserializeFruit(string));
    }


    /**
     * This method save delivery to the delivery store
     *
     * @param ds delivery store
     * @return <code>true</code> if delivery was saved
     */
    public boolean acceptDelivery(DeliveryService ds) {
        try {
            File file = new File(ds.getPathToFile());
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(serializeFruit(ds.getDelivery().getFruitsDeliveryBasked()));
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * сохранит всю информацию со склада лавки в json файл.
     */
    public void save() {

        try {
            File file = new File(STORE_LOCATION);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(serializeFruit(store));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * удаляют текущую информацию из коллекции и загружает новую из сохраненной версии.
     */
    public void load() {
        StringBuilder sb = new StringBuilder();

        File file = new File(STORE_LOCATION);
        String string = "";

        try (BufferedReader br = new BufferedReader(new FileReader(file));) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = br.readLine();
            }
            string = stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        store.addAll(deserializeFruit(string));
    }

    public ArrayList<Fruit> getStore() {
        return store;
    }


    /**
     * метод способный сказать какие продукты испортятся к заданной дате
     *
     * @param date date in format yyyy_MM_dd
     * @return array with spoiled fruits
     */
    public List<Fruit> getSpoiledFruits(String date) {

        return store.stream().filter((Fruit fruit) -> {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy_MM_dd");
            Date spoiledDate = null;
            try {
                spoiledDate = format.parse(fruit.getDeliveryDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            spoiledDate.setDate(spoiledDate.getDate() + fruit.getShelfLife());


            Date date2 = null;
            try {
                date2 = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return spoiledDate.before(date2);
        }).collect(Collectors.toList());

    }

    /**
     * возвращает список готовых к продаже продуктов
     *
     * @param date date in format yyyy_MM_dd
     * @return array with fruits which are ready to sell
     */
    public List<Fruit> getAvailableFruits(String date) {
        return store.stream().filter((Fruit fruit) -> {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy_MM_dd");
            Date spoiledDate = null;
            try {
                spoiledDate = format.parse(fruit.getDeliveryDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            spoiledDate.setDate(spoiledDate.getDate() + fruit.getShelfLife());


            Date date2 = null;
            try {
                date2 = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return spoiledDate.after(date2);
        }).collect(Collectors.toList());
    }

    /**
     * метод способный сказать какие продукты испортятся к заданной дате
     *
     * @param date date in format yyyy_MM_dd
     * @param type type of fruit
     * @return array with spoiled fruits
     */
    public List<Fruit> getSpoiledFruits(String date, Fruits type) {

        return store.stream().filter((Fruit fruit) -> {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy_MM_dd");
            Date spoiledDate = null;
            try {
                spoiledDate = format.parse(fruit.getDeliveryDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            spoiledDate.setDate(spoiledDate.getDate() + fruit.getShelfLife());


            Date date2 = null;
            try {
                date2 = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return spoiledDate.before(date2) && fruit.getFruit().equals(type);
        }).collect(Collectors.toList());

    }

    /**
     * возвращает список готовых к продаже продуктов
     *
     * @param date date in format yyyy_MM_dd
     * @param type type of fruit
     * @return array with fruits which are ready to sell
     */
    public List<Fruit> getAvailableFruits(String date, Fruits type) {
        return store.stream().filter((Fruit fruit) -> {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy_MM_dd");
            Date spoiledDate = null;
            try {
                spoiledDate = format.parse(fruit.getDeliveryDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            spoiledDate.setDate(spoiledDate.getDate() + fruit.getShelfLife());


            Date date2 = null;
            try {
                date2 = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return spoiledDate.after(date2) && fruit.getFruit().equals(type);
        }).collect(Collectors.toList());
    }

    /**
     * возвращает продукты которые были доставлены в заданную дату
     *
     * @param date date of delivery
     * @return List with fruits which was delivered at <code>date</code>
     */
    public List<Fruit> getAddedFruits(String date) {
        return store.stream().filter((Fruit fruit) -> {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy_MM_dd");
            Date fruitDeliveryDate = null;
            try {
                fruitDeliveryDate = format.parse(fruit.getDeliveryDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Date inputDate = null;
            try {
                inputDate = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return fruitDeliveryDate.equals(inputDate);
        }).collect(Collectors.toList());
    }

    /**
     * возвращает продукты которые были доставлены в заданную дату
     *
     * @param date date of delivery
     * @param type type of fruit
     * @return List with fruits which was delivered at <code>date</code>
     */
    public List<Fruit> getAddedFruits(String date, Fruits type) {
        return store.stream().filter((Fruit fruit) -> {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy_MM_dd");
            Date fruitDeliveryDate = null;
            try {
                fruitDeliveryDate = format.parse(fruit.getDeliveryDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Date inputDate = null;
            try {
                inputDate = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return fruitDeliveryDate.equals(inputDate) && fruit.getFruit().equals(type);
        }).collect(Collectors.toList());
    }
}



package module7;

import com.google.gson.Gson;
import module7.enumerated.Fruits;

import java.util.GregorianCalendar;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Fruit fruit = new Fruit(Fruits.APPLE, new GregorianCalendar(2018,1,20),
                new GregorianCalendar(Locale.getDefault()),1);

        String str = gson.toJson(fruit);

        System.out.println(str);
    }
}

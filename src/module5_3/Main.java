package module5_3;

import module5_3.flower_entities.Flower;
import module5_3.utilities.FlowersLoader;
import module5_3.utilities.FlowersSaver;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static final String PATH_TO_FILE = "src/module5_3/files/flower_bouquet.txt";

    public static void main(String[] args) {

        FlowerStore fs = new FlowerStore();

        Flower[] flowers = fs.sell(5, 4, 3);

        System.out.println(Arrays.toString(flowers));
        System.out.println("Wallet: " + fs.getWallet());

        Flower[] flowers1 = fs.sellSequence(5, 3, 1);

        System.out.println(Arrays.toString(flowers1));
        System.out.println("Wallet: " + fs.getWallet());

        FlowersSaver.save(PATH_TO_FILE, flowers);

        System.out.println("Output from FIle :");
        try {
            Flower[] flowersFromFile = FlowersLoader.load(PATH_TO_FILE);
            System.out.println(Arrays.toString(flowersFromFile));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

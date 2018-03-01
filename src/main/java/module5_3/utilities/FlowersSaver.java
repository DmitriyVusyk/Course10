package module5_3.utilities;

import module5_3.flower_entities.Flower;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.lang3.SerializationUtils.serialize;

public class FlowersSaver {

    private FlowersSaver() {
    }

    public static void save(String path, Flower[] flowerBouquet) {

        File file = new File(path);

        try {
            FileUtils.writeByteArrayToFile(file, serialize(flowerBouquet));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("i am going down here");
        }

    }

}

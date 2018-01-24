package module5_3.utilities;

import module5_3.flower_entities.Flower;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SerializationUtils;

import java.io.File;
import java.io.IOException;

public class FlowersLoader {

    private FlowersLoader() {
    }

    public static Flower[] load(String path) throws IOException {

        File file = new File(path);

        return (Flower[]) SerializationUtils.deserialize(FileUtils.readFileToByteArray(file));
    }
}

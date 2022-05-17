package collectionGenerate;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterToJson {

    public void writeIntoFile(String serviceName, String text) throws IOException {
        FileWriter writer = new FileWriter(serviceName + ".postman_collection.json", false);
        writer.write(text);
        writer.append('\n');
        writer.flush();
    }
}

import collectionGenerate.Creator;
import collectionGenerate.FileWriterToJson;
import org.junit.Test;

import static collectionGenerate.Data.repoServiceName;

public class Start {

    @Test
    public void generateCollection() throws Exception {
        Creator creator = new Creator();
        FileWriterToJson writter = new FileWriterToJson();
        writter.writeIntoFile(repoServiceName, creator.createCollection());
    }
}

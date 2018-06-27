package spring_intro.product_shop.io.writer;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class WriterImpl implements Writer {
    @Override
    public void writeToFile(String source, String fileName) {
        try {
            String mainPath = System.getProperty("user.dir") + "/src/main/resources";
            FileWriter fileWriter = new FileWriter(new File(mainPath, fileName));
            fileWriter.write(source);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

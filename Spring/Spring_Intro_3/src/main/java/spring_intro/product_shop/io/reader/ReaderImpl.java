package spring_intro.product_shop.io.reader;

import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class ReaderImpl implements Reader {

    @Override
    public String readAll(String fileName) {
        InputStream stream = Reader.class.getResourceAsStream(fileName);
        try {
            return StreamUtils.copyToString(stream, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

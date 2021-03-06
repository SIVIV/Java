package spring_intro.product_shop.io.xmlparser;

public interface XmlParser {
    <T> String serialize(T t);
    <T> T deserialize(String source, Class<T> tClass);
}

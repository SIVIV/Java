package Library;

import java.util.*;

public class Library {
    private String name;
    private List<Book> books;
    private Map<String, Double> database;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.database = new TreeMap<>();
    }

    public String getName() {
        return this.name;
    }

    public Iterator<Book> getBooks() {
        return this.books.iterator();
    }

    public void addBook(Book book) {
        this.books.add(book);
        this.database.putIfAbsent(book.getAuthor(), 0.0);
        this.database.put(book.getAuthor(), this.database.get(book.getAuthor()) + book.getPrice());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.database.entrySet().stream()
                .sorted((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()))
                .forEach(entry -> {
                    String data = String.format("%s -> %.2f", entry.getKey(), entry.getValue());
                    sb.append(data).append(System.lineSeparator());
                });
        return sb.toString().trim();
    }
}

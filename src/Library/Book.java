package Library;

import java.util.Date;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private String releaseDate;
    private String isbnNumber;
    private Double price;

    public Book() {
    }

    public Book(String title, String author, String publisher, String releaseDate, String isbnNumber, Double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.isbnNumber = isbnNumber;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public String getIsbnNumber() {
        return this.isbnNumber;
    }

    public Double getPrice() {
        return this.price;
    }
}

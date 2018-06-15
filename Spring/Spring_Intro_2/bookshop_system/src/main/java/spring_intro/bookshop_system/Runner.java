package spring_intro.bookshop_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring_intro.bookshop_system.enums.AgeRestriction;
import spring_intro.bookshop_system.enums.EditionType;
import spring_intro.bookshop_system.models.entities.Author;
import spring_intro.bookshop_system.models.entities.Book;
import spring_intro.bookshop_system.models.entities.Category;
import spring_intro.bookshop_system.services.AuthorService;
import spring_intro.bookshop_system.services.BookService;
import spring_intro.bookshop_system.services.CategoryService;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {
    private static final String AUTHORS_RESOURCE_FILE =
            System.getProperty("user.dir") + "/src/main/resources/" + "authors.txt";
    private static final String CATEGORIES_RESOURCE_FILE =
            System.getProperty("user.dir") + "/src/main/resources/" + "categories.txt";
    private static final String BOOKS_RESOURCE_FILE =
            System.getProperty("user.dir") + "/src/main/resources/" + "books.txt";

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public Runner(AuthorService authorService,
                  CategoryService categoryService,
                  BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
//        initAuthors();
//        initCategories();
//        initBooks();
        getAllBookTitlesAfter2000();
    }

    private void initAuthors() throws IOException {
        List<String> allAuthors = Files.readAllLines(Paths.get(AUTHORS_RESOURCE_FILE));
        List<Author> authors = allAuthors.stream().map(author -> {
            String[] authorNames = author.split("\\s+");
            return new Author(authorNames[0], authorNames[1]);
        }).collect(Collectors.toList());
        this.authorService.saveAuthorToDB(authors);
    }

    private void initCategories() throws IOException {
        List<String> allCategories = Files.readAllLines(Paths.get(CATEGORIES_RESOURCE_FILE));
        List<Category> categories = allCategories
                .stream()
                .filter(category -> !category.isEmpty())
                .map(Category::new)
                .collect(Collectors.toList());
        this.categoryService.saveIntoDB(categories);
    }

    private void initBooks() throws IOException, ParseException {
        List<String> allBooks = Files.readAllLines(Paths.get(BOOKS_RESOURCE_FILE));
        List<Author> allAuthors = this.authorService.getAll();
        List<Book> books = new ArrayList<>();
        List<Category> categories = this.categoryService.getAll();

        Random random = new Random();
        for (String line : allBooks) {

            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(allAuthors.size());
            Author author = allAuthors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType.toString());
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction.toString());
            book.setTitle(title);
            book.getCategories().add(categories.get(random.nextInt(categories.size())));
            books.add(book);
        }
        this.bookService.saveToDB(books);
    }

    private void getAllBookTitlesAfter2000() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2000-01-01");
        List<String> titles = this.bookService.allTitleAfterYear(date);
        System.out.println(titles);
    }
}

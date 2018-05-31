package Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library("Citadel");

        int bookCount = Integer.parseInt(reader.readLine());

        while (bookCount-- > 0) {
            String[] input = reader.readLine().split("//s+");
            String name = input[0];
            String author = input[1];
            String publisher = input[2];
            String releaseDate = input[3];
            String isbnNumber = input[4];
            double price = Double.parseDouble(input[5]);
            Book book = new Book(name, author, publisher, releaseDate, isbnNumber, price);
            library.addBook(book);
        }

        System.out.println(library);
    }
}

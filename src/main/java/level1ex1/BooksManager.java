package level1ex1;

import java.util.ArrayList;
import java.util.List;

public class BooksManager {

    private List<Book> books;

    public BooksManager() {
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(String title, String author, int numberOfPages) {
        try {
            if (books.stream().anyMatch(b -> b.getTitle().equalsIgnoreCase(title))) {
                throw new IllegalArgumentException("This book is already on the library.");
            }
            books.add(new Book(title, author, numberOfPages));
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    public Book getBookAtIndex(int index) {
        return books.get(index);
    }

    public void addBookAtIndex(int index, String title, String author, int numberOfPages) {
        try {
            books.add(index, new Book(title, author, numberOfPages));
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    public void removeBookByTitle(String title) {
        try {
            Book book = books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);

            if (book == null) {
                throw new IllegalArgumentException("This book is not in the library.");
            }

            books.remove(book);
        } catch (IllegalArgumentException e) {
            System.out.println("Error removing book: " + e.getMessage());
        }
    }
}

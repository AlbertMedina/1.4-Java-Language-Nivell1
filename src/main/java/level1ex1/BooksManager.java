package level1ex1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BooksManager {

    private List<Book> books;

    public BooksManager() {
        books = new ArrayList<>();
    }

    public List<Book> getBooksList() {
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
            Book book = getBookByTitle(title);

            if (book == null) {
                throw new IllegalArgumentException("This book is not in the library.");
            }

            books.remove(book);
        } catch (IllegalArgumentException e) {
            System.out.println("Error removing book: " + e.getMessage());
        }
    }

    public int getBookIndex(String title) {
        try {
            Book book = getBookByTitle(title);

            if (book == null) {
                throw new IllegalArgumentException("This book is not in the library.");
            }

            return books.indexOf(book);
        } catch (IllegalArgumentException e) {
            System.out.println("Error getting book by index: " + e.getMessage());
        }

        return -1;
    }

    public void sortBooksAlphabetically() {
        books.sort(Comparator.comparing(Book::getTitle));
    }

    private Book getBookByTitle(String title) {
        return books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }
}

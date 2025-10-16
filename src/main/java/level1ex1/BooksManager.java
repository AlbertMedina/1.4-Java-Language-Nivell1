package level1ex1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BooksManager {

    private final List<Book> books;

    public BooksManager() {
        books = new ArrayList<>();
    }

    public List<Book> getBooksList() {
        return List.copyOf(books);
    }

    public void addBook(Book book) {
        if (book == null){
            throw new NullPointerException("Cannot add a null book.");
        }
        if (books.contains(book)) {
            throw new IllegalArgumentException("This book is already on the library.");
        }
        books.add(book);
    }

    public Book getBookAtIndex(int index) {
        return books.get(index);
    }

    public void addBookAtIndex(int index, Book book) {
        if (book == null){
            throw new NullPointerException("Cannot add a null book.");
        }
        if (books.contains(book)) {
            throw new IllegalArgumentException("This book is already on the library.");
        }
        books.add(index, book);
    }

    public void removeBookByTitle(String title) {
        Book book = books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
        if (book == null) {
            throw new IllegalArgumentException("This book is not in the library.");
        }
        books.remove(book);
    }

    public void sortBooksAlphabetically() {
        books.sort(Comparator.comparing(Book::getTitle));
    }
}

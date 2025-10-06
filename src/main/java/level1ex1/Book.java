package level1ex1;

import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private int numberOfPages;

    public Book(String title, String author, int numberOfPages) {

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid title");
        }

        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid author");
        }

        if (numberOfPages <= 0) {
            throw new IllegalArgumentException("Invalid number of pages");
        }

        this.title = title.trim();
        this.author = author.trim();
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return "'" + title + "', by " + author + " (" + numberOfPages + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Book otherBook = (Book) other;
        return title.equalsIgnoreCase(otherBook.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase());
    }
}

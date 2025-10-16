package level1ex1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BooksManagerTest {

    @Test
    void shouldBooksManagerNotBeNull() {
        BooksManager booksManager = new BooksManager();
        assertNotNull(booksManager);
    }

    @Test
    void shouldAddBooks() {
        BooksManager booksManager = new BooksManager();
        booksManager.addBook(new Book("Marina", "Carlos Ruiz Zafón", 304));
        booksManager.addBook(new Book("El Juego del Alma", "Javier Castillo", 528));
        booksManager.addBook(new Book("La Grieta del Silencio", "Javier Castillo", 448));
        assertEquals(3, booksManager.getBooksList().size());
    }

    @Test
    void shouldAddBookAtGivenIndex() {
        BooksManager booksManager = new BooksManager();
        booksManager.addBook(new Book("Marina", "Carlos Ruiz Zafón", 304));
        booksManager.addBook(new Book("El Juego del Alma", "Javier Castillo", 528));
        booksManager.addBookAtIndex(1, new Book("La Grieta del Silencio", "Javier Castillo", 448));
        assertEquals(1, booksManager.getBooksList().indexOf(new Book("La Grieta del Silencio", "Javier Castillo", 448)));
    }

    @Test
    void shouldNotAddMoreThanOneBookWithSameTitle() {
        BooksManager booksManager = new BooksManager();
        booksManager.addBook(new Book("Marina", "Carlos Ruiz Zafón", 304));
        assertThrows(IllegalArgumentException.class, () -> booksManager.addBook(new Book("MARINA", "Carlos Ruiz Zafón", 304)));
        assertThrows(IllegalArgumentException.class, () -> booksManager.addBook(new Book("marina", "Carlos Ruiz Zafón", 304)));
        assertEquals(1, booksManager.getBooksList().size());
    }

    @Test
    void shouldReturnCorrectBookAtGivenIndex() {
        BooksManager booksManager = new BooksManager();
        booksManager.addBook(new Book("Marina", "Carlos Ruiz Zafón", 304));
        booksManager.addBook(new Book("El Juego del Alma", "Javier Castillo", 528));
        booksManager.addBook(new Book("La Grieta del Silencio", "Javier Castillo", 448));
        assertEquals("El Juego del Alma", booksManager.getBookAtIndex(1).getTitle());
    }

    @Test
    void shouldIncreaseBookListSizeWhenBookIsAdded() {
        BooksManager booksManager = new BooksManager();
        int booksListSize = booksManager.getBooksList().size();
        booksManager.addBook(new Book("Marina", "Carlos Ruiz Zafón", 304));
        assertNotEquals(booksListSize, booksManager.getBooksList().size());
    }

    @Test
    void shouldDecreaseBookListSizeWhenBookIsAdded() {
        BooksManager booksManager = new BooksManager();
        booksManager.addBook(new Book("Marina", "Carlos Ruiz Zafón", 304));
        booksManager.addBook(new Book("El Juego del Alma", "Javier Castillo", 528));
        booksManager.addBook(new Book("La Grieta del Silencio", "Javier Castillo", 448));
        int booksListSize = booksManager.getBooksList().size();
        booksManager.removeBookByTitle("Marina");
        assertNotEquals(booksListSize, booksManager.getBooksList().size());
    }

    @Test
    void shouldOrderBooksAlphabeticallyByTitle() {
        BooksManager booksManager = new BooksManager();
        booksManager.addBook(new Book("Marina", "Carlos Ruiz Zafón", 304));
        booksManager.addBook(new Book("El Juego del Alma", "Javier Castillo", 528));
        booksManager.addBook(new Book("La Grieta del Silencio", "Javier Castillo", 448));
        booksManager.sortBooksAlphabetically();
        assertEquals(0, booksManager.getBooksList().indexOf(new Book("El Juego del Alma", "Javier Castillo", 528)));
        assertEquals(1, booksManager.getBooksList().indexOf(new Book("La Grieta del Silencio", "Javier Castillo", 448)));
        assertEquals(2, booksManager.getBooksList().indexOf(new Book("Marina", "Carlos Ruiz Zafón", 304)));
        booksManager.removeBookByTitle("La Grieta del Silencio");
        assertEquals(0, booksManager.getBooksList().indexOf(new Book("El Juego del Alma", "Javier Castillo", 528)));
        assertEquals(1, booksManager.getBooksList().indexOf(new Book("Marina", "Carlos Ruiz Zafón", 304)));
    }
}

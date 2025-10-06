package level1ex1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BooksManagerTest {

    private BooksManager booksManager;

    @Test
    void checkCreateBooksManager() {
        booksManager = new BooksManager();
        assertNotNull(booksManager);
    }

    @Test
    void checkAddBooks() {
        booksManager = new BooksManager();
        booksManager.addBook("Marina", "Carlos Ruiz Zafón", 304);
        booksManager.addBook("El Juego del Alma", "Javier Castillo", 528);
        booksManager.addBook("La Grieta del Silencio", "Javier Castillo", 448);
        assertEquals(3, booksManager.getBooksList().size());
    }

    @Test
    void checkBookIndex() {
        booksManager = new BooksManager();
        booksManager.addBook("Marina", "Carlos Ruiz Zafón", 304);
        booksManager.addBook("El Juego del Alma", "Javier Castillo", 528);
        booksManager.addBookAtIndex(1, "La Grieta del Silencio", "Javier Castillo", 448);
        assertEquals(1, booksManager.getBooksList().indexOf(new Book("La Grieta del Silencio", "Javier Castillo", 448)));
    }

    @Test
    void checkNoDuplicates() {
        booksManager = new BooksManager();
        booksManager.addBook("Marina", "Carlos Ruiz Zafón", 304);
        booksManager.addBook("MARINA", "Carlos Ruiz Zafón", 304);
        booksManager.addBook("marina", "Carlos Ruiz Zafón", 304);
        assertEquals(1, booksManager.getBooksList().size());
    }

    @Test
    void checkGetBookByIndex() {
        booksManager = new BooksManager();
        booksManager.addBook("Marina", "Carlos Ruiz Zafón", 304);
        booksManager.addBook("El Juego del Alma", "Javier Castillo", 528);
        booksManager.addBook("La Grieta del Silencio", "Javier Castillo", 448);
        assertEquals("El Juego del Alma", booksManager.getBookAtIndex(1).getTitle());
    }

    @Test
    void checkBooksAfterAdd() {
        booksManager = new BooksManager();
        int booksListSize = booksManager.getBooksList().size();
        booksManager.addBook("Marina", "Carlos Ruiz Zafón", 304);
        assertNotEquals(booksListSize, booksManager.getBooksList().size());
    }

    @Test
    void checkBooksAfterRemove() {
        booksManager = new BooksManager();
        booksManager.addBook("Marina", "Carlos Ruiz Zafón", 304);
        booksManager.addBook("El Juego del Alma", "Javier Castillo", 528);
        booksManager.addBook("La Grieta del Silencio", "Javier Castillo", 448);
        int booksListSize = booksManager.getBooksList().size();
        booksManager.removeBookByTitle("Marina");
        assertNotEquals(booksListSize, booksManager.getBooksList().size());
    }

    @Test
    void checkAlphabeticalOrder() {
        booksManager = new BooksManager();
        booksManager.addBook("Marina", "Carlos Ruiz Zafón", 304);
        booksManager.addBook("El Juego del Alma", "Javier Castillo", 528);
        booksManager.addBook("La Grieta del Silencio", "Javier Castillo", 448);
        booksManager.sortBooksAlphabetically();
        assertEquals(0, booksManager.getBooksList().indexOf(new Book("El Juego del Alma", "Javier Castillo", 528)));
        assertEquals(1, booksManager.getBooksList().indexOf(new Book("La Grieta del Silencio", "Javier Castillo", 448)));
        assertEquals(2, booksManager.getBooksList().indexOf(new Book("Marina", "Carlos Ruiz Zafón", 304)));
        booksManager.removeBookByTitle("La Grieta del Silencio");
        assertEquals(0, booksManager.getBooksList().indexOf(new Book("El Juego del Alma", "Javier Castillo", 528)));
        assertEquals(1, booksManager.getBooksList().indexOf(new Book("Marina", "Carlos Ruiz Zafón", 304)));
    }
}

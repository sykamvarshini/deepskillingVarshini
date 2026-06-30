import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        bookService = new BookService();
        bookService.addBook(new Book("1", "Effective Java", "Joshua Bloch", 45.0, true));
        bookService.addBook(new Book("2", "Clean Code", "Robert C. Martin", 50.0, true));
    }

    @Test
    public void testAssertEquals() {
        Book book = bookService.getBook("1");
        assertEquals("Effective Java", book.getTitle());
        assertEquals(45.0, book.getPrice());
    }

    @Test
    public void testAssertTrueAndFalse() {
        Book book = bookService.getBook("1");
        assertTrue(book.isAvailable());

        bookService.rentBook("1");
        assertFalse(book.isAvailable());
    }

    @Test
    public void testAssertNullAndNotNull() {
        assertNotNull(bookService.getBook("1"));
        assertNull(bookService.getBook("99"));
    }

    @Test
    public void testAssertArrayEquals() {
        String[] expectedIds = {"1", "2"};
        assertArrayEquals(expectedIds, bookService.getBookIds());
    }

    @Test
    public void testAssertThrows() {
        Book invalidBook = new Book("3", "Invalid Book", "Unknown", -10.0, true);
        assertThrows(IllegalArgumentException.class, () -> {
            bookService.addBook(invalidBook);
        });
    }

    @Test
    public void testAssertTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            bookService.getBook("2");
        });
    }
}

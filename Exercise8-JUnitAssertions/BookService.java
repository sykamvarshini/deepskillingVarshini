import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (book.getPrice() < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        for (Book b : books) {
            if (b.getId().equals(book.getId())) {
                throw new IllegalArgumentException("Book ID already exists");
            }
        }
        books.add(book);
    }

    public Book getBook(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }

    public String[] getBookIds() {
        String[] ids = new String[books.size()];
        for (int i = 0; i < books.size(); i++) {
            ids[i] = books.get(i).getId();
        }
        return ids;
    }

    public void rentBook(String id) {
        Book book = getBook(id);
        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is already rented");
        }
        book.setAvailable(false);
    }
}

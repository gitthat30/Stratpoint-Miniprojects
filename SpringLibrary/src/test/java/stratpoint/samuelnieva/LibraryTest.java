package stratpoint.samuelnieva;

import org.junit.jupiter.api.Test;
import stratpoint.samuelnieva.EntityLayer.Book;
import stratpoint.samuelnieva.EntityLayer.Novel;
import stratpoint.samuelnieva.ServiceLayer.IMPL.LibraryServiceIMPL;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void addBook() {
        List<Book> testBooks = new ArrayList<>();
        LibraryServiceIMPL testLibrary = new LibraryServiceIMPL(testBooks);
        Book testBook = new Novel("Test", "Testa", "Testp", "Testdp", "Testisbn", "Testg");


        testLibrary.addBook(testBook);

        assertTrue(testLibrary.getListBooks().contains(testBook));
    }

    @Test
    void delBook() {
        List<Book> testBooks = new ArrayList<>();
        Book testBook = new Novel("Test", "Testa", "Testp", "Testdp", "Testisbn", "Testg");
        testBooks.add(testBook);

        LibraryServiceIMPL testLibrary = new LibraryServiceIMPL(testBooks);


        testLibrary.delBook(0);

        assertFalse(testLibrary.getListBooks().contains(testBook));
    }
}
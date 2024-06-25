package stratpoint.samuelnieva;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void addBook() {
        List<Book> testBooks = new ArrayList<>();
        Library testLibrary = new Library(testBooks);
        Book testBook = new Novel("Test", "Testa", "Testp", "Testdp", "Testisbn", "Testg");


        testLibrary.addBook(testBook);

        assertTrue(testLibrary.getListBooks().contains(testBook));
    }

    @Test
    void delBook() {
        List<Book> testBooks = new ArrayList<>();
        Book testBook = new Novel("Test", "Testa", "Testp", "Testdp", "Testisbn", "Testg");
        testBooks.add(testBook);

        Library testLibrary = new Library(testBooks);


        testLibrary.delBook(0);

        assertFalse(testLibrary.getListBooks().contains(testBook));
    }
}
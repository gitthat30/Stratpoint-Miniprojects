package stratpoint.samuelnieva;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class consists of methods that operate on a list of Book objects.
 * These methods facilitate the actions of: adding books, deleting books and
 * outputting the list of books to STDOUT.
 */
public class Library {
    /**
     * These are the List objects used by the class.
     *
     * The listBooks list contains the list
     * of books the Library class contains.
     *
     * The returnedList list contains the list of books
     * returned by the searchBooks method of the library
     * class.
     */
    List<Book> listBooks = new ArrayList<>();
    List<Book> returnedList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    Logger logger = LoggerFactory.getLogger(Library.class);

    /**
     * Instantiates a new Library class using a list of Book objects as a parameter.
     *
     * @param b The list of Book objects.
     */
    Library(List<Book> b) {
        this.listBooks = b;
    }

    /**
     * Outputs the information of the Book objects with the Library class'
     * list of books. The information is outputted using the Book object's
     * outputInfo method.
     */
    public void outputBooks() {

        int counter = 1;
        for (Book b : listBooks) {
            System.out.println("\nBook " + counter + ":");
            b.outputInfo();
            counter++;
        }
    }

    /**
     * Searches for book(s) within the list of books using a search query.
     * Each Book object within the list that matches the query is added to the
     * returnedList list. The method then outputs the info of each book.
     *
     * @param query The search query to be used.
     */
    public void searchBooks(String query) {
        logger.debug("searchBooks with parameter {} has entered the initial for loop with {} books in listBooks", query, listBooks.size());
        returnedList.clear();
        logger.debug("returnedList has been cleared.");

        for(Book b : listBooks) {
            if(b.getTitle().contains(query) || b.getPublisher().contains(query) || b.getAuthor().contains(query) || b.getISBN().equals(query)) {
                returnedList.add(b);
                logger.debug("Book {} has been added to returnedList", b.getTitle());
            }

        }

        logger.debug("searchBooks has left the initial for loop with {} books in returnedList", returnedList.size());
        System.out.println("Found " + returnedList.size() + " books:");

        int counter = 1;
        for(Book b: returnedList) {
            System.out.println("Book " + counter + ":");
            b.outputInfo();
            System.out.println();
            counter++;
        }
    }

    /**
     * Adds a Book object to the list of books.
     *
     * @param b The Book object to be added.
     */
    public void addBook(Book b) {
        listBooks.add(b);
    }

    /**
     * Deletes a book from the list using a given index. The index is zero-based.
     *
     * @param index The index of the book to be deleted
     */
    public void delBook(int index) {
        listBooks.remove(index);
        logger.debug("Successfully removed book in index {} from listBooks", index);
    }

    /**
     * Gets list books.
     *
     * @return the list books
     */
    public List<Book> getListBooks() {
        return listBooks;
    }

    /**
     * Sets list books.
     *
     * @param listBooks the list books
     */
    public void setListBooks(List<Book> listBooks) {
        this.listBooks = listBooks;
    }
}

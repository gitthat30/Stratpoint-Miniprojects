package stratpoint.samuelnieva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Main class that facilitates the use of the Book object and
 * its subclasses: Biography, Novel and Manga, along with the
 * Library class.
 */
public class Main {

    /**
     * The Sc.
     */
    static Scanner sc = new Scanner(System.in);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.debug("Start of main method:");

        Scanner sc = new Scanner(System.in);

        List<Book> books = new ArrayList<>();
        Library l = new Library(books);

        Main.addSampleBooks(l);

        try {
            while(true) {
                System.out.println("Pick an action: ");
                System.out.println("1 - List all books");
                System.out.println("2 - Search for a book");
                System.out.println("3 - Add a book");
                System.out.println("4 - Delete a book\n");

                System.out.println("Choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        l.outputBooks();
                        break;
                    case 2:
                        System.out.println("\nEnter search query:");

                        String query = sc.next();
                        System.out.println();

                        l.searchBooks(query);
                        break;

                    case 3:
                        System.out.println("\nSelect type of book to add:");
                        System.out.println("1 - Novel");
                        System.out.println("2 - Biography");
                        System.out.println("3 - Manga\n");
                        System.out.println("Choice: ");

                        int choice3 = sc.nextInt();

                        switch(choice3) {
                            case 1:
                                l.addBook(Main.parseNovel());
                                break;

                            case 2:
                                l.addBook(Main.parseBiography());
                                break;

                            case 3:
                                l.addBook(Main.parseManga());
                                break;

                            default:
                                throw new Exception();
                        }

                        break;

                    case 4:
                        l.outputBooks();

                        l.delBook(Main.parseDeleteBook(l.getListBooks().size()));
                        break;

                    default:
                        throw new Exception();
                }

                System.out.println();
            }
        }
        catch(Exception e) {
            sc.next();
            System.out.println("Invalid input. Please try again\n");
        }

    }

    /**
     * This method generates sample data for the given Library object
     * @param l Library object to be added sample data to
     */
    public static void addSampleBooks(Library l) {
        //Test Data
        l.addBook(new Manga("One Piece", "Eiichiro Oda", "VIZ Media LLC", "September 2, 2003", "978-1569319017", "Eiichiro Oda", "1", "Adventure"));
        l.addBook(new Manga("Death Note", "Tsugumi Ohba", "VIZ Media LLC", "October 10, 2005", "978-1421501680", "Takeshi Obata", "1", "Mystery"));
        l.addBook(new Biography("Steve Jobs: A Biography (Greenwood Biographies)", "Michael B. Becraft", "Greenwood", "November 21, 2016", "978-1610694964", "Steve Jobs"));
        l.addBook(new Biography("Alexander Hamilton", "Ron Chernow", "Penguin Books", "March 29, 2005", "978-0143034759", "Alexander Hamilton"));
        l.addBook(new Novel("Don Quixote", " Miguel De Cervantes Saavedra", "Penguin Classics", "February 25, 2003", "978-0142437230", "Satire"));
        l.addBook(new Manga("Naruto", "Masashi Kishimoto", "VIZ Media LLC", "August 6, 2003", "978-1569319000", "Masashi Kishimoto", "1", "Action"));
        l.addBook(new Manga("Attack on Titan", "Hajime Isayama", "Kodansha Comics", "March 17, 2010", "978-1612620244", "Hajime Isayama", "1", "Fantasy"));
        l.addBook(new Biography("Becoming", "Michelle Obama", "Crown Publishing Group", "November 13, 2018", "978-1524763138", "Michelle Obama"));
        l.addBook(new Biography("Leonardo da Vinci", "Walter Isaacson", "Simon & Schuster", "October 17, 2017", "978-1501139154", "Leonardo da Vinci"));
        l.addBook(new Novel("1984", "George Orwell", "Signet Classics", "July 1, 1950", "978-0451524935", "Dystopian fiction"));
        l.addBook(new Manga("My Hero Academia", "Kohei Horikoshi", "VIZ Media LLC", "November 4, 2014", "978-1421582696", "Kohei Horikoshi", "1", "Superhero"));
        l.addBook(new Manga("Tokyo Ghoul", "Sui Ishida", "VIZ Media LLC", "June 16, 2015", "978-1421580364", "Sui Ishida", "1", "Horror"));
        l.addBook(new Biography("Elon Musk: Tesla, SpaceX, and the Quest for a Fantastic Future", "Ashlee Vance", "Ecco", "May 19, 2015", "978-0062301239", "Elon Musk"));
        l.addBook(new Biography("The Diary of a Young Girl", "Anne Frank", "Bantam", "June 1, 1993", "978-0553296983", "Anne Frank"));
        l.addBook(new Novel("Pride and Prejudice", "Jane Austen", "Penguin Classics", "December 31, 2002", "978-0141439518", "Romance"));
    }

    /**
     * Parses user input to create a Biography object.
     *
     * @return The Biography object created from the user input.
     */
    public static Biography parseBiography() {
        System.out.println("Enter title: ");
        String t = sc.next();

        System.out.println("Enter author: ");
        String a = sc.next();

        System.out.println("Enter publisher: ");
        String p = sc.next();

        System.out.println("Enter date published: ");
        String dp = sc.next();

        System.out.println("Enter ISBN: ");
        String isbn = sc.next();

        System.out.println("Enter subject:");
        String s = sc.next();

        return new Biography(t, a, p, dp, isbn, s);
    }

    /**
     * Parses user input to create a Novel object.
     *
     * @return The Novel object created from the user input.
     */
    public static Novel parseNovel() {
        System.out.println("Enter title: ");
        String t = sc.next();

        System.out.println("Enter author: ");
        String a = sc.next();

        System.out.println("Enter publisher: ");
        String p = sc.next();

        System.out.println("Enter date published: ");
        String dp = sc.next();

        System.out.println("Enter ISBN: ");
        String isbn = sc.next();

        System.out.println("Enter genre:");
        String g = sc.next();

        return new Novel(t, a, p, dp, isbn, g);
    }

    /**
     * Parses user input to create a Manga object.
     *
     * @return The Manga object created from the user input.
     */
    public static Manga parseManga() {
        System.out.println("Enter title: ");
        String t = sc.next();

        System.out.println("Enter author: ");
        String a = sc.next();

        System.out.println("Enter publisher: ");
        String p = sc.next();

        System.out.println("Enter date published: ");
        String dp = sc.next();

        System.out.println("Enter ISBN: ");
        String isbn = sc.next();

        System.out.println("Enter illustrator: ");
        String i = sc.next();

        System.out.println("Enter volume: ");
        String v = sc.next();

        System.out.println("Enter genre: ");
        String g = sc.next();

        return new Manga(t, a, p, dp, isbn, i, v, g);
    }

    /**
     * Parses user input for an index representing a book to delete from a
     * Library object's list of books.
     *
     * @param size The size of the Library's list of books
     * @return The index of the book to be removed
     */
    public static int parseDeleteBook(int size) {
        int choice = -1;
        while(choice < 1 || choice > size) {
            try {
                System.out.print("\nPlease select book to delete (Enter Number): ");
                choice = sc.nextInt();
            }
            catch(Exception e) {
                sc.next();
            }

            if(choice < 1 || choice > size)
                System.out.println("Invalid Input: Please select from one of the choices");
        }

        return choice-1;
    }
}

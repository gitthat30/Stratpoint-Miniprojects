package stratpoint.samuelnieva;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manga test1 = new Manga("One Piece", "Eiichiro Oda", "VIZ Media LLC", "September 2, 2003", "978-1569319017", "Eiichiro Oda", "1", "Adventure");
        Manga test2 = new Manga("Death Note", "Tsugumi Ohba", "VIZ Media LLC", "October 10, 2005", "978-1421501680", "Takeshi Obata", "1", "Mystery");

        Biography test3 = new Biography("Steve Jobs: A Biography (Greenwood Biographies)", "Michael B. Becraft", "Greenwood", "November 21, 2016", "978-1610694964", "Steve Jobs");
        Biography test4 = new Biography("Alexander Hamilton", "Ron Chernow", "Penguin Books", "March 29, 2005", "978-0143034759", "Alexander Hamilton");

        Novel test5 = new Novel("Don Quixote", " Miguel De Cervantes Saavedra", "Penguin Classics", "February 25, 2003", "978-0142437230", "Satire");

        Manga test6 = new Manga("Death Note2", "Tsugumi Ohba", "VIZ Media LLC", "October 10, 2005", "978-1421501680", "Takeshi Obata", "1", "Mystery");

        Scanner sc = new Scanner(System.in);

        List<Book> books = new ArrayList<>();

        books.add(test1);
        books.add(test2);
        books.add(test3);
        books.add(test4);
        books.add(test5);

        Library l = new Library(books);

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
                        System.out.println("\nSearch for book using:");
                        System.out.println("1 - Title");
                        System.out.println("2 - Author");
                        System.out.println("3 - Publisher");
                        System.out.println("4 - ISBN\n");
                        System.out.println("Choice: ");

                        int choice2 = sc.nextInt();

                        System.out.println("Enter search query: ");

                        String query = sc.next();
                        System.out.println();

                        switch(choice2) {
                            case 1:
                                l.searchBooks(query, "t");
                                break;

                            case 2:
                                l.searchBooks(query, "a");
                                break;

                            case 3:
                                l.searchBooks(query, "p");
                                break;

                            case 4:
                                l.searchBooks(query, "i");
                                break;
                        }
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
                                l.addNovel();
                                break;

                            case 2:
                                l.addBiography();
                                break;

                            case 3:
                                l.addManga();
                                break;

                            default:
                                throw new Exception();
                        }

                        break;

                    case 4:
                        l.delBook();
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
}

package stratpoint.samuelnieva;

import java.util.*;

public class Library {
    List<Book> listBooks = new ArrayList<>();
    List<Book> returnedList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    Library(List<Book> b) {
        this.listBooks = b;
    }

    public void outputBooks() {
        int counter = 1;
        for (Book b : listBooks) {
            System.out.println("\nBook " + counter + ":");
            b.outputInfo();
            counter++;
        }
    }

    public void outputNumBooks() {
        System.out.println(listBooks.size());
    }

    public void searchBooks(String query, String type) {
        returnedList.clear();

        switch(type) {
            case "t":
                for (Book b: listBooks) {
                    if(b.getTitle().contains(query)) {
                        returnedList.add(b);
                    }
                }
                break;

            case "a":
                for (Book b: listBooks) {
                    if(b.getAuthor().contains(query)) {
                        returnedList.add(b);
                    }
                }
                break;

            case "p":
                for (Book b: listBooks) {
                    if(b.getPublisher().contains(query)) {
                        returnedList.add(b);
                    }
                }

            case "i":
                for (Book b: listBooks) {
                    if(b.getISBN().contains(query)) {
                        returnedList.add(b);
                    }
                }
        }

        System.out.println("Found " + returnedList.size() + " books:");

        int counter = 1;
        for(Book b: returnedList) {
            System.out.println("Book " + counter + ":");
            b.outputInfo();
            System.out.println();
            counter++;
        }
    }

    public void addBiography() {
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

        listBooks.add(new Biography(t, a, p, dp, isbn, s));
    }

    public void addNovel() {
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

        listBooks.add(new Novel(t, a, p, dp, isbn, g));
    }

    public void addManga() {
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

        listBooks.add(new Manga(t, a, p, dp, isbn, i, v, g));

    }

    public void delBook() {
        this.outputBooks();

        int choice = -1;
        while(choice < 1 || choice > listBooks.size()) {
            try {
                System.out.print("\nPlease select book to delete (Enter Number): ");
                choice = sc.nextInt();
            }
            catch(Exception e) {
                sc.next();
            }

            if(choice < 1 || choice > listBooks.size())
                System.out.println("Invalid Input: Please select from one of the choices");
        }

        listBooks.remove(choice - 1);



    }

    public List<Book> getListBooks() {
        return listBooks;
    }

    public void setListBooks(List<Book> listBooks) {
        this.listBooks = listBooks;
    }
}

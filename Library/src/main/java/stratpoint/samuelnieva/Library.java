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
        String t = sc.nextLine();
        String a = sc.nextLine();
        String p = sc.nextLine();
        String dp = sc.nextLine();
        String isbn = sc.nextLine();
        String s = sc.nextLine();

        listBooks.add(new Biography(t, a, p, dp, isbn, s));
    }

    public void addNovel() {
        String t = sc.nextLine();
        String a = sc.nextLine();
        String p = sc.nextLine();
        String dp = sc.nextLine();
        String isbn = sc.nextLine();
        String g = sc.nextLine();

        listBooks.add(new Novel(t, a, p, dp, isbn, g));
    }

    public void addManga() {
        String t = sc.nextLine();
        String a = sc.nextLine();
        String p = sc.nextLine();
        String dp = sc.nextLine();
        String isbn = sc.nextLine();
        String i = sc.nextLine();
        String v = sc.nextLine();
        String g = sc.nextLine();

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

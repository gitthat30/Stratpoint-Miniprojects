package stratpoint.samuelnieva;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private String datePublished;
    private String ISBN;

    Book(String t, String a, String p, String dp, String isbn) {
        this.title = t;
        this.author = a;
        this.publisher = p;
        this.datePublished = dp;
        this.ISBN = isbn;
    }

    public void outputInfo() {
        System.out.println("Title: " + this.getTitle());
        System.out.println("Author: " + this.getAuthor());
        System.out.println("Publisher: " + this.getPublisher());
        System.out.println("Date Published: " + this.getDatePublished());
        System.out.println("ISBN: " + this.getISBN());

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }



}

package stratpoint.samuelnieva.EntityLayer;

/**
 * The Book class. This is the template for the Book subclasses: Biography,
 * Novel and Manga. It contains the attributes common to all three, as
 * well as the template for the outputInfo method which displays the
 * information of the Book through STDOUT.
 */
public class Book {
    private String title;
    private String author;
    private String publisher;
    private String datePublished;
    private String ISBN;

    /**
     * The constructor for the Book class. All the parameters must be of
     * type String.
     *
     * @param t    The title of the book
     * @param a    The author of the book
     * @param p    The publisher of the book
     * @param dp   The date the book was published
     * @param isbn The ISBN of the book
     */
    public Book(String t, String a, String p, String dp, String isbn) {
        this.title = t;
        this.author = a;
        this.publisher = p;
        this.datePublished = dp;
        this.ISBN = isbn;
    }

    /**
     * The method that prints the information of the Book to STDOUT.
     */
    public void outputInfo() {
        System.out.print("Title: " + this.getTitle());
        System.out.print(" | Author: " + this.getAuthor());
        System.out.print(" | Publisher: " + this.getPublisher());
        System.out.print(" | Date Published: " + this.getDatePublished());
        System.out.print(" | ISBN: " + this.getISBN());

    }


    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets publisher.
     *
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets publisher.
     *
     * @param publisher the publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets date published.
     *
     * @return the date published
     */
    public String getDatePublished() {
        return datePublished;
    }

    /**
     * Sets date published.
     *
     * @param datePublished the date published
     */
    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    /**
     * Gets isbn.
     *
     * @return the isbn
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Sets isbn.
     *
     * @param ISBN the isbn
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }



}

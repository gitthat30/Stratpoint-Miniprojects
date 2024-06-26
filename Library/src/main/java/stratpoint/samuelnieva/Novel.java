package stratpoint.samuelnieva;

/**
 * The Novel subclass. The unique attributes of this subclass is the genre of the Novel.
 */
public class Novel extends Book {
    private String genre;

    /**
     * The constructor of the Novel subclass. It calls the superclass', Book, constructor
     * first. Then, it assigns the genre using the given value from the parameter.
     *
     * @param t    The title of the Novel
     * @param a    The author of the Novel
     * @param p    The publisher of the Novel
     * @param dp   The date the Novel was published
     * @param isbn The ISBN of the Novel
     * @param g    The genre of the Novel
     */
    public Novel(String t, String a, String p, String dp, String isbn, String g) {
        super(t, a, p, dp, isbn);
        this.genre = g;
    }

    @Override
    public void outputInfo() {
        super.outputInfo();
        System.out.println(" | Genre: " + this.getGenre());
    }

    /**
     * Gets genre.
     *
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets genre.
     *
     * @param genre the genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
}

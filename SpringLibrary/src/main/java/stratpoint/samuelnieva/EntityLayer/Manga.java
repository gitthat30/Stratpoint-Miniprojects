package stratpoint.samuelnieva.EntityLayer;

/**
 * This subclass represent Manga books. The unique attributes for this subclass
 * are the illustrator of the book, the genre and the volume of the Manga.
 */
public class Manga extends Book {
    String illustrator;
    String volume;
    String genre;

    /**
     * The constructor of the class. First, the constructor of the superclass,
     * Book, is called, before it takes in the illustrator, volume and genre
     * and assigns it to the Manga's attributes.
     *
     * @param t    The title of the manga
     * @param a    The author of the manga
     * @param p    The publisher of the manga
     * @param dp   The date the manga was published
     * @param isbn The ISBN of the manga
     * @param i    The illustrator of the manga
     * @param v    The volume of the manga
     * @param g    The genre of the manga
     */
    public Manga(String t, String a, String p ,String dp, String isbn, String i, String v, String g) {
        super(t, a, p, dp, isbn);
        this.illustrator = i;
        this.volume = v;
        this.genre = g;
    }

    @Override
    public void outputInfo() {
        super.outputInfo();
        System.out.print(" | Illustrator: " + this.getIllustrator());
        System.out.print(" | Volume Number(s): " + this.getVolume());
        System.out.println(" | Genre: " + this.getGenre());
    }

    /**
     * Gets illustrator.
     *
     * @return the illustrator
     */
    public String getIllustrator() {
        return illustrator;
    }

    /**
     * Sets illustrator.
     *
     * @param illustrator the illustrator
     */
    public void setIllustrator(String illustrator) {
        this.illustrator = illustrator;
    }

    /**
     * Gets volume.
     *
     * @return the volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * Sets volume.
     *
     * @param volume the volume
     */
    public void setVolume(String volume) {
        this.volume = volume;
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

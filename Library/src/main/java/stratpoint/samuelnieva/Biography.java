package stratpoint.samuelnieva;

/**
 * The Biography class which extends the Book class. This class is meant to represent
 * Biography books that are meant to document the life of a person. Unique to this
 * subclass is the subject attribute.
 */
public class Biography extends Book {
    private String subject;

    /**
     * The constructor for the class. It calls on the superclasses constructor to
     * set the common attributes for a Book object. Then, it sets the subject
     * attribute.
     *
     * @param t    The title of the biography
     * @param a    The author of the biography
     * @param p    The publisher of the biography
     * @param dp   The date the biography was published
     * @param isbn The ISBN of the biography
     * @param s    The subject of the biography
     */
    Biography(String t, String a, String p, String dp, String isbn, String s) {
        super(t, a, p, dp, isbn);
        this.subject = s;
    }

    @Override
    public void outputInfo() {
        super.outputInfo();
        System.out.println(" | Subject: " + this.getSubject());
    }

    /**
     * Gets subject.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
}

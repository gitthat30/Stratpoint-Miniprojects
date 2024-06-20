package stratpoint.samuelnieva;

public class Novel extends Book {
    private String genre;

    public Novel(String t, String a, String p, String dp, String isbn, String g) {
        super(t, a, p, dp, isbn);
        this.genre = g;
    }

    @Override
    public void outputInfo() {
        super.outputInfo();
        System.out.println("Genre: " + this.getGenre());
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

package stratpoint.samuelnieva;

public class Manga extends Book {
    String illustrator;
    String volume;
    String genre;

    Manga(String t, String a, String p ,String dp, String isbn, String i, String v, String g) {
        super(t, a, p, dp, isbn);
        this.illustrator = i;
        this.volume = v;
        this.genre = g;
    }

    @Override
    public void outputInfo() {
        super.outputInfo();
        System.out.println("Illustrator: " + this.getIllustrator());
        System.out.println("Volume Number(s): " + this.getVolume());
        System.out.println("Genre: " + this.getGenre());
    }

    public String getIllustrator() {
        return illustrator;
    }

    public void setIllustrator(String illustrator) {
        this.illustrator = illustrator;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

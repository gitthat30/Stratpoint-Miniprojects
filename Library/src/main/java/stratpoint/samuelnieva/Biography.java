package stratpoint.samuelnieva;

public class Biography extends Book {
    private String subject;

    Biography(String t, String a, String p, String dp, String isbn, String s) {
        super(t, a, p, dp, isbn);
        this.subject = s;
    }

    @Override
    public void outputInfo() {
        super.outputInfo();
        System.out.println("Subject: " + this.getSubject());
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

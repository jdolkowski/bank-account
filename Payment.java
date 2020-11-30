import java.util.Date;

public class Payment {
    private final String title;
    private final Date date;
    private final float amount;
    private final String from;
    private final String to;

    public Payment(String title, Date date, float amount, String from, String to){
        this.title = title;
        this.date = date;
        this.amount = amount;
        this.from = from;
        this.to = to;
    }
    public Payment(){
        this("untitled", null, 0, "", "" );
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
    public void printPayment(){
        System.out.println("From: " + getFrom() + " To: " + getTo() + " Amount: " + getAmount() + " Date: " + getDate());
    }
}

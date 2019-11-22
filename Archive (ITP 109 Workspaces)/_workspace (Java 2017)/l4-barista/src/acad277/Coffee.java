package acad277;

/**
 * Created by R on 2/1/2017.
 */
public class Coffee {
    public static final String ORDERED = "ordered";
    public static final String COMPLETED = "completed";

    private String size;
    private String desc;
    private String customer;
    private String status;

    public Coffee(String size, String desc, String customer) {
        this.size = size;
        this.desc = desc;
        this.customer = customer;
        this.status = ORDERED;
    }

    public void setCompleted() {
        this.status = COMPLETED;
    }

    public String getInfo() {
        String msg = size + " " + desc + " for " + customer + " (" + status + ")";
        return msg;
    }
}

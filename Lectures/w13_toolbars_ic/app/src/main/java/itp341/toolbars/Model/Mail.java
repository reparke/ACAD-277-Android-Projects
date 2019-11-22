package itp341.toolbars.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Mail implements Serializable {
    private String sender;
    private String title;
    private String message;

    private boolean isRead;

    public Mail(String sender, String title, String message) {
        this.sender = sender;
        this.title = title;
        this.message = message;
        this.isRead = false;
    }

    public String getSender() {
        return sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

}

import java.time.LocalDateTime;

public class Message {
    private String text;
    private String sender;
    private LocalDateTime timestamp;

    public Message(String text, String sender) {
        this.text = text;
        this.sender = sender;
        this.timestamp = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

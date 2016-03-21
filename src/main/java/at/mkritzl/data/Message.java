package at.mkritzl.data;

public class Message {
    private int status;
    private String message;

    public Message(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private Message() {

    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

package at.mkritzl.dezsys09.data;

/**
 * Diese Klasse stellt die Antwort des Servers dar.
 *
 * @author Martin Kritzl
 * @version 20160321
 */
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

package at.mkritzl.dezsys09.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Diese Klasse stellt den Account eines Benutzers dar. Dieser hat sowohl eine
 * identifizierende E-Mail, als auch ein Passwort.
 *
 * @author Martin Kritzl
 * @version 20160321
 */
@Entity
public class UserAccount implements Serializable {

    @Id
    @Size(max = 50)
    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min=5, max = 50)
    private String password;

    /**
     * Erstellt einen neuen Benutzer mit den angegebenen Parametern. Dieser Konstruktor
     * wird fuer die deserialisierung von Client-Anfagen verwendet.
     *
     * @param email Eindeutige E-Mail des Benutzers
     * @param password Passwort des Benutzers
     */
    public UserAccount(@JsonProperty("email") String email, @JsonProperty("password") String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Wird benoetigt um das Objekt mittels refection zu erstellen
     */
    protected UserAccount() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

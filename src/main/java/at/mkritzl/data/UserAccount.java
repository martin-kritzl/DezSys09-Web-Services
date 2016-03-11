package at.mkritzl.data;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class UserAccount implements Serializable {

    @Id
    @Size(max = 100)
    private String email;

    @Size(max = 100)
    private String username;

    @NotEmpty
    private String password;

    public UserAccount(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    protected UserAccount() {
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

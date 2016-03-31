package at.mkritzl.dezsys09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Diese Klasse ist fuer den Start der Spring Boot Applikation zustaendig.
 *
 * @author Martin Kritzl
 * @version 20160331
 */
@SpringBootApplication
public class Application {

    /**
     * Startet eine neue Spring Boot Applikation
     *
     * @param args Argumente der Spring Applikation (keine notwendig)
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
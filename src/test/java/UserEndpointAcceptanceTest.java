import at.mkritzl.Application;
import at.mkritzl.data.Message;
import at.mkritzl.data.UserAccount;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.junit.Before;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * Created by mkritzl on 18.03.2016.
 */
public class UserEndpointAcceptanceTest {

    private RestTemplate restTemplate;

    public UserEndpointAcceptanceTest() {
        this.restTemplate = new RestTemplate();
    }

    @Before
    public void setUp() {
        String[] args = {"--spring.profiles.active=test"};
        Application.main(args);
    }

    @Test
    public void testRegisterSuccess() {
        UserAccount user = new UserAccount("max.mustermann@beispiel.com", "1234");
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatusCode().value());
    }
}

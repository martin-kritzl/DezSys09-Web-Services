package at.mkritzl.dezsys09;

import at.mkritzl.dezsys09.Application;
import at.mkritzl.dezsys09.data.Message;
import at.mkritzl.dezsys09.data.UserAccount;
import org.junit.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

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

    @BeforeClass
    public static void setUp() {
        String[] args = {"--spring.profiles.active=test"};
        Application.main(args);
    }

    @Test
    public void testRegisterSuccess() {
        UserAccount user = new UserAccount("max.mustermann1@beispiel.com", "12345");
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatusCode().value());
    }

    @Test(expected=HttpClientErrorException.class)
    public void testRegsiterAlreadyPresentUser() {
        UserAccount user1 = new UserAccount("max.mustermann2@beispiel.com", "12345");
        ResponseEntity response1 = restTemplate.postForEntity("http://127.0.0.1:8080/register", user1, Message.class);
        UserAccount user2 = new UserAccount("max.mustermann2@beispiel.com", "12345");
        ResponseEntity response2 = restTemplate.postForEntity("http://127.0.0.1:8080/register", user2, Message.class);
    }

    @Test(expected=HttpClientErrorException.class)
    public void testRegisterEmptyPassword() {
        UserAccount user = new UserAccount("max.mustermann4@beispiel.com", null);
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
    }

    @Test(expected=HttpClientErrorException.class)
     public void testRegisterEmptyEmail() {
        UserAccount user = new UserAccount(null, "12345");
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
    }

    @Test(expected=HttpClientErrorException.class)
    public void testRegisterEmptyEmailAndPassword() {
        UserAccount user = new UserAccount(null, null);
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
    }

    @Test(expected=HttpClientErrorException.class)
    public void testRegisterInvalidEmail1() {
        UserAccount user = new UserAccount("noEmail", "12345");
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
    }

    @Test(expected=HttpClientErrorException.class)
    public void testRegisterInvalidEmail2() {
        UserAccount user = new UserAccount("", "12345");
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
    }

    @Test(expected=HttpClientErrorException.class)
    public void testRegisterToLongEmail() {
        UserAccount user = new UserAccount("abcdefghijkl.mnopqrstuvwxyz@abcdefghijklmnopqrstuvw.xyz", "12345");
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
    }

    @Test(expected=HttpClientErrorException.class)
    public void testRegisterToLongPassword() {
        UserAccount user = new UserAccount("max.mustermann5@beispiel.com", "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
    }

    @Test(expected=HttpClientErrorException.class)
    public void testRegisterInvalidPassword() {
        UserAccount user = new UserAccount("max.mustermann6@beispiel.com", "");
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
    }

    @Test(expected=HttpClientErrorException.class)
    public void testRegisterToShortPassword() {
        UserAccount user = new UserAccount("max.mustermann7@beispiel.com", "1234");
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
    }

    @Test
    public void testLoginSuccess() {
        UserAccount user = new UserAccount("max.mustermann8@beispiel.com", "12345");
        ResponseEntity responseRegistration = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
        assertEquals(Response.Status.CREATED.getStatusCode(), responseRegistration.getStatusCode().value());
        ResponseEntity responseLogin = restTemplate.postForEntity("http://127.0.0.1:8080/login", user, Message.class);
        assertEquals(Response.Status.OK.getStatusCode(), responseLogin.getStatusCode().value());
    }

    @Test(expected=HttpClientErrorException.class)
    public void testLoginEmptyPassword() {
        UserAccount user1 = new UserAccount("max.mustermann9@beispiel.com", "12345");
        UserAccount user2 = new UserAccount("max.mustermann9@beispiel.com", null);
        restTemplate.postForEntity("http://127.0.0.1:8080/register", user1, Message.class);
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user2, Message.class);
    }

    @Test(expected=HttpClientErrorException.class)
    public void testLoginEmptyEmail() {
        UserAccount user = new UserAccount(null, "12345");
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
    }

    @Test(expected=HttpClientErrorException.class)
    public void testLoginEmptyEmailAndPassword() {
        UserAccount user = new UserAccount(null, null);
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
    }

    @Test(expected=HttpClientErrorException.class)
    public void testLoginInvalidEmail1() {
        UserAccount user = new UserAccount("noEmail", "12345");
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
    }

    @Test(expected=HttpClientErrorException.class)
    public void testLoginInvalidEmail2() {
        UserAccount user = new UserAccount("", "12345");
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
    }

    @Test(expected=HttpClientErrorException.class)
    public void testLoginInvalidPassword() {
        UserAccount user1 = new UserAccount("max.mustermann10@beispiel.com", "12345");
        UserAccount user2 = new UserAccount("max.mustermann10@beispiel.com", "");
        restTemplate.postForEntity("http://127.0.0.1:8080/register", user1, Message.class);
        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user2, Message.class);
    }

//    @Test
//    public void testRegisterFalseObject() {
//        String user = "That is no UserAccount";
//        ResponseEntity response = restTemplate.postForEntity("http://127.0.0.1:8080/register", user, Message.class);
//    }


}

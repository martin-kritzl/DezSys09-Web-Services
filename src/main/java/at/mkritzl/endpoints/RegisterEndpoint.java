package at.mkritzl.endpoints;

import at.mkritzl.data.Message;
import at.mkritzl.data.UserAccount;
import at.mkritzl.persistent.UserRepository;
import at.mkritzl.utils.UserAccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Named;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces({MediaType.APPLICATION_JSON})
@Named
public class RegisterEndpoint {

    @Autowired
    private UserRepository repository;

    @POST
    @Path("/register")
    public Response register(UserAccount requestAccount) {
        //User ist nicht bereits vorhanden
        if (UserAccountValidator.hasData(requestAccount)) {
            if (this.repository.findOne(requestAccount.getEmail()) == null) {
                //Anlegen des neuen Benutzers
                UserAccount account = new UserAccount(requestAccount.getEmail(), requestAccount.getPassword());
                this.repository.save(account);
                //Erfolgreiche Response schicken
                int status = Response.Status.CREATED.getStatusCode();
                return Response.status(status).entity(new Message(status, "Created account with the E-Mail " + account.getEmail())).build();
            } else {
                int status = Response.Status.FORBIDDEN.getStatusCode();
                return Response.status(status).entity(new Message(status, "An account already registered with this E-Mail")).build();
            }
        } else {
            int status = Response.Status.BAD_REQUEST.getStatusCode();
            return Response.status(status).entity(new Message(status, "Missing account argument or a required field was not set")).build();
        }
    }
}

package at.mkritzl.endpoints;

import at.mkritzl.data.UserAccount;
import at.mkritzl.persistent.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Named
@Path("/register")
@Produces({MediaType.APPLICATION_JSON})
public class RegisterEndpoint {

    @Inject
    private UserRepository repository;

    @POST
    public Response register(UserAccount requestAccount) {
        return Response.status(Response.Status.OK.getStatusCode()).build();
    }
}

package at.mkritzl.utils;

import at.mkritzl.endpoints.LoginEndpoint;
import at.mkritzl.endpoints.RegisterEndpoint;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Named;

@Named
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
//        this.register(LoginEndpoint.class);
        this.register(RegisterEndpoint.class);
//        this.register(AccountEndpoint.class);
        this.register(JacksonFeature.class);
    }
}
package at.mkritzl.config;

import at.mkritzl.endpoints.LoginEndpoint;
import at.mkritzl.endpoints.RegisterEndpoint;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
//        this.register(LoginEndpoint.class);
        this.register(RegisterEndpoint.class);
//        this.register(AccountEndpoint.class);
        this.register(JacksonFeature.class);
    }
}
package at.mkritzl.dezsys09.config;

import at.mkritzl.dezsys09.endpoints.UserEndpoint;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        this.register(UserEndpoint.class);
        this.register(JacksonFeature.class);
    }
}
package at.mkritzl.dezsys09.config;

import at.mkritzl.dezsys09.endpoints.UserEndpoint;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Diese Klasse registriert die erstellten Endpoints bei Jersey
 *
 * @author Martin Kritzl
 * @version 20160321
 */
@Configuration
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        this.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        this.register(UserEndpoint.class);
    }
}
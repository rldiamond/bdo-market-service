package twich.bdo.market.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twich.bdo.market.common.Service;
import twich.bdo.market.common.ServiceInitializationException;
import twich.bdo.market.common.ServiceShutdownException;
import twich.bdo.market.rest.RestService;

import javax.security.auth.login.Configuration;


/**
 * Main entrypoint class for the API application. Called from Docker entry script.
 */
public class ServiceApplication implements Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceApplication.class);

    public static void main(String[] args) throws Exception {
        ServiceApplication application = new ServiceApplication();

        try {
            application.initialize();
        } catch (ServiceInitializationException ex) {
            LOGGER.error("Failed to start the market service!", ex);
            try {
                application.shutdown();
            } catch (ServiceShutdownException e) {
                LOGGER.error("Failed to shutdown the market service!", e);
                throw new RuntimeException(e);
            }
            throw new RuntimeException(ex);
        }


    }

    private RestService myRestService;

    public ServiceApplication() {

    }

    @Override
    public void initialize() throws ServiceInitializationException {
        LOGGER.info("Initializing the Black Desert Market Service...");

        // Load configuration
        Configuration.getConfiguration();

        // Start item caching service
        // TODO: to be implemented in the future.

        // Start REST service
        myRestService = new RestService();
        myRestService.initialize();
    }

    @Override
    public void shutdown() throws ServiceShutdownException {
        LOGGER.info("Shutting down the Black Desert Market Service...");

        myRestService.shutdown();
        myRestService = null;

        LOGGER.info("Shutdown complete!");

    }
}

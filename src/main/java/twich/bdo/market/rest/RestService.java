package twich.bdo.market.rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twich.bdo.market.common.Configuration;
import twich.bdo.market.common.Service;
import twich.bdo.market.common.ServiceInitializationException;
import twich.bdo.market.common.ServiceShutdownException;


public class RestService implements Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestService.class);

    private Server myServer;
    private static final String PATH_SPEC = "/api/bdo/*";

    @Override
    public void initialize() throws ServiceInitializationException {
        LOGGER.info("Initializing the REST Service...");

        // Retrieve the port to run on from Configuration.
        final int port = Configuration.getConfiguration().getRestPort();

        // Setup the JETTY server
        myServer = new Server(port);

        final ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        contextHandler.setContextPath("/");
        myServer.setHandler(contextHandler);

        final ServletHolder servletHolder = contextHandler.addServlet(ServletContainer.class, PATH_SPEC);
        servletHolder.setInitOrder(0);
        servletHolder.setInitParameter(
                "jersey.config.server.provider.packages",
                "twich.bdo.market.rest.resources"
        );

        try {
            myServer.start();
            myServer.join();
        } catch (Exception ex) {
            throw new ServiceInitializationException("Failed to start the REST service!", ex);
        } finally {
            try {
                shutdown();
            } catch (ServiceShutdownException ex) {
                LOGGER.error("Failed to shutdown the REST service.", ex);
                throw new ServiceInitializationException("Failed to start the REST service!", ex);
            }
        }

    }

    @Override
    public void shutdown() throws ServiceShutdownException {
        LOGGER.info("Shutting down the REST service...");
        if (myServer != null) {
            try {
                myServer.destroy();
            } catch (Exception ex) {
                throw new ServiceShutdownException("Failed to destroy the Jetty server.", ex);
            }
            myServer = null;
        }
        LOGGER.info("REST service shutdown complete.");
    }
}

package twich.bdo.market.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configuration class hold configurable variables for use in the application.
 */
public class Configuration {

    private static final Logger LOGGER = LoggerFactory.getLogger(Configuration.class);
    private static Configuration SINGLETON;

    /**
     * @return The current configuration for the application.
     */
    public static Configuration getConfiguration() {
        if (SINGLETON == null) {
            SINGLETON = new Configuration();
            SINGLETON.initialize();
        }
        return SINGLETON;
    }

    private static final String REST_PORT = "REST_PORT";

    private int restPort;


    /**
     * Private constructor for singleton class.
     */
    private Configuration() {

    }

    /**
     * Initializes the configuration, loading in optional parameters.
     */
    private void initialize() {
        LOGGER.info("Loading configuration...");
        String current = null;

        // Rest Port
        current = loadEvironmentVariable(REST_PORT);
        if (current == null) {
            current = "8080";
        }
        try {
            restPort = Integer.parseInt(current);
        } catch (NumberFormatException ex) {
            LOGGER.error("Invalid variable for " + REST_PORT + " supplied. Could not convert to a number. Defaulting to 8080.", ex);
            restPort = 8080;
        }


        LOGGER.info("Configuration loaded!");
    }

    /**
     * @return The port on which the REST service will run.
     */
    public int getRestPort() {
        return restPort;
    }

    private String loadEvironmentVariable(String variableName) {
        LOGGER.debug("Loading environment variable: " + variableName);

        String var = System.getenv(variableName);
        if (var == null || "".equals(var)) {
            LOGGER.debug("Environment variable " + var + " not found! Will use default.");
            return null;
        }
        return var.trim();
    }

}

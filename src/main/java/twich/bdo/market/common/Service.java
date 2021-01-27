package twich.bdo.market.common;

public interface Service {

    /**
     * Initialize the service prior to use.
     *
     * @throws ServiceInitializationException If an error occurs during service initialization.
     */
    void initialize() throws ServiceInitializationException;

    /**
     * Shutdown the service gracefully after use.
     *
     * @throws ServiceShutdownException If an error occurs during service shutdown.
     */
    void shutdown() throws ServiceShutdownException;
}

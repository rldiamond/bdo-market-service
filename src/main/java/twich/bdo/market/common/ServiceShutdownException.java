package twich.bdo.market.common;

public class ServiceShutdownException extends ServiceException {

    public ServiceShutdownException() {
    }

    public ServiceShutdownException(String message) {
        super(message);
    }

    public ServiceShutdownException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceShutdownException(Throwable cause) {
        super(cause);
    }

    public ServiceShutdownException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

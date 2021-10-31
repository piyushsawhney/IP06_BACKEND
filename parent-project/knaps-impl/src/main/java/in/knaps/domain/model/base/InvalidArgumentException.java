package in.knaps.domain.model.base;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(String errorMessage) {
        super(errorMessage);
    }
    public InvalidArgumentException(String errorMessage, Throwable cause) {
        super(errorMessage,cause);
    }
}

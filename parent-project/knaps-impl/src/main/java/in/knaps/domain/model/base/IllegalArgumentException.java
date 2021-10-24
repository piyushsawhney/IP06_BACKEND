package in.knaps.domain.model.base;

public class IllegalArgumentException extends RuntimeException {
    public IllegalArgumentException(String errorMessage) {
        super(errorMessage);
    }
    public IllegalArgumentException(String errorMessage, Throwable cause) {
        super(errorMessage,cause);
    }
}

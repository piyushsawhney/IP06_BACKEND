package in.knaps.domain.model.db;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String errorMessage) {
        super(errorMessage);
    }
    public EntityNotFoundException(String errorMessage, Throwable cause) {
        super(errorMessage,cause);
    }
}

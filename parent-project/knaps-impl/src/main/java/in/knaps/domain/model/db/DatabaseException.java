package in.knaps.domain.model.db;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String errorMessage) {
        super(errorMessage);
    }
    public DatabaseException(String errorMessage, Throwable cause) {
        super(errorMessage,cause);
    }
}

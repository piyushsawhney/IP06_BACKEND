package in.knaps.domain.model.base;

public class ImproperDomainValueException extends RuntimeException {
    public ImproperDomainValueException(String errorMessage) {
        super(errorMessage);
    }
    public ImproperDomainValueException(String errorMessage, Throwable cause) {
        super(errorMessage,cause);
    }
}

package fmi.designpatterns.figures.exceptions;

public class FactoryCreationException extends RuntimeException {
    public FactoryCreationException(String message) {
        super(message);
    }

    public FactoryCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}

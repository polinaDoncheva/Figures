package fmi.designpatterns.figures.exceptions;

public class FigureCreationException extends RuntimeException {
    public FigureCreationException(String message) {
        super(message);
    }

    public FigureCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}

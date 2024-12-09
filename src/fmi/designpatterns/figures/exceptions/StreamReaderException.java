package fmi.designpatterns.figures.exceptions;

public class StreamReaderException extends RuntimeException {
    public StreamReaderException(String message) {
        super(message);
    }

    public StreamReaderException(String message, Throwable cause) {
        super(message, cause);
    }
}

package fmi.designpatterns.figures.exceptions;

public class StreamWriterException extends RuntimeException {
    public StreamWriterException(String message) {
        super(message);
    }

    public StreamWriterException(String message, Throwable cause) {
        super(message, cause);
    }
}

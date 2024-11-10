package fmi.designpatterns.figures.figure;

public interface Figure extends Cloneable {
    double perimeter();

    Figure clone() throws CloneNotSupportedException;

    String toString();
}

package fmi.designpatterns.figures.figure;

public class Circle implements Figure {
    private double radius;
    private static final double PI = 3.14;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Circle radius should be a positive number.");
        }

        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2 * PI * radius;
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        Circle clonedCircle = (Circle) super.clone();

        clonedCircle.radius = this.radius;

        return clonedCircle;
    }

    @Override
    public String toString() {
        return "circle " + radius;
    }
}

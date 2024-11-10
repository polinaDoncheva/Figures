package fmi.designpatterns.figures.figure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle implements Figure {
    private List<Double> sides;

    public Triangle(double a, double b, double c) {
        if (!areValidSides(a, b, c)) {
            throw new IllegalArgumentException("Invalid values for triangle sides.");
        }

        if (willOverflow(a, b, c)) {
            throw new ArithmeticException("Calculating the perimeter will result in overflow");
        }

        sides = new ArrayList<>(List.of(a, b, c));
        Collections.sort(sides);
    }

    @Override
    public double perimeter() {
        return sides.get(0) + sides.get(1) + sides.get(2);
    }

    @Override
    public String toString() {
        return "triangle " + sides.get(0) + " " + sides.get(1) + " " + sides.get(2);
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        Triangle clonedTriangle = (Triangle) super.clone();

        clonedTriangle.sides = new ArrayList<>(this.sides);

        return clonedTriangle;
    }

    private boolean areValidSides(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }

        return a + b > c && a + c > b && b + c > a;
    }

    private boolean willOverflow(double a, double b, double c) {
        return a > Double.MAX_VALUE - b - c;
    }
}
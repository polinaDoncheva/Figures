package fmi.designpatterns.figures.figure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rectangle implements Figure {
    private List<Double> sides;

    public Rectangle(double a, double b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Rectangle sides should be positive numbers.");
        }

        sides = new ArrayList<>(List.of(a, b));
        Collections.sort(sides);
    }

    @Override
    public double perimeter() {
        return 2 * sides.get(0) + 2 * sides.get(1);
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        Rectangle clonedRectangle = (Rectangle) super.clone();

        clonedRectangle.sides = new ArrayList<>(this.sides);

        return clonedRectangle;
    }

    @Override
    public String toString() {
        return "rectangle " + sides.get(0) + " " + sides.get(1);
    }
}

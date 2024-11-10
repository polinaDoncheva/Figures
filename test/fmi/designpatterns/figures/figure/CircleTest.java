package fmi.designpatterns.figures.figure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    @Test
    public void testPerimeter() {
        Circle circle = new Circle(5);
        assertEquals(31.4, circle.perimeter(), 0.0001, "Circle perimeter should be 31.4.");
    }

    @Test
    public void testNegativeSides() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(-5),
                "Exception should be thrown, when radius is negative.");
    }

    @Test
    public void testToString() {
        Circle circle = new Circle(5);
        assertEquals("circle 5.0", circle.toString(),
                "String representation for circle is invalid.");
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        Circle circle1 = new Circle(5);
        Figure circle2 = circle1.clone();

        assertNotSame(circle1, circle2,
                "The cloned circle should be a different object from the original.");

        assertEquals(circle1.perimeter(), circle2.perimeter(),
                "Cloned circles should have same perimeters.");
    }
}
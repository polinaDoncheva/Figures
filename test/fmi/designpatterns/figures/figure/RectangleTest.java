package fmi.designpatterns.figures.figure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    public void testPerimeter() {
        Rectangle rectangle = new Rectangle(4, 5);
        assertEquals(18, rectangle.perimeter(), 0.0001,
                "Rectangle perimeter should be 18.");
    }

    @Test
    public void testNegativeSides() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-4, 5),
                "Exception should be thrown, when rectangle side is negative.");
    }

    @Test
    public void testToString() {
        Rectangle rectangle = new Rectangle(5, 4);
        assertEquals("rectangle 4.0 5.0", rectangle.toString(),
                "String representation for rectangle is invalid.");
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        Rectangle rectangle1 = new Rectangle(4, 5);
        Figure rectangle2 = rectangle1.clone();

        assertNotSame(rectangle1, rectangle2,
                "The cloned rectangle should be a different object from the original.");

        assertEquals(rectangle1.perimeter(), rectangle2.perimeter(),
                "Cloned rectangle should have same perimeters.");
    }

}
package fmi.designpatterns.figures.figure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    private Rectangle rectangle;

    @BeforeEach
    void setup() {
        rectangle = new Rectangle(4, 5);
    }
    @Test
    void testPerimeter() {
        assertEquals(18, rectangle.perimeter(), 0.0001,
                "Rectangle perimeter should be 18.");
    }

    @Test
    void testNegativeSides() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-4, 5),
                "Exception should be thrown, when rectangle side is negative.");
    }

    @Test
    void testToString() {
        assertEquals("rectangle 4.0 5.0", rectangle.toString(),
                "String representation for rectangle is invalid.");
    }

    @Test
    void testClone() throws CloneNotSupportedException {
        Figure rectangleClone = rectangle.clone();

        assertNotSame(rectangle, rectangleClone,
                "The cloned rectangle should be a different object from the original.");

        assertEquals(rectangle.perimeter(), rectangleClone.perimeter(),
                "Cloned rectangle should have same perimeters.");
    }

}
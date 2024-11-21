package fmi.designpatterns.figures.figure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void testPerimeter() {
        Triangle triangle = new Triangle(3, 4, 5);
        assertEquals(12, triangle.perimeter(), 0.0001,
                "Triangle perimeter should be 12.");
    }

    @Test
    void testInvalidSides() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 3),
                "Exception should be thrown, when sides do not form triangle.");
    }

    @Test
    void testNegativeSides() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(3, -4, 5),
                "Exception should be thrown, when triangle side is negative.");
    }

    @Test
    void testToString() {
        Triangle triangle = new Triangle(5, 3, 4);
        assertEquals("triangle 3.0 4.0 5.0", triangle.toString(),
                "String representation for triangle is invalid.");
    }

    @Test
    void testClone() throws CloneNotSupportedException {
        Triangle triangle1 = new Triangle(3, 4, 5);
        Figure triangle2 = triangle1.clone();

        assertNotSame(triangle1, triangle2,
                "The cloned triangle should be a different object from the original.");

        assertEquals(triangle1.perimeter(), triangle2.perimeter(),
                "Cloned triangles should have same perimeters.");
    }
}

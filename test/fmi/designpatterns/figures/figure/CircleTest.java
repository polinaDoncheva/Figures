package fmi.designpatterns.figures.figure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    private Circle circleRadius5;
    @BeforeEach
    void setup() {
        circleRadius5 = new Circle(5);;
    }
    @Test
    void testPerimeter() {
        assertEquals(31.4, circleRadius5.perimeter(), 0.0001,
                "Circle with radius 5 perimeter should be 31.4.");
    }

    @Test
    void testConstructorNegativeSides() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(-5),
                "Exception should be thrown, when radius is negative.");
    }

    @Test
    void testToString() {
        assertEquals("circle 5.0", circleRadius5.toString(),
                "String representation for circle is invalid.");
    }

    @Test
    void testClone() throws CloneNotSupportedException {
        Figure circleCLone = circleRadius5.clone();

        assertNotSame(circleRadius5, circleCLone,
                "The cloned circle should be a different object from the original.");

        assertEquals(circleRadius5.perimeter(), circleCLone.perimeter(),
                "Cloned circles should have same perimeters.");
    }
}
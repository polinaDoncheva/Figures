package fmi.designpatterns.figures.stringToFigureFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToFigureFactoryTest {
    StringToFigureFactory factory = new StringToFigureFactory();

    @Test
    public void testCircleCreateFrom() {
        assertEquals("circle 5.0",
                factory.createFrom("circle 5").toString(),
                "Invalid creating of circle from string.");
    }

    @Test
    public void testCircleCreateFromLessArguments() {
        assertThrows(IllegalArgumentException.class, () -> factory.createFrom("circle"),
                "Exception should be thrown, when no radius given.");
    }

    @Test
    public void testCircleCreateFromInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> factory.createFrom("circle -5"),
                "Exception should be thrown, when radius is invalid.");
    }

    @Test
    public void testRectangleCreateFrom() {
        assertEquals("rectangle 4.0 5.0",
                factory.createFrom("rectangle 4 5").toString(),
                "Invalid creating of rectangle from string");
    }

    @Test
    public void testRectangleCreateFromLessArguments() {
        assertThrows(IllegalArgumentException.class, () -> factory.createFrom("rectangle 3"),
                "Exception should be thrown, when given 1 number for rectangle.");
    }

    @Test
    public void testRectangleCreateFromInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> factory.createFrom("rectangle -5 4"),
                "Exception should be thrown, when given invalid numbers for rectangle.");
    }

    @Test
    public void testTriangleCreateFrom() {
        assertEquals("triangle 3.0 4.0 5.0",
                factory.createFrom("triangle 3 4 5").toString(),
                "Invalid creating of triangle from string.");
    }

    @Test
    public void testTriangleCreateFromLessArguments() {
        assertThrows(IllegalArgumentException.class, () -> factory.createFrom("triangle 4 5"),
                "Exception should be thrown, when given 2 number for triangle.");
    }

    @Test
    public void testTriangleCreateFromInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> factory.createFrom("triangle -5 4 abs"),
                "Exception should be thrown, when given 1 number for rectangle.");
    }

    @Test
    public void testUnknownCreateFromInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> factory.createFrom("unknown -5 4 abs"),
                "Invalid creating of figure from string");
    }
}
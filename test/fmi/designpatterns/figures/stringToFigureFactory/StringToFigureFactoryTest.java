package fmi.designpatterns.figures.stringToFigureFactory;

import fmi.designpatterns.figures.figure.Circle;
import fmi.designpatterns.figures.figure.Rectangle;
import fmi.designpatterns.figures.figure.Triangle;
import fmi.designpatterns.figures.figureFactory.FigureEntry;

import fmi.designpatterns.figures.figureFactory.StringToFigureFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringToFigureFactoryTest {
    private final StringToFigureFactory factory = new StringToFigureFactory(List.of(
            new FigureEntry("triangle", 3, "^triangle( \\d+(\\.\\d+)?){3}$", Triangle.class),
            new FigureEntry("rectangle", 2, "^rectangle( \\d+(\\.\\d+)?){2}$", Rectangle.class),
            new FigureEntry("circle", 1, "^circle \\d+(\\.\\d+)?$", Circle.class)));

    @Test
    void testCreateFromWithValidCircle() {
        assertEquals("circle 5.0",
                factory.createFrom("circle 5").toString(),
                "Invalid creating of circle from string.");
    }

    @Test
    void testCreateFromWithCircleLessArguments() {
        assertThrows(IllegalArgumentException.class, () -> factory.createFrom("circle"),
                "Exception should be thrown, when no radius given.");
    }

    @Test
    void testCreateFromWithCircleInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> factory.createFrom("circle -5"),
                "Exception should be thrown, when radius is invalid.");
    }

    @Test
    void testCreateFromWithValidRectangle() {
        assertEquals("rectangle 4.0 5.1",
                factory.createFrom("rectangle 4 5.1").toString(),
                "Invalid creating of rectangle from string");
    }

    @Test
    void testCreateFromWithRectangleLessArguments() {
        assertThrows(IllegalArgumentException.class, () -> factory.createFrom("rectangle 3"),
                "Exception should be thrown, when given 1 number for rectangle.");
    }

    @Test
    void testCreateFromWithRectangleInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> factory.createFrom("rectangle -5 4"),
                "Exception should be thrown, when given invalid numbers for rectangle.");
    }

    @Test
    void testCreateFromWithValidTriangle() {
        assertEquals("triangle 3.1 4.0 5.0",
                factory.createFrom("triangle 3.1 4 5").toString(),
                "Invalid creating of triangle from string.");
    }

    @Test
    void testCreateFromWithTriangleLessArguments() {
        assertThrows(IllegalArgumentException.class, () -> factory.createFrom("triangle 4 5"),
                "Exception should be thrown, when given 2 number for triangle.");
    }

    @Test
    void testCreateFromWithTriangleInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> factory.createFrom("triangle -5 4 abs"),
                "Exception should be thrown, when given 1 number for rectangle.");
    }

    @Test
    void testUnknownCreateFromInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> factory.createFrom("unknown -5 4 abs"),
                "Invalid creating of figure from string");
    }
}
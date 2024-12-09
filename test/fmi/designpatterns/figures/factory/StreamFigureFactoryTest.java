package fmi.designpatterns.figures.factory;

import fmi.designpatterns.figures.figure.Circle;
import fmi.designpatterns.figures.figure.Rectangle;
import fmi.designpatterns.figures.figure.Triangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StreamFigureFactoryTest {
    private final List<FigureEntry> entries = new ArrayList<>();

    @BeforeEach
    void setup() {
        entries.add(new FigureEntry("triangle", 3, "^triangle( \\d+(\\.\\d+)?){3}$", Triangle.class));
        entries.add(new FigureEntry("rectangle", 2, "^rectangle( \\d+(\\.\\d+)?){2}$", Rectangle.class));
        entries.add(new FigureEntry("circle", 1, "^circle \\d+(\\.\\d+)?$", Circle.class));
    }

    @Test
    void testCreate() throws IOException {
        String representation = "triangle 3.0 4.7 5.0";
        BufferedReader reader = new BufferedReader(new StringReader(representation));
        StreamFigureFactory factory = new StreamFigureFactory(reader, entries);

        assertEquals(representation, factory.create().toString(),
                "Invalid figure created. Expected " + representation);
    }

    @Test
    void testEmptyStreamCreate() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(""));
        StreamFigureFactory factory = new StreamFigureFactory(reader, entries);

        assertThrows(IllegalArgumentException.class, () -> factory.create().toString(),
                "Exception should be thrown, if stream is empty.");
    }

    @Test
    void testStreamAfterErrorCreate() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader("-5\ntriangle 3 4 5"));
        StreamFigureFactory factory = new StreamFigureFactory(reader, entries);


        assertThrows(IllegalArgumentException.class, () -> factory.create().toString(),
                "Exception should be thrown, if stream is empty.");

        assertEquals("triangle 3.0 4.0 5.0", factory.create().toString(),
                "Invalid figure created after exception.");
    }
}
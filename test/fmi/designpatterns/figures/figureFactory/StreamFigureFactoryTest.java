package fmi.designpatterns.figures.figureFactory;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class StreamFigureFactoryTest {
    @Test
    void testCreate() throws IOException {
        String representation = "triangle 3.0 4.0 5.0";
        BufferedReader reader = new BufferedReader(new StringReader(representation));
        StreamFigureFactory factory = new StreamFigureFactory(reader);
        String res = factory.create().toString();

        assertEquals(representation, res, "Invalid figure created. " + res);
    }

    @Test
    void testEmptyStreamCreate() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(""));
        StreamFigureFactory factory = new StreamFigureFactory(reader);

        assertThrows(IllegalArgumentException.class, () -> factory.create().toString(),
                "Exception should be thrown, if stream is empty.");
    }

    @Test
    void testStreamAfterErrorCreate() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader("-5\ntriangle 3 4 5"));
        StreamFigureFactory factory = new StreamFigureFactory(reader);


        assertThrows(IllegalArgumentException.class, () -> factory.create().toString(),
                "Exception should be thrown, if stream is empty.");

        assertEquals("triangle 3.0 4.0 5.0", factory.create().toString(),
                "Invalid figure created after exception.");
    }
}
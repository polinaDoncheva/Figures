package fmi.designpatterns.figures.factory;

import fmi.designpatterns.figures.figure.Circle;
import fmi.designpatterns.figures.figure.Rectangle;
import fmi.designpatterns.figures.figure.Triangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AbstractFigureFactoryTest {
    private final List<FigureEntry> entries = new ArrayList<>();

    @BeforeEach
    void setup() {
        entries.add(new FigureEntry("triangle", 3, "^triangle( \\d+(\\.\\d+)?){3}$", Triangle.class));
        entries.add(new FigureEntry("rectangle", 2, "^rectangle( \\d+(\\.\\d+)?){2}$", Rectangle.class));
        entries.add(new FigureEntry("circle", 1, "^circle \\d+(\\.\\d+)?$", Circle.class));
    }

    @Test
    void testGetFactoryWithStandardInput() throws IOException {
        assertInstanceOf(StreamFigureFactory.class,
                AbstractFigureFactory.of("standard", entries));
    }

    @Test
    void testGetFactoryWithFileInput() throws IOException {
        File tempFile = File.createTempFile("figures", ".txt");
        tempFile.deleteOnExit();

        AbstractFigureFactory factory = AbstractFigureFactory.
                of("file " + tempFile.getAbsolutePath(), entries);

        assertNotNull(factory);
        assertInstanceOf(StreamFigureFactory.class, factory);
    }

    @Test
    void testGetFactoryWithRandomInput() throws IOException {
        assertInstanceOf(RandomFigureFactory.class,
                AbstractFigureFactory.of("random", entries));
    }

    @Test
    void testGetFactoryWithInvalidInput() {
        assertThrows(IllegalArgumentException.class,
                () -> AbstractFigureFactory.of("unknown", entries));
    }

    @Test
    void testGetFactoryWithRandomExtraParameters() {
        assertThrows(IllegalArgumentException.class,
                () -> AbstractFigureFactory.of("random extra", entries));
    }

    @Test
    void testGetFactoryWithStandardExtraParameters() {
        assertThrows(IllegalArgumentException.class,
                () -> AbstractFigureFactory.of("standard extra", entries));
    }

    @Test
    void testGetFactoryWithFileLessParameters() {
        assertThrows(IllegalArgumentException.class,
                () -> AbstractFigureFactory.of("file", entries));
    }
}
package fmi.designpatterns.figures.figureFactory;

import fmi.designpatterns.figures.figure.Circle;
import fmi.designpatterns.figures.figure.Rectangle;
import fmi.designpatterns.figures.figure.Triangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
                AbstractFigureFactory.getFactory("standard", entries));
    }

    @Test
    void testGetFactoryWithFileInput() throws IOException {
        File tempFile = File.createTempFile("figures", ".txt");
        tempFile.deleteOnExit();

        AbstractFigureFactory factory = AbstractFigureFactory.
                getFactory("file " + tempFile.getAbsolutePath(), entries);

        assertNotNull(factory);
        assertInstanceOf(StreamFigureFactory.class, factory);
    }

    @Test
    void testGetFactoryWithRandomInput() throws IOException {
        assertInstanceOf(RandomFigureFactory.class,
                AbstractFigureFactory.getFactory("random", entries));
    }

    @Test
    void testGetFactoryWithInvalidInput() {
        assertThrows(IllegalArgumentException.class,
                () -> AbstractFigureFactory.getFactory("unknown", entries));
    }

    @Test
    void testGetFactoryWithRandomExtraParameters() {
        assertThrows(IllegalArgumentException.class,
                () -> AbstractFigureFactory.getFactory("random extra", entries));
    }

    @Test
    void testGetFactoryWithStandardExtraParameters() {
        assertThrows(IllegalArgumentException.class,
                () -> AbstractFigureFactory.getFactory("standard extra", entries));
    }

    @Test
    void testGetFactoryWithFileLessParameters() {
        assertThrows(IllegalArgumentException.class,
                () -> AbstractFigureFactory.getFactory("file", entries));
    }
}
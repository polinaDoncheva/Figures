package fmi.designpatterns.figures.api;

import fmi.designpatterns.figures.factory.AbstractFigureFactory;
import fmi.designpatterns.figures.factory.StreamFigureFactory;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FactoryReaderMenuTest {
    @Test
    void testReadEnd() throws IOException {
        FactoryReaderMenu menu = new FactoryReaderMenu(new Scanner("end\n"));

        assertNull(menu.read(List.of()), "Expected null return when command is end");
    }

    @Test
    void testReadHelp() throws FileNotFoundException {
        FactoryReaderMenu menu = new FactoryReaderMenu(new Scanner("help\nend\n"));

        assertDoesNotThrow(() -> menu.read(List.of()), "Not expected exception thrown");
    }

    @Test
    void testReadInvalid() throws IOException {
        FactoryReaderMenu menu = new FactoryReaderMenu(new Scanner("some invalid input\n"));

        assertThrows(IllegalArgumentException.class, () -> menu.read(List.of()),
                "Expected exception thrown for invalid input");
    }
}
package fmi.designpatterns.figures.api;

import fmi.designpatterns.figures.figure.Circle;
import fmi.designpatterns.figures.figure.Figure;
import fmi.designpatterns.figures.factory.AbstractFigureFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class FiguresReaderMenuTest {
    private final AbstractFigureFactory factoryMock = Mockito.mock();

    @Test
    void testReadZero() throws IOException {
        FiguresReaderMenu menu = new FiguresReaderMenu(new Scanner("0\n"));

        assertTrue(menu.read(factoryMock, List.of()).isEmpty(),
                "Expected no figures for negative number of figures");
    }

    @Test
    void testReadNegativeNumber() throws IOException {
        FiguresReaderMenu menu = new FiguresReaderMenu(new Scanner("-2\n"));

        assertThrows(IllegalArgumentException.class, () -> menu.read(factoryMock, List.of()).isEmpty());
    }

    @Test
    void testReadValidNumber() throws IOException {
        FiguresReaderMenu menu = new FiguresReaderMenu(new Scanner("2\n"));
        when(factoryMock.create()).thenReturn(new Circle(5));

        List<Figure> figures =  menu.read(factoryMock, List.of());

        assertEquals(2,figures.size(),
                "Expected count of figures to be 2");
    }
}
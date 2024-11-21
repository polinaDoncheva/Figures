package fmi.designpatterns.figures.api;

import fmi.designpatterns.figures.figure.Circle;
import fmi.designpatterns.figures.figure.Figure;
import fmi.designpatterns.figures.figureFactory.AbstractFigureFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FiguresReaderMenuTest {
    private final Scanner scannerMock = Mockito.mock();
    private final AbstractFigureFactory factoryMock = Mockito.mock();

    private final FiguresReaderMenu menu = new FiguresReaderMenu(scannerMock);

    @Test
    void testReadNegativeNumber() throws IOException {
        when(scannerMock.nextLine()).thenReturn("-2");

        assertTrue(menu.read(factoryMock, List.of()).isEmpty(),
                "Expected no figures for negative number of figures");
    }

    @Test
    void testReadValidNumber() throws IOException {
        when(scannerMock.nextInt()).thenReturn(2);
        when(factoryMock.create()).thenReturn(new Circle(5));

        List<Figure> figures =  menu.read(factoryMock, List.of());

        assertEquals(2,figures.size(),
                "Expected count of figures to be 2");
    }
}
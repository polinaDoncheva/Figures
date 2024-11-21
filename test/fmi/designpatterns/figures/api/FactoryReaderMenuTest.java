package fmi.designpatterns.figures.api;

import fmi.designpatterns.figures.figureFactory.AbstractFigureFactory;
import fmi.designpatterns.figures.figureFactory.RandomFigureFactory;
import fmi.designpatterns.figures.figureFactory.StreamFigureFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FactoryReaderMenuTest {
    @Mock
    private Scanner scannerMock;

    @InjectMocks
    private FactoryReaderMenu menu;

    @Test
    void testReadEnd() throws FileNotFoundException {
        when(scannerMock.nextLine()).thenReturn("end");

        assertNull(menu.read(List.of()), "Expected null return when command is end");
        verify(scannerMock, times(1)).nextLine();

    }

    @Test
    void testReadHelp() throws FileNotFoundException {
        when(scannerMock.nextLine()).thenReturn("help").thenReturn("end");

        assertDoesNotThrow(() -> menu.read(List.of()), "Not expected exception thrown");
        verify(scannerMock, times(2)).nextLine();
    }

    /*   @Test
    void testReadStandard() throws FileNotFoundException {
        AbstractFigureFactory abstractFactory = Mockito.mock();
        StreamFigureFactory streamFactory = Mockito.mock();

        when(AbstractFigureFactory.getFactory("standard", List.of())).thenReturn(streamFactory);
        when(scannerMock.nextLine()).thenReturn("standard");

        assertInstanceOf(StreamFigureFactory.class, menu.read(List.of()));
    }

    @Test
    void testReadFile() throws IOException {
        AbstractFigureFactory abstractFactory = Mockito.mock();
        StreamFigureFactory streamFactory = Mockito.mock();

        when(AbstractFigureFactory.getFactory("file", List.of())).thenReturn(streamFactory);
        when(scannerMock.nextLine()).thenReturn("file");

        assertInstanceOf(StreamFigureFactory.class, menu.read(List.of()));
    }

    @Test
    void testReadRandom() throws IOException {
        AbstractFigureFactory abstractFactory = Mockito.mock();
        RandomFigureFactory randomFactory = Mockito.mock();

        when(AbstractFigureFactory.getFactory("random", List.of())).thenReturn(randomFactory);
        when(scannerMock.nextLine()).thenReturn("random");

        assertInstanceOf(RandomFigureFactory.class, menu.read(List.of()));
    }*/

    @Test
    void testReadInvalid() throws IOException {
        when(scannerMock.nextLine()).thenReturn("invalid input");

        assertThrows(IllegalArgumentException.class, () -> menu.read(List.of()),
                "Expected exception thrown for invalid input");
    }
}
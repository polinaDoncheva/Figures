package fmi.designpatterns.figures.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FiguresOperationsMenuTest {
    @Mock
    private Scanner scannerMock;

    @InjectMocks
    private FiguresOperationsMenu menu;

    @Test
    void testExecuteEnd() throws IOException {
        when(scannerMock.nextLine()).thenReturn("end");

        assertDoesNotThrow(() -> menu.execute(List.of()), "Not expected exception when command is end");
        verify(scannerMock, times(1)).nextLine();
    }

    @Test
    void testExecuteHelp() throws FileNotFoundException {
        when(scannerMock.nextLine()).thenReturn("help").thenReturn("end");

        assertDoesNotThrow(() -> menu.execute(List.of()), "Not expected exception when command is end");
        verify(scannerMock, times(2)).nextLine();
    }
}
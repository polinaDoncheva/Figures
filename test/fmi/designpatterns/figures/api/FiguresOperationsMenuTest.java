package fmi.designpatterns.figures.api;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class FiguresOperationsMenuTest {
    @Test
    void testExecuteEnd() throws IOException {
        FiguresOperationsMenu menu = new FiguresOperationsMenu(new Scanner("end\n"));

        assertDoesNotThrow(() -> menu.execute(List.of()), "Not expected exception when command is end");
    }

    @Test
    void testExecuteHelp() throws FileNotFoundException {
        FiguresOperationsMenu menu = new FiguresOperationsMenu(new Scanner("help\nend\n"));

        assertDoesNotThrow(() -> menu.execute(List.of()), "Not expected exception when command is end");
    }
}
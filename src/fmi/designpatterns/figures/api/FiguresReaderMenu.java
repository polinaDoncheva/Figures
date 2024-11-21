package fmi.designpatterns.figures.api;

import fmi.designpatterns.figures.figure.Figure;
import fmi.designpatterns.figures.figureFactory.AbstractFigureFactory;
import fmi.designpatterns.figures.figureFactory.FigureEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FiguresReaderMenu {
    private final Scanner scanner;

    public FiguresReaderMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Figure> read(AbstractFigureFactory factory, List<FigureEntry> entries)
            throws IOException {

        System.out.println("enter number of figures to be created: ");

        int number = scanner.nextInt();
        scanner.nextLine();
        List<Figure> result = new ArrayList<>(number);

        displayFiguresOptions(entries);
        System.out.println("expected input: " + number + " lines following any of the patterns");

        for (int i = 0; i < number; i++) {
            result.add(factory.create());
        }

        return result;
    }

    private void displayFiguresOptions(List<FigureEntry> entries) {
        for (FigureEntry entry : entries) {
            System.out.println("<" + entry.name() + " {positive double} * " + entry.argumentsCount() + ">");
        }
    }
}

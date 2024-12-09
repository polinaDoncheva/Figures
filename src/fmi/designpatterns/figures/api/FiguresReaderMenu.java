package fmi.designpatterns.figures.api;

import fmi.designpatterns.figures.figure.Figure;
import fmi.designpatterns.figures.factory.AbstractFigureFactory;
import fmi.designpatterns.figures.factory.FigureEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FiguresReaderMenu {
    private final Scanner scanner;

    public FiguresReaderMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Figure> read(AbstractFigureFactory factory, List<FigureEntry> entries) {
        System.out.println("enter number of figures to be created: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (number < 0) {
            throw new IllegalArgumentException("Negative number for figures count");
        }

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

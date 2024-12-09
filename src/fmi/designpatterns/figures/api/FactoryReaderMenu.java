package fmi.designpatterns.figures.api;

import fmi.designpatterns.figures.factory.AbstractFigureFactory;
import fmi.designpatterns.figures.factory.FigureEntry;

import java.util.List;
import java.util.Scanner;

public class FactoryReaderMenu {
    private final Scanner scanner;

    public FactoryReaderMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public AbstractFigureFactory read(List<FigureEntry> entries) {
        while (true) {
            System.out.println("<help> displays options");
            System.out.println("<end> terminates program");
            String choice = scanner.nextLine();

            switch (choice) {
                case "end":
                    return null;
                case "help":
                    displayFactoryOptions();
                    break;
                default:
                    return AbstractFigureFactory.of(choice, entries);
            }
        }
    }

    private void displayFactoryOptions() {
        System.out.println("<standard> creates figures from standard input");
        System.out.println("<file file_name> creates figures from file file_name");
        System.out.println("<random> creates random figures");
    }
}
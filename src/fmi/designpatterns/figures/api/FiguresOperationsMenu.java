package fmi.designpatterns.figures.api;

import fmi.designpatterns.figures.figure.Figure;
import fmi.designpatterns.figures.figure.FigureByStringComparator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Scanner;

public class FiguresOperationsMenu {
    private final Scanner scanner;

    public FiguresOperationsMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void execute(List<Figure> figures) throws IOException {
        while (true) {
            System.out.println("<help> displays options");
            System.out.println("<end> terminates program");
            String choice = scanner.nextLine();

            switch (choice) {
                case "end":
                    return;
                case "help":
                    displayFiguresOperationsOptions();
                    break;
                case "sort":
                    sortFigures(figures);
                    break;
                case "save standard":
                    saveToStream(figures, new BufferedWriter(new OutputStreamWriter(System.out)));
                    break;
                case "save file":
                    saveToStream(figures, new BufferedWriter(new FileWriter(readFileName())));
                    break;
                default:
                    throw new UnsupportedOperationException("Invalid operation.");
            }
        }
    }

    private void displayFiguresOperationsOptions() {
        System.out.println("<sort> sorts the created figures in lexicographic order");
        System.out.println("<save standard> displays figures on standard input");
        System.out.println("<save file> saves figures to file");
    }

    private void saveToStream(List<Figure> figures, BufferedWriter writer) throws IOException {
        for (Figure figure : figures) {
            writer.write(figure.toString());
            writer.newLine();
        }
        writer.flush();
    }

    private void sortFigures(List<Figure> figures) {
        figures.sort(new FigureByStringComparator());
    }

    private String readFileName() {
        System.out.println("enter file name: ");

        return scanner.next();
    }
}

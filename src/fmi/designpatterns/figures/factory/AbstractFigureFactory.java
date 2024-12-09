package fmi.designpatterns.figures.factory;

import fmi.designpatterns.figures.exceptions.FactoryCreationException;
import fmi.designpatterns.figures.figure.Figure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractFigureFactory {
    public abstract Figure create();

    public static AbstractFigureFactory of(String input, List<FigureEntry> entries) {
        try (Scanner scanner = new Scanner(input)) {
            String operation = scanner.next();

            if (operation.equals("standard") && !scanner.hasNext()) {
                return new StreamFigureFactory(new BufferedReader(new InputStreamReader(System.in)), entries);
            }
            if (operation.equals("file") && scanner.hasNext()) {
                return new StreamFigureFactory(new BufferedReader(new FileReader(scanner.next())), entries);
            }
            if (operation.equals("random") && !scanner.hasNext()) {
                return new RandomFigureFactory(entries);
            }
            throw new IllegalArgumentException("Unknown factory method");

        } catch (FileNotFoundException e) {
            throw new FactoryCreationException("Could not create factory from file. File not found. " + e.getMessage());
        }
    }
}
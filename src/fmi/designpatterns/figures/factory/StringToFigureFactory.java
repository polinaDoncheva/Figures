package fmi.designpatterns.figures.factory;

import fmi.designpatterns.figures.exceptions.FigureCreationException;
import fmi.designpatterns.figures.figure.Figure;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class StringToFigureFactory {
    private final List<FigureEntry> entries;

    public StringToFigureFactory(List<FigureEntry> entries) {
        this.entries = entries;
    }

    public Figure createFrom(String representation) {
        for (FigureEntry entry : entries) {
            if (representation.matches(entry.regex())) {
                return getInstance(entry, representation);
            }
        }

        throw new IllegalArgumentException("Can not create figure. Invalid string");
    }

    private Figure getInstance(FigureEntry entry, String representation) {
        Object[] parameters = getParameters(entry, representation);
        Constructor<?> constructor = entry.classType().getConstructors()[0];
        Figure result;

        try {
            result = (Figure) constructor.newInstance(parameters);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new FigureCreationException("Error while creating an instance from matching string: "
                    + e.getMessage());
        }

        return result;
    }

    private Object[] getParameters(FigureEntry entry, String representation) {
        Scanner scanner = new Scanner(representation);
        scanner.useLocale(Locale.US);

        scanner.next();

        Object[] params = new Object[entry.argumentsCount()];
        for (int i = 0; i < entry.argumentsCount(); i++) {
            params[i] = scanner.nextDouble();
        }

        return params;
    }
}

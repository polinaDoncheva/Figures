package fmi.designpatterns.figures.figureFactory;

import fmi.designpatterns.figures.figure.Figure;
import fmi.designpatterns.figures.stringToFigureFactory.StringToFigureFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomFigureFactory extends AbstractFigureFactory {
    private static List<FigureEntry> entries = new ArrayList<>();
    private static double sideMin = 5;
    private static double sideRange = 45;

    static {
        entries.add(new FigureEntry("triangle", 3));
        entries.add(new FigureEntry("circle", 1));
        entries.add(new FigureEntry("rectangle", 2));
    }

    private Random random = new Random();
    StringToFigureFactory stringFactory = new StringToFigureFactory();

    @Override
    public Figure create() {
        FigureEntry entry = entries.get(random.nextInt(entries.size()));

        StringBuilder representation = new StringBuilder(entry.name());

        for (int i = 0; i < entry.argumentsCount(); i++) {
            representation.append(" ").append(randomDouble());
        }

        return stringFactory.createFrom(representation.toString());
    }

    private double randomDouble() {
        return sideMin + random.nextDouble() * sideRange;
    }
}

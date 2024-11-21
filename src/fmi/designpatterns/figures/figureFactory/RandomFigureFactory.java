package fmi.designpatterns.figures.figureFactory;

import fmi.designpatterns.figures.figure.Figure;

import java.util.List;
import java.util.Random;

public class RandomFigureFactory extends AbstractFigureFactory {
    private final List<FigureEntry> entries;
    private final static double sideMin = 5;
    private final static double sideRange = 45;
    private final Random random = new Random();
    StringToFigureFactory stringFactory;

    public RandomFigureFactory(List<FigureEntry> entries) {
        stringFactory = new StringToFigureFactory(entries);
        this.entries = entries;
    }

    @Override
    public Figure create() {
        FigureEntry entry = entries.get(random.nextInt(entries.size()));

        StringBuilder representation = new StringBuilder(entry.name());

        for (int i = 0; i < entry.argumentsCount(); i++) {
            representation.append(" ").append(randomPositiveDouble());
        }

        return stringFactory.createFrom(representation.toString());
    }

    private double randomPositiveDouble() {
        return sideMin + random.nextDouble() * sideRange;
    }
}

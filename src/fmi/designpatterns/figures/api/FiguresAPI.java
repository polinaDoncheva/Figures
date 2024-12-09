package fmi.designpatterns.figures.api;

import fmi.designpatterns.figures.figure.Circle;
import fmi.designpatterns.figures.figure.Figure;
import fmi.designpatterns.figures.figure.Rectangle;
import fmi.designpatterns.figures.figure.Triangle;
import fmi.designpatterns.figures.factory.AbstractFigureFactory;
import fmi.designpatterns.figures.factory.FigureEntry;

import java.util.List;
import java.util.Scanner;

public class FiguresAPI {
    private static final List<FigureEntry> ENTRIES = List.of(
            new FigureEntry("triangle", 3, "^triangle( \\d+(\\.\\d+)?){3}$", Triangle.class),
            new FigureEntry("rectangle", 2, "^rectangle( \\d+(\\.\\d+)?){2}$", Rectangle.class),
            new FigureEntry("circle", 1, "^circle \\d+(\\.\\d+)?$", Circle.class));
    private final Scanner scanner = new Scanner(System.in);
    private final FactoryReaderMenu factoryReaderMenu = new FactoryReaderMenu(scanner);
    private final FiguresReaderMenu figuresReaderMenu = new FiguresReaderMenu(scanner);
    private final FiguresOperationsMenu figuresOperationsMenu = new FiguresOperationsMenu(scanner);

    public void execute() {
        AbstractFigureFactory abstractFactory = factoryReaderMenu.read(ENTRIES);
        List<Figure> figures = figuresReaderMenu.read(abstractFactory, ENTRIES);
        figuresOperationsMenu.execute(figures);
    }
}

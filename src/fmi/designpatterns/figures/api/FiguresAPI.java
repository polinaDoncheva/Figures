package fmi.designpatterns.figures.api;

import fmi.designpatterns.figures.figure.Circle;
import fmi.designpatterns.figures.figure.Figure;
import fmi.designpatterns.figures.figure.Rectangle;
import fmi.designpatterns.figures.figure.Triangle;
import fmi.designpatterns.figures.figureFactory.AbstractFigureFactory;
import fmi.designpatterns.figures.figureFactory.FigureEntry;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FiguresAPI {
    private final static List<FigureEntry> entries = List.of(
            new FigureEntry("triangle", 3, "^triangle( \\d+(\\.\\d+)?){3}$", Triangle.class),
            new FigureEntry("rectangle", 2, "^rectangle( \\d+(\\.\\d+)?){2}$", Rectangle.class),
            new FigureEntry("circle", 1, "^circle \\d+(\\.\\d+)?$", Circle.class));
    private final Scanner scanner = new Scanner(System.in);
    private final FactoryReaderMenu factoryReaderMenu = new FactoryReaderMenu(scanner);
    private final FiguresReaderMenu figuresReaderMenu = new FiguresReaderMenu(scanner);
    private final FiguresOperationsMenu figuresOperationsMenu = new FiguresOperationsMenu(scanner);

    public void execute() throws IOException {
        AbstractFigureFactory abstractFactory = factoryReaderMenu.read(entries);
        List<Figure> figures = figuresReaderMenu.read(abstractFactory, entries);
        figuresOperationsMenu.execute(figures);
    }
}

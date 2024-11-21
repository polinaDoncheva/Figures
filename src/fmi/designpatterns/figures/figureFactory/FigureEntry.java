package fmi.designpatterns.figures.figureFactory;

import fmi.designpatterns.figures.figure.Figure;

public record FigureEntry(String name, int argumentsCount,
                          String regex, Class<? extends Figure> classType) {
}

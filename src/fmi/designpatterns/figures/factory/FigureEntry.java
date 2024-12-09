package fmi.designpatterns.figures.factory;

import fmi.designpatterns.figures.figure.Figure;

public record FigureEntry(String name, int argumentsCount,
                          String regex, Class<? extends Figure> classType) {
}

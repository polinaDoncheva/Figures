package fmi.designpatterns.figures.stringToFigureFactory.stringParser;

import fmi.designpatterns.figures.figure.Figure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StringToFigure {
    public abstract Figure createFrom(String representation);

    public abstract Pattern getPattern();

    public boolean matches(String representation) {
        Matcher matcher = getPattern().matcher(representation);
        return matcher.matches();
    }
}

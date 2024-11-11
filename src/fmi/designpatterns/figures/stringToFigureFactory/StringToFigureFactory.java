package fmi.designpatterns.figures.stringToFigureFactory;

import fmi.designpatterns.figures.figure.Figure;
import fmi.designpatterns.figures.stringToFigureFactory.stringParser.StringToRectangle;
import fmi.designpatterns.figures.stringToFigureFactory.stringParser.StringToCircle;
import fmi.designpatterns.figures.stringToFigureFactory.stringParser.StringToFigure;
import fmi.designpatterns.figures.stringToFigureFactory.stringParser.StringToTriangle;

import java.util.ArrayList;
import java.util.List;

public class StringToFigureFactory {
    private List<StringToFigure> parsers = new ArrayList<>();

    public StringToFigureFactory() {
        StringToFigure toTriangle = new StringToTriangle();
        StringToFigure toRectangle = new StringToRectangle();
        StringToFigure toCircle = new StringToCircle();

        parsers.add(toTriangle);
        parsers.add(toRectangle);
        parsers.add(toCircle);
    }

    public Figure createFrom(String representation) {
        for (StringToFigure parser : parsers) {
            if (parser.matches(representation)) {
                return parser.createFrom(representation);
            }
        }

        throw new IllegalArgumentException("Can not create figure. Invalid string");
    }
}

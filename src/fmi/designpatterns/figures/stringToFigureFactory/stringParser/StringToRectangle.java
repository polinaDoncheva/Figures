package fmi.designpatterns.figures.stringToFigureFactory.stringParser;

import fmi.designpatterns.figures.figure.Figure;
import fmi.designpatterns.figures.figure.Rectangle;
import fmi.designpatterns.figures.stringToFigureFactory.stringParser.StringToFigure;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringToRectangle extends StringToFigure {
    private static String regex = "^rectangle( \\d+(\\.\\d+)?){2}$";
    private static Pattern pattern = Pattern.compile(regex);

    @Override
    public Figure createFrom(String representation) {
        if (!super.matches(representation)) {
            throw new IllegalArgumentException("Could not create rectangle. Invalid format of string.");
        }

        Scanner scanner = new Scanner(representation);
        scanner.next();
        double side1 = scanner.nextDouble();;
        double side2 = scanner.nextDouble();;

        return new Rectangle(side1, side2);
    }

    @Override
    public Pattern getPattern() {
        return pattern;
    }
}

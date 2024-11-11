package fmi.designpatterns.figures.stringToFigureFactory.stringParser;

import fmi.designpatterns.figures.figure.Circle;
import fmi.designpatterns.figures.figure.Figure;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringToCircle extends StringToFigure {
    private static String regex = "^circle \\d+(\\.\\d+)?$";
    private static Pattern pattern = Pattern.compile(regex);

    @Override
    public Figure createFrom(String representation) {
        if (!super.matches(representation)) {
            throw new IllegalArgumentException("Could not create circle. Invalid format of string.");
        }

        Scanner scanner = new Scanner(representation);
        scanner.next();
        double radius = scanner.nextDouble();;

        return new Circle(radius);
    }

    @Override
    public Pattern getPattern() {
        return pattern;
    }
}

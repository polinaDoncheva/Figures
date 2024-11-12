package fmi.designpatterns.figures.stringToFigureFactory.stringParser;

import fmi.designpatterns.figures.figure.Figure;
import fmi.designpatterns.figures.figure.Triangle;
import fmi.designpatterns.figures.stringToFigureFactory.stringParser.StringToFigure;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToTriangle extends StringToFigure {
    private static String regex = "^triangle( \\d+(\\.\\d+)?){3}$";
    private static Pattern pattern = Pattern.compile(regex);

    @Override
    public Figure createFrom(String representation) {
        Matcher matcher = pattern.matcher(representation);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Could not create triangle. Invalid format of string.");
        }

        Scanner scanner = new Scanner(representation);
        scanner.useLocale(Locale.US);

        scanner.next();
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();

        return new Triangle(side1, side2, side3);
    }

    @Override
    public Pattern getPattern() {
        return pattern;
    }
}

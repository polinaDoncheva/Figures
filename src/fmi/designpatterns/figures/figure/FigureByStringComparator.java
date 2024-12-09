package fmi.designpatterns.figures.figure;

import java.util.Comparator;

public class FigureByStringComparator implements Comparator<Figure> {

    @Override
    public int compare(Figure figure1, Figure figure2) {
        return figure1.toString().compareTo(figure2.toString());
    }
}

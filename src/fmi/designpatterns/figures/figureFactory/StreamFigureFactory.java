package fmi.designpatterns.figures.figureFactory;

import fmi.designpatterns.figures.figure.Figure;
import fmi.designpatterns.figures.stringToFigureFactory.StringToFigureFactory;

import java.io.BufferedReader;
import java.io.IOException;

public class StreamFigureFactory extends AbstractFigureFactory {
    private BufferedReader reader;
    private StringToFigureFactory stringFactory;

    public StreamFigureFactory(BufferedReader reader) {
        this.reader = reader;
        stringFactory = new StringToFigureFactory();
    }

    @Override
    public Figure create() throws IOException {
        String line = reader.readLine();
        if (line == null) {
            throw new IllegalArgumentException("Can not create figure. Stream is empty.");
        }
        return stringFactory.createFrom(line);
    }
}

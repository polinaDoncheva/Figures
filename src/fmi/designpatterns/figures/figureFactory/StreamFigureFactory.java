package fmi.designpatterns.figures.figureFactory;

import fmi.designpatterns.figures.figure.Figure;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class StreamFigureFactory extends AbstractFigureFactory {
    private final BufferedReader reader;
    private final StringToFigureFactory stringFactory;

    public StreamFigureFactory(BufferedReader reader, List<FigureEntry> entries) {
        this.reader = reader;
        stringFactory = new StringToFigureFactory(entries);
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
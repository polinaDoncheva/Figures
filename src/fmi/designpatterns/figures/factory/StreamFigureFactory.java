package fmi.designpatterns.figures.factory;

import fmi.designpatterns.figures.exceptions.StreamReaderException;
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
    public Figure create() {
        String line = null;

        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new StreamReaderException("Could not create a figure. Invalid read from stream.");
        }

        if (line == null) {
            throw new IllegalArgumentException("Can not create figure. Stream is empty.");
        }

        return stringFactory.createFrom(line);
    }
}
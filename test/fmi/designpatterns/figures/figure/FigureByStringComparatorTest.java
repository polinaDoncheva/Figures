package fmi.designpatterns.figures.figure;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class FigureByStringComparatorTest {
    private final Figure circleMock = Mockito.mock();
    private final Figure triangleMock = Mockito.mock();
    private final Figure rectangleMock = Mockito.mock();
    private final Figure rectangleSecondMock = Mockito.mock();
    private final FigureByStringComparator comparator = new FigureByStringComparator();

    @Test
    void testCompareWithCircleAndTriangle() {
        when(circleMock.toString()).thenReturn("circle 5.0");
        when(triangleMock.toString()).thenReturn("triangle 3.0 4.0 5.0");

        assertTrue(comparator.compare(circleMock, triangleMock) < 0,
                "Expected circle 5.0 to come before triangle 3.0 4.0 5.0");
        assertTrue(comparator.compare(triangleMock, circleMock) > 0,
                "Expected triangle 3.0 4.0 5.0 to come after circle 5.0");
    }

    @Test
    void testCompareEqual() {
        when(circleMock.toString()).thenReturn("circle 5.0");

        assertEquals(0, comparator.compare(circleMock, circleMock),
                "Comparator should return 0 for figures with identical toString representations.");
    }

    @Test
    void testCompareTwoRectangles() {
        when(rectangleMock.toString()).thenReturn("rectangle 2.0 4.0");
        when(rectangleSecondMock.toString()).thenReturn("rectangle 5.0 10.0");

        assertTrue(comparator.compare(rectangleMock, rectangleSecondMock) < 0,
                "Expected rectangle 2.0 4.0 to come before rectangle 5.0 10.0");
        assertTrue(comparator.compare(rectangleSecondMock, rectangleMock) > 0,
                "Expected rectangle 5.0 10.0 to come after rectangle 2.0 4.0");
    }
}
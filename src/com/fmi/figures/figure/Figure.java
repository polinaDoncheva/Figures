package com.fmi.figures.figure;

public interface Figure extends Cloneable {
    double perimeter();
    Object clone() throws CloneNotSupportedException;
}

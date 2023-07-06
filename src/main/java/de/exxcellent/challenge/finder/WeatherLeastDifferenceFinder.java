package de.exxcellent.challenge.finder;

public class WeatherLeastDifferenceFinder extends AbstractLeastDifferenceFinder {
    @Override
    protected int calculateDifference(int value1, int value2) {
        /*
            A simple subtraction will suffice, because the maximum
            temperature is always guaranteed to be greater than the
            minimum temperature
        */
        return value1 - value2;
    }
}
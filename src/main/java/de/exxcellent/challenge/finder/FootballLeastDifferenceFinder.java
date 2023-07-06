package de.exxcellent.challenge.finder;

public class FootballLeastDifferenceFinder extends AbstractLeastDifferenceFinder {
    @Override
    protected int calculateDifference(int value1, int value2) {
        /* 
            absolute value because the difference between goals scored and 
            goals conceded could be a negative value also 
        */
        return Math.abs(value1 - value2);
    }
}
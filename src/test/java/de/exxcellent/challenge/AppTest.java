package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import de.exxcellent.challenge.finder.LeastDifferenceFinder;
import de.exxcellent.challenge.finder.WeatherLeastDifferenceFinder;
import de.exxcellent.challenge.finder.FootballLeastDifferenceFinder;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {
    @Test
    void testWeatherLeastDifferenceFinder() {
        String[][] dayNumberData = {
            {"1", "30", "20"},
            {"2", "25", "15"},
            {"3", "28", "26"},
            {"4", "22", "20"}
        };

        LeastDifferenceFinder dayNumberFinder = new WeatherLeastDifferenceFinder();
        String dayNumber = dayNumberFinder.findLeastDifference(dayNumberData);

        assertEquals("3", dayNumber);
    }

    @Test
    void testFootballLeastDifferenceFinder() {
        String[][] teamNameData = {
            {"Team A", "10", "5"},
            {"Team B", "8", "8"},
            {"Team C", "12", "10"},
            {"Team D", "6", "4"}
        };

        LeastDifferenceFinder teamNameFinder = new FootballLeastDifferenceFinder();
        String teamName = teamNameFinder.findLeastDifference(teamNameData);

        assertEquals("Team B", teamName);
    }
}
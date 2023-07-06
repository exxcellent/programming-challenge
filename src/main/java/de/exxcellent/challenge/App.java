package de.exxcellent.challenge;

import de.exxcellent.challenge.reader.FileReader;
import de.exxcellent.challenge.reader.CSVReader;
import de.exxcellent.challenge.finder.LeastDifferenceFinder;
import de.exxcellent.challenge.finder.WeatherLeastDifferenceFinder;
import de.exxcellent.challenge.finder.FootballLeastDifferenceFinder;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {
    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */ 
    public static void main(String... args) {
        String dayNumberFilePath = "de/exxcellent/challenge/weather.csv";
        String teamNameFilePath = "de/exxcellent/challenge/football.csv";

        FileReader csvReader = new CSVReader();
        LeastDifferenceFinder dayNumberFinder = new WeatherLeastDifferenceFinder();
        LeastDifferenceFinder teamNameFinder = new FootballLeastDifferenceFinder();

        String[][] dayNumberData = csvReader.readFile(dayNumberFilePath);
        String dayNumber = dayNumberFinder.findLeastDifference(dayNumberData);
        System.out.printf("Day with smallest temperature spread : %s%n\n", dayNumber);

        String[][] teamNameData = csvReader.readFile(teamNameFilePath);
        String teamName = teamNameFinder.findLeastDifference(teamNameData);
        System.out.printf("Team with smallest goal spread       : %s%n\n", teamName);
    }

}

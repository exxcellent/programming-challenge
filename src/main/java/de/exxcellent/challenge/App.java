package de.exxcellent.challenge;

import de.exxcellent.challenge.bo.FootballDataBO;
import de.exxcellent.challenge.bo.WeatherDataBO;
import de.exxcellent.challenge.controllers.AppController;
import de.exxcellent.challenge.utils.FileReaderUtil;

import java.io.IOException;
import java.util.Arrays;

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
        try {
            AppController appController = new AppController();
            appController.processFootballDataFromCSV("de/exxcellent/challenge/football.csv");
            appController.processFootballDataFromJson("de/exxcellent/challenge/football.json");
            appController.processWeatherDataFromCSV("de/exxcellent/challenge/weather.csv");
            appController.processWeatherDataFromJson("de/exxcellent/challenge/weather.json");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

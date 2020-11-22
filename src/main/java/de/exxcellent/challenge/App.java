package de.exxcellent.challenge;

import de.exxcellent.challenge.controllers.AppController;
import java.io.IOException;

import static de.exxcellent.challenge.constants.Domain.FOOTBALL;
import static de.exxcellent.challenge.constants.Domain.WEATHER;

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
            System.out.println(appController.processCSVData("de/exxcellent/challenge/football.csv", FOOTBALL));
            System.out.println(appController.processCSVData("de/exxcellent/challenge/weather.csv", WEATHER));
            System.out.println(appController.processJSONData("de/exxcellent/challenge/football.json", FOOTBALL));
            System.out.println(appController.processJSONData("de/exxcellent/challenge/weather.json", WEATHER));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

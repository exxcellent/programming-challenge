package de.exxcellent.challenge;

import de.exxcellent.challenge.bo.FootballDataBO;
import de.exxcellent.challenge.bo.WeatherDataBO;

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
            String footballData = FileReaderUtil.readFile("de/exxcellent/challenge/football.csv");
            String[] teamData = footballData.split(System.lineSeparator());

            FootballDataBO teamWithSmallestGoalSpread = Arrays.stream(teamData).skip(1)
                    .map(teamDataItem -> new FootballDataBO(teamDataItem))
                    .reduce(new FootballDataBO(teamData[1]), (finalTeam, currentTeam) -> {
                int goalDifference = Math.abs(currentTeam.getGoalsAllowed() - currentTeam.getGoals());
                int minGoalDifference = Math.abs(finalTeam.getGoalsAllowed() - finalTeam.getGoals());
                return  (minGoalDifference > goalDifference) ? currentTeam : finalTeam;
            });
            System.out.printf("Team with smallest goal spread: %s%n", teamWithSmallestGoalSpread.getTeam());

            String weatherDataStr = FileReaderUtil.readFile("de/exxcellent/challenge/weather.csv");
            String[] weatherData = weatherDataStr.split(System.lineSeparator());
            WeatherDataBO dayWithSmallestTempSpread = Arrays.stream(weatherData).skip(1)
                    .map(weatherDataItem -> new WeatherDataBO(weatherDataItem))
                    .reduce(new WeatherDataBO(weatherData[1]), (smallestTempSpreadDay, currentDay) -> {
                        int tempDifference = Math.abs(currentDay.getMaxTemperature() - currentDay.getMinTemperature());
                        int minTempDifference = Math.abs(smallestTempSpreadDay.getMaxTemperature() - smallestTempSpreadDay.getMinTemperature());
                        return  (minTempDifference > tempDifference) ? currentDay : smallestTempSpreadDay;
                    });
            System.out.printf("Day with smallest temperature spread : Day %s%n", dayWithSmallestTempSpread.getDay());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

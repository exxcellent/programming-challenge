package de.exxcellent.challenge.controllers;

import de.exxcellent.challenge.bo.BaseBO;
import de.exxcellent.challenge.bo.FootballDataBO;
import de.exxcellent.challenge.bo.WeatherDataBO;
import de.exxcellent.challenge.service.CsvReader;
import de.exxcellent.challenge.utils.SpreadCalculatorUtil;
import de.exxcellent.challenge.utils.FileReaderUtil;

import java.io.IOException;
import java.util.List;

public class AppController {

    public void begin() {
        try {
            processFootballDataFromCSV("de/exxcellent/challenge/football.csv");
            processWeatherDataFromCSV("de/exxcellent/challenge/weather.csv");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private void processFootballDataFromCSV(String filePath) throws IOException {
        String footballDataCsv = FileReaderUtil.readFile(filePath);
        List<BaseBO> footballData = new CsvReader().read(footballDataCsv, "FOOTBALL");
        FootballDataBO teamWithSmallestGoalSpread = SpreadCalculatorUtil.calculateFootballDataSpread(footballData);
        System.out.printf("Team with smallest goal spread: %s%n", teamWithSmallestGoalSpread.getTeam());
    }

    private void processWeatherDataFromCSV(String filePath) throws IOException {
        String weatherDataCsv = FileReaderUtil.readFile(filePath);
        List<BaseBO> weatherData = new CsvReader().read(weatherDataCsv, "WEATHER");
        WeatherDataBO dayWithSmallestTempSpread = SpreadCalculatorUtil.calculateWeatherDataSpread(weatherData);
        System.out.printf("Day with smallest temperature spread : Day %s%n", dayWithSmallestTempSpread.getDay());
    }
}

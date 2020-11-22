package de.exxcellent.challenge.controllers;

import de.exxcellent.challenge.bo.BaseBO;
import de.exxcellent.challenge.bo.FootballDataBO;
import de.exxcellent.challenge.bo.WeatherDataBO;
import de.exxcellent.challenge.service.processors.FootballSpreadProcessor;
import de.exxcellent.challenge.service.processors.WeatherSpreadProcessor;
import de.exxcellent.challenge.service.readers.CsvReader;
import de.exxcellent.challenge.service.readers.JsonReader;
import de.exxcellent.challenge.utils.FileReaderUtil;

import java.io.IOException;
import java.util.List;

import static de.exxcellent.challenge.constants.Domain.*;

public class AppController {

    public void processFootballDataFromCSV(String filePath) throws IOException {
        String footballDataCsv = FileReaderUtil.readFile(filePath);
        List<BaseBO> footballData = new CsvReader().read(footballDataCsv, FOOTBALL);
        FootballDataBO teamWithSmallestGoalSpread = new FootballSpreadProcessor().calculateSpread(footballData);
        System.out.printf("Team with smallest goal spread from CSV: %s%n", teamWithSmallestGoalSpread.getTeam());
    }

    public void processFootballDataFromJson(String filePath) throws IOException {
        String footballDataJson = FileReaderUtil.readFile(filePath);
        List<? extends BaseBO> footballData = new JsonReader().read(footballDataJson, FOOTBALL);
        FootballDataBO teamWithSmallestGoalSpread = new FootballSpreadProcessor().calculateSpread(footballData);
        System.out.printf("Team with smallest goal spread from JSON: %s%n", teamWithSmallestGoalSpread.getTeam());
    }

    public void processWeatherDataFromCSV(String filePath) throws IOException {
        String weatherDataCsv = FileReaderUtil.readFile(filePath);
        List<BaseBO> weatherData = new CsvReader().read(weatherDataCsv, WEATHER);
        WeatherDataBO dayWithSmallestTempSpread = new WeatherSpreadProcessor().calculateSpread(weatherData);
        System.out.printf("Day with smallest temperature spread from CSV: Day %s%n", dayWithSmallestTempSpread.getDay());
    }

    public void processWeatherDataFromJson(String filePath) throws IOException {
        String weatherDataJson = FileReaderUtil.readFile(filePath);
        List<? extends BaseBO> weatherData = new JsonReader().read(weatherDataJson, WEATHER);
        WeatherDataBO dayWithSmallestTempSpread = new WeatherSpreadProcessor().calculateSpread(weatherData);
        System.out.printf("Day with smallest temperature spread from JSON: Day %s%n", dayWithSmallestTempSpread.getDay());
    }
}

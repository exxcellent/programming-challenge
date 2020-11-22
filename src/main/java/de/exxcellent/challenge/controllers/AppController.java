package de.exxcellent.challenge.controllers;

import de.exxcellent.challenge.bo.BaseBO;
import de.exxcellent.challenge.constants.Domain;
import de.exxcellent.challenge.service.processors.FootballSpreadProcessor;
import de.exxcellent.challenge.service.processors.WeatherSpreadProcessor;
import de.exxcellent.challenge.service.readers.CsvReader;
import de.exxcellent.challenge.service.readers.JsonReader;
import de.exxcellent.challenge.utils.FileReaderUtil;

import java.io.IOException;
import java.util.List;

public class AppController {

    public void processCSVData(String filePath, Domain domain) throws IOException {
        String csvData =  FileReaderUtil.readFile(filePath);
        List<BaseBO> domainObjectList = new CsvReader().read(csvData, domain);
        switch(domain) {
            case FOOTBALL: new FootballSpreadProcessor().processFootballData(domainObjectList); break;
            case WEATHER: new WeatherSpreadProcessor().processWeatherData(domainObjectList); break;
        }
    }

    public void processJSONData(String filePath, Domain domain) throws IOException {
        String jsonData = FileReaderUtil.readFile(filePath);
        List<? extends BaseBO> domainData = new JsonReader().read(jsonData, domain);
        switch (domain) {
            case FOOTBALL: new FootballSpreadProcessor().processFootballData(domainData); break;
            case WEATHER: new WeatherSpreadProcessor().processWeatherData(domainData); break;
        }
    }
}

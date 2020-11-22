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

import static de.exxcellent.challenge.constants.FileFormat.CSV;
import static de.exxcellent.challenge.constants.FileFormat.JSON;

public class AppController {

    public String processCSVData(String filePath, Domain domain) throws IOException {
        String csvData =  FileReaderUtil.readFile(filePath);
        List<BaseBO> domainObjectList = new CsvReader().read(csvData, domain);
        switch(domain) {
            case FOOTBALL: return new FootballSpreadProcessor().processFootballData(domainObjectList, CSV);
            case WEATHER: return new WeatherSpreadProcessor().processWeatherData(domainObjectList, CSV);
        }
        return null;
    }

    public String processJSONData(String filePath, Domain domain) throws IOException {
        String jsonData = FileReaderUtil.readFile(filePath);
        List<? extends BaseBO> domainData = new JsonReader().read(jsonData, domain);
        switch (domain) {
            case FOOTBALL: return new FootballSpreadProcessor().processFootballData(domainData, JSON);
            case WEATHER: return new WeatherSpreadProcessor().processWeatherData(domainData, JSON);
        }
        return null;
    }
}

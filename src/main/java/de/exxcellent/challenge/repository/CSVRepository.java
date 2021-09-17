package de.exxcellent.challenge.repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.bean.CsvToBeanBuilder;

import de.exxcellent.challenge.App;
import de.exxcellent.challenge.exceptions.CouldNotReadInputFileException;

public class CSVRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(CSVRepository.class);
	
	public List<WeatherLine> findAllWeatherLines(String fromFile) throws CouldNotReadInputFileException {
		List<WeatherLine> weatherLines = new ArrayList<>();
    	URL resource = App.class.getResource(fromFile);
    	
		if (resource == null) {
			LOGGER.error("Could not read the file '{}'. Please provide a class loader reachable URI.", fromFile);
			throw new CouldNotReadInputFileException();
		}
		
		try (InputStream resourceAsStream = resource.openStream()) {
			InputStreamReader reader = new InputStreamReader(resourceAsStream);
			CsvToBeanBuilder<WeatherLine> csvParser = new CsvToBeanBuilder<WeatherLine>(reader).withType(WeatherLine.class);
			weatherLines.addAll(csvParser.build().parse());
		} catch (IOException ioe) {
			LOGGER.error("Could not read the file '{}'. Please provide a class loader reachable URI.", fromFile, ioe);
			throw new CouldNotReadInputFileException(ioe);
		} catch (RuntimeException re) {
			LOGGER.error("Malformed CSV file. Please check the format and column names of the CSV file '{}'.", fromFile, re);
			System.out.println("Malformed CSV file. Please check the format and column names of the CSV file.");
			throw new CouldNotReadInputFileException(re);
		}
		
		if (weatherLines.isEmpty())
    		LOGGER.warn("This file was empty. Please make sure the file '{}' is there and is correct (line breaks, etc).", fromFile);
    	
		return weatherLines;
	}
}
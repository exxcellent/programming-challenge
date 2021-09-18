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
import com.opencsv.bean.FuzzyMappingStrategy;

import de.exxcellent.challenge.App;
import de.exxcellent.challenge.exceptions.CouldNotReadInputFileException;

/**
 * This class hosts the logic to read from a CSV file. I did not (yet) create an interface,
 * since an interface for one class is not efficient. But it can be refactored out easily
 * and the name of the method is already prepared for that.
 * 
 * @author Ralph Löwe <ralph.loewe@gmail.com>
 */
public class CSVRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(CSVRepository.class);
	
	/**
	 * This method can read rows from different CSV file types. The logic which rows to read
	 * is defined in T and clazz.
	 * 
	 * @param <T> The type of CSV row to read from the file.
	 * @param fromFile The file (from the classpath).
	 * @param clazz The type of class needed for the CSV library (sadly).
	 * @return A list of all read rows of the CSV
	 * @throws CouldNotReadInputFileException
	 */
	public <T> List<T> findAllLines(String fromFile, Class<? extends T> clazz) throws CouldNotReadInputFileException {
		List<T> lines = new ArrayList<>();
    	URL resource = App.class.getResource(fromFile);
    	
		if (resource == null) {
			LOGGER.error("Could not read the file '{}'. Please provide a class loader reachable URI.", fromFile);
			throw new CouldNotReadInputFileException();
		}
		
		try (InputStream resourceAsStream = resource.openStream()) {
			InputStreamReader reader = new InputStreamReader(resourceAsStream);
			FuzzyMappingStrategy<T> fuzzyMappingStrategy = new FuzzyMappingStrategy<>();
			fuzzyMappingStrategy.setType(clazz);
			CsvToBeanBuilder<T> csvParser = new CsvToBeanBuilder<T>(reader).withMappingStrategy(fuzzyMappingStrategy);
			lines.addAll(csvParser.build().parse());
		} catch (IOException ioe) {
			LOGGER.error("Could not read the file '{}'. Please provide a class loader reachable URI.", fromFile, ioe);
			throw new CouldNotReadInputFileException(ioe);
		} catch (RuntimeException re) {
			LOGGER.error("Malformed CSV file. Please check the format and column names of the CSV file '{}'.", fromFile, re);
			System.out.println("Malformed CSV file. Please check the format and column names of the CSV file.");
			throw new CouldNotReadInputFileException(re);
		}
		
		if (lines.isEmpty())
    		LOGGER.warn("This file was empty. Please make sure the file '{}' is there and is correct (line breaks, etc).", fromFile);
    	
		return lines;
	}
}
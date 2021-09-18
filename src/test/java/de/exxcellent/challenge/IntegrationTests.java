package de.exxcellent.challenge;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * I decided to only write integration tests at that point since it is a single application
 * that does not expose an API and has only file or stream interfaces. So we test the whole
 * app and every in the instructions suggested case.
 * 
 * A more interwoven app would need another setup of tests.
 * 
 * @author Ralph Löwe <ralph.loewe@googlemail.com>
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "de.exxcellent.challenge.*")
class IntegrationTests {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	// save the original streams in those variables at init time.
	private final PrintStream originalOut = System.out;
	
	private final PrintStream originalErr = System.err;

	@BeforeEach
	public void setUpStreams() {
		// overwrite the streams with PrintStreams to BAOS.
		// This is not the most elegant way, but it depends on the way the application outputs the results.
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@AfterEach
	public void restoreStreams() {
		// Bring back original streams.
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
    @Test
    void runWeatherWithProvidedDataSet() throws IOException {
        App.main("--weather", "weather.csv");
        String allWrittenLines = new String(outContent.toByteArray()); 
        assertTrue(allWrittenLines.contains("Day(s) with smallest temperature spread : 14"));
    }

    @Test
    void runWeatherWithTwoDaysAtMinumum() throws IOException {
        App.main("--weather", "weather_two_days.csv");
        String allWrittenLines = new String(outContent.toByteArray()); 
        assertTrue(allWrittenLines.contains("Day(s) with smallest temperature spread : 141,142"));
    }

    @Test
    void runWeatherWithMalformedDataSet() throws IOException {
		App.main("--weather", "malformed.csv");
        String allWrittenLines = new String(outContent.toByteArray()); 
        assertTrue(allWrittenLines.contains("Malformed CSV file. Please check the format and column names of the CSV file."));
    }

    @Test
    void runWrongArguments() throws IOException {
		App.main("-s", "sadasd");
        String allWrittenLines = new String(outContent.toByteArray()); 
        assertTrue(allWrittenLines.contains("Arguments not known, please check the help listing."));
    }

    @Test
    void runHelp() throws IOException {
		App.main("-h");
        String allWrittenLines = new String(outContent.toByteArray()); 
        assertTrue(allWrittenLines.contains("usage: programming-challenge [-f <arg>] [-h] [-w <arg>]"));
    }

    @Test
    void runWeatherInvalidFile() throws IOException {
		App.main("--weather", "weather_invalid.csv");
        String allWrittenLines = new String(outContent.toByteArray()); 
        assertTrue(allWrittenLines.contains("There is a negative difference at day '10'. Please check you data for validity."));
    }
    
    @Test
    void runWeatherFileNotFound() throws IOException {
		App.main("--weather", "not_found.csv");
        String allWrittenLinesOut = new String(outContent.toByteArray()); 
        assertTrue(allWrittenLinesOut.contains("Could not read the input file. Check if it is reachable by classloader."));
    }

    @Test
    void runFootballWithProvidedDataSet() throws IOException {
        App.main("--football", "football.csv");
        String allWrittenLines = new String(outContent.toByteArray()); 
        assertTrue(allWrittenLines.contains("Team(s) with smallest goal spread : Aston_Villa"));
    }
}
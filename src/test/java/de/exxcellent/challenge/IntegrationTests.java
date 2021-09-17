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
 * Example JUnit 5 test case.
 * @author Ralph Löwe <ralph.loewe@googlemail.com>
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.baeldung.powermockito.introduction.*")
class IntegrationTests {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private final PrintStream originalOut = System.out;
	
	private final PrintStream originalErr = System.err;

	@BeforeEach
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@AfterEach
	public void restoreStreams() {
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
        assertTrue(allWrittenLines.contains("usage: programming-challenge [-h] [-w <arg>]"));
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
}
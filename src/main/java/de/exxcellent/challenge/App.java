package de.exxcellent.challenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.exxcellent.challenge.service.AppService;

/**
 * This is the entry class for the app. It only handles the logging 
 * of the start and end time and propagates the exit code.
 * 
 * @author Ralph Löwe <ralph.loewe@gmail.com>
 */
public final class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
    /**
     * The main function only handles basic logging, printing out the version and calling the central service.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
    	LOGGER.info("Starting app, version 1.0");
    	AppService app = new AppService();
    	app.processData(args);
    	LOGGER.info("End");
    }
}
package de.exxcellent.challenge.service;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.exxcellent.challenge.exceptions.ArgumentsNotUseableException;

public class ArgumentsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArgumentsService.class);
	
	private Options options;
	
	public ArgumentsService() {
		options = new Options();
		
		options.addOption("f", "football", true, "process the soccer results. Resource location via classpath uri.");
		options.addOption("w", "weather", true, "process the weather results. Resource location via classpath uri.");
		options.addOption("h", "help", false, "print this help.");
	}
	
	public CommandLine parseArguments(String[] rawArguments) throws ArgumentsNotUseableException {
		CommandLine cmd;

		try {
			CommandLineParser parser = new DefaultParser();
			cmd = parser.parse( options, rawArguments);
		}
		catch (ParseException e) {
			e.printStackTrace();
			LOGGER.error("Could not parse command line arguments: {}", StringUtils.join(rawArguments, ','));
	    	printHelp();
			throw new ArgumentsNotUseableException(e);
		}
		
		return cmd;
	}

	public void printHelp() {
		String header = "Analyse csv data to get aggregated information.\n\n";
    	String footer = "\nPlease report issues at https://github.com/loewe/programming-challenge";
    	 
    	HelpFormatter formatter = new HelpFormatter();
    	formatter.printHelp("programming-challenge", header, this.options, footer, true);
	}
}

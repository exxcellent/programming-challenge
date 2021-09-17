package de.exxcellent.challenge.service;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.exxcellent.challenge.exceptions.ArgumentsNotUseableException;
import de.exxcellent.challenge.exceptions.CouldNotReadInputFileException;
import de.exxcellent.challenge.repository.CSVRepository;
import de.exxcellent.challenge.repository.WeatherLine;

public class AppService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppService.class);
	
	public void processData(String... args) {
		ArgumentsService arguments = new ArgumentsService();
		
		try {
			CommandLine cmd = arguments.parseArguments(args);
			
			if (cmd.hasOption("h")) {
				arguments.printHelp();
			}
			else if (cmd.hasOption("w")) {
				CSVRepository csvRepo = new CSVRepository();
				List<WeatherLine> weatherLines = csvRepo.findAllWeatherLines(cmd.getOptionValue("w"));
				
				WeatherProcessService weatherProcessing = new WeatherProcessService();
				List<ReportLine> reportLines = weatherProcessing.process(weatherLines);
				
				ReportService reportService = new ReportService();
				reportService.report(reportLines, System.out);
				return;
			}
		} catch (ArgumentsNotUseableException anue) {
			System.out.println("Arguments not known, please check the help listing.");
			LOGGER.warn("Program called with wrong arguments.", anue);
		} catch (CouldNotReadInputFileException cnrife) {
			System.out.println("Could not read the input file. Check if it is reachable by classloader.");
			LOGGER.warn("Could not read the input file.", cnrife);
		}
    	
		arguments.printHelp();
	}
}
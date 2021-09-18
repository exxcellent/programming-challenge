package de.exxcellent.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.exxcellent.challenge.exceptions.ArgumentsNotUseableException;
import de.exxcellent.challenge.exceptions.CouldNotReadInputFileException;
import de.exxcellent.challenge.repository.CSVRepository;
import de.exxcellent.challenge.repository.FootballLine;
import de.exxcellent.challenge.repository.WeatherLine;

/**
 * The app service encapsulates the general control logic and arranges the services.
 * 
 * @author Ralph Löwe <ralph.loewe@gmail.com>
 */
public class AppService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppService.class);
	
	/**
	 * The method calls different services base on the (raw) arguments.
	 * For argument parsing Apache Commons CLI is used.
	 * 
	 * @param args The (raw) arguments from <code>main()</code>.
	 */
	public void processData(String... args) {
		ArgumentsService arguments = new ArgumentsService();
		CSVRepository csvRepo = new CSVRepository();
		MapperService mapper = new MapperService();
		
		try {
			CommandLine cmd = arguments.parseArguments(args);
			List<MinDifferenceItem> minDiffLines = new ArrayList<>();
			ReportLineType reportType = ReportLineType.UNKNOWN;
			
			if (cmd.hasOption("h")) {
				arguments.printHelp();
			}
			else if (cmd.hasOption("w")) {
				List<WeatherLine> weatherLines = csvRepo.findAllLines(cmd.getOptionValue("w"), WeatherLine.class);
				reportType = ReportLineType.DAYS_WITH_MIN_DIFFERENCE;
				minDiffLines.addAll(mapper.convertWeatherLines(weatherLines));
			}
			else if (cmd.hasOption("f")) {
				List<FootballLine> footballLines = csvRepo.findAllLines(cmd.getOptionValue("f"), FootballLine.class);
				reportType = ReportLineType.TEAMS_WITH_MIN_SCORE_DIFFERENCE;
				minDiffLines.addAll(mapper.convertFootballLines(footballLines));
			}
			
			if (cmd.hasOption("w") || cmd.hasOption("f")) {
				MinDifferenceProcessService weatherProcessing = new MinDifferenceProcessService();
				List<ReportLine> reportLines = weatherProcessing.process(minDiffLines, reportType);
				
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
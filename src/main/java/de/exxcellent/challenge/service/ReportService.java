package de.exxcellent.challenge.service;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This service just prints out the result values into standard out. This was suggested in the
 * scaffold of the project. So we just keep it that way.
 * 
 * @author Ralph Löwe <ralph.loewe@gmail.com>
 */
public class ReportService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportService.class);

	/**
	 * Print all report lines.
	 * 
	 * @param reportLines The report lines to convert to a human readable representation.
	 * @param out To a given stream.
	 */
	public void report(List<ReportLine> reportLines, OutputStream out) {
		for (ReportLine reportLine : reportLines) {
			if (ReportLineType.DAYS_WITH_MIN_DIFFERENCE.equals(reportLine.getType())) {
				try (PrintWriter writer = new PrintWriter(out)) {
					writer.printf("Day(s) with smallest temperature spread : %s%n", reportLine.getValue());
				}
			}
			else if (ReportLineType.TEAMS_WITH_MIN_SCORE_DIFFERENCE.equals(reportLine.getType())) {
				try (PrintWriter writer = new PrintWriter(out)) {
					writer.printf("Team(s) with smallest goal spread : %s%n", reportLine.getValue());
				}
			}
			else {
				String name = "unknown";
				if (reportLine.getType() != null)
					name = reportLine.getType().name();
				
				LOGGER.warn("Unsupported report line {}. Please contact the developer.", name);
			}
		}
	}
}
package de.exxcellent.challenge.service;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportService.class);

	public void report(List<ReportLine> reportLines, OutputStream out) {
		
		for (ReportLine reportLine : reportLines) {
			if (ReportLineType.DAYS_WITH_MIN_DIFFERENCE.equals(reportLine.getType())) {
				try (PrintWriter writer = new PrintWriter(out)) {
					writer.printf("Day(s) with smallest temperature spread : %s%n", reportLine.getValue());
				}
			}
			else {
				String name = "unknown";
				if (reportLine.getType() != null)
					name = reportLine.getType().name();
				
				LOGGER.warn("Unsupported report line {}. Please contact the developer.", name);
			}
		}

// TODO: add football results.
//        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
//        System.out.printf("Team with smallest goal spread : %s%n", teamWithSmallestGoalSpread);
//		
	}
}
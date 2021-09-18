package de.exxcellent.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A domain service to process a list of items into a list of report lines.
 *
 * @author Ralph Löwe <ralph.loewe@gmail.com>
 */
public class MinDifferenceProcessService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MinDifferenceProcessService.class);
	
	/**
	 * This method handles the calculation of the min difference between a min and max value.
	 * It also handles some specific things for the reports. One can also decide to split it again,
	 * since there are too many differences. That could be a strategic decision based on the
	 * expected changes or extensions of the app.
	 * 
	 * @param minDiffItems The list of items to process.
	 * @param reportType The target type of report to create lines for.
	 * @return A list of report lines.
	 */
	public List<ReportLine> process(List<MinDifferenceItem> minDiffItems, ReportLineType reportType) {
		Long minDifference = null;
		List<String> labels = new ArrayList<>();
		List<ReportLine> reportLines = new ArrayList<>();
		
    	for (MinDifferenceItem minDiffItem : minDiffItems) {
    		long rowDifference = minDiffItem.getMax() - minDiffItem.getMin();
    		
    		if (rowDifference < 0 && ReportLineType.DAYS_WITH_MIN_DIFFERENCE.equals(reportType)) {
    			LOGGER.warn("There is a negative difference at day '{}'. Please check you data for validity.", minDiffItem.getLabel());
    			System.out.printf("There is a negative difference at day '%s'. Please check you data for validity.%n", minDiffItem.getLabel());
    			continue;
    		}
    		else if (ReportLineType.TEAMS_WITH_MIN_SCORE_DIFFERENCE.equals(reportType))
    			rowDifference = Math.abs(rowDifference);
    		
    		if (minDifference == null)
    			minDifference = rowDifference;
    		
			if (rowDifference < minDifference) {
				labels.clear();
				labels.add(minDiffItem.getLabel());
			    minDifference = rowDifference;
			}
			else if (rowDifference == minDifference)
				labels.add(minDiffItem.getLabel());
    	}

    	String labelsFormated = String.join(",", labels);
    	
    	if (minDifference != null)
    		reportLines.add(new ReportLine(reportType, labelsFormated));
    	
    	return reportLines;
	}
}
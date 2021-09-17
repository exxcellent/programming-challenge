package de.exxcellent.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.exxcellent.challenge.repository.WeatherLine;

public class WeatherProcessService {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherProcessService.class);
	
	public List<ReportLine> process(List<WeatherLine> weatherLines) {
		long minDifference = -1;
		List<Long> days = new ArrayList<>();
		List<ReportLine> reportLines = new ArrayList<>();
		
    	for (WeatherLine bean : weatherLines) {
    		long rowDifference = bean.getMxT() - bean.getMnT();
    		
    		if (rowDifference < 0) {
    			LOGGER.warn("There is a negative difference at day '{}'. Please check you data for validity.", bean.getDay());
    			System.out.printf("There is a negative difference at day '%s'. Please check you data for validity.%n", bean.getDay());
    			continue;
    		}
    		
    		if (minDifference == -1)
    			minDifference = rowDifference;
    		
			if (rowDifference < minDifference) {
				days.clear();
				days.add(bean.getDay());
			    minDifference = rowDifference;
			}
			else if (rowDifference == minDifference)
				days.add(bean.getDay());
    	}

    	StringBuilder daysFormated = new StringBuilder();
    	
    	for (Long day : days) {
    		if (daysFormated.length() != 0)
    			daysFormated.append(",");
    		daysFormated.append(day);
    	}
    	
    	if (minDifference != -1)
    		reportLines.add(new ReportLine(ReportLineType.DAYS_WITH_MIN_DIFFERENCE, daysFormated.toString()));
    	
    	return reportLines;
	}
}
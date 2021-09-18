package de.exxcellent.challenge.service;

import java.util.ArrayList;
import java.util.List;

import de.exxcellent.challenge.repository.FootballLine;
import de.exxcellent.challenge.repository.WeatherLine;

/**
 * Some converter methods to convert the CSV representation into a generic representation for the
 * business model. In that case we convert all into a MinDifferenceItem.
 * 
 * @author Ralph Löwe <ralph.loewe@gmail.com>
 */
public class MapperService {
	public List<MinDifferenceItem> convertFootballLines(List<FootballLine> footballLines) {
		List<MinDifferenceItem> minDifferenceItems = new ArrayList<>();
		
		for (FootballLine footballLine : footballLines) {
			MinDifferenceItem item = new MinDifferenceItem();
			item.setLabel(footballLine.getTeam());
			item.setMax(footballLine.getGoals());
			item.setMin(footballLine.getGoalsAllowed());
			minDifferenceItems.add(item);
		}
		
		return minDifferenceItems;
	}
	
	public List<MinDifferenceItem> convertWeatherLines(List<WeatherLine> weatherLines) {
		List<MinDifferenceItem> minDifferenceItems = new ArrayList<>();
		
		for (WeatherLine weatherLine : weatherLines) {
			MinDifferenceItem item = new MinDifferenceItem();
			item.setLabel(weatherLine.getDay());
			item.setMax(weatherLine.getMxT());
			item.setMin(weatherLine.getMnT());
			minDifferenceItems.add(item);
		}
		
		return minDifferenceItems;
	}
}
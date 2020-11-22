package de.exxcellent.challenge.service.processors;

import de.exxcellent.challenge.bo.BaseBO;
import de.exxcellent.challenge.bo.WeatherDataBO;

import java.util.List;

public class WeatherSpreadProcessor implements SpreadProcessor {

    @Override
    public WeatherDataBO calculateSpread(List<? extends BaseBO> weatherData) {
        return weatherData.stream()
                .map(weatherDataItem -> (WeatherDataBO) weatherDataItem)
                .reduce((WeatherDataBO) weatherData.get(0), (minTemp, curTemp) -> {
                    int currentDifference = getDifference(curTemp.getMaxTemperature(), curTemp.getMinTemperature());
                    int minDifference = getDifference(minTemp.getMaxTemperature(), minTemp.getMinTemperature());
                    return  (minDifference > currentDifference) ? curTemp : minTemp;
                });
    }
}

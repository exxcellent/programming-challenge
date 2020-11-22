package de.exxcellent.challenge.utils;

import de.exxcellent.challenge.bo.BaseBO;
import de.exxcellent.challenge.bo.FootballDataBO;
import de.exxcellent.challenge.bo.WeatherDataBO;

import java.util.List;

public class SpreadCalculatorUtil {

    public static FootballDataBO calculateFootballDataSpread(List<BaseBO> footballData) {
        return footballData.stream()
                .map(teamData -> (FootballDataBO) teamData)
                .reduce((FootballDataBO) footballData.get(0), (minTeam, curTeam) -> {
            int currentDifference = getDifference(curTeam.getGoals(), curTeam.getGoalsAllowed());
            int minDifference = getDifference(minTeam.getGoals(), minTeam.getGoalsAllowed());
            return  (minDifference > currentDifference) ? curTeam : minTeam;
        });
    }

    public static WeatherDataBO calculateWeatherDataSpread(List<BaseBO> weatherData) {
        return weatherData.stream()
                .map(weatherDataItem -> (WeatherDataBO) weatherDataItem)
                .reduce((WeatherDataBO) weatherData.get(0), (minTemp, curTemp) -> {
                    int currentDifference = getDifference(curTemp.getMaxTemperature(), curTemp.getMinTemperature());
                    int minDifference = getDifference(minTemp.getMaxTemperature(), minTemp.getMinTemperature());
                    return  (minDifference > currentDifference) ? curTemp : minTemp;
                });
    }

    private static int getDifference(Integer num1, Integer num2) {
        return Math.abs(num1 - num2);
    }
}

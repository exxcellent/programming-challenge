package de.exxcellent.challenge.bo;

import java.util.List;

public class WeatherDataListBO implements BaseBO {

    private List<WeatherDataBO> weatherData;

    public List<WeatherDataBO> getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(List<WeatherDataBO> weatherData) {
        this.weatherData = weatherData;
    }
}

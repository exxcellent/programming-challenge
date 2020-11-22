package de.exxcellent.challenge.service.readers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.exxcellent.challenge.bo.BaseBO;
import de.exxcellent.challenge.bo.FootballDataListBO;
import de.exxcellent.challenge.bo.WeatherDataListBO;
import de.exxcellent.challenge.constants.Domain;
import de.exxcellent.challenge.factory.BaseBOFactory;

import java.util.List;

public class JsonReader implements Reader {

    @Override
    public List<? extends BaseBO> read(String data, Domain domain) {
        try {
            data = data.replace(System.lineSeparator(), "");
            BaseBO baseBOListItem = new ObjectMapper().readValue(data, BaseBOFactory.getBaseObject(null, domain).getClass());
            switch (domain) {
                case FOOTBALL: return ((FootballDataListBO) baseBOListItem).getFootballData();
                case WEATHER: return ((WeatherDataListBO) baseBOListItem).getWeatherData();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

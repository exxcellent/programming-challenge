package de.exxcellent.challenge.factory;

import de.exxcellent.challenge.bo.*;
import de.exxcellent.challenge.constants.Domain;

public class BaseBOFactory {

    public static BaseBO getBaseObject(String data, Domain domain){
        switch (domain) {
            case FOOTBALL: return (data == null) ? new FootballDataListBO() : new FootballDataBO(data);
            case WEATHER: return (data == null) ? new WeatherDataListBO() : new WeatherDataBO(data);
            default: return null;
        }
    }
}

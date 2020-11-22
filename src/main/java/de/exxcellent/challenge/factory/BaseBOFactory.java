package de.exxcellent.challenge.factory;

import de.exxcellent.challenge.bo.BaseBO;
import de.exxcellent.challenge.bo.FootballDataBO;
import de.exxcellent.challenge.bo.WeatherDataBO;

public class BaseBOFactory {

    public static BaseBO getBaseObject(String data, String objectType){
        if(objectType == null){
            return null;
        }
        if(objectType.equalsIgnoreCase("FOOTBALL")){
            return new FootballDataBO(data);
        } else if(objectType.equalsIgnoreCase("WEATHER")){
            return new WeatherDataBO(data);
        }

        return null;
    }
}

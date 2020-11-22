package de.exxcellent.challenge.bo;

import java.util.List;

public class FootballDataListBO implements BaseBO {

    private List<FootballDataBO> footballData;

    public List<FootballDataBO> getFootballData() {
        return footballData;
    }

    public void setFootballData(List<FootballDataBO> footballData) {
        this.footballData = footballData;
    }
}

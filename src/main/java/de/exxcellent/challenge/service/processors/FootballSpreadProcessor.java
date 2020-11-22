package de.exxcellent.challenge.service.processors;

import de.exxcellent.challenge.bo.BaseBO;
import de.exxcellent.challenge.bo.FootballDataBO;

import java.util.List;

public class FootballSpreadProcessor implements SpreadProcessor {

    @Override
    public FootballDataBO calculateSpread(List<? extends BaseBO> footballData) {
        return footballData.stream()
                .map(teamData -> (FootballDataBO) teamData)
                .reduce((FootballDataBO) footballData.get(0), (minTeam, curTeam) -> {
                    int currentDifference = getDifference(curTeam.getGoals(), curTeam.getGoalsAllowed());
                    int minDifference = getDifference(minTeam.getGoals(), minTeam.getGoalsAllowed());
                    return  (minDifference > currentDifference) ? curTeam : minTeam;
                });
    }
}

package de.exxcellent.challenge.service.processors;

import de.exxcellent.challenge.bo.BaseBO;
import de.exxcellent.challenge.bo.FootballDataBO;
import de.exxcellent.challenge.constants.FileFormat;

import java.util.List;

public class FootballSpreadProcessor implements SpreadProcessor {

    @Override
    public FootballDataBO calculateSpread(List<? extends BaseBO> footballData) {
        return footballData.stream()
                .map(teamData -> (FootballDataBO) teamData)
                .reduce((FootballDataBO) footballData.get(0), (minSpreadTeam, curTeam) -> {
                    int currentDifference = getDifference(curTeam.getGoals(), curTeam.getGoalsAllowed());
                    int minDifference = getDifference(minSpreadTeam.getGoals(), minSpreadTeam.getGoalsAllowed());
                    return  (minDifference > currentDifference) ? curTeam : minSpreadTeam;
                });
    }

    public String processFootballData(List<? extends BaseBO> footballData, FileFormat fileFormat) {
        FootballDataBO teamWithSmallestGoalSpread = new FootballSpreadProcessor().calculateSpread(footballData);
        return "Team with smallest goal spread from " + fileFormat.name() + ": " + teamWithSmallestGoalSpread.getTeam();
    }
}

package de.exxcellent.challenge.bo;

public class FootballDataBO implements BaseBO {

    private String team;
    private Integer games;
    private Integer wins;
    private Integer losses;
    private Integer draws;
    private Integer goals;
    private Integer goalsAllowed;
    private Integer points;

    public FootballDataBO(String footballTeamDataStr) {
        String[] footballTeamData = footballTeamDataStr.split(",");
        this.team = footballTeamData[0];
        this.games = Integer.parseInt(footballTeamData[1]);
        this.wins = Integer.parseInt(footballTeamData[2]);
        this.losses = Integer.parseInt(footballTeamData[3]);
        this.draws = Integer.parseInt(footballTeamData[4]);
        this.goals = Integer.parseInt(footballTeamData[5]);
        this.goalsAllowed = Integer.parseInt(footballTeamData[6]);
        this.points = Integer.parseInt(footballTeamData[7]);
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Integer getDraws() {
        return draws;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getGoalsAllowed() {
        return goalsAllowed;
    }

    public void setGoalsAllowed(Integer goalsAllowed) {
        this.goalsAllowed = goalsAllowed;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}

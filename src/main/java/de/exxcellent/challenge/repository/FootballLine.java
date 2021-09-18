package de.exxcellent.challenge.repository;

import com.opencsv.bean.CsvBindByName;

/**
 * Simple bean to define the rows of the football CSV.
 * 
 * @author Ralph Löwe <ralph.loewe@gmail.com>
 */
public class FootballLine {
	@CsvBindByName
	private String team;
	
	@CsvBindByName
	private long goals;
	
	@CsvBindByName(column = "Goals Allowed")
	private long goalsAllowed;

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public long getGoals() {
		return goals;
	}

	public void setGoals(long goals) {
		this.goals = goals;
	}

	public long getGoalsAllowed() {
		return goalsAllowed;
	}

	public void setGoalsAllowed(long goalsAllowed) {
		this.goalsAllowed = goalsAllowed;
	}
}
package de.exxcellent.challenge.service;

/**
 * The following report types are possible:
 * - DAYS_WITH_MIN_DIFFERENCE: The (potential multiple) days with a min temperature difference.
 * - TEAMS_WITH_MIN_SCORE_DIFFERENCE: The teams with the minimum goal difference.
 * - UNKNOWN: Alway have a default value as spare.
 * 
 * @author Ralph Löwe <ralph.loewe@gmail.com>
 */
public enum ReportLineType {
	DAYS_WITH_MIN_DIFFERENCE,
	TEAMS_WITH_MIN_SCORE_DIFFERENCE,
	UNKNOWN;
}
package de.exxcellent.challenge.service;

/**
 * A report line that is defined by a enum as a type and a value. The text for the output
 * is managed in the ReportService
 * 
 * @author Ralph Löwe <ralph.loewe@gmail.com>
 */
public class ReportLine {
	private ReportLineType type;
	
	private String value;
	
	public ReportLine(ReportLineType type, String value) {
		this.type = type;
		this.value = value;
	}

	public ReportLineType getType() {
		return type;
	}

	public void setType(ReportLineType type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
package de.exxcellent.challenge.service;

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
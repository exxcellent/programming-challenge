package de.exxcellent.challenge.service;

/**
 * A domain class for the (generic) business model of finding out a minimum value between two (long) numbers.
 * 
 * @author Ralph Löwe <ralph.loewe@gmail.com>
 */
public class MinDifferenceItem {
	private String label;
	
	private long min;
	
	private long max;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public long getMin() {
		return min;
	}

	public void setMin(long min) {
		this.min = min;
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		this.max = max;
	}
}
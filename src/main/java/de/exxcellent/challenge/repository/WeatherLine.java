package de.exxcellent.challenge.repository;

import com.opencsv.bean.CsvBindByName;

/**
 * Simple bean to define the rows of the weather CSV.
 * 
 * @author Ralph Löwe <ralph.loewe@gmail.com>
 */
public class WeatherLine {
	@CsvBindByName
	private String day;
	
	@CsvBindByName
	private long mxT;
	
	@CsvBindByName
	private long mnT;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public long getMxT() {
		return mxT;
	}

	public void setMxT(long mxT) {
		this.mxT = mxT;
	}

	public long getMnT() {
		return mnT;
	}

	public void setMnT(long mnT) {
		this.mnT = mnT;
	}
}
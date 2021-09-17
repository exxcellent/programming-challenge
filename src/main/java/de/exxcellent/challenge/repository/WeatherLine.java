package de.exxcellent.challenge.repository;

import com.opencsv.bean.CsvBindByName;

public class WeatherLine {
	@CsvBindByName
	private long day;
	
	@CsvBindByName
	private long mxT;
	
	@CsvBindByName
	private long mnT;

	public long getDay() {
		return day;
	}

	public void setDay(long day) {
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
package com.example.timeconverter;

public enum Period {
	PM ("PRE_MATCH"),
	H1 ("FIRST_HALF"),
	HT ("HALF_TIME"),
	H2 ("SECOND_HALF"),
	FT ("FULL_TIME");
	
	private String period;

	private Period(String period) {
		this.period = period;
	}

	public String getPeriod() {
		return period;
	}
}

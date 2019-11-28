package com.example.timeconverter;

public class StringTimeConverter {
	
	private String period;
	private Time time;
	
	public StringTimeConverter () {
		this.time = new Time();
	}
	
	public String convert (String arg) {
		
		checkString(arg);
		
		this.period = this.findPeriod(arg);
		
		this.time = this.findTime(arg);
		
		String output = this.outputGenerator(this.time, this.period);
		
		return output;
	}

	public String outputGenerator(Time time, String period) {
		
		// TODO Additional time for first and second half
		
		//increase seconds and minutes
		if(time.getMillisecond()>=500) {
			if(time.getSecond()==59) {
				time.setSecond(0);
				time.setMinute(time.getMinute()+1);
			}else {
				time.setSecond(time.getSecond()+1);
			}
		}
		
		Time additionalTime = new Time();
		
		//first half
		// || Period.H2.equals(period) || Period.FT.equals(period) ) {
		if(Period.H1.equals(period) && time.getMinute().equals(45)) {
			additionalTime.setMinute(time.getMinute()-45);
			additionalTime.setSecond(time.getSecond());
		}
		//second half
		else()
		
		
		return time.toStringShort() + " – " + period;
	}

	public void checkString(String arg) {
		// TODO Auto-generated method stub
		
	}

	public Time findTime(String arg) {
		String[] timeTemp1 = arg.split(" ");
		
		String[] timeTemp2 = timeTemp1[1].split("\\.");
		
		String[] timeTemp3 = timeTemp2[0].split(":");
				
		this.time.setMinute(Integer.parseInt(timeTemp3[0]));
		this.time.setSecond(Integer.parseInt(timeTemp3[1]));
		this.time.setMillisecond(Integer.parseInt(timeTemp2[1]));
		
		return time;
	}

	public String findPeriod(String arg) {
		String[] temp = arg.split(" ");
		
		temp[0] = temp[0].replace("[", "");
		temp[0] = temp[0].replace("]", "");
		
		Period period = Period.valueOf(temp[0]);
		this.period = period.getPeriod();
		return this.period;
	}
	
	

}

package com.example.timeconverter;

public class StringTimeConverter {
	
	private String period;
	private Time time;
	
	public StringTimeConverter () {
		this.time = new Time();
	}
	
	public String convert (String arg) {
		String output;
		try{
			this.period = this.findPeriod(arg);
			this.time = this.findTime(arg);
			output = this.outputGenerator(this.time, this.period);
		}catch (Exception e) {
			output = "INVALID";
		}	
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
		boolean thereIsAdditionalTime = false;
		
		//first half
		if(Period.H1.getPeriod().equals(period) && time.getMinute()>=45) {
			additionalTime.setMinute(time.getMinute()-45);
			additionalTime.setSecond(time.getSecond());
			time.setMinute(45);
			time.setSecond(0);
			thereIsAdditionalTime = true;
		}
		//second half
		else if((Period.H2.getPeriod().equals(period) || Period.FT.getPeriod().equals(period)) && time.getMinute()>=90) {
			additionalTime.setMinute(time.getMinute()-90);
			additionalTime.setSecond(time.getSecond());
			time.setMinute(90);
			time.setSecond(0);
			thereIsAdditionalTime = true;
		}
		
		if (thereIsAdditionalTime) {
			return time.toStringShort() + " +"+additionalTime.toStringShort() + " – " + period;
		}else {
			return time.toStringShort() + " – " + period;
		}	
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

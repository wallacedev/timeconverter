package com.example.timeconverter;

public class Time {
	private Integer minute;
	private Integer second;
	private Integer millisecond;
	
	public Time() {
	}
	
	public Time(Integer minute, Integer second, Integer millisecond) {
		super();
		this.minute = minute;
		this.second = second;
		this.millisecond = millisecond;
	}

	public String toStringShort() {
		return String.format("%02d", minute)+":"+String.format("%02d", second); 
	}
	
	public Integer getMinute() {
		return minute;
	}
	public void setMinute(Integer minute) {
		this.minute = minute;
	}
	public Integer getSecond() {
		return second;
	}
	public void setSecond(Integer second) {
		this.second = second;
	}
	public Integer getMillisecond() {
		return millisecond;
	}
	public void setMillisecond(Integer millisecond) {
		this.millisecond = millisecond;
	}
	
	
}

package com.example.timeconverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringTimeConverterTest{

	StringTimeConverter stringTimeConverter = new StringTimeConverter();
	
	@Test
    public void testOutputGenerator() {
		assertEquals("00:16 – FIRST_HALF", stringTimeConverter.outputGenerator(new Time(0,15,987), "FIRST_HALF"));
		assertEquals("00:15 – FIRST_HALF", stringTimeConverter.outputGenerator(new Time(0,15,209), "FIRST_HALF"));
	}
	
	@Test
	public void testFindPeriod() {
		assertEquals("PRE_MATCH", stringTimeConverter.findPeriod("[PM] 0:00.000"));
	}
	
	@Test
	public void testFindTime() {
		//assertEquals(new Time(46,15,752), stringTimeConverter.findTime("[H1] 46:15.752"));
	}
	
	@Test
	public void testConvert() {
		assertEquals("00:00 – PRE_MATCH", stringTimeConverter.convert("[PM] 0:00.000"));
		assertEquals("00:15 – FIRST_HALF", stringTimeConverter.convert("[H1] 0:15.025"));
		assertEquals("45:01 – SECOND_HALF", stringTimeConverter.convert("[H2] 45:00.500"));
		assertEquals("46:00 – SECOND_HALF", stringTimeConverter.convert("[H2] 45:59.700"));
		
	}
	
	
}

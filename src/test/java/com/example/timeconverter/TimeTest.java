package com.example.timeconverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimeTest {

	@Test
	public void testFindTime() {
		Time time = new Time(2,5,758);
		assertEquals("02:05", time.toStringShort());
	}
}

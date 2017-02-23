package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class EscapeTimeExceedsTest {

	@Test
	public void Mandelbrottest() {
	Main mn = new Main();
	int coordinates = mn.Mandelbrot(0.5946289062500001, 1.2949218750000122);// x and y coordinates outside the range
	assertEquals(1,coordinates);// should return 1 if escape time for a coordinate whose distance from the origin  exceeds the escape distance 
	
	
	
	
	}



	@Test
	public void Juliatest() {
	Main mn = new Main();
	int coordinates = mn.Julia(1.6933593749999853, 0.9765625);// x and y coordinates outside the range
	assertEquals(1,coordinates);;// should return 1 if escape time for a coordinate whose distance from the origin  exceeds the escape distance 
	
	}
	
	
	
	@Test
	public void Multibrottest() {
	Main mn = new Main();
	int coordinates = mn.Multibrot(0.9921875, 1.05625);// x and y coordinates outside the range
	assertEquals(1,coordinates);;// should return 1 if escape time for a coordinate whose distance from the origin  exceeds the escape distance 
	
	}}
	
	
	
	
	
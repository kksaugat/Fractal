package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class EscapeTimeTests {

	@Test
	public void Mandelbrottest() {
	Main mn = new Main();
	int coordinates = mn.Mandelbrot(0.3207031250000001, -0.07109374999999386);// x and y coordinates within the range
	assertEquals(255,coordinates); // should return 255 if escape time for a coordinate whose distance from the origin never exceeds the escape distance 
	
	
	
	
	}



	@Test
	public void Juliatest() {
	Main mn = new Main();
	int coordinates = mn.Julia(1.0492187499999897, -0.234375);// x and y coordinates within the range
	assertEquals(255,coordinates);// should return 255 if escape time for a coordinate whose distance from the origin never exceeds the escape distance 
	
	
	}
	
	
	@Test
	public void BurningShiptest() {
	Main mn = new Main();
	int coordinates = mn.BurningShip(-1.7443359374999874, -0.017451171875000338);// x and y coordinates within the range
	assertEquals(255,coordinates); // should return 255 if escape time for a coordinate whose distance from the origin never exceeds the escape distance 
	
	}
	
	@Test
	public void Multibrottest() {
	Main mn = new Main();
	int coordinates = mn.Multibrot(0.5859375, 0.24375000000000108);// x and y coordinates within the range
	assertEquals(255,coordinates);// should return 255 if escape time for a coordinate whose distance from the origin never exceeds the escape distance 
	
	}}
	
	
	
	
	
package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class mainTest {

	@Test
	public void testMandelbrot() {
		//Should test that x,y given is within acceptable range: x(-2.15:0.6), y(-1.3:1.3)
		main m = new main();
		int result = m.Mandelbrot(0.5, 1.0);
		int result2 = m.Mandelbrot(2, 2.0);
		System.out.println("result is: " + result);
		assertEquals("Your calculation for escapeTime is incorrect", 1, result);
		assertEquals("should be false if out of range", result2, 0); //What should it return for out of range value?
	}

	@Test
	public void testJulia(){
		//ranges x(-1.7 : 1.7) y(-1.0 : 1.0)	
		main m = new main();
		int result = m.Julia(-1.0, 1.0);// ranges are acceptable ,returns escapeTime
		int result2 = m.Julia(-2.0 , 2.0);//ranges are outside of acceptable, returns 0
		assertEquals(2, result);
		assertEquals(0, result2); //should return 0 since the x,y values are out of range
	}
	
	@Test
	public void testBurningShip(){
		//ranges x(-1.7 : -1.8) y(-.08 : .025)
		main m = new main();
		int result = m.BurningShip(-1.75, .01); //within range
		int result2 = m.BurningShip(2.0, .03); //out of acceptable range
		assertEquals(2, result); 
		assertEquals(0, result2); //out of range so should return 0
	}
	
	@Test
	public void Multibrot(){
		main m = new main();
		int result = m.Multibrot(.50, 1.0); //within range
		int result2 = m.Multibrot(-1.2, 1.0); //out of acceptable range
		assertEquals(2, result);
		assertEquals(0, result2); //out of range so should return 0
	}
	
}
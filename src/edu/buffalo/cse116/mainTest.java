package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class mainTest {

	@Test
	public void testMandelbrot() {
		//Should test that x,y given is within acceptable range: x(-2.15:0.6), y(-1.3:1.3)
		main m = new main();
		int result = m.Mandelbrot(0.5, 1.0);
		System.out.println("result is: " + result);
		assertEquals(result,2,0);
	}

}

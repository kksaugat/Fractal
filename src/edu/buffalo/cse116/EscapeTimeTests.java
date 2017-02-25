package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class EscapeTimeTests {

	@Test
	public void Mandelbrottest() {
	main mn = new main();
	int coordinates = mn.Mandelbrot(0.3207031250000001, -0.07109374999999386);// x and y coordinates within the range
	assertEquals(255,coordinates); // should return 255 if escape time for a coordinate whose distance from the origin never exceeds the escape distance 
	
	
	
	
	}



	@Test
	public void Juliatest() {
	main mn = new main();
	int coordinates = mn.Julia(1.0492187499999897, -0.234375);// x and y coordinates within the range
	assertEquals(255,coordinates);// should return 255 if escape time for a coordinate whose distance from the origin never exceeds the escape distance 
	
	
	}
	
	
	@Test
	public void BurningShiptest() {
	main mn = new main();
	int coordinates = mn.BurningShip(-1.7443359374999874, -0.017451171875000338);// x and y coordinates within the range
	assertEquals(255,coordinates); // should return 255 if escape time for a coordinate whose distance from the origin never exceeds the escape distance 
	
	}
	
	@Test
	public void Multibrottest() {
	main mn = new main();
	int coordinates = mn.Multibrot(0.5859375, 0.24375000000000108);// x and y coordinates within the range
	assertEquals(255,coordinates);// should return 255 if escape time for a coordinate whose distance from the origin never exceeds the escape distance 
	
	}
	
	@Test
	public void burningShipPixelTest(){
		main mn = new main();
		int[][] arr = mn.setArrBurningShip();
		int x= 0;
		int y= 0;
		
		while(y<512){
			x = 0;
			while(x < 512){
				int escapeTime = arr[x][y];
				assertEquals(255, escapeTime);
				x++;
			}
			y++;
		}
	}
	
	@Test
	public void MandelBrotSize(){
		main mn = new main();
		int[][] arr = mn.setArrMadelBrot();
		int x= 0;
		int y= 0;
		int xCounter = 0; //should be equal to 512*512 since it goes through 512 rows with 512 columns each
		int yCounter = 0; //should return 512
		
		while(y<512){
			x = 0;
			while(x < 512){
				int escapeTime = arr[x][y];
				xCounter++;
				x++;
			}
			yCounter++;
			y++;
		}
		assertEquals(262144, xCounter);
		assertEquals(512, yCounter);
	}
	
	@Test
	public void JuliaSize(){
		main mn = new main();
		int[][] arr = mn.setArrJulia();
		int x= 0;
		int y= 0;
		int xCounter = 0; //should be equal to 512*512 since it goes through 512 rows with 512 columns each
		int yCounter = 0; //should return 512
		
		while(y<512){
			x = 0;
			while(x < 512){
				int escapeTime = arr[x][y];
				xCounter++;
				x++;
			}
			yCounter++;
			y++;
		}
		assertEquals(262144, xCounter);
		assertEquals(512, yCounter);
	}
	
	@Test
	public void BurningShipSize(){
		main mn = new main();
		int[][] arr = mn.setArrBurningShip();
		int x= 0;
		int y= 0;
		int xCounter = 0; //should be equal to 512*512 since it goes through 512 rows with 512 columns each
		int yCounter = 0; //should return 512
		
		while(y<512){
			x = 0;
			while(x < 512){
				int escapeTime = arr[x][y];
				xCounter++;
				x++;
			}
			yCounter++;
			y++;
		}
		assertEquals(262144, xCounter);
		assertEquals(512, yCounter);
	}
	
	@Test
	public void MultBrotSize(){
		main mn = new main();
		int[][] arr = mn.setArrMultiBrot();
		int x= 0;
		int y= 0;
		int xCounter = 0; //should be equal to 512*512 since it goes through 512 rows with 512 columns each
		int yCounter = 0; //should return 512
		
		while(y<512){
			x = 0;
			while(x < 512){
				int escapeTime = arr[x][y]; //makes sure x/y doesnt go past 512 and throws an outOfBounds execption if it does
				xCounter++;
				x++;
			}
			yCounter++;
			y++;
		}
		assertEquals(262144, xCounter);
		assertEquals(512, yCounter);
	}
	
	
}
	
	
	
	
	
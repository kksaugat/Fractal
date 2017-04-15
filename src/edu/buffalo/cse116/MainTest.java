package edu.buffalo.cse116;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
public class MainTest {

		@Test
		public void MandelbrotTimeExceedsTest() {
		Main mn = new Main();
		int coordinates = mn.Mandelbrot(0.5946289062500001, 1.2949218750000122);// x and y coordinates outside the range
		assertEquals(1,coordinates);// should return 1 if escape time for a coordinate whose distance from the origin  exceeds the escape distance
		}



		@Test
		public void JuliaimeExceedsTestTest() {
		Main mn = new Main();
		int coordinates = mn.Julia(1.6933593749999853, 0.9765625);// x and y coordinates outside the range
		assertEquals(1,coordinates);;// should return 1 if escape time for a coordinate whose distance from the origin  exceeds the escape distance
		}



		@Test
		public void MultibrotimeExceedsTestTest() {
		Main mn = new Main();
		int coordinates = mn.Multibrot(0.9921875, 1.05625);// x and y coordinates outside the range
		assertEquals(1,coordinates);// should return 1 if escape time for a coordinate whose distance from the origin  exceeds the escape distance
		}

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
		}

		@Test
		public void burningShipPixelTest(){
			Main mn = new Main();
			int[][] arr = mn.setArrBurningShip();
			int x= 0;
			int y= 0;

			while(y<512){//While loop goes through burningShips int[][] and makes sure nothing equals 1||0
				x = 0;
				while(x < 512){
					int escapeTime = arr[x][y];
					assertFalse((escapeTime == 1 ||escapeTime == 0)); //makes sure escapeTime ==1 || ==0 is false
					x++;
				}
				y++;
			}
		}

		@Test
		public void MandelBrotSize(){
			Main mn = new Main();
			int[][] arr = mn.setArrMandelBrot();
			int x= 0;
			int y= 0;
			int xCounter = 0; //should be equal to 512*512 since it goes through 512 rows with 512 columns each
			int yCounter = 0; //should return 512

			while(y<512){
				x = 0;
				while(x < 512){
					int escapeTime = arr[x][y]; // makes sure nothing goes out of bounds
					xCounter++; //counts each time x is increased
					x++;
				}
				yCounter++;//counts each time y is increased
				y++;
			}
			assertEquals(262144, xCounter); //xCounter == 262144
			assertEquals(512, yCounter);	//yCounter == 512
		}

		@Test
		public void JuliaSize(){
			Main mn = new Main();
			int[][] arr = mn.setArrJulia();
			int x= 0;
			int y= 0;
			int xCounter = 0; //should be equal to 512*512 since it goes through 512 rows with 512 columns each
			int yCounter = 0; //should return 512

			while(y<512){
				x = 0;
				while(x < 512){
					int escapeTime = arr[x][y]; //makes sure nothing goes out of bounds
					xCounter++;//counts each time x is increased
					x++;
				}
				yCounter++;//counts each time y is increased
				y++;
			}
			assertEquals(262144, xCounter);
			assertEquals(512, yCounter);
		}

		@Test
		public void BurningShipSize(){
			Main mn = new Main();
			int[][] arr = mn.setArrBurningShip();
			int x= 0;
			int y= 0;
			int xCounter = 0; //should be equal to 512*512 since it goes through 512 rows with 512 columns each
			int yCounter = 0; //should return 512

			while(y<512){
				x = 0;
				while(x < 512){
					int escapeTime = arr[x][y]; //makes sure nothing goes out of bounds
					xCounter++; //counts each time x is increased
					x++;
				}
				yCounter++; //counts each time y is increased
				y++;
			}
			assertEquals(262144, xCounter);
			assertEquals(512, yCounter);
		}

		@Test
		public void MultBrotSize(){
			Main mn = new Main();
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
		
		@Test
		public void xTranslateMultiBrot(){
			Main m = new Main();
			int rowToTranslate = 0; //row we want to copy and move
			int xCoord = 1; //row that we want to copy to 
			int[][] array = m.setArrMultiBrot(); //populates a 2d Array
			int[][] arrayAfterTranslate = m.translateRow(array, rowToTranslate, xCoord);  //calls translateRow();
				
				for(int y = 0; y < 512; y++){	//loops through all coordinates at xCoord
					int rowOriginal = array[rowToTranslate][y];  //
					int rowNew = arrayAfterTranslate[xCoord][y];
					assertEquals(rowOriginal, rowNew);
				}
		}
		@Test
		public void yTranslateMultiBrot(){
			Main m = new Main();
			int columnToCopy = 0; //row we want to copy and move
			int yCoord = 30; //row that we want to copy to 
			int[][] array = m.setArrMultiBrot(); //populates a 2d Array
			int[][] arrayAfterTranslate = m.translateColumn(array, columnToCopy, yCoord);  //calls translateColumn();
				
				for(int x = 0; x < 512; x++){ //loops through all 512 X values at yCoord
					int columnOriginal = array[x][columnToCopy]; 
					int columnNew = arrayAfterTranslate[x][yCoord]; 
					assertEquals(columnOriginal, columnNew); //makes sure each column is equal at the same x value
				}
		}
		@Test
		public void xTranslateBurningShip(){
			Main m = new Main();
			int rowToTranslate = 1; //row we want to copy and move
			int xCoord = 421; //row that we want to copy to 
			int[][] array = m.setArrBurningShip(); //populates a 2d Array
			int[][] arrayAfterTranslate = m.translateRow(array, rowToTranslate, xCoord);  //calls translateRow();
				
				for(int y = 0; y < 512; y++){	//loops through all 512 Y values at xCoord
					int rowOriginal = array[rowToTranslate][y];  //
					int rowNew = arrayAfterTranslate[xCoord][y];
					assertEquals(rowOriginal, rowNew);
				}
		}
		@Test
		public void yTranslateBurningShip(){
			Main m = new Main();
			int columnToCopy = 0; //row we want to copy and move
			int yCoord = 91; //row that we want to copy to 
			int[][] array = m.setArrBurningShip(); //populates a 2d Array
			int[][] arrayAfterTranslate = m.translateColumn(array, columnToCopy, yCoord);  //calls translateColumn();
				
				for(int x = 0; x < 512; x++){ //loops through all 512 X values at yCoord
					int columnOriginal = array[x][columnToCopy]; 
					int columnNew = arrayAfterTranslate[x][yCoord]; 
					assertEquals(columnOriginal, columnNew); //makes sure each column is equal at the same x value
				}
		}
		@Test
		public void xTranslateJulia(){
			Main m = new Main();
			int rowToTranslate = 3; //row we want to copy and move
			int xCoord = 92; //row that we want to copy to 
			int[][] array = m.setArrJulia(); //populates a 2d Array
			int[][] arrayAfterTranslate = m.translateRow(array, rowToTranslate, xCoord);  //calls translateRow();
				
				for(int y = 0; y < 512; y++){	//loops through all 512 Y values at xCoord
					int rowOriginal = array[rowToTranslate][y];  //
					int rowNew = arrayAfterTranslate[xCoord][y];
					assertEquals(rowOriginal, rowNew);
				}
		}
		@Test
		public void yTranslateJulia(){
			Main m = new Main();
			int columnToCopy = 0; //row we want to copy and move
			int yCoord = 30; //row that we want to copy to 
			int[][] array = m.setArrJulia(); //populates a 2d Array
			int[][] arrayAfterTranslate = m.translateColumn(array, columnToCopy, yCoord);  //calls translateColumn();
				
				for(int x = 0; x < 512; x++){ //loops through all 512 X values at yCoord
					int columnOriginal = array[x][columnToCopy]; 
					int columnNew = arrayAfterTranslate[x][yCoord]; 
					assertEquals(columnOriginal, columnNew); //makes sure each column is equal at the same x value
				}
		}
		@Test
		public void xTranslateMadelBrot(){
			Main m = new Main();
			int rowToTranslate = 511; //row we want to copy and move
			int xCoord = 3; //row that we want to copy to 
			int[][] array = m.setArrBurningShip(); //populates a 2d Array
			int[][] arrayAfterTranslate = m.translateRow(array, rowToTranslate, xCoord);  //calls translateRow();
				
				for(int y = 0; y < 512; y++){	//loops through all 512 Y values at xCoord
					int rowOriginal = array[rowToTranslate][y];  //
					int rowNew = arrayAfterTranslate[xCoord][y];
					assertEquals(rowOriginal, rowNew);
				}
		}
		@Test
		public void yTranslateMadelBrot(){
			Main m = new Main();
			int columnToCopy = 44; //row we want to copy and move
			int yCoord = 122; //row that we want to copy to 
			int[][] array = m.setArrBurningShip(); //populates a 2d Array
			int[][] arrayAfterTranslate = m.translateColumn(array, columnToCopy, yCoord);  //calls translateColumn();
				
				for(int x = 0; x < 512; x++){ //loops through all 512 X values at yCoord
					int columnOriginal = array[x][columnToCopy]; 
					int columnNew = arrayAfterTranslate[x][yCoord]; 
					assertEquals(columnOriginal, columnNew); //makes sure each column is equal at the same x value
				}
		}
		
 	//When maximum escape time is set to 135 and distance to 2
	@Test
	public void newMandelbrotTest (){
	 Main mn = new Main();
	int result = (mn.newescapeDistanceMandelBrot(0.3207031250000001, -0.07109374999999386));
	assertEquals(135,result);// should return the maximum escape time which is 135
	}

	public void JuliaSet (){
    Main mn = new Main();
	int result = (mn.newescapeDistanceJuila(1.0492187499999897, -0.234375));
	assertEquals(135,result);// should return the maximum escape time which is 135
	}
	
	
	public void BurningShipTest (){
    Main mn = new Main();
	int result = (mn.newescapeDistanceBurningShip(-1.7443359374999874, -0.017451171875000338));
	assertEquals(135,result);// should return the maximum escape time which is 135
	}
	
	
	public void MultiBrotTest(){
    Main mn = new Main();
	int result = (mn.newescapeDistanceMultiBrot(0.5859375, 0.24375000000000108));
	assertEquals(135,result);// should return the maximum escape time which is 135
	}

}

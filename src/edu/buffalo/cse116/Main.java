package edu.buffalo.cse116;

// GENERAL IDEA:
//Set xCalc = current point's x-coordinate
//Set yCalc = current point's y-coordinate
//Set dist = distance from the point (xCalc, yCalc) to (0,0) using the Pythagorean theorem
//Set passes = 0
//While dist ≤ 4 and passes < 255 do
//  Update xCalc and yCalc equal using the update function defined for the fractal being generated
//  Increase passes by 1
//  Set dist distance from the point (xCalc, yCalc) to (0,0) using the Pythagorean theorem
//EndWhile
//Set the current point's escape-time equal to passes 


//PHASE 1:
   // CALC ESACAPE-TIME FOR EACH FRACTAL
public class Main  {
	
	double xPoint;
	double yPoint;
	private static double distance;

	public void setEscDist(double dist){
		distance = dist;
	}
	public int Mandelbrot(double x, double y){//Taking our coordinates as input
		
			double xCalc = x;   // X' 
			double yCalc = y;   // Y'
			double dist=Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));;  // Distance
			int passes = 0; // # of passes
		
			while (dist <=2 && passes <255){ //Arbitrary values used for loop
				xCalc = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + x; 
				yCalc = 2 * xCalc * yCalc + y;
				passes++;
				dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2)); //Distance using pythag
		
			}
			int escapeTime = passes;			
			return escapeTime;
		}
//		x' = x² - y² + current point's x-coordinate
//		y' = 2 * x * y + current point's y-coordinate
//		   where x and y are the values of xCalc and yCalc prior to this update and x' and y' are their values after the update.
//		X-coordinate range from -2.15 to 0.6
//		Y-coordinate range from -1.3 to 1.3
	
	
	public int Julia(double x, double y){
		
			double xCalc = x;   // X' 
			double yCalc= y;   // Y'
			double dist=Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));;  // Distance
			int passes = 0; // # of passes
		
			while (dist <=2 && passes <255){ //Arbitrary values used for loop
				xCalc = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) - 0.72689; 
				yCalc = 2 * xCalc * yCalc + 0.188887;
				passes++;
				dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2)); //Distance using pythag
				
			}
			int escapeTime = passes;
            return escapeTime;
		}
//		x' = x² - y² + -0.72689
//		y' = 2 * x * y + 0.188887
//		   where x and y are the values of xCalc and yCalc prior to this update and x' and y' are their values after the update.
//		X-coordinate range from -1.7 to 1.7
//		Y-coordinate range from -1.0 to 1.0
	
	
	public int BurningShip(double x, double y){
		
			double xCalc = x;   // X' 
			double yCalc = y;   // Y'
			double dist=Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));;  // Distance
			int passes = 0; // # of passes
		
			while (dist <=2 && passes <255){ //Arbitrary values used for loop
				xCalc = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + x; 
				yCalc = Math.abs(2 * xCalc * yCalc) + y;
				passes++;
				dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2)); //Distance using pythag
				
				
			}
			int escapeTime = passes;
		    return escapeTime;
		}
//		x' = x² - y² + current point's x-coordinate
//		y' = Math.abs(2 * x * y) + current point's y-coordinate
//		   where x and y are the values of xCalc and yCalc prior to this update and x' and y' are their values after the update.
//		X-coordinate range from -1.8 to -1.7
//		Y-coordinate range from -0.08 to 0.025
	

	public int Multibrot(double x, double y){
		
			double xCalc = x;
			double yCalc = y;
			double dist =Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));;
			int passes = 0;
			
			while(dist<=2 && passes <255){
				xCalc = Math.pow(xCalc, 3) - (3 * xCalc * Math.pow(yCalc, 2)) + x;
				yCalc = (3*Math.pow(xCalc, 2) * yCalc) - Math.pow(yCalc, 3) + y;
				passes++;
				dist = Math.sqrt(Math.pow(xCalc, 2)+ Math.pow(yCalc, 2));
	
			
			
			}
			int escapeTime = passes;
            return escapeTime;
			
			
		}
		
		//x' = x³ - (3 * x * y²) + current point's x-coordinate
		//y' = (3 * x² * y) - y³ + current point's y-coordinate
		  // where x and y are the values of xCalc and yCalc prior to this update and x' and y' are their values after the update.
	//	X-coordinate range from -1 to 1
		//Y-coordinate range from -1.3 to 1.3
	
	
	
	
	public int[][] setArrMultiBrot(){ //x and y values = array[x][y] and sets xPoint and yPoint in array 
		
			double xMin = -1.0; //ranges
			double xMax = 1.0;
			double yMin = -1.3;
			double yMax = 1.3;
		
			double xSpacing = (xMax-xMin)/512; //sets spacing between x values
			double ySpacing = (yMax-yMin)/512;	//sets spacing between y values
			int y = 0;
			int x = 0;
			int[][] fractalFinal = new int[512][512]; //records each indicies escapeTime
		
				while(y < 512 ){ //goes through array 
					x = 0;
			
						while(x < 512){
							xPoint = xMin + (x * xSpacing); 
							yPoint = yMin + (y * ySpacing);
							fractalFinal[x][y] = Multibrot(xPoint, yPoint); //determines escape time of xPoint/yPoint
							x++;
			
						}
						y++;
				}
		
		return fractalFinal;
		
	}
	
	public int[][] setArrBurningShip(){ //x and y values = array[x][y] and sets xPoint and yPoint in array 
		
		double xMin = -1.8; //Ranges
		double xMax = -1.7;
		double yMin = -.08;
		double yMax = .025;
	
		double xSpacing = (xMax-xMin)/512; //sets spacing between x values
		double ySpacing = (yMax-yMin)/512;	//sets spacing between y values
		int y = 0;
		int x = 0;
		int[][] fractalFinal = new int[512][512]; //records each indicies escapeTime
	
			while(y < 512 ){ //goes through array 
				x = 0;
		
					while(x < 512){
						xPoint = xMin + (x * xSpacing); //starts at min range and is increased by the position in the row int[X][]*xspacing
						yPoint = yMin + (y * ySpacing); //same as xPoint but with the y coords
						fractalFinal[x][y] = BurningShip(xPoint, yPoint); //determines escape time of xPoint/yPoint
						x++;
		
					}
					y++; 
			}
	
	return fractalFinal;
	
}
	
	public int[][] setArrJulia(){ //x and y values = array[x][y] and sets xPoint and yPoint in array 
		
			double xMin = -1.7;
			double xMax = 1.7;		//Sets the ranges for x
			double yMin = -1.0;		//sets the ranges for y
			double yMax = 1.0;
	
			double xSpacing = (xMax-xMin)/512; //sets spacing between x values
			double ySpacing = (yMax-yMin)/512;	//sets spacing between y values
			int y = 0;
			int x = 0;
			int[][] fractalFinal = new int[512][512]; //records each indicies escapeTime
	
				while(y < 512 ){ //goes through array 
					
					x = 0;
		
						while(x < 512){
							xPoint = xMin + (x * xSpacing); 
							yPoint = yMin + (y * ySpacing);
							fractalFinal[x][y] = Julia(xPoint, yPoint); //determines escape time of xPoint/yPoint
							x++;
						}
						
					y++;
					
				}
	
	return fractalFinal;
	
}
	
	public int[][] setArrMandelBrot(){ //x and y values = array[x][y] and sets xPoint and yPoint in array 
		
			double xMin = -2.15;
			double xMax = .6;
			double yMin = -1.3;
			double yMax = 1.3;
	
			double xSpacing = (xMax-xMin)/512; //sets spacing between x values
			double ySpacing = (yMax-yMin)/512;	//sets spacing between y values
			int y = 0;
			int x = 0;
			int[][] fractalFinal = new int[512][512]; //records each indicies escapeTime
	
				while(y < 512 ){ //goes through array 
					x = 0;
		
						while(x < 512){
							xPoint = xMin + (x * xSpacing); 
							yPoint = yMin + (y * ySpacing);
							fractalFinal[x][y] = Mandelbrot(xPoint, yPoint); //determines escape time of xPoint/yPoint
							x++;
						}
						
					y++;
					
				}
	
	return fractalFinal;
	
}
	
	public int[][] translateRow(int[][] someArray, int rowToCopy, int newXcoord){ 
		
		int[][] retVal = someArray;
		
			for(int cursor = 0; cursor < 512; cursor++){
				retVal[newXcoord][cursor] = someArray[rowToCopy][cursor];
			}
		
		return retVal;
		
	}
	
	public int[][] translateColumn(int[][] someArray, int columnToCopy, int newYcoord){
		
		int[][] retVal = someArray;
		
			for(int cursor = 0; cursor < 512; cursor++){
				retVal[cursor][newYcoord] = someArray[cursor][columnToCopy];
			}
		
		return retVal;
		
	}	
	
	public void changeBurningShip(int startingX, int endingX, int startingY, int endingY){
		
	}
	
	
	

}
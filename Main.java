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
public class Main {
	
	public int Mandelbrot(double x, double y){//Taking our coordinates as input
		if (x<-2.15 || x>0.6 || y<-1.3 || y>1.3){
			return 0;//If out of bounds return 0?
		}
		else{
			double xp;   // X' 
			double yp;   // Y'
			double dist=0;  // Distance
			int passes = 0; // # of passes
		
			while (dist <=2 && passes <255){ //Arbitrary values used for loop
				xp = Math.pow(x, 2) - Math.pow(y, 2) + x; 
				yp = 2 * x * y + y;
				dist = Math.sqrt(Math.pow(xp, 2) + Math.pow(yp, 2)); //Distance using pythag
				passes+=1;
				x = xp;
				y = yp;
			}
			int escapeTime = passes;
			passes = 0;
			return escapeTime;
		}
//		x' = x² - y² + current point's x-coordinate
//		y' = 2 * x * y + current point's y-coordinate
//		   where x and y are the values of xCalc and yCalc prior to this update and x' and y' are their values after the update.
//		X-coordinate range from -2.15 to 0.6
//		Y-coordinate range from -1.3 to 1.3
	}
	
	public int Julia(double x, double y){
		if (x<-1.7 || x>1.7 || y<-0.08 || y>0.025){
			return 0;//If out of bounds return 0?
		}
		else{
			double xp;   // X' 
			double yp;   // Y'
			double dist=0;  // Distance
			int passes = 0; // # of passes
		
			while (dist <=2 && passes <255){ //Arbitrary values used for loop
				xp = Math.pow(x, 2) - Math.pow(y, 2) - 0.72689; 
				yp = 2 * x * y + 0.188887;
				dist = Math.sqrt(Math.pow(xp, 2) + Math.pow(yp, 2)); //Distance using pythag
				passes+=1;
				x = xp;
				y = yp;
			}
			int escapeTime = passes;
			passes = 0;
			return escapeTime;
		}
//		x' = x² - y² + -0.72689
//		y' = 2 * x * y + 0.188887
//		   where x and y are the values of xCalc and yCalc prior to this update and x' and y' are their values after the update.
//		X-coordinate range from -1.7 to 1.7
//		Y-coordinate range from -1.0 to 1.0
	}
	
	public int BurningShip(double x, double y){
		if (x<-1.8 || x>-1.7 || y<-0.08 || y>0.025){
			return 0;//If out of bounds return 0?
		}
		else{
			double xp;   // X' 
			double yp;   // Y'
			double dist=0;  // Distance
			int passes = 0; // # of passes
		
			while (dist <=2 && passes <255){ //Arbitrary values used for loop
				xp = Math.pow(x, 2) - Math.pow(y, 2) - x; 
				yp = Math.abs(2 * x * y) + y;
				dist = Math.sqrt(Math.pow(xp, 2) + Math.pow(yp, 2)); //Distance using pythag
				passes+=1;
				x = xp;
				y = yp;
			}
			int escapeTime = passes;
			passes = 0;
			return escapeTime;
		}
//		x' = x² - y² + current point's x-coordinate
//		y' = Math.abs(2 * x * y) + current point's y-coordinate
//		   where x and y are the values of xCalc and yCalc prior to this update and x' and y' are their values after the update.
//		X-coordinate range from -1.8 to -1.7
//		Y-coordinate range from -0.08 to 0.025
	}
	
	public int Multibrot(double x, double y){
		if(x<-1 || x>1 || y<-1.3 || y>1.3){
			return 0;
		}
		else{
			double xp;
			double yp;
			double dist =0;
			int passes = 0;
			
			while(dist<=2 && passes <255){
				xp = Math.pow(x, 3) - (3*x*Math.pow(y, 2))+x;
				yp = (3*Math.pow(x, 2)*y)- Math.pow(y, 3)+y;
				dist = Math.sqrt(Math.pow(xp, 2)+ Math.pow(yp, 2));
			passes+=1;
			
			
			}
			int escapeTime = passes;
			passes = 0;
			return escapeTime;
			
			
		}
		
		//x' = x³ - (3 * x * y²) + current point's x-coordinate
		//y' = (3 * x² * y) - y³ + current point's y-coordinate
		  // where x and y are the values of xCalc and yCalc prior to this update and x' and y' are their values after the update.
	//	X-coordinate range from -1 to 1
		//Y-coordinate range from -1.3 to 1.3
	
	}
}
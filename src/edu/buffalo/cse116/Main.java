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
	private static double distance = 2; //defaults to 2
	double xMin;
	double xMax;
	double yMin;
	double yMax;
	int threads;
	double xCordStart;
	double xCordEnd;
	double yCordStart;
	double yCordEnd;
	private int time = 255;

	public void setEscDist(double dist){
		if(dist > 0){distance = dist;}
	}
	public void setEscTime(int x){
		if(x > 0 ){
			time = x;
		}
	}
	public void setThread(int thread){
		threads = thread;
		int extraThreads;
		extraThreads = 2048%thread;
		int start = 0;
		int dif  = (2048/thread)+1;
		int oDif = 2048/thread;
		
		for(int i = 0;i<extraThreads;i++){
			TheSwingWorker sw = new TheSwingWorker(start,start+dif);
			
			start+=dif;
			
		}
		for(int i = 0;i<thread-extraThreads;i++){
			TheSwingWorker tsw = new TheSwingWorker(dif,dif+oDif);
			dif+=oDif;
		}
		
	}
	
	public int Mandelbrot(double x, double y){//Taking our coordinates as input
		
			double xCalc = x;   // X' 
			double yCalc = y;   // Y'
			double dist=Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));;  // Distance
			int passes = 0; // # of passes
		
			while (dist <= distance && passes < time){ //Arbitrary values used for loop
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
		
			while (dist <= distance && passes < time){ //Arbitrary values used for loop
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
		
			while (dist <= distance && passes < time){ //Arbitrary values used for loop
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
			
			while(dist<= distance && passes < time){
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
		
//			double xMin = -1.0; //ranges
//			double xMax = 1.0;
//			double yMin = -1.3;
//			double yMax = 1.3;
		
			double xSpacing = (xMax-xMin)/2048; //sets spacing between x values
			double ySpacing = (yMax-yMin)/2048;	//sets spacing between y values
			int y = 0;
			int x = 0;
			int[][] fractalFinal = new int[2048][2048]; //records each indicies escapeTime
		
				while(y < 2048 ){ //goes through array 
					x = 0;
			
						while(x < 2048){
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
		
//		double xMin = -1.8; //Ranges
//		double xMax = -1.7;
//		double yMin = -.08;
//		double yMax = .025;
	
		double xSpacing = (xMax-xMin)/2048; //sets spacing between x values
		double ySpacing = (yMax-yMin)/2048;	//sets spacing between y values
		int y = 0;
		int x = 0;
		int[][] fractalFinal = new int[2048][2048]; //records each indicies escapeTime
	
			while(y < 2048 ){ //goes through array 
				x = 0;
		
					while(x < 2048){
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
		
//			double xMin = -1.7;
//			double xMax = 1.7;		//Sets the ranges for x
//			double yMin = -1.0;		//sets the ranges for y
//			double yMax = 1.0;
	
			double xSpacing = (xMax-xMin)/2048; //sets spacing between x values
			double ySpacing = (yMax-yMin)/2048;	//sets spacing between y values
			int y = 0;
			int x = 0;
			int[][] fractalFinal = new int[2048][2048]; //records each indicies escapeTime
	
				while(y < 2048 ){ //goes through array 
					
					x = 0;
		
						while(x < 2048){
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
		
//			double xMin = -2.15;
//			double xMax = .6;
//			double yMin = -1.3;
//			double yMax = 1.3;
	
			double xSpacing = (xMax-xMin)/2048; //sets spacing between x values
			double ySpacing = (yMax-yMin)/2048;	//sets spacing between y values
			int y = 0;
			int x = 0;
			int[][] fractalFinal = new int[2048][2048]; //records each indicies escapeTime
	
				while(y < 2048 ){ //goes through array 
					x = 0;
		
						while(x < 2048){
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
		
			for(int cursor = 0; cursor < 20488; cursor++){
				retVal[newXcoord][cursor] = someArray[rowToCopy][cursor];
			}
		
		return retVal;
		
	}
	
	public int[][] translateColumn(int[][] someArray, int columnToCopy, int newYcoord){
		
		int[][] retVal = someArray;
		
			for(int cursor = 0; cursor < 2048; cursor++){
				retVal[cursor][newYcoord] = someArray[cursor][columnToCopy];
			}
		
		return retVal;
		
	}	
	
	
	
	
	public int[][] setNewCoordinates(int minX, int minY, int maxX, int maxY, String arrayName){
		
		if(arrayName.equalsIgnoreCase("MandelBrot")){
				
			if(minX > maxX && minY > maxY){ //
				xCordStart = xMin + (maxX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (minX * ((xMax-xMin)/2048));
				yCordStart = yMin + (maxY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (minY * ((yMax- yMin)/2048));
			}
			if(minX < maxX && minY < maxY){ //1
				xCordStart = xMin + (minX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (maxX * ((xMax-xMin)/2048));
				yCordStart = yMin + (minY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (maxY * ((yMax- yMin)/2048));
			}
			if(minX > maxX && minY < maxY){ //
				xCordStart = xMin + (maxX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (minX * ((xMax-xMin)/2048));
				yCordStart = yMin + (minY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (maxY * ((yMax- yMin)/2048));
			}
			if(minX < maxX && minY > maxY){ //2
				yCordStart = yMin + (maxY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (minY * ((yMax- yMin)/2048));
				xCordStart = xMin + (minX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (maxX * ((xMax-xMin)/2048));
			}	
				
				xMin = xCordStart;
				xMax = xCordEnd;
				yMin = yCordStart;
				yMax = yCordEnd;
				
				
				System.out.println(xMin + " " + xMax +  " " +  yMin + " " + yMax);
				
				return setArrMandelBrot();
			}
			
		
		
		if(arrayName.equalsIgnoreCase("Julia")){
			
			if(minX > maxX && minY > maxY){ 
				xCordStart = xMin + (maxX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (minX * ((xMax-xMin)/2048));
				yCordStart = yMin + (maxY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (minY * ((yMax- yMin)/2048));
			}
			if(minX < maxX && minY < maxY){ 
				xCordStart = xMin + (minX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (maxX * ((xMax-xMin)/2048));
				yCordStart = yMin + (minY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (maxY * ((yMax- yMin)/2048));
			}
			if(minX > maxX && minY < maxY){ 
				xCordStart = xMin + (maxX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (minX * ((xMax-xMin)/2048));
				yCordStart = yMin + (minY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (maxY * ((yMax- yMin)/2048));
			}
			if(minX < maxX && minY > maxY){ 
				yCordStart = yMin + (maxY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (minY * ((yMax- yMin)/2048));
				xCordStart = xMin + (minX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (maxX * ((xMax-xMin)/2048));
				
			}
			
			
		
			xMin = xCordStart;
			xMax = xCordEnd;
			yMin = yCordStart;
			yMax = yCordEnd;
		
			
		System.out.println(xMin + " " + xMax +  " " +  yMin + " " + yMax);
		
		return setArrJulia();
		}
//		
		if(arrayName.equalsIgnoreCase("BurningShip")){

			if(minX > maxX && minY > maxY){ //
				xCordStart = xMin + (maxX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (minX * ((xMax-xMin)/2048));
				yCordStart = yMin + (maxY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (minY * ((yMax- yMin)/2048));
			}
			if(minX < maxX && minY < maxY){ //1
				xCordStart = xMin + (minX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (maxX * ((xMax-xMin)/2048));
				yCordStart = yMin + (minY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (maxY * ((yMax- yMin)/2048));
			}
			if(minX > maxX && minY < maxY){ //
				xCordStart = xMin + (maxX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (minX * ((xMax-xMin)/2048));
				yCordStart = yMin + (minY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (maxY * ((yMax- yMin)/2048));
			}
			if(minX < maxX && minY > maxY){ //2
				yCordStart = yMin + (maxY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (minY * ((yMax- yMin)/2048));
				xCordStart = xMin + (minX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (maxX * ((xMax-xMin)/20448));
			}
		
			xMin = xCordStart;
			xMax = xCordEnd;
			yMin = yCordStart;
			yMax = yCordEnd;
		
		return setArrBurningShip();
	
		}
//		
		if(arrayName.equalsIgnoreCase("MultiBrot")){

			if(minX > maxX && minY > maxY){ //
				xCordStart = xMin + (maxX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (minX * ((xMax-xMin)/2048));
				yCordStart = yMin + (maxY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (minY * ((yMax- yMin)/2048));
			}
			if(minX < maxX && minY < maxY){ //1
				xCordStart = xMin + (minX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (maxX * ((xMax-xMin)/2048));
				yCordStart = yMin + (minY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (maxY * ((yMax- yMin)/2048));
			}
			if(minX > maxX && minY < maxY){ //
				xCordStart = xMin + (maxX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (minX * ((xMax-xMin)/2048));
				yCordStart = yMin + (minY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (maxY * ((yMax- yMin)/2048));
			}
			if(minX < maxX && minY > maxY){ //2
				yCordStart = yMin + (maxY * ((yMax - yMin)/2048));
				yCordEnd = yMin + (minY * ((yMax- yMin)/2048));
				xCordStart = xMin + (minX * ((xMax-xMin)/2048));
				xCordEnd = xMin + (maxX * ((xMax-xMin)/2048));
			}	
		
		xMin = xCordStart;
		xMax = xCordEnd;
		yMin = yCordStart;
		yMax = yCordEnd;
		
		return setArrMandelBrot();
	}
		return null;
		
	}
	
	
	
	
	/*
	 * Methods to setDfault coordinate ranges (unZoom)
	 * 
	 */
	
	public void setMandelBrotDefualt(){
		xMin = -2.15;
		xMax = .6;
		yMin = -1.3;
		yMax = 1.3;
	}
	
	public void setJuliaDefault(){
		xMin = -1.7;
		xMax = 1.7;		
		yMin = -1.0;		
		yMax = 1.0;
	}
	
	public void setMultiBrotDefault(){
		xMin = -1.0; 
		xMax = 1.0;
		yMin = -1.3;
		yMax = 1.3;
	}
	
	public void setBurningShipDefault(){
		xMin = -1.8;
		xMax = -1.7;
		yMin = -.08;
		yMax = .025;
	}
	
	
	

	
// takes x-coordinate and y-coordinate as an argument
// returns an int of the escape time calculated from the new maximum escape time	
	 
	public int newescapeDistanceMandelBrot(double x, double y){
		Main mn = new Main();
		  
		double dist=0;  
		int iteration = 0; 
	
		while (dist <= distance && iteration <135){ 
			mn.Mandelbrot(x, y);
		iteration++;	
		}
		int escapeTime =iteration;			
		return escapeTime;
	}
	public int newescapeDistanceJuila(double x, double y){
		Main mn = new Main();
		double dist=0; 
		int iteration = 0; 
	
		while (dist <= distance && iteration <135){ 
			mn.Julia(x, y);
		iteration++;
		}
		int escapeTime = iteration;			
		return escapeTime;
	}

public int newescapeDistanceMultiBrot(double x, double y){
	Main mn = new Main();
 	double dist=0;  
	int iteration = 0; 

	while(dist<= distance && iteration <135){
		mn.Multibrot(x, y);
iteration++;
	}
	int escapeTime = iteration;			
	return escapeTime;
}

public int newescapeDistanceBurningShip(double x, double y){
	Main mn = new Main();
	double dist=0;  
	int iteration = 0; 

	while (dist <= distance && iteration <135){ 
	 mn.BurningShip(x, y);
	iteration++;		
	}
	int escapeTime = iteration;			
	return escapeTime;
}
}

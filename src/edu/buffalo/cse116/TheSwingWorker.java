package edu.buffalo.cse116;

import javax.swing.SwingWorker;

public class TheSwingWorker extends SwingWorker {
	private int _startRow;
	private int _numRow;
	
	public TheSwingWorker(int startRow, int numRow){
		_startRow = startRow;
		_numRow = numRow;
	}

	@Override
	protected Object doInBackground() throws Exception {
		//calculate range of fractal
		//starting at start row
		//ending at end of section 
		int [][]data = null;
		
		return null;
	}
	

	
}

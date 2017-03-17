package edu.buffalo.cse116;
import edu.buffalo.cse116.ColorModelFactory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import edu.buffalo.fractal.FractalPanel;
import java.awt.image.IndexColorModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public  class GUI {
	
private static Main _main;
	private JFrame _frame;
	private static FractalPanel _fractalPanel;
	private static IndexColorModel _model = ColorModelFactory.createBluesColorModel(18); //sets color model to a default color of blue
	private JPanel _optionsMenu;
	private JButton file;
	private JButton ColorScheme;
	private JButton Fractals;
    private static final int WIDTH = 600;;
    private static final int HEIGHT = 600;
	private static int [][] _array;
	
	public GUI(){
		_main = new Main();
		_fractalPanel = new FractalPanel(); //where fractal is displayed
		_array = _main.setArrMultiBrot(); // default array
		_frame = new JFrame("Fractals Images");
		_optionsMenu = new JPanel();
		
		_optionsMenu.setBackground(Color.BLACK);
		
		file = new JButton ("File");
		file.addActionListener(new Action2());
		file.setSize(20, 20);
		
		ColorScheme = new JButton ("ColorScheme");
		ColorScheme.addActionListener(new Action4 ());
		ColorScheme.setSize(20, 20);
		
		Fractals = new JButton("Fractals");
		Fractals.addActionListener(new Action());
		
		
		_optionsMenu.add(file);
		_optionsMenu.add(ColorScheme);
		_optionsMenu.add(Fractals);
		
		_frame.add(_fractalPanel);
		_frame.add(_optionsMenu, BorderLayout.PAGE_START);
	
		_frame.setSize(WIDTH,HEIGHT);
		_frame.pack();
		_frame.setVisible(true);
		
		
	
	}
	
	
static class Action implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frame2 = new JFrame("Fractals");
		JPanel panel = new JPanel();
		
		JButton MultiBrot = new JButton("MultiBrot");
		JButton BurningShip = new JButton("BurningShip");
		JButton Julia = new JButton("Julia");
		JButton MandelBrot = new JButton("MandelBrot");
		MultiBrot.addActionListener(new Action3());
		BurningShip.addActionListener(new Action3());
		Julia.addActionListener(new Action3());
		MandelBrot.addActionListener(new Action3());
		
		
		panel.add(MultiBrot);
		panel.add(BurningShip);
		panel.add(Julia);
		panel.add(MandelBrot);
	
		frame2.setVisible(true);
		frame2.setSize(300, 200);
		
		
		frame2.add(panel);
		frame2.pack();
		
	
	
	}

	
}
static class Action2 implements ActionListener{
@Override
public void actionPerformed(ActionEvent e) {
JFrame frame3 = new JFrame("File");
JLabel label = new JLabel("You are about to exit",JLabel.CENTER);
frame3.setSize(300, 300);
frame3.setVisible(true);
frame3.setDefaultCloseOperation(frame3.EXIT_ON_CLOSE);
frame3.add(label);	
}
	
}

static class Action3 implements ActionListener{
@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getActionCommand().equals("MultiBrot")){ //checks JButton text .equals("multiBrot")
		
		_array = _main.setArrMultiBrot(); //sets array to correct array type
		_fractalPanel.setIndexColorModel(_model); //sets the array to that color model
		_fractalPanel.updateImage(_array); //updates the array in the window
		System.out.println("MultiBrot Selected"); //prints in console what array you selected
	}
	
	if(e.getActionCommand().equals("MandelBrot")){
		
		_array = _main.setArrMandelBrot();
		_fractalPanel.setIndexColorModel(_model);
		_fractalPanel.updateImage(_array);
		System.out.println("MandelBrot Selected");
	}
	
	if(e.getActionCommand().equals("BurningShip")){
		
		_array = _main.setArrBurningShip();
		_fractalPanel.setIndexColorModel(_model);
		_fractalPanel.updateImage(_array);
		System.out.println("BurningShip Selected");
	}
	
	if(e.getActionCommand().equals("Julia")){
		
		_array = _main.setArrJulia();
		_fractalPanel.setIndexColorModel(_model);
		_fractalPanel.updateImage(_array);
		System.out.println("Julia Selected");
	}
	
}


}


static class Action4 implements ActionListener{
@Override
public void actionPerformed(ActionEvent e) {
	JFrame ColorFrame = new JFrame("Colors");
	JPanel ColorPanel = new JPanel();
	
	JButton Rainbow = new JButton("Rainbow");
	JButton Blues = new JButton("Blues");
	JButton Grays = new JButton("Grays");
	JButton CottonCandy = new JButton("Cotton Candy");
	Rainbow.addActionListener(new Action5());
	Blues.addActionListener(new Action5());
	Grays.addActionListener(new Action5());
	CottonCandy.addActionListener(new Action5());
	
	ColorPanel.add(Rainbow);
	ColorPanel.add(Blues);
	ColorPanel.add(Grays);
	ColorPanel.add(CottonCandy);
	
	ColorFrame.add(ColorPanel);
	ColorFrame.setSize(200, 200);
	ColorFrame.setVisible(true); 
	ColorFrame.pack();
}

static class Action5 implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Rainbow")){
			_model = ColorModelFactory.createRainbowColorModel(26);
			_fractalPanel.setIndexColorModel(_model);
			_fractalPanel.updateImage(_array);
		}
		
		if(e.getActionCommand().equals("Blues")){
			_model = ColorModelFactory.createBluesColorModel(18);
			_fractalPanel.setIndexColorModel(_model);
			_fractalPanel.updateImage(_array);
		}
		
		if(e.getActionCommand().equals("Grays")){
			_model = ColorModelFactory.createGrayColorModel(32);
			_fractalPanel.setIndexColorModel(_model);
			_fractalPanel.updateImage(_array);
			
		}
		if(e.getActionCommand().equals("Cotton Candy")){
			_model = ColorModelFactory.createGraColorModel(42);
			_fractalPanel.setIndexColorModel(_model);
			_fractalPanel.updateImage(_array);
		}
		
	}

	
					


	
}
}
}

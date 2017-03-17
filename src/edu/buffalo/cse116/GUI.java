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

public  class GUI implements ActionListener {
	
private static Main _main;
	private JFrame _frame;
	private static FractalPanel _fractalPanel;
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
		IndexColorModel model = ColorModelFactory.createRainbowColorModel(89); //color model chosen
		_fractalPanel.setIndexColorModel(model); //sets the array to that color model
		_fractalPanel.updateImage(_array); //updates the array in the window
		System.out.println("MultiBrot Selected"); //prints in console what array you selected
	}
	
	if(e.getActionCommand().equals("MandelBrot")){
		
		_array = _main.setArrMandelBrot();
		IndexColorModel model = ColorModelFactory.createBluesColorModel(7);
		_fractalPanel.setIndexColorModel(model);
		_fractalPanel.updateImage(_array);
		System.out.println("MandelBrot Selected");
	}
	
	if(e.getActionCommand().equals("BurningShip")){
		
		_array = _main.setArrBurningShip();
		IndexColorModel model = ColorModelFactory.createGrayColorModel(18);
		_fractalPanel.setIndexColorModel(model);
		_fractalPanel.updateImage(_array);
		System.out.println("BurningShip Selected");
	}
	
	if(e.getActionCommand().equals("Julia")){
		
		_array = _main.setArrJulia();
		IndexColorModel model = ColorModelFactory.createRainbowColorModel(60);
		_fractalPanel.setIndexColorModel(model);
		_fractalPanel.updateImage(_array);
		System.out.println("Julia Selected");
	}
	
}


}


static class Action4 implements ActionListener{
@Override
public void actionPerformed(ActionEvent e) {
	JFrame ColorFrame = new JFrame("Colors");
	ColorFrame.setSize(200, 200);
	JPanel ColorPanel = new JPanel();
	JButton Rainbow = new JButton("Rainbow");
	JButton Blues = new JButton("Blues");
	JButton Grays = new JButton("Grays");
	ColorPanel.add(Rainbow);
	ColorPanel.add(Blues);
	ColorPanel.add(Grays);
	ColorFrame.add(ColorPanel);
	ColorFrame.setVisible(true); 
}

static class Action5 implements ActionListener{
public void actionPerformed1(ActionEvent e) {
	if(e.getActionCommand().equals("Rainbow"));
	
		_fractalPanel.updateImage(_array);
		
			for(int y = 0; y < 512; y++){
				for(int x = 0; x < 512; x++){
					System.out.println("[" + x + "]" + "[" + y + "]");
				IndexColorModel model = ColorModelFactory.createRainbowColorModel(_array[x][y]);
					_fractalPanel.setIndexColorModel(model);
				_fractalPanel.getColorModel(); 
				
				}}}					

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}}}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}}
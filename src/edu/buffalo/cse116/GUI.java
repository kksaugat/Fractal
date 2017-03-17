
package edu.buffalo.cse116;
import edu.buffalo.cse116.ColorModelFactory;
import edu.buffalo.fractal.FractalPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.IndexColorModel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public  class GUI {

private static Main _main;	
private static JMenu Fractals;
private static JMenuBar MenuBar;	
private static JMenu ColorSchemes;
private static JMenuItem MandelBrot;	
private static JMenuItem Rainbow;
private static JMenuItem CottonCandy;
private static JMenuItem Blues;
private static JMenuItem Grays;
private static  JMenuItem MultiBrot;
private static  JMenuItem Julia;
private static JMenu File;
private static JMenuItem BurningShip;	
private static FractalPanel _fractalPanel;
private static JMenuItem Exit;
private static int [][]_array;
private static IndexColorModel _model = ColorModelFactory.createBluesColorModel(18);	
public GUI(){
	_fractalPanel = new FractalPanel();
	_main = new Main();
	_array = _main.setArrMultiBrot();
	JFrame frame = new JFrame("Fractal Images");
	frame.add(_fractalPanel);
	
	frame.setVisible(true);
	frame.setSize(400, 200);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	MenuBar = new JMenuBar();


	 frame.setJMenuBar(MenuBar);
	  Fractals = new JMenu("Fractals");
	  ColorSchemes = new JMenu("ColorSchemes");
	
	  File = new JMenu("File");
	MenuBar.add(Fractals);
	MenuBar.add(File);
	MenuBar.add(ColorSchemes);

	 MandelBrot = new JMenuItem("MandelBrot");
	 Julia = new JMenuItem("Julia");
	 MultiBrot = new JMenuItem("MultiBrot");
	 BurningShip = new JMenuItem("BurningShip");
	 Fractals.add(MandelBrot);
	 Fractals.add(MultiBrot);
	 Fractals.add(BurningShip);
	 Fractals.add(Julia);
	 Rainbow = new JMenuItem("Rainbow");
	 Blues = new JMenuItem("Blues");
	 CottonCandy = new JMenuItem("CottonCandy");
	 Grays = new JMenuItem("Grays");
	ColorSchemes.add(Rainbow);
	ColorSchemes.add(CottonCandy);
	ColorSchemes.add(Grays);
	ColorSchemes.add(Blues);
	MandelBrot.addActionListener(new FractalsAction());
    MultiBrot.addActionListener(new FractalsAction());
    BurningShip.addActionListener(new FractalsAction());
    Julia.addActionListener(new FractalsAction());
    Rainbow.addActionListener(new ColorAction());
    Blues.addActionListener(new ColorAction());
    CottonCandy.addActionListener(new ColorAction());
    Grays.addActionListener(new ColorAction());
Exit = new JMenuItem("Exit");
File.add(Exit);
Exit.addActionListener(new ExitAction());
frame.pack();

}
	
 class ExitAction implements ActionListener{
		public void actionPerformed (ActionEvent e){
		System.exit(0);
	}}


	
	 class FractalsAction implements ActionListener{
public void actionPerformed (ActionEvent e){
			if(e.getActionCommand().equals("MultiBrot")){ 
				
				_array = _main.setArrMultiBrot(); 
				_fractalPanel.setIndexColorModel(_model); 
				_fractalPanel.updateImage(_array); 
				System.out.println("MultiBrot Selected"); 
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
		}}
		}
	 class ColorAction implements ActionListener{
	public void actionPerformed(ActionEvent e){

		
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














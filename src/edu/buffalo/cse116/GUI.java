
package edu.buffalo.cse116;
import edu.buffalo.cse116.ColorModelFactory;
import edu.buffalo.fractal.FractalPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.IndexColorModel;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;


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
private static JFormattedTextField textField;
private static JMenuItem EscDistance;
private static JMenuItem BurningShip;	
private static JPopupMenu popup;
private static JMenuItem EscTime;
private static FractalPanel _fractalPanel;
private static JMenuItem Exit;
private static JButton button;
private static JButton button2;
private static int [][]_array;
private static JFormattedTextField escTimeText;
private static IndexColorModel _model = ColorModelFactory.createBluesColorModel(18);	
private String currentFractal = "MultiBrot"; //default value - changes as a new moel is selected


public GUI(){
	
	_fractalPanel = new FractalPanel();
	_main = new Main();
	_array = _main.setArrMultiBrot();
	JFrame frame = new JFrame("Fractal Images");
	frame.add(_fractalPanel);
	
	
	_fractalPanel.addMouseListener(new mListener());

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	MenuBar = new JMenuBar();
	frame.setJMenuBar(MenuBar);
	Fractals = new JMenu("Fractals");
	ColorSchemes = new JMenu("ColorSchemes");
	EscDistance = new JMenu("EscDistance");
	EscTime = new JMenu("EscTime");
	 
	textField = new JFormattedTextField();
	File = new JMenu("File");
	button = new JButton("Enter");
	button2 = new JButton("Select");
			
	MenuBar.add(Fractals);
	MenuBar.add(File);
	MenuBar.add(ColorSchemes);
	MenuBar.add(EscDistance);
	MenuBar.add(EscTime);
	escTimeText = new JFormattedTextField();
	textField = new JFormattedTextField();
	EscDistance.add(textField);
	EscDistance.add(button);
	EscTime.add(escTimeText);
	EscTime.add(button2);
	

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
    button.addActionListener(new ButtonAction());
    button2.addActionListener(new Button2Action());
    Exit = new JMenuItem("Exit");
    File.add(Exit);
    Exit.addActionListener(new ExitAction());
    
    frame.setVisible(true);
    frame.pack();

}
	
class ExitAction implements ActionListener{
	@Override
	public void actionPerformed (ActionEvent e){
		System.exit(0);
	}
}


class ButtonAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Enter")){
			double dis = Double.parseDouble(textField.getText());
			_main.setEscDist(dis);
			if(currentFractal.equals("MandelBrot")){
				_array = _main.setArrMandelBrot();
				_fractalPanel.updateImage(_array);
			}
			if(currentFractal.equals("MultiBrot")){
				_array = _main.setArrMultiBrot();
				_fractalPanel.updateImage(_array);
			}
			if(currentFractal.equals("BurningShip")){
				_array = _main.setArrBurningShip();
				_fractalPanel.updateImage(_array);
			}
			if(currentFractal.equals("Julia")){
				_array = _main.setArrJulia();
				_fractalPanel.updateImage(_array);
			}
			
			
		}
	}
}
class Button2Action implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Select")){
			//add code for max esc time
			double maxTime = Double.parseDouble(escTimeText.getText());
			
			
		}
	}
}
class FractalsAction implements ActionListener{
	@Override
	public void actionPerformed (ActionEvent e){
		if(e.getActionCommand().equals("MultiBrot")){ 
				
			_array = _main.setArrMultiBrot(); 
			_fractalPanel.setIndexColorModel(_model); 
			_fractalPanel.updateImage(_array); 
			currentFractal = "MultiBrot";
			System.out.println("MultiBrot Selected"); 
		}
			
		if(e.getActionCommand().equals("MandelBrot")){
				
			_array = _main.setArrMandelBrot();
			_fractalPanel.setIndexColorModel(_model);
			_fractalPanel.updateImage(_array);
			currentFractal = "MandelBrot";
			System.out.println("MandelBrot Selected");
		}
			
		if(e.getActionCommand().equals("BurningShip")){
				
			_array = _main.setArrBurningShip();
			_fractalPanel.setIndexColorModel(_model);
			_fractalPanel.updateImage(_array);
			currentFractal = "BurningShip";
			System.out.println("BurningShip Selected");
		}
			
		if(e.getActionCommand().equals("Julia")){
				
				_array = _main.setArrJulia();
				_fractalPanel.setIndexColorModel(_model);
				_fractalPanel.updateImage(_array);
				currentFractal = "Julia";
				System.out.println("Julia Selected");	
		}}
		}
	 class ColorAction implements ActionListener{
	@Override
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
			if(e.getActionCommand().equals("CottonCandy")){
				_model = ColorModelFactory.createGraColorModel(42);
				_fractalPanel.setIndexColorModel(_model);
				_fractalPanel.updateImage(_array);
		}

		}
	
	}
	 
	 class mListener implements MouseListener{
		 private int startingX;
			private int endingX;
			private int startingY;
			private int endingY;

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				
				startingX = e.getX();
				startingY = e.getY();
				
				System.out.println("Starting x coord = [" + startingX +"] Starting y coord = [" + startingY +"]");

			}

			public void mouseReleased(MouseEvent e) {
				
				
				endingX = e.getX();
				endingY = e.getY();
				
				int x = endingX - startingX;
				int y = endingY - startingY;
				
				System.out.println("Final x coord = [" + endingX +"] Final y coord = [" + endingY +"]" + x);

			}
	 }
		
	}













